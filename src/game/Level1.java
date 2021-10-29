package game;

import javax.swing.JLayeredPane;

import entities.Barrier;
import entities.Tank;
import tools.Positioner;

/**
 * Creates a level that places the tanks and creates and places barriers.
 * 
 * @author Caden Howell
 */
public class Level1 extends Level {

	private Barrier[] barriers = new Barrier[0];

	public Level1(JLayeredPane mainPane, Tank[] tanks) {
		super(mainPane, tanks);
	}

	@Override
	public void addTanks() {
		tanks[0].setLocation(1280, Positioner.getCenterY(mainPane, 104));
		tanks[0].rotateTank(90);

		tanks[1].setLocation(57, Positioner.getCenterY(mainPane, 104));
		tanks[1].rotateTank(270);
	}

	@Override
	public Barrier[] getBarriers() {
		return barriers;
	}

}
