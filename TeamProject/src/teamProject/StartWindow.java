package teamProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JSeparator;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartWindow extends JFrame {

	private JPanel window;
	static BillingSystem b = new BillingSystem("menuItems.txt");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartWindow frame = new StartWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		for (Item el : b.getItemList()) {
			System.out.println(el);
		}
	}

	/**
	 * Create the frame.
	 */
	public StartWindow() {
		setSize(new Dimension(755, 935));
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window = new JPanel();
		window.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(window);
		window.setLayout(new CardLayout(0, 0));
		setLocationRelativeTo(null);
		
		JPanel panelMenu = new JPanel();
		createPanelMenu(panelMenu);
		
		JPanel panelBilling = new JPanel();
		createPanelBilling(panelBilling);
		panelBilling.setLayout(null);
		
		JLabel lblMenu = new JLabel("Menu");
		createLblMenu(panelMenu, lblMenu);
		
		JButton btnContinue = new JButton("Continue");
		createBtnContinue(panelMenu, panelBilling, btnContinue);
		
		JSeparator separator = new JSeparator();
		createSeparator(panelMenu, separator);
		
		int offset = 0;
		for (Item el : b.getItemList()) {
			createBillingItem(panelBilling, offset, el.getName(), el.getPrice());
			offset += 50;
		}
		
		createBillingItem(panelBilling, offset, "Subtotal", b.calculateSubtotal());
		
		JButton btnBack = new JButton("Back To Menu");
		createBtnBack(panelMenu, panelBilling, btnBack);
		
		// createMenuItem()
		// createBillingItem()	
	}

	private void createBtnBack(JPanel panelMenu, JPanel panelBilling, JButton btnBack) {
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(true);
				panelBilling.setVisible(false);
			}
		});
		btnBack.setBounds(10, 11, 120, 23);
		panelBilling.add(btnBack);
	}

	private void createBillingItem(JPanel panelBilling, int offset, String name, double price) {
		JLabel lblYourOrder = new JLabel("Your Order");
		lblYourOrder.setFont(new Font("Arial", Font.BOLD, 50));
		lblYourOrder.setBounds(47, 35, 427, 96);
		panelBilling.add(lblYourOrder);
		
		JLabel lblItem = new JLabel(name);
		lblItem.setFont(new Font("Arial", Font.BOLD, 15));
		lblItem.setBounds(47, 153 + offset, 83, 14);
		panelBilling.add(lblItem);
		
		JSeparator separator1 = new JSeparator();
		separator1.setBounds(47, 181 + offset, 630, 2);
		panelBilling.add(separator1);
		
		JLabel lblPrice = new JLabel(String.format("$%.2f", price));
		lblPrice.setFont(new Font("Arial", Font.BOLD, 15));
		lblPrice.setBounds(633, 153 + offset, 44, 14);
		panelBilling.add(lblPrice);
	}

	private void createPanelBilling(JPanel panelBilling) {
		panelBilling.setVisible(false);
		window.add(panelBilling, "name_1229635896010400");
		
	}

	private void createSeparator(JPanel panelMenu, JSeparator separator) {
		separator.setBounds(55, 145, 616, 2);
		panelMenu.add(separator);
	}

	private void createBtnContinue(JPanel panelMenu, JPanel panelBilling, JButton btnContinue) {
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(false);
				panelBilling.setVisible(true);
			}
		});
		btnContinue.setBounds(320, 751, 100, 35);
		panelMenu.add(btnContinue);
	}

	private void createLblMenu(JPanel panelMenu, JLabel lblNewLabel) {
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 50));
		lblNewLabel.setBounds(55, 49, 158, 59);
		panelMenu.add(lblNewLabel);
	}

	private void createPanelMenu(JPanel panelMenu) {
		window.add(panelMenu, "name_1229630471082900");
		panelMenu.setLayout(null);
	}
}
