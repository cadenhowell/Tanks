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
public class Level7 extends Level {

Barrier[] barriers = new Barrier[2];
	
	public Level7(JLayeredPane mainPane, Tank[] tanks) {
		super(mainPane, tanks);
		
		Barrier barrier0 = new Barrier(400, Positioner.getCenterY(mainPane, 30), 640, 30);
		barriers[0] = barrier0;
		
		Barrier barrier1 = new Barrier(Positioner.getCenterX(mainPane, 30), 100, 30, 640);
		barriers[1] = barrier1;
		
		for (Barrier barrier : barriers)
			mainPane.add(barrier, new Integer(1));
	}

	@Override
	public void addTanks() {
		tanks[0].setLocation(Positioner.getFifthX(mainPane, 104), 0);
		tanks[0].rotateTank(-45);
		tanks[0].setVisible(true);
		
		tanks[1].setLocation(Positioner.getFourFifthX(mainPane, 104), MainDisplay.DISPHEIGHT);
		tanks[1].rotateTank(135);
		tanks[1].setVisible(true);
	}

	@Override
	public Barrier[] getBarriers() {
		return barriers;
	}

}
