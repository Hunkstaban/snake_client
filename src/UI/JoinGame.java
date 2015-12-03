package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import DTO.Game;
import java.awt.Font;

public class JoinGame extends JPanel {
	private JLabel lblJoinGame;
	private JButton btnBack;
	private JLabel lblGameInvites;
	private JComboBox comboBoxGames;
	private JTextField controls;
	private JLabel lblControls;
	private JButton btnPlay;

	/**
	 * Create the panel.
	 */
	public JoinGame() {
		setLayout(null);
		
		lblJoinGame = new JLabel("Join Game");
		lblJoinGame.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblJoinGame.setBounds(25, 25, 300, 40);
		add(lblJoinGame);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnBack.setBounds(25, 650, 200, 60);
		add(btnBack);
		
		lblGameInvites = new JLabel("Game invites:");
		lblGameInvites.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblGameInvites.setBounds(311, 118, 221, 33);
		add(lblGameInvites);
		
		comboBoxGames = new JComboBox();
		comboBoxGames.setBounds(311, 159, 386, 51);
		add(comboBoxGames);
		
		controls = new JTextField();
		controls.setFont(new Font("Tahoma", Font.PLAIN, 33));
		controls.setBounds(311, 312, 326, 50);
		add(controls);
		controls.setColumns(10);
		
		lblControls = new JLabel("Controls:");
		lblControls.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblControls.setBounds(311, 263, 165, 33);
		add(lblControls);
		
		btnPlay = new JButton("Play");
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnPlay.setBounds(660, 470, 200, 60);
		add(btnPlay);

	}
	
	public void addActionListeners(ActionListener l) {
		btnBack.addActionListener(l);
		btnPlay.addActionListener(l);
	}
	
	public void setGame(ArrayList<Game>games){
		comboBoxGames.removeAllItems();
		for (Game i:games) {
			comboBoxGames.addItem(i.getName());
		}
	}

	public String getGameName() {
		return (String)comboBoxGames.getSelectedItem();
	}

	public String getControls() {
		return controls.getText();
	}
	
	

}
