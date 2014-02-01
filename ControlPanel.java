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
	private final String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8"};
	private int[] location;
	private JButton button;
	private JComboBox locationX;
	private JComboBox locationY;
	private JLabel column;
	private JLabel directions;
	private JLabel row;
	private boolean gameOver;
	private boolean result;
	private JLabel resultMessage;
	private int counter;
	private JLabel numOfTurns;

	public ControlPanel() {
		setPreferredSize(new Dimension(200, BattleshipPanel.HEIGHT));
		setBackground(Color.darkGray);
		location = new int[2];
		location[0] = 10;
		location[1] = 10;
		result = false;
		gameOver = false;
		counter = 15;

		JPanel directionPanel = new JPanel();
		directionPanel.setBackground(Color.darkGray);
        directionPanel.setLayout(new GridLayout(1,0));
        directionPanel.setPreferredSize(new Dimension(180, 170));

        directions = new JLabel();
        directions.setText("<html>"
        			+ "<br><br>"
                    + "Directions:" 
                    + "<br>"
                    + "Select a row and column as the point that you want to hit."
                    + "<br>" 
                    + "Yellow means hit while white means miss."
                    +"</html>");
        directions.setForeground(Color.white);
		directions.setFont(directions.getFont().deriveFont(14f));
		directionPanel.add(directions);

		JPanel locationPanel = new JPanel();
		locationPanel.setBackground(Color.darkGray);
        locationPanel.setLayout(new GridLayout(2,2));
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

		JPanel submitPanel = new JPanel();
		submitPanel.setBackground(Color.darkGray);
        submitPanel.setLayout(new GridLayout(1,0));
        submitPanel.setPreferredSize(new Dimension(100, 30));

		button = new JButton("Submit");
		button.addActionListener(new ButtonListener());
		submitPanel.add(button);

		JPanel resultPanel = new JPanel();
		resultPanel.setBackground(Color.darkGray);
        resultPanel.setLayout(new GridLayout(1,0));
        resultPanel.setPreferredSize(new Dimension(100, 30));

        resultMessage = new JLabel("");
        resultMessage.setForeground(Color.white);
		resultMessage.setFont(resultMessage.getFont().deriveFont(16f));
		if (result) {
			resultMessage.setText("You won!");
		} else {
			resultMessage.setText("You lost!");
		}
		resultPanel.add(resultMessage);

		JPanel numOfTurnsPanel = new JPanel();
		numOfTurnsPanel.setBackground(Color.darkGray);
        numOfTurnsPanel.setLayout(new GridLayout(1,0));
        numOfTurnsPanel.setPreferredSize(new Dimension(180, 30));

        numOfTurns = new JLabel();
        numOfTurns.setText("<html>Number of Turns Left: " + counter + "<html>");
        numOfTurns.setForeground(Color.white);
		numOfTurns.setFont(resultMessage.getFont().deriveFont(14f));
		numOfTurnsPanel.add(numOfTurns);

		JPanel emptyPanel1 = new JPanel();
		emptyPanel1.setBackground(Color.darkGray);
        emptyPanel1.setLayout(new GridLayout(1,0));
        emptyPanel1.setPreferredSize(new Dimension(200, 50));

        JPanel emptyPanel2 = new JPanel();
		emptyPanel2.setBackground(Color.darkGray);
        emptyPanel2.setLayout(new GridLayout(1,0));
        emptyPanel2.setPreferredSize(new Dimension(200, 50));

        JPanel emptyPanel3 = new JPanel();
		emptyPanel3.setBackground(Color.darkGray);
        emptyPanel3.setLayout(new GridLayout(1,0));
        emptyPanel3.setPreferredSize(new Dimension(200, 50));

		add(directionPanel);
		add(emptyPanel1);
		add(locationPanel);
		add(submitPanel);
		add(emptyPanel2);
		add(numOfTurnsPanel);
		add(emptyPanel3);
		if (gameOver) {
			add(resultPanel);
		}
	}

	public int[] getLocationXY() {
		return location;
	}

	public void gameIsOver() {
		gameOver = true;
	}

	public void userWins() {
		result = true;
		counter = 0;
	}

	public void decrementCounter() {
		counter--;
	}

	public int getCounter() {
		return counter;
	}

	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			location[0] = locationX.getSelectedIndex();
			location[1] = locationY.getSelectedIndex();
		}
	}
}
