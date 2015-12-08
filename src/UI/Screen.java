package UI;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//highscore class which inherits the methods and attributes of JFrame
public class Screen extends JFrame {

	//declaring the instance variables
	private JPanel mainPanel;
	private CardLayout cL;
	private Login login;
	private UserMenu userMenu;
	private JPanel contentpane;
	private DeleteGame delete;
	private Highscore score;
	private PlayGame play;
	private CreateGame create;
	private JoinGame join;

	//class constructor
	public Screen(){
		//adding contentpane to make declare the size of the panels + cardlayout, so the user will be able to navigate
		// through the different GUI panels
		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(5,5,5,5));
		contentpane.setLayout(new BorderLayout(1050, 700));
		setContentPane(contentpane);
		cL = new CardLayout();

		//instantiating objects of the GUI's constructors
		mainPanel = new JPanel();
		login = new Login();
		userMenu = new UserMenu();
		delete = new DeleteGame();
		score = new Highscore();
		play = new PlayGame();
		create = new CreateGame();
		join = new JoinGame();

		//adding the different panels to the cardlayout, so the user will be able to navigate through them
		mainPanel.setLayout(cL);
		mainPanel.add(login, "loginPanel");
		mainPanel.add(userMenu,"menuPanel");
		mainPanel.add(delete, "deletePanel");
		mainPanel.add(score, "scorePanel");
		mainPanel.add(play, "playPanel");
		mainPanel.add(create,"createPanel");
		mainPanel.add(join, "joinPanel");
		mainPanel.setBounds(100, 100, 1056, 703);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		contentpane.add(mainPanel, BorderLayout.CENTER);
		//when screen is iniated, it will show the login panel
		cL.show(mainPanel, "loginPanel");
		setSize(1050, 800);
		setResizable(false);
		setVisible(true);
	}

	//show method which will enable the cardlayout to show the chosen panel
	public void show(String cardName){
		cL.show(mainPanel, cardName);
	}

	//creating getters so they can be used in the Controller class
	public Login getLogin() {
		return login;
	}
	
	public UserMenu getUserMenu() {
		return userMenu;
	}
	
	public DeleteGame getDelete() {
		return delete;
	}
	
	public Highscore getScore() {
		return score;
	}
	
	public PlayGame getPlay() {
		return play;
	}
	
	public CreateGame getCreate() {
		return create;
	}
	
	public JoinGame getJoin() {
		return join;
	}
}
