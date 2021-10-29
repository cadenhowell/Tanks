package game;

import javax.swing.JLayeredPane;

import display.MainDisplay;
import entities.Barrier;
import entities.Tank;
import tools.Positioner;

/**
 * Creates a level that places the tanks and creates and places barriers.
 * 
 * @author Caden Howell
 */
public class Level5 extends Level {

Barrier[] barriers = new Barrier[3];
	
	public Level5(JLayeredPane mainPane, Tank[] tanks) {
		super(mainPane, tanks);
		
		Barrier barrier0 = new Barrier(Positioner.getCenterX(mainPane, 1000), Positioner.getQuarterY(mainPane, 10), 1000, 10);
		barriers[0] = barrier0;
		
		Barrier barrier1 = new Barrier(Positioner.getCenterX(mainPane, 1000), Positioner.getThreeQuarterY(mainPane, 10), 1000, 10);
		barriers[1] = barrier1;
		
		Barrier barrier2 = new Barrier(Positioner.getCenterX(mainPane, 100), Positioner.getCenterY(mainPane, 100), 100, 100);
		barriers[2] = barrier2;
		
		for (Barrier barrier : barriers)
			mainPane.add(barrier, new Integer(1));
	}

	@Override
	public void addTanks() {
		tanks[0].setLocation(Positioner.getCenterX(mainPane, 104), 0);
		tanks[0].rotateTank(0);
		tanks[0].setVisible(true);
		
		tanks[1].setLocation(Positioner.getCenterX(mainPane, 104), MainDisplay.DISPHEIGHT);
		tanks[1].rotateTank(180);
		tanks[1].setVisible(true);
	}

	@Override
	public Barrier[] getBarriers() {
		return barriers;
	}

}
