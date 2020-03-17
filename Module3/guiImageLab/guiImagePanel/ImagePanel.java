package guiImagePanel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel {
	private Color[] colors = {
			Color.ORANGE,
			Color.BLUE,
			Color.RED,			
	};
	private int colorIndex = 0;
	private int x = 10;
	
	/**
	 * Create the panel.
	 */
	public ImagePanel() {

	}
	
	public void changeColor() {
		colorIndex = ++colorIndex % colors.length;
		setBackground(colors[colorIndex]);
	}
	
	public void move() {
		x += 10;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		setBackground(colors[colorIndex]);
		ImageIcon icon = new ImageIcon(ImagePanel.class.getResource("/Images/skateboarder.png"));
		icon.paintIcon(this, g, x, 40);
	}
}
