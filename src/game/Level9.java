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
public class Level9 extends Level {

Barrier[] barriers = new Barrier[3];
	
	public Level9(JLayeredPane mainPane, Tank[] tanks) {
		super(mainPane, tanks);
		
		Barrier barrier0 = new Barrier(Positioner.getCenterX(mainPane, 30), Positioner.getFourFifthY(mainPane, 400), 30, 400);
		barriers[0] = barrier0;
		
		Barrier barrier1 = new Barrier(Positioner.getQuarterX(mainPane, 30), 150, 30, 300);
		barriers[1] = barrier1;
		
		Barrier barrier2 = new Barrier(Positioner.getCenterX(mainPane, 800) + 25, 200, 800, 30);
		barriers[2] = barrier2;
		
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
