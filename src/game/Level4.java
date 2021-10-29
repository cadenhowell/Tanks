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
public class Level4 extends Level{

	Barrier[] barriers = new Barrier[2];
	
	public Level4(JLayeredPane mainPane, Tank[] tanks) {
		super(mainPane, tanks);
		
		Barrier barrier0 = new Barrier(Positioner.getQuarterX(mainPane, 30), Positioner.getFifthY(mainPane, 300), 30, 300);
		barriers[0] = barrier0;
		
		Barrier barrier1 = new Barrier(Positioner.getThreeQuarterX(mainPane, 30), Positioner.getFourFifthY(mainPane, 300), 30, 300);
		barriers[1] = barrier1;
		
		for (Barrier barrier : barriers)
			mainPane.add(barrier, new Integer(1));
	}

	@Override
	public void addTanks() {
		tanks[0].setLocation(1280, Positioner.getFourFifthY(mainPane, 104));
		tanks[0].rotateTank(90);
		tanks[0].setVisible(true);
		
		tanks[1].setLocation(57, Positioner.getFifthY(mainPane, 104));
		tanks[1].rotateTank(270);
		tanks[1].setVisible(true);
	}

	@Override
	public Barrier[] getBarriers() {
		return barriers;
	}

}
