import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class ControlPanel extends JPanel {
	private final String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8"};
	private JComboBox locationX;
	private JComboBox locationY;
	private JLabel row;
	private JLabel column;
	private JButton button;
	private int[] location;

	public ControlPanel() {
		setPreferredSize(new Dimension(200, BattleshipPanel.HEIGHT));
		setBackground(Color.darkGray);

		location = new int[2];
		location[0] = 1;
		location[1] = 1;

		row = new JLabel("Row: ");
		row.setForeground(Color.white);
		row.setFont(row.getFont().deriveFont(20f));
		locationX = new JComboBox(numbers);
		locationX.setEditable(false);
		add(row);
		add(locationX);

		column = new JLabel("Column: ");
		column.setForeground(Color.white);
		column.setFont(column.getFont().deriveFont(20f));
		locationY = new JComboBox(numbers);
		locationY.setEditable(false);
		add(column);
		add(locationY);

		button = new JButton("Submit");
		button.addActionListener(new ButtonListener());
		add(button);
	}

	public int[] getLocationXY() {
		return location;
	}

	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			location[0] = locationX.getSelectedIndex();
			location[1] = locationY.getSelectedIndex();
		}
	}
}
