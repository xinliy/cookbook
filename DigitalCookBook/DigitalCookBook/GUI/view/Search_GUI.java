package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Business_Logic.Recipe;
import controller.Controller;

public class Search_GUI extends JFrame {
	private JPanel middlePanel = new JPanel();
	private JPanel topPanel = new JPanel();
	private JPanel panelContainer = new JPanel();
	private JPanel bottomPanel = new JPanel();
	private JPanel []innerPanel = new JPanel[20];
	private JPanel emptyPanel = new JPanel();
	
	
	private JButton jb_add = new JButton("Add your own recipe!");
	private JTextField jtf_search = new JTextField("Dish Name/ Ingredient", 80);
	final String[] flavor = {"sweet", "spicy", "salty", "sour", "All flavor"};
	private JComboBox<Object> jcb_flavor = new JComboBox<Object>(flavor);
	private JButton jb_search = new JButton("SEARCH");
	private JLabel jl_search = new JLabel();
	private Icon search_logo = null;
	


	private JLabel jl_result = new JLabel("We have found the following recipe(s):");
	private JLabel []jl_name = new JLabel[20];
	private JLabel []jl_prepTime = new JLabel[20];
	private JLabel []jl_cookTime = new JLabel[20];
	private JLabel []jl_ingredients = new JLabel[20];
	private JLabel []jl_targetPrepTime = new JLabel[20];
	private JLabel []jl_targetCookTime = new JLabel[20];
	private JLabel []jl_targetIngredients = new JLabel[20];
	private JLabel []jl_flavor1 = new JLabel[20];
	private JLabel []jl_flavor2 = new JLabel[20];
	private JLabel []jl_flavor3 = new JLabel[20];
	private JLabel []jl_flavor4 = new JLabel[20];
	
