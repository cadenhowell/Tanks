package display;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import entities.Tank;

/**
 * Creates the Startup Display and all of the features associated with it.
 * 
 * @author Caden Howell
 */
public class StartupDisplay extends JFrame {

	private JLayeredPane lp = getLayeredPane();
	private JTextField player1;
	private JTextField player2;
	private final int DISPLAY_WIDTH = 800;
	private final int DISPLAY_HEIGHT = 480;
	private final Font wiiFont = new Font("contb", Font.PLAIN, 20);
	private Clip clip;
	public static String player1Text;
	public static String player2Text;

	/**
	 * Creates the frame and features of the start up menu.
	 */
	public StartupDisplay() throws FontFormatException, IOException, URISyntaxException, UnsupportedAudioFileException,
			LineUnavailableException, ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		super("© Caden Howell (2018) - Creative Works Act File: 18:173:b90a - All Rights Reserved");
		//https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setVisible(true);
		setResizable(false);
		createFonts();
		createBackground();
		populateFrame();
		playSound();
	}

	/**
	 * Creates the fonts for the game and adds them to the graphics environment.
	 * 
	 * @throws FontFormatException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public void createFonts() throws FontFormatException, IOException, URISyntaxException {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(getClass().getResource("./font/contb.ttf").toURI())));
		ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(getClass().getResource("./font/BroshK.ttf").toURI())));
	}

	/**
	 * Creates the background and adds it to the frame.
	 */
	public void createBackground() {
		JLabel backgroundLabel = new JLabel();
		Image backgroundImg = new ImageIcon(this.getClass().getResource("/Startup_Background.png")).getImage();
		backgroundLabel.setIcon(new ImageIcon(backgroundImg));
		backgroundLabel.setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);
		lp.add(backgroundLabel, new Integer(0));
	}

	/**
	 * Creates the frames components and adds them to it.
	 */
	public void populateFrame() {
		JButton startButton = new JButton("Start Game");
		startButton.setFont(wiiFont);
		startButton.setBounds(10, DISPLAY_HEIGHT - 80, 200, 50);
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Gets text in JTestField
				player1Text = player1.getText();
				player2Text = player2.getText();
				MainDisplay main = new MainDisplay();
				clip.close();
				main.main();
				dispose();
			}
		});
		lp.add(startButton, new Integer(1));

		JLabel tankLabel = new JLabel("TANKS");
		tankLabel.setBounds(230, 120, 600, 200);
		tankLabel.setFont(new Font("BroshK", Font.PLAIN, 250));
		tankLabel.setForeground(new Color(0, 204, 204, 200));
		lp.add(tankLabel, new Integer(1), 0);

		JLabel csg = new JLabel();
		Image csgImg = new ImageIcon(this.getClass().getResource("/CS_GOD.jpg")).getImage();
		csg.setIcon(new ImageIcon(csgImg));
		csg.setBounds(305, 30, 400, 400);
		csg.setVisible(false);
		lp.add(csg, new Integer(0), 0);

		Tank tank = new Tank(lp, 220, 10);
		Timer tankTimer = new Timer(5, new ActionListener() {
			boolean bottom = true;
			boolean right = false;
			int x = 220;
			int y = 10;

			@Override
			public void actionPerformed(ActionEvent e) {
				//Creates moving animation of tank on startup display
				if (bottom && !right) {
					y++;
					tank.setLocation(x, y);
					tank.rotateTank(0);
					if (y >= DISPLAY_HEIGHT - tank.getHeight() - 35) {
						right = true;
						lp.setLayer(tank, new Integer((int) (Math.random() * 2 + 1)), 1);
					}
				} else if (bottom && right) {
					x++;
					tank.setLocation(x, y);
					tank.rotateTank(270);
					if (x >= DISPLAY_WIDTH - tank.getWidth() - 10) {
						bottom = false;
					}
				} else if (!bottom && right) {
					y--;
					tank.setLocation(x, y);
					tank.rotateTank(180);
					if (y <= 10) {
						right = false;
						lp.setLayer(tank, new Integer((int) (Math.random() * 2 + 1)), 1);
					}
				} else if (!bottom && !right) {
					x--;
					tank.setLocation(x, y);
					tank.rotateTank(90);
					if (x <= 220) {
						bottom = true;
					}
				}
			}
		});
		tankTimer.start();
		lp.add(tank, new Integer(1));

		//Creates player 1 JTextField
		player1 = new JTextField("Player 1");
		player1.setBounds(10, 10, 200, 50);
		player1.setHorizontalAlignment(JTextField.CENTER);
		player1.setFont(wiiFont);
		player1.setForeground(Color.WHITE);
		player1.setBackground(Color.BLACK);
		player1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				player1Text = player1.getText();
				//Easter Egg
				if (player1Text.indexOf("Tiveron") > -1 || player1Text.indexOf("tiveron") > -1
						|| player1Text.indexOf("Derrick") > -1 || player1Text.indexOf("derrick") > -1
						|| player1Text.indexOf("tivs") > -1 || player1Text.indexOf("Tivs") > -1) {
					csg.setVisible(true);
					tankLabel.setBounds(26, 190, 200, 50);
					tankLabel.setFont(new Font("contb", Font.BOLD, 50));
				}
			}
		});
		lp.add(player1, new Integer(1));

		//Creates player 2 JTextField
		player2 = new JTextField("Player 2");
		player2.setBounds(10, 70, 200, 50);
		player2.setHorizontalAlignment(JTextField.CENTER);
		player2.setFont(wiiFont);
		player2.setForeground(Color.WHITE);
		player2.setBackground(Color.BLACK);
		player2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				player2Text = player2.getText();
				//Easter Egg
				if (player2Text.indexOf("Tiveron") > -1 || player2Text.indexOf("tiveron") > -1
						|| player2Text.indexOf("Derrick") > -1 || player2Text.indexOf("derrick") > -1
						|| player2Text.indexOf("tivs") > -1 || player2Text.indexOf("Tivs") > -1) {
					csg.setVisible(true);
					tankLabel.setBounds(26, 150, 200, 50);
					tankLabel.setFont(new Font("contb", Font.BOLD, 50));
				}
			}
		});
		lp.add(player2, new Integer(1));
	}

	/**
	 * Creates and plays the music for the start up menu.
	 * 
	 * @throws UnsupportedAudioFileException
	 * @throws LineUnavailableException
	 * @throws IOException
	 */
	public void playSound() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
		clip = AudioSystem.getClip();
		AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Wii_Music.wav"));
		clip.open(ais);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

}