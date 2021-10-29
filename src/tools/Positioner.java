package tools;

import javax.swing.JLayeredPane;

/**
 * Provides a means of easy positioning of components.
 * 
 * @author Caden Howell
 */
public class Positioner {

	/**
	 * Gets the ideal center x coordinate for the component.
	 * 
	 * @param jl
	 *            the JLayeredPane which will be positioned on
	 * @param width
	 *            the width of the component
	 * @return the x coordinate of where to place the component
	 */
	public static int getCenterX(JLayeredPane jl, int width) {
		return (jl.getWidth() / 2) - (width / 2);
	}

	/**
	 * Gets the ideal center y coordinate for the component.
	 * 
	 * @param jl
	 *            the JLayeredPane which will be positioned on
	 * @param height
	 *            the height of the component
	 * @return the y coordinate of where to place the component
	 */
	public static int getCenterY(JLayeredPane jl, int height) {
		return (jl.getHeight() / 2) - (height / 2);
	}

	/**
	 * Gets the ideal 1/3 x coordinate for the component.
	 * 
	 * @param jl
	 *            the JLayeredPane which will be positioned on
	 * @param width
	 *            the width of the component
	 * @return the x coordinate of where to place the component
	 */
	public static int getThirdX(JLayeredPane jl, int width) {
		return (jl.getWidth() / 3) - (width / 2);
	}

	/**
	 * Gets the ideal 1/3 y coordinate for the component.
	 * 
	 * @param jl
	 *            the JLayeredPane which will be positioned on
	 * @param height
	 *            the height of the component
	 * @return the y coordinate of where to place the component
	 */
	public static int getThirdY(JLayeredPane jl, int height) {
		return (jl.getHeight() / 3) - (height / 2);
	}

	/**
	 * Gets the ideal 2/3 x coordinate for the component.
	 * 
	 * @param jl
	 *            the JLayeredPane which will be positioned on
	 * @param width
	 *            the width of the component
	 * @return the x coordinate of where to place the component
	 */
	public static int getTwoThirdX(JLayeredPane jl, int width) {
		return (2 * jl.getWidth() / 3) - (width / 2);
	}

	/**
	 * Gets the ideal 2/3 y coordinate for the component.
	 * 
	 * @param jl
	 *            the JLayeredPane which will be positioned on
	 * @param height
	 *            the height of the component
	 * @return the y coordinate of where to place the component
	 */
	public static int getTwoThirdY(JLayeredPane jl, int height) {
		return (2 * jl.getHeight() / 3) - (height / 2);
	}

	/**
	 * Gets the ideal 1/4 x coordinate for the component.
	 * 
	 * @param jl
	 *            the JLayeredPane which will be positioned on
	 * @param width
	 *            the width of the component
	 * @return the x coordinate of where to place the component
	 */
	public static int getQuarterX(JLayeredPane jl, int width) {
		return (jl.getWidth() / 4) - (width / 2);
	}

	/**
	 * Gets the ideal 1/4 y coordinate for the component.
	 * 
	 * @param jl
	 *            the JLayeredPane which will be positioned on
	 * @param height
	 *            the height of the component
	 * @return the y coordinate of where to place the component
	 */
	public static int getQuarterY(JLayeredPane jl, int height) {
		return (jl.getHeight() / 4) - (height / 2);
	}

	/**
	 * Gets the ideal 3/4 x coordinate for the component.
	 * 
	 * @param jl
	 *            the JLayeredPane which will be positioned on
	 * @param width
	 *            the width of the component
	 * @return the x coordinate of where to place the component
	 */
	public static int getThreeQuarterX(JLayeredPane jl, int width) {
		return (3 * jl.getWidth() / 4) - (width / 2);
	}

	/**
	 * Gets the ideal 3/4 y coordinate for the component.
	 * 
	 * @param jl
	 *            the JLayeredPane which will be positioned on
	 * @param height
	 *            the height of the component
	 * @return the y coordinate of where to place the component
	 */
	public static int getThreeQuarterY(JLayeredPane jl, int height) {
		return (3 * jl.getHeight() / 4) - (height / 2);
	}

	/**
	 * Gets the ideal 1/5 x coordinate for the component.
	 * 
	 * @param jl
	 *            the JLayeredPane which will be positioned on
	 * @param width
	 *            the width of the component
	 * @return the x coordinate of where to place the component
	 */
	public static int getFifthX(JLayeredPane jl, int width) {
		return (jl.getWidth() / 5) - (width / 2);
	}

	/**
	 * Gets the ideal 1/5 y coordinate for the component.
	 * 
	 * @param jl
	 *            the JLayeredPane which will be positioned on
	 * @param height
	 *            the height of the component
	 * @return the y coordinate of where to place the component
	 */
	public static int getFifthY(JLayeredPane jl, int height) {
		return (jl.getHeight() / 5) - (height / 2);
	}

	/**
	 * Gets the ideal 2/5 x coordinate for the component.
	 * 
	 * @param jl
	 *            the JLayeredPane which will be positioned on
	 * @param width
	 *            the width of the component
	 * @return the x coordinate of where to place the component
	 */
	public static int getTwoFifthX(JLayeredPane jl, int width) {
		return (2 * jl.getWidth() / 5) - (width / 2);
	}

	/**
	 * Gets the ideal 2/5 y coordinate for the component.
	 * 
	 * @param jl
	 *            the JLayeredPane which will be positioned on
	 * @param height
	 *            the height of the component
	 * @return the y coordinate of where to place the component
	 */
	public static int getTwoFifthY(JLayeredPane jl, int height) {
		return (2 * jl.getHeight() / 5) - (height / 2);
	}

	/**
	 * Gets the ideal 3/5 x coordinate for the component.
	 * 
	 * @param jl
	 *            the JLayeredPane which will be positioned on
	 * @param width
	 *            the width of the component
	 * @return the x coordinate of where to place the component
	 */
	public static int getThreeFifthX(JLayeredPane jl, int width) {
		return (3 * jl.getWidth() / 5) - (width / 2);
	}

	/**
	 * Gets the ideal 3/5 y coordinate for the component.
	 * 
	 * @param jl
	 *            the JLayeredPane which will be positioned on
	 * @param height
	 *            the height of the component
	 * @return the y coordinate of where to place the component
	 */
	public static int getThreeFifthY(JLayeredPane jl, int height) {
		return (3 * jl.getHeight() / 5) - (height / 2);
	}

	/**
	 * Gets the ideal 4/5 x coordinate for the component.
	 * 
	 * @param jl
	 *            the JLayeredPane which will be positioned on
	 * @param width
	 *            the width of the component
	 * @return the x coordinate of where to place the component
	 */
	public static int getFourFifthX(JLayeredPane jl, int width) {
		return (4 * jl.getWidth() / 5) - (width / 2);
	}

	/**
	 * Gets the ideal 4/5 y coordinate for the component.
	 * 
	 * @param jl
	 *            the JLayeredPane which will be positioned on
	 * @param height
	 *            the height of the component
	 * @return the y coordinate of where to place the component
	 */
	public static int getFourFifthY(JLayeredPane jl, int height) {
		return (4 * jl.getHeight() / 5) - (height / 2);
	}

}
