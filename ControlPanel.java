import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.GroupLayout;

public class ControlPanel extends JPanel {
	private final String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8"};
	private int[] location;
	private JButton button;
	private JComboBox locationX;
	private JComboBox locationY;
	private JLabel column;
	private JLabel row;
	private GroupLayout layout;

	public ControlPanel() {
		setPreferredSize(new Dimension(200, BattleshipPanel.HEIGHT));
		setBackground(Color.darkGray);

		location = new int[2];
		location[0] = 10;
		location[1] = 10;

		layout = new GroupLayout(this); 
		this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

		row = new JLabel("Row: ");
		row.setForeground(Color.white);
		row.setFont(row.getFont().deriveFont(16f));
		locationX = new JComboBox(numbers);
		locationX.setEditable(false);

		column = new JLabel("Column: ");
		column.setForeground(Color.white);
		column.setFont(column.getFont().deriveFont(16f));
		locationY = new JComboBox(numbers);
		locationY.setEditable(false);

		layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(row)
                .addComponent(column))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(locationX)
                .addComponent(locationY))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(row)
                .addComponent(locationX))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(column)
                .addComponent(locationY))
        );

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
