package guiDice;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class LabGuiDice extends JFrame {

	/**
	 * Default serialVersionUID from Eclipse to get rid of warnings
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int diceNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabGuiDice frame = new LabGuiDice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LabGuiDice() {
		createNewJFrame();
		setContentPane(contentPane);
		
		JLabel lblNewLabel = createNewLbl();
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		JButton btnNewButton = newRollButton(lblNewLabel);
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
	}

	private JLabel createNewLbl() {
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
		lblNewLabel.setIcon(new ImageIcon(LabGuiDice.class.getResource("/guiDice/Resources/die-1.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		return lblNewLabel;
	}

	private void createNewJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
	}

	private JButton newRollButton(JLabel lblNewLabel) {
		diceNum = 1;
		JButton btnNewButton = new JButton("Roll 'em");
		btnNewButton.setForeground(Color.PINK);
		btnNewButton.setBorder(new EmptyBorder(10, 0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				int random = rand.nextInt(6) + 1;
				
				while(random == diceNum) {
					random = rand.nextInt(6) + 1;
				}
				lblNewLabel.setIcon(new ImageIcon(LabGuiDice.class.getResource("/guiDice/Resources/die-"+random+".png")));
				diceNum = random;
			}
		});
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Rockwell", Font.PLAIN, 25));
		return btnNewButton;
	}
}
