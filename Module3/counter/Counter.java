package counter;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

/**
 * Counter class that extends JFrame container to allow the class to have GUI 
 * functionality.
 * 
 * @author Chad Z
 */
public class Counter extends JFrame {

	/**
	 * Default SerialVersionUID from Eclipse.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int counter = 0;
	private int current;

	/**
	 * Launches the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Counter frame = new Counter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the initial frame.
	 */
	public Counter() {
		createJFrame();
		setContentPane(contentPane);
		
		JLabel bottomLabel = createBottomLbl();
		contentPane.add(bottomLabel, BorderLayout.SOUTH);
		
		JPanel panel = createJPanel();
		panel.setLayout(null);
		
		JLabel redLabel = setRedLabel();
		panel.add(redLabel);
		
		JButton clickMeButton = setClickMeButton(redLabel);
		panel.add(clickMeButton);
	}

	/**
	 * Creates Parent JFrame with size of 500X200, padding of 2px, and is 
	 * unable to be resized.
	 */
	private void createJFrame() {
		setResizable(false);
		setMaximumSize(new Dimension(500, 200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		contentPane.setLayout(new BorderLayout(0, 0));
	}

	/**
	 * Creates label at the bottom of the GUI with Author's Name.
	 * 
	 * @return Returns the bottom label.
	 */
	private JLabel createBottomLbl() {
		JLabel bottomLabel = new JLabel("Chad's GUI");
		bottomLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
		bottomLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		bottomLabel.setBackground(SystemColor.window);
		bottomLabel.setOpaque(true);
		bottomLabel.setHorizontalAlignment(SwingConstants.CENTER);
		return bottomLabel;
	}

	/**
	 * Creates the parent panel to contain the RedLabel and ClickMe button in
	 * the specified manner.
	 * 
	 * @return Returns the panel.
	 */
	private JPanel createJPanel() {
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		return panel;
	}

	/**
	 * Creates RedLabel and initializes it with 00 as the count.
	 * 
	 * @return Returns the RedLable and counter variable.
	 */
	private JLabel setRedLabel() {
		JLabel redLabel = new JLabel(String.format("Red Counter: %02d",counter));
		redLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
		redLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		redLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
		redLabel.setBackground(Color.LIGHT_GRAY);
		redLabel.setOpaque(true);
		redLabel.setHorizontalAlignment(SwingConstants.CENTER);
		redLabel.setBounds(0, 0, 246, 132);
		return redLabel;
	}

	/**
	 * Creates the ClickMe button and initializes it with a BLUE background.
	 * 
	 * @param redLabel	Takes in a RedLabel in order to update the count.
	 * @return	Returns the Click Me button.
	 */
	private JButton setClickMeButton(JLabel redLabel) {
		current = 1;
		JButton clickMeButton = new JButton("Click Me");
		clickMeButton.setBackground(Color.BLUE);
		clickMeButton.addActionListener(new ActionListener() {
			
			/**
			 * Action Listener method that randomizes and sets the ClickMe 
			 * button's background and updates the Red Label with the new
			 * count if the background is RED.
			 */
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				int random = rand.nextInt(5) + 1;
				
				while(random == current) {
					random = rand.nextInt(5) + 1;
				}
				
				switch(random) {
				case 1:
					clickMeButton.setBackground(Color.BLUE);
					current = 1;
					break;
				case 2:
					clickMeButton.setBackground(Color.GREEN);
					current = 2;
					break;
				case 3:
					clickMeButton.setBackground(Color.ORANGE);
					current = 3;
					break;
				case 4:
					clickMeButton.setBackground(Color.MAGENTA);
					current = 4;
					break;
				case 5:
					clickMeButton.setBackground(Color.RED);
					current = 5;
					counter++;
					redLabel.setText(String.format("Red Counter: %02d",counter));
					break;
				}
			}
		});
		clickMeButton.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		clickMeButton.setForeground(Color.WHITE);
		clickMeButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		clickMeButton.setBounds(244, 0, 252, 132);
		clickMeButton.setOpaque(true);
		return clickMeButton;
	}
}
