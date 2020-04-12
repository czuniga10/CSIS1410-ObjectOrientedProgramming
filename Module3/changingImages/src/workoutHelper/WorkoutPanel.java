package workoutHelper;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Random;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class WorkoutPanel extends JPanel {
	WorkoutType type;
	JLabel mediaGif;
	JLabel mediaTypeLbl;
	Random rand = new Random();
	int lblColor;
	int currentStrength;
	int currentCore;
	int currentCardio;

	/**
	 * Create the panel.
	 */
	public WorkoutPanel(WorkoutType type) {
		this.type = type;
		setLayout(new BorderLayout(0, 0));
		
		JLabel mediaGif = setMediaByType(type);
		add(mediaGif);
		
		mediaTypeLbl = createMediaLabel();
		add(mediaTypeLbl, BorderLayout.SOUTH);
	}

	//Make sure random number doesnt repeat previous number
	private JLabel setMediaByType(WorkoutType type) {
		mediaGif = new JLabel("gif");
		if(type == WorkoutType.STRENGTH) {
			int random = rand.nextInt(6) + 1;
			mediaGif.setIcon(new ImageIcon(WorkoutPanel.class.getResource
					(String.format("/Resources/Strength/strength%d.gif", random))));
			mediaGif.setHorizontalAlignment(SwingConstants.CENTER);
			currentStrength = random;
		}
		if(type == WorkoutType.CORE) {
			int random = rand.nextInt(5) + 1;
			mediaGif.setIcon(new ImageIcon(WorkoutPanel.class.getResource
					(String.format("/Resources/Core/core%d.gif", random))));
			mediaGif.setHorizontalAlignment(SwingConstants.CENTER);
			currentCore = random;
		}
		if(type == WorkoutType.CARDIO) {
			int random = rand.nextInt(4) + 1;
			mediaGif.setIcon(new ImageIcon(WorkoutPanel.class.getResource
					(String.format("/Resources/Cardio/cardio%d.gif", random))));
			mediaGif.setHorizontalAlignment(SwingConstants.CENTER);
			currentCardio = random;
		}
		return mediaGif;
	}

	private JLabel createMediaLabel() {
		//Default reps, sets, and seconds.
		int sets = 3;
		int reps = 10;
		int seconds = 30;
		if(type != WorkoutType.CARDIO) {
			mediaTypeLbl = new JLabel(String.format("%s: %d sets X %d reps",
					type,sets,reps));
		} else {
			mediaTypeLbl = new JLabel(String.format("%s: %d sets X %d seconds",
					type,sets,seconds));
		}
		mediaTypeLbl.setBorder(new EmptyBorder(3, 0, 3, 0));
		mediaTypeLbl.setFont(new Font("Arial Rounded MT Bold", Font.BOLD
				| Font.ITALIC, 9));
		mediaTypeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		return mediaTypeLbl;
	}
	
	/**
	 * Updates Strength panel with a random Strength gif.
	 */
	public void updateStrength() {
		Random rand = new Random();
		int random = rand.nextInt(6) + 1;
		while(random == currentStrength) {
			random = rand.nextInt(6) + 1;
		}
		mediaGif.setIcon(new ImageIcon(WorkoutPanel.class.getResource
				(String.format("/Resources/Strength/strength%d.gif", random))));
		currentStrength = random;
	}
	
	/**
	 * Updates Core panel with a random Core gif.
	 */
	public void updateCore() {
		Random rand = new Random();
		int random = rand.nextInt(5) + 1;
		while(random == currentStrength) {
			random = rand.nextInt(5) + 1;
		}
		mediaGif.setIcon(new ImageIcon(WorkoutPanel.class.getResource
				(String.format("/Resources/Core/core%d.gif", random))));
		currentStrength = random;
	}
	
	/**
	 * Updates Cardio panel with a random Cardio gif.
	 */
	public void updateCardio() {
		Random rand = new Random();
		int random = rand.nextInt(4) + 1;
		while(random == currentStrength) {
			random = rand.nextInt(4) + 1;
		}
		mediaGif.setIcon(new ImageIcon(WorkoutPanel.class.getResource
				(String.format("/Resources/Cardio/cardio%d.gif", random))));
		currentStrength = random;
	}
	
	/**
	 * Updates Media label with a random color when Submit button is clicked and
	 * none of the checkboxes are selected.
	 */
	public void updateLblColor() {
		mediaTypeLbl.setOpaque(true);
		Random rand = new Random();
		int random = rand.nextInt(5) + 1;
		while(random == lblColor) {
			random = rand.nextInt(5) + 1;
		}
		switch(random) {
		case 1:
			mediaTypeLbl.setBackground(Color.ORANGE);
			lblColor = 1;
			break;
		case 2:
			mediaTypeLbl.setBackground(Color.CYAN);
			lblColor = 2;
			break;
		case 3:
			mediaTypeLbl.setBackground(Color.MAGENTA);
			lblColor = 3;
			break;
		case 4:
			mediaTypeLbl.setBackground(Color.GREEN);
			lblColor = 4;
			break;
		case 5:
			mediaTypeLbl.setBackground(Color.PINK);
			lblColor = 5;
			break;
		}
	}
}
