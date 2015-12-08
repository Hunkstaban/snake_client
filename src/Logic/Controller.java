package Logic;

import DTO.Game;
import DTO.Gamer;
import DTO.User;
import SDK.API;
import UI.Screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {
	//declaring the instance variables
	private Screen screen;
	private User currentUser;
	private API api;
	private ArrayList<User> users;
	private ArrayList<Game> games;
	private ArrayList<Game> gamesToDelete;

	//class constructor
	public Controller() {
		screen = new Screen();
		currentUser = new User();
		api = new API();
	}
	
	public void run(){
		screen.getLogin().addActionListeners(new LoginActionListener());
		screen.getUserMenu().addActionListeners(new MenuActionListener());
		screen.getDelete().addActionListeners(new DeleteActionListener());
		screen.getScore().addActionListeners(new ScoreActionListener());
		screen.getPlay().addActionListeners(new PlayActionListener());
		screen.getCreate().addActionListeners(new CreateActionListener());
		screen.getJoin().addActionListeners(new JoinActionListener());
	}
	
	private class LoginActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			currentUser.setUsername(screen.getLogin().getUserName());
			currentUser.setPassword(screen.getLogin().getPassword());
			String serverMessage = api.login(currentUser);
			JOptionPane.showMessageDialog(screen, serverMessage);

			if (serverMessage.equals("Login successful")) {
				screen.show("menuPanel");
			}
		}
		
		
		
	}
	
	private class MenuActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		
			switch (e.getActionCommand()) {
			case "Menu":
				
				break;
			
			case "Play game":
				screen.show("playPanel");
				
				break;
			
			case "Highscores":
				screen.show("scorePanel");
				screen.getScore().setScoreTable(api.getHighscores());
				
				break;
			
			case "Delete game":
				gamesToDelete = api.getAllActiveGames(currentUser.getId());
				screen.getDelete().addGames(gamesToDelete);
				screen.show("deletePanel");
				
				break;
				
			case "Log out":
				screen.show("loginPanel");
				
				break;

			}
			
		}
		
	}
	
	private class DeleteActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Back":
				screen.show("menuPanel");
				
				break;
			
			case "Delete":
				Game deleteGame = null;
				for (Game game:gamesToDelete) {
					if (game.getName().equals(screen.getDelete().getGame())) {
						deleteGame = game;
					}
				}
				String serverMessage = api.deleteGame(deleteGame.getGameId());
				JOptionPane.showMessageDialog(screen, serverMessage);
				screen.show("menuPanel");
				break;

			}
			
		}
		
	}
	
	private class ScoreActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			screen.show("menuPanel");
			
		}
		
	}
	
	private class PlayActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Create game":
				screen.show("createPanel");
				users = api.getAllUsers();
				screen.getCreate().setOpponent(users);
				
				break;
				
			case "Join game":
				games = api.getPendingGames(currentUser.getId());
				screen.getJoin().setGame(games);
				screen.show("joinPanel");
				
				break;
			
			case "Back":
				screen.show("menuPanel");
				
				break;
				
			}
			
		}
		
	}
	
	private class CreateActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Back":
				screen.show("playPanel");
				
				break;
				
			case "Create game":
				Game game = new Game();
				Gamer host = new Gamer();
				Gamer opponent = new Gamer();
				game.setName(screen.getCreate().getGameName());
				host.setControls(screen.getCreate().getControls());
				host.setId(currentUser.getId());
				for (User user:users) {
					if (user.getUsername().equals(screen.getCreate().getUsername())) {
						opponent.setId(user.getId());
					}
				}
				game.setHost(host);
				game.setOpponent(opponent);
				game.setMapSize(10);
				String serverMessage = api.createGame(game);
				JOptionPane.showMessageDialog(screen, serverMessage);
				break;
			}
		}
	}
	
	private class JoinActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Back":
				screen.show("playPanel");
				break;

			case "Play":
				Game game = null;
				for(Game g:games) {
					if (g.getName().equals(screen.getJoin().getGameName())){
						game = g;
					}
				}
				Gamer opponent = new Gamer();

				opponent.setControls(screen.getJoin().getControls());
				opponent.setId(currentUser.getId());
				game.setOpponent(opponent);

				String serverMessage = api.joinGame(game);
				game = api.startGame(game);

				for(User user:users){
					if (user.getId()==game.getWinner().getId()){
						game.getWinner().setUsername(user.getUsername());
					}
				}
				JOptionPane.showMessageDialog(screen, serverMessage + "\n The winner was: " + game.getWinner().getUsername());


				break;
			}
		}
	}


	

}
