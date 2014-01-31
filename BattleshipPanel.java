import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.util.Random;

public class BattleshipPanel extends JPanel {
	public static final int WIDTH = 600, HEIGHT = 600;
	
	private ControlPanel cPanel;
	private Rectangle bounds;
	private Timer timer;
	private Box box;
	private Box[][] boxes;
	private boolean initial;

	public BattleshipPanel (ControlPanel control) {
		cPanel = control;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.gray);
		bounds = new Rectangle(0, 0, WIDTH, HEIGHT);
		boxes = new Box[8][8];
		createBoxes(boxes);
		createBattleship(boxes);
		initial = true;

		timer = new Timer(100, new TimerListener());
		timer.start();
	}

	public void paintComponent(Graphics g) {
	//***Does not need to be edited
		super.paintComponent(g); //Call to the super constructor to make sure
		//all of JPanel's paintComponent stuff is called first
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				boxes[i][j].draw(g);
			}
		}	
	}

	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			check();
			repaint();
		}
	}

	public void createBoxes(Box[][] boxes) {
		int x = 120;
		int y = 120;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				boxes[i][j] = new Box(x,y);
				x = x + 40;
			}
			y = y + 40;
			x = 120;
		}
	}

	public void createBattleship (Box[][] boxes) {
		Random ranDirection = new Random();
		int direction =  ranDirection.nextInt(2);

		if (direction == 0) {
			int x1 = ranDirection.nextInt(5);
			int x2 = x1 + 1;
			int x3 = x1 + 2;
			int x4 = x1 + 3;

			int y1 = ranDirection.nextInt(8);

			for (int i = 0; i < 4; i++) {
				boxes[x1][y1].isBattleship();
				boxes[x2][y1].isBattleship();
				boxes[x3][y1].isBattleship();
				boxes[x4][y1].isBattleship();
			}
		} else { //
			int x1 = ranDirection.nextInt(8);

			int y1 = ranDirection.nextInt(5);
			int y2 = y1 + 1;
			int y3 = y1 + 2;
			int y4 = y1 + 3;

			for (int i = 0; i < 4; i++) {
				boxes[x1][y1].isBattleship();
				boxes[x1][y2].isBattleship();
				boxes[x1][y3].isBattleship();
				boxes[x1][y4].isBattleship();
			}
		}
	}

	public void check() {
		int[] locationXY = cPanel.getLocationXY();
		int xPos = locationXY[0];
		int yPos = locationXY[1];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) { 
				if ((i == xPos) && (j == yPos)) {
					if (boxes[i][j].getBattleship()) {
						boxes[i][j].hitBox();
					} else {
						boxes[i][j].emptyBox();
					}
				}
			}
		}
	}
}