import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Battleship {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Battleship");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ControlPanel control = new ControlPanel();
		frame.add(control, BorderLayout.WEST);
		frame.add(new BattleshipPanel(control)); //defaults to CENTER
		frame.pack();
		frame.setVisible(true);
	}
}