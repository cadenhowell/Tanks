package entities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 * Creates the Tank object with its functionality.
 * 
 * @author Caden Howell
 */
public class Tank extends JLabel {

	public BufferedImage bufTankImg;
	public double dY;
	public double dX;
	public boolean counterClockwise;
	public boolean clockwise;
	public boolean moveForward;
	public boolean moveBackward;
	public int degrees;
	public int speed = 5;

	/**
	 * Creates a tank and adds it to the frame.
	 * 
	 * @param mainPane
	 *            the JLayeredPane to add the tank to
	 * @param x
	 *            the x location of the tank
	 * @param y
	 *            the y location of the tank
	 */
	public Tank(JLayeredPane mainPane, int x, int y) {
		Image tankImg = new ImageIcon(this.getClass().getResource("/Tank.png")).getImage();
		bufTankImg = toBufferedImage(tankImg);
		setIcon(new ImageIcon(bufTankImg));
		setBounds(x, y, 150, 150);
		mainPane.add(this, Integer.valueOf(2));
	}

	/**
	 * Rotates the tank to the proper degree.
	 * 
	 * @param degs
	 *            the rotation desired in degrees
	 */
	public void rotateTank(int degs) {
		double rotationRequired = Math.toRadians(degs);
		double locationX = 80;
		double locationY = 80;
		//Creates a rotation centered around point (80, 80)
		//https://stackoverflow.com/questions/20275424/rotating-image-with-affinetransform
		AffineTransform at = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp atop = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		BufferedImage newImage = new BufferedImage(bufTankImg.getWidth(), bufTankImg.getHeight(), bufTankImg.getType());
		atop.filter(bufTankImg, newImage);
		setIcon(new ImageIcon(newImage));
		degrees = degs;
		//Find x and y with respect to angle
		dX = Math.cos(rotationRequired + (3 * Math.PI) / 2);
		dY = Math.sin(rotationRequired + (3 * Math.PI) / 2);
	}

	/**
	 * Changes an image into a buffered image.
	 * 
	 * @param img
	 *            the image to be changed
	 * @return the created buffered image
	 */
	public static BufferedImage toBufferedImage(Image img) {
		//https://stackoverflow.com/questions/13605248/java-converting-image-to-bufferedimage/13605485
		if (img instanceof BufferedImage) {
			return (BufferedImage) img;
		}
		BufferedImage bufImg = new BufferedImage(160, 160, BufferedImage.TYPE_INT_ARGB);
		Graphics2D bGr = bufImg.createGraphics();
		bGr.drawImage(img, 30, 30, null);
		bGr.dispose();
		return bufImg;
	}

}