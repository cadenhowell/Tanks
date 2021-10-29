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
public class Level2 extends Level {
	private Barrier[] barriers = new Barrier[4];

	public Level2(JLayeredPane mainPane, Tank[] tanks) {
		super(mainPane, tanks);
		Barrier barrier1 = new Barrier(Positioner.getQuarterX(mainPane, 130), Positioner.getQuarterY(mainPane, 100),
				130, 100);
		barriers[0] = barrier1;

		Barrier barrier2 = new Barrier(Positioner.getQuarterX(mainPane, 130),
				Positioner.getThreeQuarterY(mainPane, 100), 130, 100);
		barriers[1] = barrier2;

		Barrier barrier3 = new Barrier(Positioner.getThreeQuarterX(mainPane, 130),
				Positioner.getQuarterY(mainPane, 100), 130, 100);
		barriers[2] = barrier3;

		Barrier barrier4 = new Barrier(Positioner.getThreeQuarterX(mainPane, 130),
				Positioner.getThreeQuarterY(mainPane, 100), 130, 100);
		barriers[3] = barrier4;

		for (Barrier barrier : barriers)
			mainPane.add(barrier, new Integer(1));
	}

	@Override
	public void addTanks() {
		tanks[0].setLocation(1280, Positioner.getCenterY(mainPane, 104));
		tanks[0].rotateTank(90);
		tanks[0].setVisible(true);

		tanks[1].setLocation(57, Positioner.getCenterY(mainPane, 104));
		tanks[1].rotateTank(270);
		tanks[1].setVisible(true);
	}

	@Override
	public Barrier[] getBarriers() {
		return barriers;
	}
}
