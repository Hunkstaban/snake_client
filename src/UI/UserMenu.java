package UI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserMenu extends JPanel {

	private JButton btnPlayGame;
	private JButton btnHighscores;
	private JButton btnDeleteGame;
	private JButton btnLogOut;
	
	public UserMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setLayout(null);
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblMenu.setBounds(25, 25, 300, 40);
		add(lblMenu);
		
		btnPlayGame = new JButton("Play game");
		btnPlayGame.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnPlayGame.setBounds(150, 138, 300, 60);
		add(btnPlayGame);
		
		btnHighscores = new JButton("Highscores");
		btnHighscores.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnHighscores.setBounds(150, 215, 300, 60);
		add(btnHighscores);
		
		btnDeleteGame = new JButton("Delete game");
		btnDeleteGame.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnDeleteGame.setBounds(150, 292, 300, 60);
		add(btnDeleteGame);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 33));
		
		btnLogOut.setBounds(150, 369, 300, 60);
		add(btnLogOut);
	}
	
	public void addActionListeners(ActionListener l) {
		btnPlayGame.addActionListener(l);
		btnHighscores.addActionListener(l);
		btnDeleteGame.addActionListener(l);
		btnLogOut.addActionListener(l);
		
	}

}
