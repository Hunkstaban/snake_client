package UI;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Font;

public class Highscore extends JPanel {

	
	private JTable scoreTable;
	private JLabel lblHighscores;
	private JButton btnBack;
	

	
	public Highscore() {
		initialize();
	}


	private void initialize() {
		
		setLayout(null);
		lblHighscores = new JLabel("Highscores");
		lblHighscores.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblHighscores.setBounds(25, 25, 300, 40);
		add(lblHighscores);
		
		scoreTable = new JTable();
		scoreTable.setBounds(244, 93, 436, 423);
		JScrollPane scrollPane = new JScrollPane(scoreTable);
		add(scrollPane);

		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnBack.setBounds(25, 650, 200, 60);
		add(btnBack);
	}

	public void addActionListeners(ActionListener l) {
		btnBack.addActionListener(l);
	}
}
