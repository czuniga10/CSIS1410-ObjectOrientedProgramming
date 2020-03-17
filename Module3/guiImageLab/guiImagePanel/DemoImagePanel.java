package guiImagePanel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

@SuppressWarnings("serial")
public class DemoImagePanel extends JFrame {

	private JPanel contentPane;
	private ImagePanel panel;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoImagePanel frame = new DemoImagePanel();
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
	public DemoImagePanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new ImagePanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = createControlPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH); //put ButtonLayout Direction at bottom and extract everything inside as a method
	}

	private JPanel createControlPanel() {
		JPanel panel_1 = new JPanel();
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("change color");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("move");
		buttonGroup.add(rdbtnNewRadioButton_1);
		panel_1.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("GO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) 
					panel.changeColor();
				if(rdbtnNewRadioButton_1.isSelected()) 
					panel.move();
			}
		});
		panel_1.add(btnNewButton);
		return panel_1;
	}

}
