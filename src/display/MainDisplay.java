package display;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

import entities.Barrier;
import entities.Tank;
import game.Level;
import game.Level1;
import game.Level2;
import game.Level3;
import game.Level4;
import game.Level5;
import game.Level6;
import game.Level7;
import game.Level8;
import game.Level9;
import tools.Positioner;

/**
 * Creates the Main Display and all of the features associated with it.
 * 
 * @author Caden Howell
 */
public class MainDisplay extends JFrame {

	public final static int DISPHEIGHT = (int) GraphicsEnvironment.getLocalGraphicsEnvironment()
			.getMaximumWindowBounds().getHeight();
	public final static int DISPWIDTH = (int) GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds()
			.getWidth();
	private JLayeredPane mainPane;
	private JLabel player1;
	private JLabel player2;
	private Tank[] tanks = new Tank[2];
	private Tank tank0;
	private Tank tank1;
	private Timer bombTimer;
	private ArrayList<Level> levels = new ArrayList<Level>();
	private ArrayList<JLabel> bullets = new ArrayList<JLabel>();
	private KeyListener keyListener;
	public final int BULLET_SPEED = 20;
	private final int ROTATION_SPEED = 5;
	private boolean ready = true;
	private int level = 1;
	private int player1Score = 0;
	private int player2Score = 0;

	/**
	 * Creates the frame and features of the game.
	 */
	public void main() {
		setTitle("Tanks");
		setSize(DISPWIDTH, DISPHEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setVisible(true);
		setResizable(false);
		mainPane = getLayeredPane();
		createTanks();
		createBackground();
		createKeyListener();
		createLevel(level);
		createTimer();
		createScoreboard();
	}

	/**
	 * Creates the background and adds it to the frame.
	 */
	public void createBackground() {
		JLabel background = new JLabel();
		Image backgroundImg = new ImageIcon(this.getClass().getResource("/Wood.jpg")).getImage();
		background.setIcon(new ImageIcon(backgroundImg));
		background.setSize(DISPWIDTH, DISPHEIGHT);
		mainPane.add(background, new Integer(0));
	}

	/**
	 * Creates the score board and adds it to the frame.
	 */
	public void createScoreboard() {
		Font font = new Font("contb", Font.PLAIN, 50);
		player1 = new JLabel();
		player1.setBounds(25, 0, 400, 100);
		player1.setFont(font);
		player1.setText(StartupDisplay.player1Text + ": " + player1Score);
		mainPane.add(player1, new Integer(3));
		player2 = new JLabel();
		player2.setFont(font);
		player2.setText(StartupDisplay.player2Text + ": " + player2Score);
		player2.setBounds((int) (DISPWIDTH - player2.getPreferredSize().getWidth() - 20), 0, 400, 100);
		mainPane.add(player2, new Integer(3));
	}

	/**
	 * Creates the tanks and adds them to the frame.
	 */
	public void createTanks() {
		tank0 = new Tank(mainPane, 0, 0);
		tanks[0] = tank0;
		tank1 = new Tank(mainPane, 0, 0);
		tanks[1] = tank1;
	}

	/**
	 * Creates the timer which repaints the frame.
	 */
	public void createTimer() {
		//Refreshes the frame every 30 seconds
		Timer repaintTimer = new Timer(1000 / 30, new ActionListener() {
			int count = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				//ready is when you can fire (ie. you can fire once a second)
				if (count < 30)
					count++;
				else {
					ready = true;
					count = 0;
				}
				for (Tank tank : tanks) {
					rotateTank(tank);
					moveTank(tank);
					checkCollision();
				}
			}
		});
		repaintTimer.start();
	}

	/**
	 * Moves the tank.
	 * 
	 * @param tank
	 *            the tank to be moved
	 */
	public void moveTank(Tank tank) {
		//Moves the tank
		double x = tank.getX();
		double y = tank.getY();
		if (tank.moveForward) {
			x = tank.getX() - tank.speed * tank.dX;
			y = tank.getY() - tank.speed * tank.dY;
		} else if (tank.moveBackward) {
			x = tank.getX() + tank.speed * tank.dX;
			y = tank.getY() + tank.speed * tank.dY;
		}
		tank.setLocation((int) x, (int) y);
		//Limits the tank to the borders
		if (tank.getX() < 0) {
			tank.setLocation(0, (int) y);
		} else if (tank.getX() + tank.getWidth() > DISPWIDTH) {
			tank.setLocation(DISPWIDTH - tank.getWidth(), (int) y);
		}
		if (tank.getY() < 0) {
			tank.setLocation((int) x, 0);
		} else if (tank.getY() + tank.getHeight() + 20 > DISPHEIGHT) {
			tank.setLocation((int) x, DISPHEIGHT - tank.getHeight() - 20);
		}
	}

