package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import DTO.User;

import javax.swing.JComboBox;
import java.awt.Font;

//CreateGame class which inherits the methods and attributes of JPanel
public class CreateGame extends JPanel {

	//declaring the instance variables
	private JLabel lblCreateGame;
	private JButton btnBack;
	private JTextField gameName;
	private JLabel lblGameName;
	private JLabel lblControls;
	private JTextField controls;
	private JLabel lblChooseOpponent;
	private JComboBox comboBoxOpponent;
	private JButton btnCreateGame;
	private JLabel lblReminder;

	//the class constructor
	public CreateGame() {
		setLayout(null);

		//creating a JLabel(headline) for the panel
		lblCreateGame = new JLabel("Create game");
		lblCreateGame.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblCreateGame.setBounds(25, 25, 300, 40);
		add(lblCreateGame);

		//creating a button that will enable the user to go back to the menu
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnBack.setBounds(25, 650, 200, 60);
		add(btnBack);

		//adding a textfield, which enables the user to input a name for the game
		gameName = new JTextField();
		gameName.setFont(new Font("Tahoma", Font.PLAIN, 33));
		gameName.setBounds(70, 199, 326, 50);
		add(gameName);
		gameName.setColumns(10);

		//adding labels
		lblGameName = new JLabel("Game name:");
		lblGameName.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblGameName.setBounds(70, 139, 194, 48);
		add(lblGameName);
		
		lblControls = new JLabel("Controls:");
		lblControls.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblControls.setBounds(466, 147, 500, 33);
		add(lblControls);

		lblReminder = new JLabel("(Remember: use WASD)");
		lblReminder.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReminder.setBounds(466,250,350,33);
		add(lblReminder);

		//adding a textfield, which enables the user to input controls for the game
		controls = new JTextField();
		controls.setFont(new Font("Tahoma", Font.PLAIN, 33));
		controls.setBounds(466, 200, 326, 50);
		add(controls);
		controls.setColumns(10);

		//adding label
		lblChooseOpponent = new JLabel("Choose opponent:");
		lblChooseOpponent.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblChooseOpponent.setBounds(70, 268, 305, 33);
		add(lblChooseOpponent);
		
		//adding a combo box
		comboBoxOpponent = new JComboBox();
		comboBoxOpponent.setBounds(70, 314, 437, 57);
		add(comboBoxOpponent);

		//adding a button which will enable the user to create a game
		btnCreateGame = new JButton("Create game");
		btnCreateGame.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnCreateGame.setBounds(558, 314, 220, 60);
		add(btnCreateGame);

	}
	
	//adding actionlisteners to the buttons, so they can be pushed and work
	public void addActionListeners(ActionListener l) {
		btnBack.addActionListener(l);
		btnCreateGame.addActionListener(l);
	}
	
	
	//enabling the combobox to show all users in the database by going through the arraylist with a for loop
	public void setOpponent(ArrayList<User>users){
		comboBoxOpponent.removeAllItems();
		for (User i:users) {
			comboBoxOpponent.addItem(i.getUsername());
		}
	}

	//making getters so they can be used by other classes
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
