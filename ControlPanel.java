import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
	private String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8"};
	private boolean countsZero;
	private boolean result;
	private int count;
	private int[] location;
	private JButton button;
	private JComboBox locationX;
	private JComboBox locationY;
	private JLabel column;
	private JLabel directions;
	private JLabel numOfTurns;
	private JLabel resultMessage;
	private JLabel row;

	public ControlPanel() {
		setPreferredSize(new Dimension(200, BattleshipPanel.HEIGHT));
		setBackground(Color.darkGray);
		location = new int[2];
		location[0] = 10;
		location[1] = 10;
		result = false;
		countsZero = false;
		count = 15;
		
		add(directionPanel());
		add(emptyPanel1());
		add(locationPanel());
		add(submitPanel());
		add(emptyPanel2());
		add(numOfTurnsPanel());
		add(emptyPanel3());
		add(resultPanel());
	}

	public int[] getLocationXY() {
		return location;
	}

	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			count--;
			numOfTurns.setText("<html>Number of Turns Left: " + count + "<html>");

			location[0] = locationX.getSelectedIndex();
			location[1] = locationY.getSelectedIndex();

			if (count == 0) {
				if (BattleshipPanel.numOfShipsFound == 4) {
					resultMessage.setText("You won!");
				} else {
					resultMessage.setText("You lost!");
				}
				button.setEnabled(false);
			}

			if (BattleshipPanel.numOfShipsFound == 4) {
				count = 0;
				button.setEnabled(false);
				resultMessage.setText("You won!");
			}
		}
	}

	private JPanel directionPanel() {
		JPanel directionPanel = new JPanel();
		directionPanel.setBackground(Color.darkGray);
		directionPanel.setLayout(new GridLayout(1, 0));
		directionPanel.setPreferredSize(new Dimension(180, 170));

		directions = new JLabel();
		directions.setText("<html>"
			+ "<br><br>"
			+ "Directions:" 
			+ "<br>"
			+ "Select a row and column as the point that you want to hit."
			+ "There are four boxes that make up a battleship."
			+ "<br>" 
			+ "Yellow means hit while white means miss."
			+ "</html>");
		directions.setForeground(Color.white);
		directions.setFont(directions.getFont().deriveFont(14f));
		directionPanel.add(directions);
		return directionPanel;
	}

	private JPanel locationPanel() {		
		JPanel locationPanel = new JPanel();
		locationPanel.setBackground(Color.darkGray);
		locationPanel.setLayout(new GridLayout(2, 2));
		locationPanel.setPreferredSize(new Dimension(180, 60));

		row = new JLabel("Row: ");
		row.setForeground(Color.white);
		row.setFont(row.getFont().deriveFont(16f));
		locationX = new JComboBox(numbers);
		locationX.setEditable(false);
		locationPanel.add(row);
		locationPanel.add(locationX);

		column = new JLabel("Column: ");
		column.setForeground(Color.white);
		column.setFont(column.getFont().deriveFont(16f));
		locationY = new JComboBox(numbers);
		locationY.setEditable(false);
		locationPanel.add(column);
		locationPanel.add(locationY);
		return locationPanel;
	}

	private JPanel submitPanel() {
		JPanel submitPanel = new JPanel();
		submitPanel.setBackground(Color.darkGray);
		submitPanel.setLayout(new GridLayout(1, 0));
		submitPanel.setPreferredSize(new Dimension(100, 30));

		button = new JButton("Submit");
		button.addActionListener(new ButtonListener());
		submitPanel.add(button);
		return submitPanel;
	}

	private JPanel resultPanel() {
		JPanel resultPanel = new JPanel();
		resultPanel.setBackground(Color.darkGray);
		resultPanel.setLayout(new GridLayout(1, 0));
		resultPanel.setPreferredSize(new Dimension(100, 30));

		resultMessage = new JLabel("");
		resultMessage.setForeground(Color.white);
		resultMessage.setFont(resultMessage.getFont().deriveFont(16f));
		resultPanel.add(resultMessage);
		return resultPanel;
	}

	private JPanel numOfTurnsPanel() {
		JPanel numOfTurnsPanel = new JPanel();
		numOfTurnsPanel.setBackground(Color.darkGray);
		numOfTurnsPanel.setLayout(new GridLayout(1, 0));
		numOfTurnsPanel.setPreferredSize(new Dimension(180, 30));

		numOfTurns = new JLabel("<html>Number of Turns Left: 15<html>");
		numOfTurns.setForeground(Color.white);
		numOfTurns.setFont(numOfTurns.getFont().deriveFont(14f));
		numOfTurnsPanel.add(numOfTurns);
		return numOfTurnsPanel;
	}

	private JPanel emptyPanel1() {
		JPanel emptyPanel1 = new JPanel();
		emptyPanel1.setBackground(Color.darkGray);
		emptyPanel1.setLayout(new GridLayout(1, 0));
		emptyPanel1.setPreferredSize(new Dimension(200, 50));
		return emptyPanel1;
	}

	private JPanel emptyPanel2() {
		JPanel emptyPanel2 = new JPanel();
		emptyPanel2.setBackground(Color.darkGray);
		emptyPanel2.setLayout(new GridLayout(1, 0));
		emptyPanel2.setPreferredSize(new Dimension(200, 50));
		return emptyPanel2;
	}

	private JPanel emptyPanel3() {
		JPanel emptyPanel3 = new JPanel();
		emptyPanel3.setBackground(Color.darkGray);
		emptyPanel3.setLayout(new GridLayout(1, 0));
		emptyPanel3.setPreferredSize(new Dimension(200, 50));
		return emptyPanel3;
	}
}