	/**
	 * Rotates the tank.
	 * 
	 * @param tank
	 *            the tank to be rotated
	 */
	public void rotateTank(Tank tank) {
		if (tank.clockwise) {
			tank.degrees += ROTATION_SPEED;
			tank.rotateTank(tank.degrees);
		} else if (tank.counterClockwise) {
			tank.degrees -= ROTATION_SPEED;
			tank.rotateTank(tank.degrees);
		}
	}

	/**
	 * Creates the key listeners for the tank.
	 */
	public void createKeyListener() {
		keyListener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP)
					tank0.moveForward = true;
				else if (e.getKeyCode() == KeyEvent.VK_LEFT)
					tank0.counterClockwise = true;
				else if (e.getKeyCode() == KeyEvent.VK_DOWN)
					tank0.moveBackward = true;
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					tank0.clockwise = true;
				else if (e.getKeyCode() == KeyEvent.VK_SLASH)
					fire(tank0);
				else if (e.getKeyCode() == KeyEvent.VK_W)
					tank1.moveForward = true;
				else if (e.getKeyCode() == KeyEvent.VK_A)
					tank1.counterClockwise = true;
				else if (e.getKeyCode() == KeyEvent.VK_S)
					tank1.moveBackward = true;
				else if (e.getKeyCode() == KeyEvent.VK_D)
					tank1.clockwise = true;
				else if (e.getKeyCode() == KeyEvent.VK_F)
					fire(tank1);
				else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					level++;
					//Gets most recently added level (The one running) and removes the barriers to make room for next level
					for (Barrier barrier : levels.get(levels.size() - 1).getBarriers()) {
						barrier.setVisible(false);
						mainPane.remove(barrier);
					}
					createLevel(level);
					//Stops timer so tank explosion doesn't repeat after level finished
					if (bombTimer != null)
						bombTimer.stop();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP)
					tank0.moveForward = false;
				else if (e.getKeyCode() == KeyEvent.VK_LEFT)
					tank0.counterClockwise = false;
				else if (e.getKeyCode() == KeyEvent.VK_DOWN)
					tank0.moveBackward = false;
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					tank0.clockwise = false;
				else if (e.getKeyCode() == KeyEvent.VK_W)
					tank1.moveForward = false;
				else if (e.getKeyCode() == KeyEvent.VK_A)
					tank1.counterClockwise = false;
				else if (e.getKeyCode() == KeyEvent.VK_S)
					tank1.moveBackward = true;
				else if (e.getKeyCode() == KeyEvent.VK_D)
					tank1.clockwise = false;
			}
		};
		addKeyListener(keyListener);
	}

	/**
	 * Fires the tank and controls the bullet movement
	 * 
	 * @param tank
	 *            the tank to be fired
	 */
	public void fire(Tank tank) {
		if (ready) {
			ready = false;
			playFireSound();
			//Creates a bullet
			Image bullet = new ImageIcon(this.getClass().getResource("/Bullet.png")).getImage();
			BufferedImage bufBullet = Tank.toBufferedImage(bullet);
			JLabel bulletLabel = new JLabel();
			bullets.add(bulletLabel);
			int spawnX = tank.getX() + tank.getWidth() / 2;
			int spawnY = tank.getY() + tank.getHeight() / 2;
			bulletLabel.setBounds(spawnX, spawnY, 23, 21);
			bulletLabel.setIcon(new ImageIcon(bullet));
			mainPane.add(bulletLabel, new Integer(1), 0);
			//Timer for moving the bullet
			Timer bulletTimer = new Timer(1000 / 30, new ActionListener() {
				double instanceX = tank.dX;
				double instanceY = tank.dY;
				int bounce = 0;
				int count = 0;

				@Override
				public void actionPerformed(ActionEvent e) {
					//Makes bullets bounce off borders twice
					if (bulletLabel.getX() < 0 || bulletLabel.getX() + bulletLabel.getWidth() > DISPWIDTH) {
						instanceX *= -1;
						bounce++;
						if (bulletLabel.isVisible())
							playBounce();
					} else if (bulletLabel.getY() < 0
							|| bulletLabel.getY() + bulletLabel.getHeight() + 20 > DISPHEIGHT) {
						instanceY *= -1;
						bounce++;
						if (bulletLabel.isVisible())
							playBounce();
					}
					if(bounce == 3) {
						bulletLabel.setVisible(false);
					}
					try {
						//Destroys bullet if it hits barrier
						for (Barrier barrier : levels.get(levels.size() - 1).getBarriers())
							if (bulletLabel.getBounds().intersects(barrier.getBounds()))
								bulletLabel.setVisible(false);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					double x = bulletLabel.getX() - BULLET_SPEED * instanceX;
					double y = bulletLabel.getY() - BULLET_SPEED * instanceY;
					bulletLabel.setLocation((int) x, (int) y);
					Tank otherTank;
					//Makes it so you can only be killed by opponent bullets
					if (tank.equals(tanks[0]))
						otherTank = tanks[1];
					else
						otherTank = tanks[0];
					if (otherTank.getBounds().intersects(bulletLabel.getBounds()) && bulletLabel.isVisible()
							&& otherTank.isVisible()) {
						//Makes it so explosion sound only plays once
						if (count == 0) {
							playExplosionSound();
							count++;
						}
						//If there are stray bullets when the level ends they will be destroyed
						for (JLabel rougeBullet : bullets){
							rougeBullet.setVisible(false);
							mainPane.remove(rougeBullet);
						}
							
	
						//Determines whose score to add a point to
						if (otherTank.equals(tanks[0])) {
							player1Score++;
							player1.setText(StartupDisplay.player1Text + ": " + player1Score);
						} else {
							player2Score++;
							player2.setText(StartupDisplay.player2Text + ": " + player2Score);
						}
						//Creates the explosion image
						Image explosion = new ImageIcon(this.getClass().getResource("/Explosion.png")).getImage();
						BufferedImage bufExplosion = Tank.toBufferedImage(explosion);
						otherTank.setIcon(new ImageIcon(bufExplosion));
						bulletLabel.setVisible(false);
						//Makes explosion disappear after a second
						bombTimer = new Timer(1000, new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								otherTank.setVisible(false);
							}
						});
						bombTimer.start();
					}
				}
			});
			bulletTimer.start();
		}
	}

	/**
	 * Creates a designated level.
	 * 
	 * @param levelNum
	 *            the number of the level to create
	 */
	public void createLevel(int levelNum) {
		if (levelNum == 1) {
			Level1 l1 = new Level1(mainPane, tanks);
			levels.add(l1);
		} else if (levelNum == 2) {
			Level2 l2 = new Level2(mainPane, tanks);
			levels.add(l2);
		} else if (levelNum == 3) {
			Level3 l3 = new Level3(mainPane, tanks);
			levels.add(l3);
		} else if (levelNum == 4) {
			Level4 l4 = new Level4(mainPane, tanks);
			levels.add(l4);
		} else if (levelNum == 5) {
			Level5 l5 = new Level5(mainPane, tanks);
			levels.add(l5);
		} else if (levelNum == 6) {
			Level6 l6 = new Level6(mainPane, tanks);
			levels.add(l6);
		} else if (levelNum == 7) {
			Level7 l7 = new Level7(mainPane, tanks);
			levels.add(l7);
		} else if (levelNum == 8) {
			Level8 l8 = new Level8(mainPane, tanks);
			levels.add(l8);
		} else if (levelNum == 9) {
			Level9 l9 = new Level9(mainPane, tanks);
			levels.add(l9);
		} else if (levelNum == 10) {
			//Creates and adds the JLabel to designate the winner
			for (Tank tank : tanks)
				tank.setVisible(false);
			JLabel winner = new JLabel();
			winner.setBounds(Positioner.getCenterX(mainPane, 1200), Positioner.getCenterY(mainPane, 400), 1200, 400);
			winner.setHorizontalAlignment(JLabel.CENTER);
			winner.setFont(new Font("BroshK", Font.PLAIN, 200));
			winner.setForeground(new Color(0, 204, 204));
			if (player1Score > player2Score)
				winner.setText(StartupDisplay.player1Text + " Won");
			else if (player1Score == player2Score)
				winner.setText("You Tied");
			else
				winner.setText(StartupDisplay.player2Text + " Won");
			mainPane.add(winner, new Integer(1));
		}
	}

	/**
	 * Checks if the tank collides with a barrier and slows it down if it did.
	 */
	public void checkCollision() {
		for (Tank tank : tanks) {
			tank.speed = 5;
			int move = 5;
			for (Barrier barrier : levels.get(levels.size() - 1).getBarriers()) {
				if (barrier.getBounds().intersects(tank.getBounds()))
					tank.speed = 2;
			}
		}
	}

	/**
	 * Players the explosion sound.
	 */
	public void playExplosionSound() {
		try {
			//https://www.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/bomb.wav"));
			clip.open(ais);
			clip.loop(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Players the firing sound.
	 */
	public void playFireSound() {
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/fire.wav"));
			clip.open(ais);
			clip.loop(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Players the bounce sound.
	 */
	public void playBounce() {
		try {
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/bounce.wav"));
			clip.open(ais);
			clip.loop(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
