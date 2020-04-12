package workoutHelper;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class WorkoutHelper extends JFrame {
	JCheckBox controlPanelChckBx1, controlPanelChckBx2, controlPanelChckBx3;
	WorkoutPanel panel1, panel2, panel3;
	JPanel panel;
	JPanel contentPane;
	int buttonColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkoutHelper frame = new WorkoutHelper();
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
	public WorkoutHelper() {
		createJFrame();
		setContentPane(contentPane);
		
		JPanel panel = createControlPanel();
		panel.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel controlPanelLbl = createControlPanelLbl();
		panel.add(controlPanelLbl);
		
		JCheckBox controlPanelChckBx1 = createChckBx1();
		panel.add(controlPanelChckBx1);
		
		JCheckBox controlPanelChckBx2 = createChckBx2();
		panel.add(controlPanelChckBx2);
		
		JCheckBox controlPanelChckBx3 = createChckBx3();
		panel.add(controlPanelChckBx3);
		
		JButton controlPanelSubmit = createControlPanelSubmitBtn();
		panel.add(controlPanelSubmit);
	
		JPanel mediaPanel = createMediaPanel();
		mediaPanel.setLayout(new GridLayout(3, 0, 0, 0));

	}

	private JPanel createMediaPanel() {
		JPanel mediaPanel = new JPanel();
		contentPane.add(mediaPanel, BorderLayout.CENTER);
		{
			panel1 = new WorkoutPanel(WorkoutType.STRENGTH);
			mediaPanel.add(panel1);
		}
		{
			panel2 = new WorkoutPanel(WorkoutType.CORE);
			mediaPanel.add(panel2);
		}
		{
			panel3 = new WorkoutPanel(WorkoutType.CARDIO);
			mediaPanel.add(panel3);
		}
		return mediaPanel;
	}

	private void createJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 743);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
	}

	private JPanel createControlPanel() {
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		return panel;
	}

	private JLabel createControlPanelLbl() {
		JLabel controlPanelLbl = new JLabel("Choose your workout:");
		controlPanelLbl.setBorder(new EmptyBorder(0, 3, 0, 0));
		controlPanelLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		controlPanelLbl.setPreferredSize(new Dimension(115, 5));
		return controlPanelLbl;
	}

	private JCheckBox createChckBx1() {
		controlPanelChckBx1 = new JCheckBox("Strength");
		controlPanelChckBx1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		controlPanelChckBx1.setPreferredSize(new Dimension(115, 5));
		return controlPanelChckBx1;
	}

	private JCheckBox createChckBx2() {
		controlPanelChckBx2 = new JCheckBox("Core");
		controlPanelChckBx2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		controlPanelChckBx2.setPreferredSize(new Dimension(115, 5));
		return controlPanelChckBx2;
	}

	private JCheckBox createChckBx3() {
		controlPanelChckBx3 = new JCheckBox("Cardio");
		controlPanelChckBx3.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		controlPanelChckBx3.setPreferredSize(new Dimension(115, 5));
		return controlPanelChckBx3;
	}

	private JButton createControlPanelSubmitBtn() {
		JButton controlPanelSubmit = new JButton("Submit");
		controlPanelSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!controlPanelChckBx1.isSelected() && !controlPanelChckBx2.isSelected() 
						&& !controlPanelChckBx3.isSelected()) {
					setSubmitColor(controlPanelSubmit);
					panel1.updateLblColor();
					panel2.updateLblColor();
					panel3.updateLblColor();
				}
				if(controlPanelChckBx1.isSelected()) {
					panel1.updateStrength();
				}
				if(controlPanelChckBx2.isSelected()) {
					panel2.updateCore();
				}
				if(controlPanelChckBx3.isSelected()) {
					panel3.updateCardio();
				}
			}
		});
		controlPanelSubmit.setBackground(SystemColor.desktop);
		controlPanelSubmit.setOpaque(true);
		controlPanelSubmit.setBorder(new LineBorder(new Color(238, 238, 238), 9));
		controlPanelSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		controlPanelSubmit.setPreferredSize(new Dimension(115, 5));
		return controlPanelSubmit;
			
		}
	
	/**
	 * Updates Control Panel's Submit button with a random color when the button 
	 * is clicked and none of the checkboxes are selected.
	 * 
	 * @param button	Submit button
	 */
	public void setSubmitColor(JButton button) {
		Random rand = new Random();
		int random = rand.nextInt(5) + 1;
		while(random == buttonColor) {
			random = rand.nextInt(5) + 1;
		}
		switch(random) {
		case 1:
			button.setBackground(Color.ORANGE);
			buttonColor = 1;
			break;
		case 2:
			button.setBackground(Color.CYAN);
			buttonColor = 2;
			break;
		case 3:
			button.setBackground(Color.MAGENTA);
			buttonColor = 3;
			break;
		case 4:
			button.setBackground(Color.GREEN);
			buttonColor = 4;
			break;
		case 5:
			button.setBackground(Color.PINK);
			buttonColor = 5;
			break;
		}
	}

}
