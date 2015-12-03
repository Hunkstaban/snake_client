package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Font;

public class PlayGame extends JPanel {
	private JLabel lblChooseFromOption;
	private JButton btnCreateGame;
	private JButton btnJoinGame;
	private JButton btnBack;
	private JLabel lblPlayGame;

	/**
	 * Create the panel.
	 */
	public PlayGame() {
		initialize();
	}
		
		private void initialize() {
		setLayout(null);
		
		lblChooseFromOption = new JLabel("Choose from option below");
		lblChooseFromOption.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblChooseFromOption.setBounds(258, 197, 480, 33);
		add(lblChooseFromOption);
		
		btnCreateGame = new JButton("Create game");
		btnCreateGame.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnCreateGame.setBounds(400, 250, 220, 45);
		add(btnCreateGame);
		
		btnJoinGame = new JButton("Join game");
		btnJoinGame.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnJoinGame.setBounds(400, 320, 220, 45);
		add(btnJoinGame);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnBack.setBounds(25, 650, 200, 60);
		add(btnBack);
		
		lblPlayGame = new JLabel("Play game");
		lblPlayGame.setBounds(25, 25, 300, 42);
		lblPlayGame.setFont(new Font("Tahoma", Font.BOLD, 40));
		add(lblPlayGame);

	}

	
	public void addActionListeners(ActionListener l) {
		btnCreateGame.addActionListener(l);
		btnJoinGame.addActionListener(l);
		btnBack.addActionListener(l);
	}
}
