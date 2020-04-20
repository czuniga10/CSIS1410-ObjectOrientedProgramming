package teamProject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;

import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

/**
 * 
 * 
 * @author Tomas Olvera
 * @author Chad Zuniga
 */
public class StartWindow extends JFrame {

	private JPanel cardContainer;
	private JPanel menu;
	private JPanel summary;
	private List<Item> cartItems = new ArrayList<>();

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
	}

	/**
	 * Create the frame.
	 */
	public StartWindow() {
		// JFrame properties
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 800);
		setTitle("Billing System");
		setLocationRelativeTo(null);
		
		cardContainer = new JPanel();
		cardContainer.setLayout(new CardLayout());
		
		menu = new JPanel();
		menu.setLayout(new BorderLayout(0, 0));
		
		JScrollPane sp = new JScrollPane(cardContainer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.getVerticalScrollBar().setUnitIncrement(16);
		
		summary = new SummaryWindow();
		
		cardContainer.add(menu);
		cardContainer.add(summary);
		
		getContentPane().add(sp);
		
		JPanel leftContent = new JPanel();
		menu.add(leftContent, BorderLayout.WEST);
		leftContent.setLayout(new BoxLayout(leftContent, BoxLayout.Y_AXIS));
		leftContent.add(Box.createVerticalStrut(35));
		
		// title
		JLabel label = new JLabel("Menu");
		label.setFont(new Font("Arial", Font.BOLD, 50));
		leftContent.add(label);
		leftContent.setBorder(new EmptyBorder(0, 60, 0, 0));
		
		JPanel rightContent = new JPanel();
		menu.add(rightContent, BorderLayout.EAST);
		rightContent.setLayout(new BoxLayout(rightContent, BoxLayout.Y_AXIS));
		rightContent.setBorder(new EmptyBorder(0, 0, 0, 50));
		rightContent.add(Box.createVerticalStrut(85));
		
		// adding menu items
		createItemComponent(leftContent, rightContent, new Item("Pizza", 12.5));
		createItemComponent(leftContent, rightContent, new Item("Pizza1", 12.5));
		createItemComponent(leftContent, rightContent, new Item("Pizza2", 12.5));
		createItemComponent(leftContent, rightContent, new Item("Pizza3", 12.5));
		createItemComponent(leftContent, rightContent, new Item("Pizza4", 12.5));
		createItemComponent(leftContent, rightContent, new Item("Pizza5", 12.5));
		
		// 'continue' button at the bottom
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				summary.setVisible(true);
			}
		});
		menu.add(btnNewButton, BorderLayout.SOUTH);
	}

	private void createItemComponent(JPanel leftContent, JPanel rightContent, Item item) {
		// menuItem
		JPanel menuItem = new JPanel();
		leftContent.add(Box.createVerticalStrut(60));
		leftContent.add(menuItem);
		menuItem.setLayout(new BoxLayout(menuItem, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel("Item 1");
		title.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem.add(title);
		menuItem.add(Box.createVerticalStrut(10));
		
		JLabel description = new JLabel("<html><div style=\\\"width:175px;\\\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis lacinia at orci non elementum.</div><html>");
		description.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem.add(description);
		menuItem.add(Box.createVerticalStrut(10));
		
		JButton btnOrder = new JButton("Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartItems.add(item);
				System.out.println(cartItems);
			}
		});
		menuItem.add(btnOrder);
		
		// picture
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/burger.jpg"));
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);
		
		// needs fixing
		JLabel imgContainer = new JLabel();
		imgContainer.setIcon(scaledIcon);
		rightContent.add(Box.createVerticalStrut(40));
		rightContent.add(imgContainer);
	}
}