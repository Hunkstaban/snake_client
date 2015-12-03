package UI;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Screen extends JFrame {
	
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
	
	public Screen(){
		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(5,5,5,5));
		contentpane.setLayout(new BorderLayout(1050, 700));
		setContentPane(contentpane);
		cL = new CardLayout();
		mainPanel = new JPanel();
		login = new Login();
		userMenu = new UserMenu();
		delete = new DeleteGame();
		score = new Highscore();
		play = new PlayGame();
		create = new CreateGame();
		join = new JoinGame();
		
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
		cL.show(mainPanel, "loginPanel");
		setSize(1050, 800);
		setResizable(false);
		setVisible(true);
	}
	
	public void show(String cardName){
		cL.show(mainPanel, cardName);
	}
	
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
