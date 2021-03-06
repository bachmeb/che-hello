package shapes;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Point extends Shape with additional properties
 * @author bbachmey
 *
 */
public class Point extends Shape {

	/**
	 * Constructor
	 * @param lineColor
	 * @param x
	 * @param y
	 */
	public Point(Color lineColor, int x, int y) {
		super(lineColor, x, y);
	}

	/* (non-Javadoc)
	 * @see shapes.Shape#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {

		// Jot down the Color of the Graphics object
		Color jot = g.getColor();
		g.setColor(getLineColor());
		g.drawOval(getX(), getY(), 1, 1);

		// Re-jot the Color
		g.setColor(jot);

	}

	/* (non-Javadoc)
	 * @see shapes.Shape#containsLocation(int, int)
	 */
	@Override
	public boolean containsLocation(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

}
