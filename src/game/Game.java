package game;

import java.awt.FontFormatException;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

import display.StartupDisplay;

/**
 * Contains the main method to be called.
 * 
 * @author Caden Howell
 */
public class Game {

	/**
	 * Runs the main method to start the game.
	 * 
	 * @param args
	 *            the String[] of command line input parameters
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				new StartupDisplay();
			} catch (FontFormatException | IOException | URISyntaxException | UnsupportedAudioFileException
					| LineUnavailableException | ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException ex) {
				ex.printStackTrace();
			}
		});
	}
}
