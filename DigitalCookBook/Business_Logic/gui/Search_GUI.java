package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Search_GUI extends JFrame {

	private JTextField jtf_search = new JTextField("Dish Name/ Ingredient", 80);
	final String[] flavor = {"sweet", "spicy", "salty", "sour", " "};
	private JComboBox<Object> jcb_flavor = new JComboBox<Object>(flavor);
	private JButton jb_search = new JButton("SEARCH");
	private JLabel jl_search = new JLabel();
	private Icon search_logo = null;
	
	
	//private JTextArea textArea = new JTextArea();
	private JPanel jp_panel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane(jp_panel);
	private JLabel jl_result = new JLabel("We have found the following recipe(s):");
	
	private JPanel jp_subpanel1 = new JPanel();
	private JLabel jl_name1 = new JLabel("Hong Shao Rou");
	private JLabel jl_prepTime1 = new JLabel("Preparing Time:");
	private JLabel jl_cookTime1 = new JLabel("Cooking Time:");
	private JLabel jl_ingredients1 = new JLabel("Ingredients: ");
	private JLabel jl_prepTime11 = new JLabel("30 min");
	private JLabel jl_cookTime11 = new JLabel("90 min");
	private JLabel jl_ingredients11 = new JLabel("Pork, ginger, soya sauce...");
	private JLabel jl_flavor1 = new JLabel("Sweet");
	private JLabel jl_flavor2 = new JLabel("Salty");
	
	private JPanel jp_subpanel2 = new JPanel();	
	private JLabel jl_name2 = new JLabel("La Zi Ji");
	private JLabel jl_prepTime2 = new JLabel("Preparing Time:");
	private JLabel jl_cookTime2 = new JLabel("Cooking Time:");
	private JLabel jl_ingredients2 = new JLabel("Ingredients: ");
	private JLabel jl_prepTime22 = new JLabel("20 min");
	private JLabel jl_cookTime22 = new JLabel("80 min");
	private JLabel jl_ingredients22 = new JLabel("Pork, ginger");
	private JLabel jl_flavor3 = new JLabel("Sweet");
	private JLabel jl_flavor4 = new JLabel("Spicy");
	
	
	
	public Search_GUI() {
		super("Enjoy your cooking time ^ ^");
		
		//getting the center of user's pc, place the windows in the center
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dim = tool.getScreenSize();
		int width = (int)dim.getWidth();
		int height = (int)dim.getHeight();
		this.setSize(768, 480);
		this.setLocation((width - 768)/2, (height - 480)/2);
		
		//setting the search textfield4
		jtf_search.setBounds(70, 30, 450, 30);
		jtf_search.setBorder(BorderFactory.createLineBorder(Color.white, 1, true));
		jtf_search.setHorizontalAlignment(JTextField.LEFT);
		jtf_search.setForeground(Color.gray);
		this.add(jtf_search);
		
		//setting the combo box of flavor
		jcb_flavor.setBounds(530, 30, 100, 30);
		jcb_flavor.setBorder(BorderFactory.createLineBorder(Color.white, 1, true));
		jcb_flavor.setSelectedIndex(4);
		this.add(jcb_flavor);
		
		//setting the button of search
		jb_search.setBounds(640, 30, 80, 30);
		jb_search.setBackground(new Color(212, 73, 70));
		jb_search.setForeground(Color.WHITE);
		jb_search.setFont(new Font("Arial", Font.BOLD, 15));
		jb_search.setHorizontalAlignment(JButton.CENTER);
		jb_search.setBorder(BorderFactory.createLineBorder(Color.white, 1, true));
		this.add(jb_search);
		
		//setting the search logo
		search_logo = new ImageIcon(this.getClass().getResource("/icon/logo.png"));
		jl_search.setIcon(search_logo);
		jl_search.setBounds(30, 30, search_logo.getIconWidth(), search_logo.getIconHeight());
		this.add(jl_search);
		
		//setting the scroll pane, using a panel
		
		scrollPane.setBounds(0, 100, 768, 500);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		jp_panel.setLayout(null);
		//jp_panel.setBorder(BorderFactory.createTitledBorder("·Ö×é¿ò")); 
		jp_panel.setBorder(BorderFactory.createLineBorder(Color.red));
		
		jl_result.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
		jl_result.setBounds(10, 5, 600, 20);
		jl_result.setForeground(Color.gray);
		jp_panel.add(jl_result);
		
		jp_subpanel1.setLayout(null);
		//jp_subpanel1.setBorder(BorderFactory.createTitledBorder("111"));
		jp_subpanel1.setBorder(BorderFactory.createLineBorder(Color.gray));
		jp_subpanel1.setBounds(100, 50, 250, 150);
		
		jl_name1.setFont(new Font("Arial", Font.BOLD, 18));
		jl_name1.setBounds(10, 5, 600, 20);
		jl_name1.setForeground(Color.black);
		jp_subpanel1.add(jl_name1);
		jl_prepTime1.setFont(new Font("Arial", Font.PLAIN, 12));
		jl_prepTime1.setBounds(10, 35, 600, 15);
		jl_prepTime1.setForeground(Color.black);
		jp_subpanel1.add(jl_prepTime1);
		jl_prepTime11.setFont(new Font("Arial", Font.PLAIN, 12));
		jl_prepTime11.setBounds(110, 35, 600, 15);
		jl_prepTime11.setForeground(Color.black);
		jp_subpanel1.add(jl_prepTime11);
		jl_cookTime1.setFont(new Font("Arial", Font.PLAIN, 12));
		jl_cookTime1.setBounds(10, 60, 600, 15);
		jl_cookTime1.setForeground(Color.black);
		jp_subpanel1.add(jl_cookTime1);
		jl_cookTime11.setFont(new Font("Arial", Font.PLAIN, 12));
		jl_cookTime11.setBounds(100, 60, 600, 15);
		jl_cookTime11.setForeground(Color.black);
		jp_subpanel1.add(jl_cookTime11);
		jl_ingredients1.setFont(new Font("Arial", Font.PLAIN, 12));
		jl_ingredients1.setBounds(10, 85, 600, 15);
		jl_ingredients1.setForeground(Color.black);
		jp_subpanel1.add(jl_ingredients1);
		jl_ingredients11.setFont(new Font("Arial", Font.PLAIN, 12));
		jl_ingredients11.setBounds(80, 85, 600, 15);
		jl_ingredients11.setForeground(Color.black);
		jp_subpanel1.add(jl_ingredients11);
		
		jl_flavor1.setHorizontalAlignment(JLabel.CENTER);
		jl_flavor1.setFont(new Font("Arial", Font.BOLD, 12));
		jl_flavor1.setBounds(10, 110, 50, 25);
		jl_flavor1.setOpaque(true);
		jl_flavor1.setBackground(Color.green);
		jl_flavor1.setForeground(Color.white);
		jp_subpanel1.add(jl_flavor1);
		
		jl_flavor2.setHorizontalAlignment(JLabel.CENTER);
		jl_flavor2.setFont(new Font("Arial", Font.BOLD, 12));
		jl_flavor2.setBounds(80, 110, 50, 25);
		jl_flavor2.setOpaque(true);
		jl_flavor2.setBackground(Color.PINK);
		jl_flavor2.setForeground(Color.white);
		jp_subpanel1.add(jl_flavor2);
			
		jp_panel.add(jp_subpanel1);
		
		jp_subpanel2.setLayout(null);
		//jp_subpanel2.setBorder(BorderFactory.createTitledBorder("222"));
		jp_subpanel2.setBorder(BorderFactory.createLineBorder(Color.gray));
		jp_subpanel2.setBounds(418, 50, 250, 150);
		
		jl_name2.setFont(new Font("Arial", Font.BOLD, 18));
		jl_name2.setBounds(10, 5, 600, 20);
		jl_name2.setForeground(Color.black);
		jp_subpanel2.add(jl_name2);
		jl_prepTime2.setFont(new Font("Arial", Font.PLAIN, 12));
		jl_prepTime2.setBounds(10, 35, 600, 15);
		jl_prepTime2.setForeground(Color.black);
		jp_subpanel2.add(jl_prepTime2);
		jl_prepTime22.setFont(new Font("Arial", Font.PLAIN, 12));
		jl_prepTime22.setBounds(110, 35, 600, 15);
		jl_prepTime22.setForeground(Color.black);
		jp_subpanel2.add(jl_prepTime22);
		jl_cookTime2.setFont(new Font("Arial", Font.PLAIN, 12));
		jl_cookTime2.setBounds(10, 60, 600, 15);
		jl_cookTime2.setForeground(Color.black);
		jp_subpanel2.add(jl_cookTime2);
		jl_cookTime22.setFont(new Font("Arial", Font.PLAIN, 12));
		jl_cookTime22.setBounds(100, 60, 600, 15);
		jl_cookTime22.setForeground(Color.black);
		jp_subpanel2.add(jl_cookTime22);
		jl_ingredients2.setFont(new Font("Arial", Font.PLAIN, 12));
		jl_ingredients2.setBounds(10, 85, 600, 15);
		jl_ingredients2.setForeground(Color.black);
		jp_subpanel2.add(jl_ingredients2);
		jl_ingredients22.setFont(new Font("Arial", Font.PLAIN, 12));
		jl_ingredients22.setBounds(80, 85, 600, 15);
		jl_ingredients22.setForeground(Color.black);
		jp_subpanel2.add(jl_ingredients22);
		
		
		jl_flavor3.setHorizontalAlignment(JLabel.CENTER);
		jl_flavor3.setFont(new Font("Arial", Font.BOLD, 12));
		jl_flavor3.setBounds(10, 110, 50, 25);
		jl_flavor3.setOpaque(true);
		jl_flavor3.setBackground(Color.green);
		jl_flavor3.setForeground(Color.white);
		jp_subpanel2.add(jl_flavor3);
		
		jl_flavor4.setHorizontalAlignment(JLabel.CENTER);
		jl_flavor4.setFont(new Font("Arial", Font.BOLD, 12));
		jl_flavor4.setBounds(80, 110, 50, 25);
		jl_flavor4.setOpaque(true);
		jl_flavor4.setBackground(Color.RED);
		jl_flavor4.setForeground(Color.white);
		jp_subpanel2.add(jl_flavor4);
		
		jp_panel.add(jp_subpanel2);
		
		
		
		this.add(scrollPane);
		
		
		
		
		
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void initListener() {
		//default value of searching textfield, when you click on it, it will clear the default content
		jtf_search.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if(jtf_search.getText().equals("Dish Name/ Ingredient")) {
					jtf_search.setText("");
				}
			}
		});
		
		//click on the search button, show the all recipe which meets user's request
		jb_search.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
			
		});
		
	}
	
	
	
	public static void main(String[] args) {
		Search_GUI search_GUI = new Search_GUI();
		search_GUI.initListener();

	}

}