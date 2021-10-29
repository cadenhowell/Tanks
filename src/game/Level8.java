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
public class Level8 extends Level {

Barrier[] barriers = new Barrier[5];
	
	public Level8(JLayeredPane mainPane, Tank[] tanks) {
		super(mainPane, tanks);
		
		Barrier barrier0 = new Barrier(Positioner.getFourFifthX(mainPane, 30), MainDisplay.DISPHEIGHT - 300, 30, 200);
		barriers[0] = barrier0;
		
		Barrier barrier1 = new Barrier(Positioner.getThreeFifthX(mainPane, 575) - 15, MainDisplay.DISPHEIGHT - 300, 575, 30);
		barriers[1] = barrier1;
		
		Barrier barrier2 = new Barrier(Positioner.getTwoFifthX(mainPane, 30), 250, 30, 300);
		barriers[2] = barrier2;
		
		Barrier barrier3 = new Barrier(Positioner.getThreeFifthX(mainPane, 550), 250, 550, 30);
		barriers[3] = barrier3;
		
		Barrier barrier4 = new Barrier(Positioner.getFourFifthX(mainPane, 30), 80, 30, 200);
		barriers[4] = barrier4;
		
		for (Barrier barrier : barriers)
			mainPane.add(barrier, new Integer(1));
	}

	@Override
	public void addTanks() {
		tanks[0].setLocation(30, Positioner.getCenterY(mainPane, 104));
		tanks[0].rotateTank(270);
		tanks[0].setVisible(true);
		
		tanks[1].setLocation(Positioner.getCenterX(mainPane, 104), Positioner.getCenterY(mainPane, 104));
		tanks[1].rotateTank(90);
		tanks[1].setVisible(true);
	}

	@Override
	public Barrier[] getBarriers() {
		return barriers;
	}

}
