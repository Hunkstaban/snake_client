package UI;

import DTO.Score;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.Font;
import java.util.ArrayList;

//highscore class which inherits the methods and attributes of JPanel
public class Highscore extends JPanel {

	//declaring the instance variables
	private JTable scoreTable;
	private JLabel lblHighscores;
	private JButton btnBack;
	

	//constructor for the highscore class
	public Highscore() {
		//will run the initialize method
		initialize();
	}

	//method that shows the contents of the panel
	private void initialize() {
		
		setLayout(null);

		//creating the headline label
		lblHighscores = new JLabel("Highscores");
		lblHighscores.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblHighscores.setBounds(25, 25, 300, 40);
		add(lblHighscores);
		
		//creating a JTable which will be used to show the highscores
		scoreTable = new JTable();
		JScrollPane scrollPane = new JScrollPane(scoreTable);
		scrollPane.setBounds(244, 93, 436, 423);
		add(scrollPane);

		//adding button
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnBack.setBounds(25, 650, 200, 60);
		add(btnBack);
	}

	//adding actionlistener to the "back" button, so it can be used
	public void addActionListeners(ActionListener l) {
		btnBack.addActionListener(l);
	}

	public void setScoreTable(ArrayList<Score> highscores){
		HighscoreTable tableModel = new HighscoreTable(highscores);
		scoreTable.setModel(tableModel);
	}

	//private class within the highscore class, which inherits the methods and attributes of AbstractTableModel
	private class HighscoreTable extends AbstractTableModel {

		//declaring the instance variables
		private ArrayList<Score> highscores;
		private String[] columns = {"Username","Score","GameID"};
		private int numberOfRows;


		public HighscoreTable(ArrayList<Score> highscores) {
			this.highscores = highscores;
		}

		public int getColumnCount() {
			return columns.length;
		}

		public Class<?> getColumnClass( int columnIndex){
			return super.getColumnClass(columnIndex);
		}

		public int getRowCount() {
			numberOfRows = highscores.size();
			return numberOfRows;
		}

		public String getColumnName(int columnIndex){
			return columns[columnIndex];
		}

		//adding the rows into the coloums, which will show the user, its score and the game id of the game played
		public Object getValueAt(int rowIndex, int coloumnIndex) {
			highscores.get(rowIndex);
			switch (coloumnIndex) {
				case 0:
					return highscores.get(rowIndex).getUser().getUsername();
				case 1:
					return highscores.get(rowIndex).getScore();
				case 2:
					return highscores.get(rowIndex).getGame().getGameId();
			}
			return null;
		}
	}

}
