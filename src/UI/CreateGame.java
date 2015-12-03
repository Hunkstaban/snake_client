package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import DTO.User;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.Font;

public class CreateGame extends JPanel {
	private JLabel lblCreateGame;
	private JButton btnBack;
	private JTextField gameName;
	private JLabel lblGameName;
	private JLabel lblControls;
	private JTextField controls;
	private JLabel lblChooseOpponent;
	private JComboBox comboBoxOpponent;
	private JButton btnCreateGame;

	/**
	 * Create the panel.
	 */
	public CreateGame() {
		setLayout(null);
		
		lblCreateGame = new JLabel("Create game");
		lblCreateGame.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblCreateGame.setBounds(25, 25, 300, 40);
		add(lblCreateGame);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnBack.setBounds(25, 650, 200, 60);
		add(btnBack);
		
		gameName = new JTextField();
		gameName.setFont(new Font("Tahoma", Font.PLAIN, 33));
		gameName.setBounds(70, 199, 326, 50);
		add(gameName);
		gameName.setColumns(10);
		
		lblGameName = new JLabel("Game name:");
		lblGameName.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblGameName.setBounds(70, 139, 194, 48);
		add(lblGameName);
		
		lblControls = new JLabel("Controls:");
		lblControls.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblControls.setBounds(466, 147, 207, 33);
		add(lblControls);
		
		controls = new JTextField();
		controls.setFont(new Font("Tahoma", Font.PLAIN, 33));
		controls.setBounds(466, 200, 326, 50);
		add(controls);
		controls.setColumns(10);
		
		lblChooseOpponent = new JLabel("Choose opponent:");
		lblChooseOpponent.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblChooseOpponent.setBounds(70, 268, 305, 33);
		add(lblChooseOpponent);
		
		comboBoxOpponent = new JComboBox();
		comboBoxOpponent.setBounds(70, 314, 437, 57);
		add(comboBoxOpponent);
		
		btnCreateGame = new JButton("Create game");
		btnCreateGame.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnCreateGame.setBounds(558, 314, 220, 60);
		add(btnCreateGame);

	}
	

	public void addActionListeners(ActionListener l) {
		btnBack.addActionListener(l);
		btnCreateGame.addActionListener(l);
	}
	
	
	
	public void setOpponent(ArrayList<User>users){
		comboBoxOpponent.removeAllItems();
		for (User i:users) {
			comboBoxOpponent.addItem(i.getUsername());
		}
	}
	
	public String getGameName() {
		return gameName.getText();
	}
	
	public String getControls() {
		return controls.getText();
	}
	
	public String getUsername() {
		return (String)comboBoxOpponent.getSelectedItem();
	}
	
	
}
