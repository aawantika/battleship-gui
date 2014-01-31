import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.Color;

public class Box {
	private int x, y;
	private Color c;
	private boolean battleship;

	public Box (int xPos, int yPos) {
		x = xPos;
		y = yPos;
		c = Color.black;
		battleship = false;
	}

	public void draw(Graphics g) {
		g.setColor(c);
        g.fillRect(x, y, 35, 35);
    }

    public void isBattleship() {
    	battleship = true;
    }

    public boolean getBattleship() {
        return battleship;
    }

    //The user selects this box but there is no ship.
    public void emptyBox() {
        c = Color.white;
    }

    //The user selects this box and there is a ship.
    public void hitBox() {
        c = Color.yellow;
    }
}
