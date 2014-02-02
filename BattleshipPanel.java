import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BattleshipPanel extends JPanel {
	public static final int WIDTH = 600, HEIGHT = 600;
	public static int numOfShipsFound = 0;

	private Box box;
	private Box[][] boxes;
	private ControlPanel cPanel;
	private Rectangle bounds;
	private Timer timer;

	public BattleshipPanel(ControlPanel control) {
		cPanel = control;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.gray);
		bounds = new Rectangle(0, 0, WIDTH, HEIGHT);
		boxes = new Box[8][8];
		createBoxes(boxes);
		createBattleship(boxes);

		timer = new Timer(100, new TimerListener());
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				boxes[i][j].draw(g);
			}
		}	
	}

	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			checkHits();
			checkLocation();
			repaint();
		}
	}

	public void createBoxes(Box[][] boxes) {
		int x = 120;
		int y = 120;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				boxes[i][j] = new Box(x, y);
				x = x + 40;
			}
			y = y + 40;
			x = 120;
		}
	}

	public void createBattleship(Box[][] boxes) {
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
		} else { 
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

	public void checkLocation() {
		int[] locationXY = cPanel.getLocationXY();
		int xPos = locationXY[0];
		int yPos = locationXY[1];

		if ((xPos != 10) && (yPos != 10)) {
			if (boxes[xPos][yPos].getBattleship()) {
				boxes[xPos][yPos].hitBox();
			} else {
				boxes[xPos][yPos].emptyBox();
			}
		} 
	}

	public void checkHits() {
		numOfShipsFound = 1;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (Color.YELLOW.equals(boxes[i][j].getColor())) {
					numOfShipsFound++;
				}
			}
		}
	}
}