	private Box box1 = Box.createHorizontalBox();     //placing jl_result
	private Box []box_name = new Box[20];  
	private Box []box_prepTime = new Box[20];  
	private Box []box_cookTime = new Box[20];  
	private Box []box_ingredients = new Box[20];  
	private Box []box_flavor = new Box[20];  
	private Box []box_recipe = new Box[20];
	private Box []box_bottomHoriBox = new Box[20];
	private Box box_bottomPanelItem = Box.createVerticalBox();
	
	
	public Search_GUI() {
		super("Enjoy your cooking time ^ ^");
		
		//getting the center of user's pc, place the windows in the center
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dim = tool.getScreenSize();
		int width = (int)dim.getWidth();
		int height = (int)dim.getHeight();
		this.setSize(768, 480);
		this.setLocation((width - 768)/2, (height - 480)/2);
		
		
		for(int i = 0;i < 20; i++) {
			jl_name[i] = new JLabel();
		}
		for(int i = 0;i < 20; i++) {
			jl_prepTime[i] = new JLabel("Preparing Time:");
		}
		for(int i = 0;i < 20; i++) {
			jl_cookTime[i] = new JLabel("Cooking Time:");
		}
		for(int i = 0;i < 20; i++) {
			jl_ingredients[i] = new JLabel("Ingredients: ");
		}
		for(int i = 0;i < 20; i++) {
			jl_targetPrepTime[i] = new JLabel();
		}
		for(int i = 0;i < 20; i++) {
			jl_targetCookTime[i] = new JLabel();
		}
		for(int i = 0;i < 20; i++) {
			jl_targetIngredients[i] = new JLabel();
		}
		for(int i = 0;i < 20; i++) {
			jl_flavor1[i] = new JLabel("Sweet");
			jl_flavor1[i].setPreferredSize(new Dimension(40,20));
		}
		for(int i = 0;i < 20; i++) {
			jl_flavor2[i] = new JLabel("Salty");
			jl_flavor2[i].setPreferredSize(new Dimension(40,20));
		}
		for(int i = 0;i < 20; i++) {
			jl_flavor3[i] = new JLabel("Spicy");
			jl_flavor3[i].setPreferredSize(new Dimension(40,20));
		}
		for(int i = 0;i < 20; i++) {
			jl_flavor4[i] = new JLabel("Sour");
			jl_flavor4[i].setPreferredSize(new Dimension(40,20));
		}
		
		for(int i = 0;i < 20; i++) {
			box_name[i] = Box.createHorizontalBox();
		}
		for(int i = 0;i < 20; i++) {
			box_prepTime[i] = Box.createHorizontalBox();
		}
		for(int i = 0;i < 20; i++) {
			box_cookTime[i] = Box.createHorizontalBox();
		}
		for(int i = 0;i < 20; i++) {
			box_ingredients[i] = Box.createHorizontalBox();
		}
		for(int i = 0;i < 20; i++) {
			box_flavor[i] = Box.createHorizontalBox();
		}
		for(int i = 0;i < 20; i++) {
			box_recipe[i] = Box.createVerticalBox();
		}
		for(int i = 0;i < 20; i++) {
			box_bottomHoriBox[i] = Box.createHorizontalBox();
		}
		for(int i = 0;i < 20; i++) {
			innerPanel[i] = new JPanel();
			innerPanel[i].setPreferredSize(new Dimension(280,130));
		}
		
		
		
		//setting the button of add
		jb_add.setSize(200, 20);
		jb_add.setBackground(Color.BLUE);
		jb_add.setForeground(Color.WHITE);
		jb_add.setFont(new Font("Arial", Font.BOLD, 20));
		jb_add.setHorizontalAlignment(JButton.CENTER);
		jb_add.setBorder(BorderFactory.createLineBorder(Color.blue, 1, true));
		
		//setting the search logo
		search_logo = new ImageIcon(this.getClass().getResource("/icon/logo.png"));
		jl_search.setIcon(search_logo);
		jl_search.setSize(30, 30);
		
		//setting the search textfield
		jtf_search.setSize(200, search_logo.getIconHeight());
		jtf_search.setBorder(BorderFactory.createLineBorder(Color.white, 1, true));
		jtf_search.setHorizontalAlignment(JTextField.LEFT);
		jtf_search.setForeground(Color.gray);
		
		//setting the combo box of flavor
		jcb_flavor.setSize(100, 30);
		jcb_flavor.setBorder(BorderFactory.createLineBorder(Color.white, 1, true));
		jcb_flavor.setSelectedIndex(4);
		
		//setting the button of search
		jb_search.setSize(70, 30);
		jb_search.setBackground(new Color(212, 73, 70));
		jb_search.setForeground(Color.WHITE);
		jb_search.setFont(new Font("Arial", Font.BOLD, 15));
		jb_search.setHorizontalAlignment(JButton.CENTER);
		jb_search.setBorder(BorderFactory.createLineBorder(new Color(212, 73, 70), 1, true));
		
		middlePanel.add(Box.createGlue());
		middlePanel.add(jb_add);
		middlePanel.add(Box.createHorizontalStrut(20));
		
		topPanel.setLayout(new FlowLayout());
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
		topPanel.add(Box.createHorizontalStrut(20));
		topPanel.add(jl_search);
		topPanel.add(jtf_search);
		topPanel.add(Box.createHorizontalStrut(10));
		topPanel.add(jcb_flavor);
		topPanel.add(Box.createHorizontalStrut(10));
		topPanel.add(jb_search);
		topPanel.add(Box.createHorizontalStrut(20));
		
		bottomPanel.setBorder(BorderFactory.createLineBorder(Color.red));
		
		panelContainer.setLayout(new GridBagLayout());
		
		GridBagConstraints c0 = new GridBagConstraints(); 
		c0.gridwidth = 0;
		c0.gridheight = 1;
		c0.weightx = 1;
		c0.weighty = 0;
		c0.fill = GridBagConstraints.BOTH;
		panelContainer.add(emptyPanel, c0); 
		emptyPanel.setMinimumSize(new Dimension(50,30));
		
		GridBagConstraints c1 = new GridBagConstraints(); 
		c1.gridwidth = 0;
		c1.gridheight = 1;
		c1.weightx = 1;
		c1.weighty = 0;
		c1.fill = GridBagConstraints.BOTH;
		panelContainer.add(topPanel, c1); 
		
		GridBagConstraints c2 = new GridBagConstraints(); 
		c2.gridwidth = 0;
		c2.gridheight = 1;
		c2.weightx = 1;
		c2.weighty = 0;
		c2.fill = GridBagConstraints.BOTH; 
		panelContainer.add(middlePanel, c2); 
		
		GridBagConstraints c3 = new GridBagConstraints(); 
		c1.gridwidth = 0;
		c1.gridheight = 1;
		c1.weightx = 1;
		c1.weighty = 0;
		c1.fill = GridBagConstraints.BOTH;
		panelContainer.add(new JPanel(), c3); 
		
		GridBagConstraints c4 = new GridBagConstraints(); 
		c4.gridwidth = 0;
		c4.gridheight = 0;
		c4.weightx = 1;
		c4.weighty = 1;
		c4.fill = GridBagConstraints.BOTH; 
		panelContainer.add(bottomPanel, c4); 
		
		panelContainer.setOpaque(true);
		this.setContentPane(panelContainer); 
		
		this.setVisible(true);
		this.setResizable(true);
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
		
		
		//input some words on search field, the color of the words is black
		//clear the hint sentence on search field, when the user type something from keyboard
		jtf_search.addKeyListener(new KeyAdapter(){

			public void keyTyped(KeyEvent e) {
				jtf_search.setForeground(Color.BLACK);
				if(jtf_search.getText().equals("Dish Name/ Ingredient")) {
					jtf_search.setText("");
				}
				
			}
			
		});
		
		
		
		
		
		
		//click on the search button, search certain dishes, then appear the specific dishes
		jb_search.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				bottomPanel.removeAll();
				box1.removeAll();
				box_bottomPanelItem.removeAll();
				for(int i = 0; i < 20; i++) {
					innerPanel[i].removeAll();
					box_recipe[i].removeAll();
					box_name[i].removeAll();
					box_prepTime[i].removeAll();
					box_cookTime[i].removeAll();
					box_ingredients[i].removeAll();
					box_flavor[i].removeAll();
					box_bottomHoriBox[i].removeAll();
				}
				
				
				Controller controller = new Controller();
				int targetRecipeNumber = 0;
				LinkedList<Recipe> targetRecipe = null;
				try {
					targetRecipeNumber = controller.searchByNameAndIngredient(jtf_search.getText(), jcb_flavor.getSelectedItem().toString()).size();
					System.out.println(targetRecipeNumber);
					targetRecipe = new LinkedList<Recipe>();
					for(int i = 0; i < targetRecipeNumber; i++) {
						targetRecipe.add(i, controller.searchByNameAndIngredient(jtf_search.getText(), jcb_flavor.getSelectedItem().toString()).get(i));
					}
					
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				
				if(targetRecipeNumber == 0) {
					JOptionPane.showMessageDialog(null, "No Result, please try other spell method!");
				} else {
					
					//setting the results sentence
					jl_result.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
					jl_result.setForeground(Color.gray);
					box1.add(jl_result);
					box1.add(Box.createHorizontalGlue());
					bottomPanel.add(box1);
					
					box_bottomPanelItem.add(box1);
					
					for(int j = 0; j < targetRecipeNumber; j++) {
						if(j % 2 == 0) {
							//adding box which is contains one recipe
							innerPanel[j].setBorder(BorderFactory.createLineBorder(Color.gray));
								
							jl_name[j].setText(targetRecipe.get(j).getDishName());
							jl_name[j].setFont(new Font("Arial", Font.BOLD, 18));
							jl_name[j].setForeground(Color.black);
							box_name[j].add(jl_name[j]);
							box_name[j].add(Box.createHorizontalGlue());
							box_recipe[j].add(box_name[j]);
								
							jl_prepTime[j].setFont(new Font("Arial", Font.PLAIN, 12));
							jl_prepTime[j].setForeground(Color.black);
							box_prepTime[j].add(jl_prepTime[j]);
							jl_targetPrepTime[j].setText(targetRecipe.get(j).getPreparationTime() + "min");
							jl_targetPrepTime[j].setFont(new Font("Arial", Font.PLAIN, 12));
							jl_targetPrepTime[j].setForeground(Color.black);
							box_prepTime[j].add(jl_targetPrepTime[j]);
							box_prepTime[j].add(Box.createHorizontalGlue());
							box_recipe[j].add(box_prepTime[j]);
							box_recipe[j].add(Box.createVerticalStrut(10));
								
							jl_cookTime[j].setFont(new Font("Arial", Font.PLAIN, 12));
							jl_cookTime[j].setForeground(Color.black);
							box_cookTime[j].add(jl_cookTime[j]);
							jl_targetCookTime[j].setText(targetRecipe.get(j).getCookingTime() + "min");
							jl_targetCookTime[j].setFont(new Font("Arial", Font.PLAIN, 12));
							jl_targetCookTime[j].setForeground(Color.black);
							box_cookTime[j].add(jl_targetCookTime[j]);
							box_cookTime[j].add(Box.createHorizontalGlue());
							box_recipe[j].add(box_cookTime[j]);
							box_recipe[j].add(Box.createVerticalStrut(10));
								
							jl_ingredients[j].setFont(new Font("Arial", Font.PLAIN, 12));
							jl_ingredients[j].setForeground(Color.black);
							box_ingredients[j].add(jl_ingredients[j]);
							try {
								jl_targetIngredients[j].setText(controller.getAllIngredientsName(targetRecipe.get(j).getDishName()));
							} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
							}
							jl_targetIngredients[j].setFont(new Font("Arial", Font.PLAIN, 12));
							jl_targetIngredients[j].setForeground(Color.black);
							box_ingredients[j].add(jl_targetIngredients[j]);
							box_ingredients[j].add(Box.createHorizontalGlue());
							box_recipe[j].add(box_ingredients[j]);
							box_recipe[j].add(Box.createVerticalStrut(10));
								
							try {
								for(int i = 0; i < controller.getAllTags(targetRecipe.get(j).getDishName()).size(); i++) {
									String targetTag = controller.getAllTags(targetRecipe.get(j).getDishName()).get(i);
									if(targetTag.equals("sweet")) {
										jl_flavor1[j].setHorizontalAlignment(JLabel.CENTER);
										jl_flavor1[j].setFont(new Font("Arial", Font.BOLD, 12));
										jl_flavor1[j].setOpaque(true);
										jl_flavor1[j].setBorder(BorderFactory.createLineBorder(Color.green));
										jl_flavor1[j].setBackground(Color.green);
										jl_flavor1[j].setForeground(Color.white);
										box_flavor[j].add(jl_flavor1[j]);
										box_flavor[j].add(Box.createHorizontalStrut(10));
									}
									else if(targetTag.equals("salty")) {
										jl_flavor2[j].setHorizontalAlignment(JLabel.CENTER);
										jl_flavor2[j].setFont(new Font("Arial", Font.BOLD, 12));
										jl_flavor2[j].setOpaque(true);
										jl_flavor2[j].setBorder(BorderFactory.createLineBorder(Color.pink));
										jl_flavor2[j].setBackground(Color.PINK);
										jl_flavor2[j].setForeground(Color.white);
										box_flavor[j].add(jl_flavor2[j]);
										box_flavor[j].add(Box.createHorizontalStrut(10));
									}
									else if(targetTag.equals("spicy")) {
										jl_flavor3[j].setHorizontalAlignment(JLabel.CENTER);
										jl_flavor3[j].setFont(new Font("Arial", Font.BOLD, 12));
										jl_flavor3[j].setOpaque(true);
										jl_flavor3[j].setBorder(BorderFactory.createLineBorder(Color.red));
										jl_flavor3[j].setBackground(Color.red);
										jl_flavor3[j].setForeground(Color.white);
										box_flavor[j].add(jl_flavor3[j]);
										box_flavor[j].add(Box.createHorizontalStrut(10));
									}
									else if(targetTag.equals("sour")) {
										jl_flavor4[j].setHorizontalAlignment(JLabel.CENTER);
										jl_flavor4[j].setFont(new Font("Arial", Font.BOLD, 12));
										jl_flavor4[j].setOpaque(true);
										jl_flavor4[j].setBorder(BorderFactory.createLineBorder(Color.orange));
										jl_flavor4[j].setBackground(Color.orange);
										jl_flavor4[j].setForeground(Color.white);
										box_flavor[j].add(jl_flavor4[j]);
										box_flavor[j].add(Box.createHorizontalStrut(10));
									}
									box_recipe[j].add(box_flavor[j]);
								}
								box_flavor[j].add(Box.createHorizontalGlue());
							} catch (ClassNotFoundException | SQLException e) {
								e.printStackTrace();
							}
							
							innerPanel[j].add(box_recipe[j]);
							box_bottomHoriBox[j].add(innerPanel[j]);	
						}	
						
						if(j % 2 == 1) {

							//adding box which is contains one recipe
							innerPanel[j].setBorder(BorderFactory.createLineBorder(Color.gray));
								
							jl_name[j].setText(targetRecipe.get(j).getDishName());
							jl_name[j].setFont(new Font("Arial", Font.BOLD, 18));
							jl_name[j].setForeground(Color.black);
							box_name[j].add(jl_name[j]);
							box_name[j].add(Box.createHorizontalGlue());
							box_recipe[j].add(box_name[j]);
								
							jl_prepTime[j].setFont(new Font("Arial", Font.PLAIN, 12));
							jl_prepTime[j].setForeground(Color.black);
							box_prepTime[j].add(jl_prepTime[j]);
							jl_targetPrepTime[j].setText(targetRecipe.get(j).getPreparationTime() + "min");
							jl_targetPrepTime[j].setFont(new Font("Arial", Font.PLAIN, 12));
							jl_targetPrepTime[j].setForeground(Color.black);
							box_prepTime[j].add(jl_targetPrepTime[j]);
							box_prepTime[j].add(Box.createHorizontalGlue());
							box_recipe[j].add(box_prepTime[j]);
							box_recipe[j].add(Box.createVerticalStrut(10));
								
							jl_cookTime[j].setFont(new Font("Arial", Font.PLAIN, 12));
							jl_cookTime[j].setForeground(Color.black);
							box_cookTime[j].add(jl_cookTime[j]);
							jl_targetCookTime[j].setText(targetRecipe.get(j).getCookingTime() + "min");
							jl_targetCookTime[j].setFont(new Font("Arial", Font.PLAIN, 12));
							jl_targetCookTime[j].setForeground(Color.black);
							box_cookTime[j].add(jl_targetCookTime[j]);
							box_cookTime[j].add(Box.createHorizontalGlue());
							box_recipe[j].add(box_cookTime[j]);
							box_recipe[j].add(Box.createVerticalStrut(10));
								
							jl_ingredients[j].setFont(new Font("Arial", Font.PLAIN, 12));
							jl_ingredients[j].setForeground(Color.black);
							box_ingredients[j].add(jl_ingredients[j]);
							try {
								jl_targetIngredients[j].setText(controller.getAllIngredientsName(targetRecipe.get(j).getDishName()));
							} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
							}
							jl_targetIngredients[j].setFont(new Font("Arial", Font.PLAIN, 12));
							jl_targetIngredients[j].setForeground(Color.black);
							box_ingredients[j].add(jl_targetIngredients[j]);
							box_ingredients[j].add(Box.createHorizontalGlue());
							box_recipe[j].add(box_ingredients[j]);
							box_recipe[j].add(Box.createVerticalStrut(10));
								
							try {
								for(int i = 0; i < controller.getAllTags(targetRecipe.get(j).getDishName()).size(); i++) {
									String targetTag = controller.getAllTags(targetRecipe.get(j).getDishName()).get(i);
									if(targetTag.equals("sweet")) {
										jl_flavor1[j].setHorizontalAlignment(JLabel.CENTER);
										jl_flavor1[j].setFont(new Font("Arial", Font.BOLD, 12));
										jl_flavor1[j].setOpaque(true);
										jl_flavor1[j].setBorder(BorderFactory.createLineBorder(Color.green));
										jl_flavor1[j].setBackground(Color.green);
										jl_flavor1[j].setForeground(Color.white);
										box_flavor[j].add(jl_flavor1[j]);
										box_flavor[j].add(Box.createHorizontalStrut(10));
									}
									else if(targetTag.equals("salty")) {
										jl_flavor2[j].setHorizontalAlignment(JLabel.CENTER);
										jl_flavor2[j].setFont(new Font("Arial", Font.BOLD, 12));
										jl_flavor2[j].setOpaque(true);
										jl_flavor2[j].setBorder(BorderFactory.createLineBorder(Color.pink));
										jl_flavor2[j].setBackground(Color.PINK);
										jl_flavor2[j].setForeground(Color.white);
										box_flavor[j].add(jl_flavor2[j]);
										box_flavor[j].add(Box.createHorizontalStrut(10));
									}
									else if(targetTag.equals("spicy")) {
										jl_flavor3[j].setHorizontalAlignment(JLabel.CENTER);
										jl_flavor3[j].setFont(new Font("Arial", Font.BOLD, 12));
										jl_flavor3[j].setOpaque(true);
										jl_flavor3[j].setBorder(BorderFactory.createLineBorder(Color.red));
										jl_flavor3[j].setBackground(Color.red);
										jl_flavor3[j].setForeground(Color.white);
										box_flavor[j].add(jl_flavor3[j]);
										box_flavor[j].add(Box.createHorizontalStrut(10));
									}
									else if(targetTag.equals("sour")) {
										jl_flavor4[j].setHorizontalAlignment(JLabel.CENTER);
										jl_flavor4[j].setFont(new Font("Arial", Font.BOLD, 12));
										jl_flavor4[j].setOpaque(true);
										jl_flavor4[j].setBorder(BorderFactory.createLineBorder(Color.orange));
										jl_flavor4[j].setBackground(Color.orange);
										jl_flavor4[j].setForeground(Color.white);
										box_flavor[j].add(jl_flavor4[j]);
										box_flavor[j].add(Box.createHorizontalStrut(10));
									}
									box_recipe[j].add(box_flavor[j]);
								}
								box_flavor[j].add(Box.createHorizontalGlue());
							} catch (ClassNotFoundException | SQLException e) {
								e.printStackTrace();
							}
								
							innerPanel[j].add(box_recipe[j]);
							box_bottomHoriBox[j-1].add(Box.createHorizontalStrut(80));
							box_bottomHoriBox[j-1].add(innerPanel[j]);	
						
						}
						
						if(j % 2 == 0) {
							box_bottomPanelItem.add(box_bottomHoriBox[j]);
						} else {
							box_bottomPanelItem.add(box_bottomHoriBox[j-1]);
							box_bottomPanelItem.add(Box.createVerticalStrut(20));
							
						}
						
						
					}
				
					
				
				bottomPanel.add(box_bottomPanelItem);
					
				Search_GUI.this.revalidate();
				}
				
			}
			
		});
		
		
		//click on one recipe, then go to the view_GUI
		for(int i = 0; i < 20; i++) {
			innerPanel[i].addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e) {
					JOptionPane.showMessageDialog(null, "Hi!");
				}
			});
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Search_GUI search_GUI_New = new Search_GUI();
		search_GUI_New.initListener();

	}
}
