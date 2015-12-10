package SDK;

import DTO.Game;
import DTO.Score;
import DTO.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Peter on 03-12-2015.
 */

public class API {

    ServerConnection connection = new ServerConnection();

    //get method that will retrieve all users from the database
    public ArrayList<User> getAllUsers() {

        ArrayList<User> users = new Gson().fromJson(connection.get("users"), new TypeToken<ArrayList<User>>(){}.getType());
        return users;
    }

    //get method, that will retrieve all active games
    public ArrayList<Game> getPendingGames(int userId) {
        ArrayList<Game> games = new Gson().fromJson(connection.get("games/opponent/" + userId), new TypeToken<ArrayList<Game>>(){}.getType());
        return games;
    }

    //method that will send games to the server
    public String createGame(Game game) {
        String serverMessage = connection.post(new Gson().toJson(game), "games");
        return parseMessage(serverMessage);
    }

    //method that will enable you to join a game active on the server
    public String joinGame(Game game) {
        String serverMessage = connection.put(new Gson().toJson(game),"games/join");
        return parseMessage(serverMessage);
    }

    //method that will enable you to login
    public String login(User currentUser) {
        String serverMessage = connection.post(new Gson().toJson(currentUser), "login");
        int id = getUserID(serverMessage);
        currentUser.setId(id);
        return parseMessage(serverMessage);

    }

    //creating HashMap to get values from server
    public String parseMessage(String serverMessage) {
        HashMap<String, String> messageMap = new Gson().fromJson(serverMessage, HashMap.class);
        return messageMap.get("message");
    }


    public int getUserID (String serverMessage) {
        JSONParser jsonParser = new JSONParser();
        try {
            Object object = jsonParser.parse(serverMessage);
            JSONObject jsonObject = (JSONObject)object;
            return (int)(long)jsonObject.get("userid");
        } catch (ParseException | NullPointerException e) {
            e.printStackTrace();
        }
        return -1;
    }


    public Game startGame(Game game) {
        String serverMessage = connection.put(new Gson().toJson(game),"games/start");
        return new Gson().fromJson(serverMessage, Game.class);
    }

    public String deleteGame(int gameID) {
        String serverMessage = connection.delete("games/"+ gameID);
        return parseMessage(serverMessage);
    }

    public ArrayList<Game> getAllActiveGames(int userId) {
        ArrayList<Game> games = new Gson().fromJson(connection.get("games/pending/" + userId), new TypeToken<ArrayList<Game>>(){}.getType());
        return games;
    }

    //making an ArrayList with scores
    public ArrayList<Score> getHighscores() {
       return new Gson().fromJson(connection.get("highscores"), new TypeToken<ArrayList<Score>>(){}.getType());
    }

}
