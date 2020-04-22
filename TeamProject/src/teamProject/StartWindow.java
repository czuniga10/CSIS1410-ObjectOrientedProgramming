package teamProject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
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
import java.awt.Point;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	/*private List<Item> itemList = new ArrayList<>(Arrays.asList(new Item("Large Pizza", 12.5), 
			new Item("Pancakes", 6.0), new Item("Eggs", 8.0), new Item("Cookies", 2.5),
			new Item("Sandwich", 7.50), new Item("Burrito", 11.0), new Item("Rice Bowl", 5.0)));*/
	
	/*private List<Item> itemList = new ArrayList<>(
			Arrays.asList(new Item("Hamburger",3.50),
                    new Item("Cheeseburger",5.00),
                    new Item("DoubleCheeseburger",5.50),
                    new Item("TripleCheeseburger",6.00),
                    new Item("FrenchFries",2.50),
                    new Item("Drink",1.50)
                    ));*/
	
	private List<Item> itemList = new ArrayList<>();
	private List<Item> cartList = new ArrayList<>();
	static BillingSystem b;

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
		parseTextMenu("burgerJoint.txt");
		b = new BillingSystem(cartList);
		System.out.println(b.getCartList());
		
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
		
		//summary = new SummaryWindow();
		
		cardContainer.add(menu);
		//cardContainer.add(summary);
		
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
		for (Item el : itemList) {
			createItemComponent(leftContent, rightContent, el);
		}
		
		// 'continue' button at the bottom
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				summary = new SummaryWindow();
				cardContainer.add(summary);
				setSize(755, 935);
				setLocationRelativeTo(null);
				sp.getVerticalScrollBar().setValue(0);
				menu.setVisible(false);
				summary.setVisible(true);
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
		
		JLabel description = new JLabel(String.format("<html><div style=\\\"width:175px;\\\">%s</div><html>", item.getDescription()));
		description.setFont(new Font("Arial", Font.PLAIN, 12));
		menuItem.add(description);
		menuItem.add(Box.createVerticalStrut(10));
		
		JButton btnOrder = new JButton("Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cartList.add(item);
				System.out.println(b.getCartList());
			}
		});
		menuItem.add(btnOrder);
		
		// picture
		ImageIcon icon = new ImageIcon(this.getClass().getResource(String.format("/images/%s.png",item.getName())));
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);
		
		JLabel imgContainer = new JLabel();
		imgContainer.setIcon(scaledIcon);
		rightContent.add(Box.createVerticalStrut(50));
		rightContent.add(imgContainer);
	}
	
	public void parseTextMenu(String readFile) {
		try {
			FileReader reader = new FileReader(String.format("menus/%s", readFile));
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();
			
			while (line != null) {
				String[] c = line.split("_");
				itemList.add(new Item(c[0], Double.parseDouble(c[1]), c[2]));
				line = buffer.readLine();
			}
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}