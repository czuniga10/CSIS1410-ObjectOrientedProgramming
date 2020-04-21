package teamProject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 * 
 * 
 * @author Tomas Olvera
 * @author Chad Zuniga
 */
@SuppressWarnings("serial")
public class StartWindow extends JFrame {

	private JPanel cardContainer;
	private JPanel menu;
	private JPanel summary;
	private List<Item> cartItems = new ArrayList<>();
	private List<Item> menuItems = new ArrayList<>(
			Arrays.asList(new Item("Hamburger",3.50),
					new Item("Cheeseburger",5.00),
					new Item("DoubleCheeseburger",5.50),
					new Item("TripleCheeseburger",6.00),
					new Item("FrenchFries",2.50),
					new Item("Drink",1.50)
					));
	private JScrollPane sp;

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
		
		sp = new JScrollPane(cardContainer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
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
		
		// Set menu items
		for(Item el:menuItems) {
			createItemComponent(leftContent, rightContent, el);
		}
		
		// adding menu items
//		createItemComponent(leftContent, rightContent, new Item("Pizza", 12.5));
//		createItemComponent(leftContent, rightContent, new Item("Pizza1", 12.5));
//		createItemComponent(leftContent, rightContent, new Item("Pizza2", 12.5));
//		createItemComponent(leftContent, rightContent, new Item("Pizza3", 12.5));
//		createItemComponent(leftContent, rightContent, new Item("Pizza4", 12.5));
//		createItemComponent(leftContent, rightContent, new Item("Pizza5", 12.5));
		
		// 'continue' button at the bottom
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				summary.setVisible(true);
				setBounds(100, 100, 750, 850); //sets the bounds of the new page
				sp.getVerticalScrollBar().setValue(0);//moves users view to top of the page
//				SummaryWindow.triggerCartListUpdate(cartItems);
			}
		});
		menu.add(btnNewButton, BorderLayout.SOUTH);
	}

	private void createItemComponent(JPanel leftContent, JPanel rightContent, Item item) {
		// menuItem
		JPanel menuItem = new JPanel();
		leftContent.add(Box.createVerticalStrut(52));
		leftContent.add(menuItem);
		menuItem.setLayout(new BoxLayout(menuItem, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(item.getName());
		title.setFont(new Font("Arial", Font.BOLD, 14));
		menuItem.add(title);
		menuItem.add(Box.createVerticalStrut(10));
		
		JLabel description = new JLabel(String.format("<html><div style=\\\"width:200px;\\\">%s</div><html>",item.getDescription()));
		description.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem.add(description);
		menuItem.add(Box.createVerticalStrut(10));
		
		JButton btnOrder = new JButton("Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartItems.add(item);
				SummaryWindow.updateCartList(item);
				System.out.println(cartItems);
			}
		});
		menuItem.add(btnOrder);
		
		// picture
		ImageIcon icon = new ImageIcon(this.getClass().getResource(String.format("/images/%s.png",item.getName())));
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(120, 125, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);
		
		// needs fixing
		JLabel imgContainer = new JLabel();
		imgContainer.setIcon(scaledIcon);
		rightContent.add(Box.createVerticalStrut(50));
		rightContent.add(imgContainer);
	}
}