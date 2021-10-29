package game;

import javax.swing.JLayeredPane;

import entities.Barrier;
import entities.Tank;

/**
 * Creates a level that places the tanks and creates and places barriers.
 * 
 * @author Caden Howell
 */
public abstract class Level {

	public JLayeredPane mainPane;
	public Tank[] tanks;

	/**
	 * A general level setup which all subclasses will have to follow.
	 * 
	 * @param mainPane
	 *            the JLayeredPane which will be added to
	 * @param tanks
	 *            the array of tanks to reference
	 */
	public Level(JLayeredPane mainPane, Tank[] tanks) {
		this.mainPane = mainPane;
		this.tanks = tanks;
		addTanks();
	}

	/**
	 * Adds the tanks to the frame.
	 */
	public abstract void addTanks();

	/**
	 * Returns the array of barriers.
	 * 
	 * @return the array of barriers
	 */
	public abstract Barrier[] getBarriers();

}
