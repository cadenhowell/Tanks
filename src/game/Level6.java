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
public class Level6 extends Level {

Barrier[] barriers = new Barrier[3];
	
	public Level6(JLayeredPane mainPane, Tank[] tanks) {
		super(mainPane, tanks);
		
		Barrier barrier0 = new Barrier(0, Positioner.getFifthY(mainPane, 5) + 20, 700, 5);
		barriers[0] = barrier0;
		
		Barrier barrier1 = new Barrier(MainDisplay.DISPWIDTH - 700, Positioner.getCenterY(mainPane, 5), 700, 5);
		barriers[1] = barrier1;
		
		Barrier barrier2 = new Barrier(0, Positioner.getFourFifthY(mainPane, 5) - 20, 700, 5);
		barriers[2] = barrier2;
		
		for (Barrier barrier : barriers)
			mainPane.add(barrier, new Integer(1));
	}

	@Override
	public void addTanks() {
		tanks[0].setLocation(Positioner.getFifthX(mainPane, 104), MainDisplay.DISPHEIGHT);
		tanks[0].rotateTank(180);
		tanks[0].setVisible(true);
		
		tanks[1].setLocation(Positioner.getFifthX(mainPane, 104), 0);
		tanks[1].rotateTank(0);
		tanks[1].setVisible(true);
	}

	@Override
	public Barrier[] getBarriers() {
		return barriers;
	}

}
