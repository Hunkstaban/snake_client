package UI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import DTO.Game;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class DeleteGame extends JPanel {

	private JButton btnBack;
	private JButton btnDelete;
	private JComboBox comboBox;
	private JLabel lblDeleteGame;

	public DeleteGame() {
		initialize();
	}

	private void initialize() {
		
		setLayout(null);
		JLabel lblChooseGameYou = new JLabel("Choose game you want to delete:");
		lblChooseGameYou.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblChooseGameYou.setBounds(110, 124, 456, 33);
		add(lblChooseGameYou);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnBack.setBounds(25, 650, 200, 60);
		add(btnBack);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 33));
			
		btnDelete.setBounds(700, 250, 171, 41);
		add(btnDelete);
		
		comboBox = new JComboBox();
		comboBox.setBounds(110, 224, 545, 81);
		add(comboBox);
		
		lblDeleteGame = new JLabel("DELETE GAME");
		lblDeleteGame.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblDeleteGame.setBounds(25, 25, 300, 40);
		add(lblDeleteGame);
	}
	
	public void addActionListeners(ActionListener delete) {
		btnBack.addActionListener(delete);
		btnDelete.addActionListener(delete);
	}
	
	public String getGame() {
		return (String)comboBox.getSelectedItem();
	}
	
	public void addGames(ArrayList<Game>deleteGames) {
		comboBox.removeAllItems();
		for (Game i:deleteGames) {
			comboBox.addItem(i.getName());
		}
	}
}
