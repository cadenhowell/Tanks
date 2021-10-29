package entities;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Creates a Barrier object.
 * 
 * @author Caden Howell
 */
public class Barrier extends JPanel {

	private int height;
	private int width;

	/**
	 * Creates and paints a barrier.
	 * 
	 * @param x
	 *            the x location of the barrier
	 * @param y
	 *            the y location of the barrier
	 * @param width
	 *            the width of the barrier
	 * @param height
	 *            the height of the barrier
	 */
	public Barrier(int x, int y, int width, int height) {
		this.height = height;
		this.width = width;
		setBounds(x, y, width, height);
		setOpaque(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
	}

}
