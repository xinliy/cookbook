package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business_Logic.Ingredient;
import Business_Logic.Recipe;
import Business_Logic.Tag;
import controller.Controller;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Edit extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

//	private Box horizontalBox_9 ;
//	public Box getHorizontalBox_9() {
//		
//		return horizontalBox_9;
//	}
//
//
//
//	public void setHorizontalBox_9(Box horizontalBox_9) {
//		this.horizontalBox_9 = horizontalBox_9;
//	}
	private Box horizontalBox_10 ;
	public Box getHorizontalBox_10() {
		return horizontalBox_10;
	}



	public void setHorizontalBox_10(Box horizontalBox_10) {
		this.horizontalBox_10 = horizontalBox_10;
	}
	private  JCheckBox chckbxSour;
	private  JCheckBox chckbxSweet;
	private  JCheckBox chckbxSpicy;
	private  JCheckBox chckbxSalty;
	private  JComboBox comboBox;
	private static String recipeName;  //???
	private static Recipe targetRecipe;//?????
	private JPanel contentPane;
	private LinkedList<JTextField> ingredientTextField = new LinkedList<JTextField>();

	public LinkedList<Box> getIngredientBoxList() {
		return ingredientBoxList;
	}



	public void setIngredientBoxList(LinkedList<Box> ingredientBoxList) {
		this.ingredientBoxList = ingredientBoxList;
	}



	public LinkedList<JTextField> getIngredientTextField() {
		return ingredientTextField;
	}



	public void setIngredientTextField(LinkedList<JTextField> ingredientTextField) {
		this.ingredientTextField = ingredientTextField;
	}



	public JCheckBox getChckbxSour() {
		return chckbxSour;
	}



	public void setChckbxSour(JCheckBox chckbxSour) {
		this.chckbxSour = chckbxSour;
	}



	public JCheckBox getChckbxSweet() {
		return chckbxSweet;
	}



	public void setChckbxSweet(JCheckBox chckbxSweet) {
		this.chckbxSweet = chckbxSweet;
	}



	public JCheckBox getChckbxSpicy() {
		return chckbxSpicy;
	}



	public void setChckbxSpicy(JCheckBox chckbxSpicy) {
		this.chckbxSpicy = chckbxSpicy;
	}



	public JCheckBox getChckbxSalty() {
		return chckbxSalty;
	}



	public void setChckbxSalty(JCheckBox chckbxSalty) {
		this.chckbxSalty = chckbxSalty;
	}



	public JTextField getTextField_1() {
		return textField_1;
	}



	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}



	public JTextField getTextField_2() {
		return textField_2;
	}



	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}



	public JTextField getTextField_3() {
		return textField_3;
	}



	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}



	public JTextField getTextField_4() {
		return textField_4;
	}



	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}

	public JPanel getPanel_2() {
		return panel_2;
	}



	public void setPanel_2(JPanel panel_2) {
		this.panel_2 = panel_2;
	}



	public JPanel getPanel_3() {
		return panel_3;
	}



	public void setPanel_3(JPanel panel_3) {
		this.panel_3 = panel_3;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}



	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}
	private JPanel panel_2;
	private JPanel panel_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public int getCountIngredientText() {
		return countIngredientText;
	}



	public void setCountIngredientText(int countIngredientText) {
		this.countIngredientText = countIngredientText;
	}



	public int getCountStepText() {
		return countStepText;
	}



	public void setCountStepText(int countStepText) {
		this.countStepText = countStepText;
	}

	private int countIngredientText;
	private int countStepText;
	private Box box;
	private JTextField tfield;
	private LinkedList<Box> ingredientBoxList = new LinkedList<Box>(); // 用户添加的ingredient 一个box有四个输入框
	private LinkedList<JTextField> stepList = new LinkedList<JTextField>(); // 用户添加的步骤
	



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

				try {
					//Edit frame = new Edit();
					Edit edit = new Edit();
					edit.addWindowListener(new WindowListener(){
						public void windowOpened(WindowEvent e) {  
					        System.out.println("windowOpened--->窗口被打开");  
					        Controller controller = new Controller();
					       try {
					    	   	recipeName = "Hong Shao Rou";
					    	   	targetRecipe = controller.catchRecipe(recipeName);
					    	   	
					    	   	edit.getTextField_1().setText((targetRecipe.getDishName()));
					    	   	edit.getTextField_1().setEditable(false);
					    	   	//edit.getTextField_1().setEditable(false);
					    	   	edit.getTextField_2().setText((targetRecipe.getLocation()));
					    	   	edit.getTextField_3().setText(Integer.toString(targetRecipe.getPreparationTime()));
					    	   	edit.getTextField_4().setText(Integer.toString(targetRecipe.getCookingTime()));
					    	   	//
					    	   	edit.getComboBox().setSelectedIndex(targetRecipe.getServings() -1) ;
					    	   			
					    	   	for(int i=0;i<targetRecipe.getTagList().size();i++){
					    	   
					    	   		if(targetRecipe.getTagList().get(i).getTagContent().equals("sweet")){
					    	   			edit.getChckbxSweet().setSelected(true);
					    	   		}if(targetRecipe.getTagList().get(i).getTagContent().equals("salty")){
					    	   			edit.getChckbxSalty().setSelected(true);
					    	   		}if(targetRecipe.getTagList().get(i).getTagContent().equals("spicy")){
					    	   			edit.getChckbxSpicy().setSelected(true);
					    	   		}if(targetRecipe.getTagList().get(i).getTagContent().equals("sour")){
					    	   			edit.getChckbxSour().setSelected(true);
					    	   		}
					    	   		
					    	   	}
					    	   		int countIngredient = targetRecipe.getIngredient().size();
					    	   		
					    	   		int countStep = targetRecipe.getSteps().size();
					    	   		System.out.println(countStep +"step");
					    	   		for(int i3=0; i3<countStep;i3++){
					    	   			Box box = Box.createHorizontalBox();
					    	   			JTextField tfield = new JTextField();
					    	   			
					    	   			box.add(tfield);
					    				edit.getPanel_3().add(box);
					    				edit.countStepText++;
					    				
					    				tfield.setColumns(10);
					    				tfield.setMaximumSize(new Dimension(1000, 20));
					    				//edit.getHorizontalBox_10().add(tfield);
					    				
					    				edit.stepList.add(tfield);
					    	   		}
					    	   		
									if (edit.countStepText == 100) {

									} else {
										int counter = edit.countStepText - 100;
										for (int n = 0; n < counter; n++) {
											edit.stepList.get(n).setText(targetRecipe.getSteps().get(n));
											//recipe2.addPreparationStep(stepList.get(n).getText());
										}
										edit.revalidate();
									}
									
									
					    	   		
					    	   	
					    	   		
					    	   		
					    	   		for(int i2 =0 ;i2 <countIngredient; i2++){
					    	   			Box box = Box.createHorizontalBox();
					    	   			//box = Box.createHorizontalBox();
					    				//ingredientBoxList.add(box);
					    	   			//box = Box.createHorizontalBox();
					    				edit.ingredientBoxList.add(box);
					    				edit.getPanel_2().add(box);
					    				//edit.countStepText;
					    				
					    				for (int i1 = 1; i1 <= 4; i1++) {
					    					JTextField tfield = new JTextField();
					    					tfield.setColumns(10);
					    					tfield.setMaximumSize(new Dimension(1000, 20));
					    					box.add(tfield);
					    					//ingredientTextField.add(tfield);
					    					int count;
					    					
					    					edit.getIngredientTextField().add(tfield);
					    					count = edit.getCountIngredientText();
					    					count++;
					    					edit.setCountIngredientText(count);
					    					
					    					//edit.setIngredientTextField(edit.getIngredientTextField());
					    				}
					    				
					    				edit.revalidate();
					    			}
					    	   		//int a = edit.getCountIngredientText() + 4*countIngredient;
					    	   		//edit.setCountIngredientText(a);
					    	   		if (edit.getCountIngredientText() == 20) {

									} else {
										int counter = (edit.getCountIngredientText() - 20) / 4;// how much
																						// 4
										//System.out.println(ingredientTextField.size());
										//System.out.println(countIngredientText);
										for (int n = 0; n < counter; n++) {
											
												edit.getIngredientTextField().get((n) * 4).setText(targetRecipe.getIngredient().get((n)).getIngredientName());
												
												edit.getIngredientTextField().get(1+(n) * 4).setText(Double.toString(targetRecipe.getIngredient().get((n)).getQuantity()));
												edit.getIngredientTextField().get(2+(n) * 4).setText(targetRecipe.getIngredient().get((n)).getUnit());
												edit.getIngredientTextField().get(3+(n) * 4).setText(targetRecipe.getIngredient().get((n)).getDescription());
									
										
										}
									}
					    	   	
										
					    	   	
					    	   	
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					    }  
					  
					    @Override  
					    public void windowClosing(WindowEvent e) {  
					        System.out.println("windowClosing--->窗口关闭");  
					    }  
					  
					    @Override  
					    public void windowClosed(WindowEvent e) {  
					        System.out.println("windowClosed--->窗口被关闭");  
					    }  
					  
					    @Override  
					    public void windowIconified(WindowEvent e) {  
					        System.out.println("windowIconified--->窗口最小化");  
					    }  
					  
					    @Override  
					    public void windowDeiconified(WindowEvent e) {  
					        System.out.println("windowDeiconfied--->窗口从最小化恢复");  
					    }  
					  
					    @Override  
					    public void windowActivated(WindowEvent e) {  
					        System.out.println("windowActivated--->窗口被选中");  
					    }  
					  
					    @Override  
					    public void windowDeactivated(WindowEvent e) {  
					        System.out.println("windowDeactivated--->取消窗口被选中");  
					    }  
					});
					
					edit.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	

	/**
	 * Create the frame.
	 */
	public Edit() {

		countStepText = 100;
		countIngredientText = 20;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 480);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		horizontalBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		contentPane.add(horizontalBox);

		JButton btnNewButton = new JButton("Back");
		horizontalBox.add(btnNewButton);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Integer recipeId;
				String dishName;
				String location;
				Integer servings;
				Integer preparationTime;
				Integer cookingTime;
				//
				// String ingredientName;
				// Integer quantity;
				// String unit;
				// String description;
				//
				// Integer step;
				//
				// String tagContent;
				// int ingredientTextCounter=0;
				// int stepTextCounte=0;



				try{
					Controller controller = new Controller();
					recipeId = controller.selectIdByName(targetRecipe.getDishName());
					dishName = textField_1.getText();
					location = textField_2.getText();
					servings = comboBox.getSelectedIndex() + 1;
					preparationTime = Integer.parseInt(textField_3.getText());
					cookingTime = Integer.parseInt(textField_4.getText());
				
					Recipe recipe2 = new Recipe(recipeId, dishName, location, servings);
					recipe2.setPreparationTime(preparationTime);
					recipe2.setCookingTime(cookingTime);
					controller.updateRecipe(recipe2);
//					for(int i =0 ; i<recipe2.getTagList().size();i++){
//						recipe2.getTagList().removeLast();
//					}
					controller.removeAllTag(recipe2);
					if(chckbxSpicy.isSelected()){
						recipe2.addTag(new Tag(chckbxSpicy.getText()));
					}
					if(chckbxSweet.isSelected()){
						recipe2.addTag(new Tag(chckbxSweet.getText()));
					}
					if(chckbxSalty.isSelected()){
						recipe2.addTag(new Tag(chckbxSalty.getText()));
					}
					if(chckbxSour.isSelected()){
						recipe2.addTag(new Tag(chckbxSour.getText()));
					}
					controller.addRecipeTag(recipe2);
					
					
					
//
					
					
					
				} catch (ClassNotFoundException e1) {

					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

//				try {
//					//controller.deleteRecipe(targetRecipe.getDishName());
//					recipeId = controller.selectIdByName(targetRecipe.getDishName());
//					System.out.println(recipeId + "aaaaaaaaa");
//					dishName = textField_1.getText();
//					location = textField_2.getText();
//					// servings = comboBox.getSelectedItem();
//					servings = comboBox.getSelectedIndex() + 1;
//					Recipe recipe2 = new Recipe(recipeId, dishName, location, servings);
//					preparationTime = Integer.parseInt(textField_3.getText());
//					cookingTime = Integer.parseInt(textField_4.getText());
//					recipe2.setPreparationTime(preparationTime);
//					recipe2.setCookingTime(cookingTime);
//					if(chckbxSpicy.isSelected()){
//						recipe2.addTag(new Tag(chckbxSpicy.getText()));
//					}
//					if(chckbxSweet.isSelected()){
//						recipe2.addTag(new Tag(chckbxSweet.getText()));
//					}
//					if(chckbxSalty.isSelected()){
//						recipe2.addTag(new Tag(chckbxSalty.getText()));
//					}
//					if(chckbxSour.isSelected()){
//						recipe2.addTag(new Tag(chckbxSour.getText()));
//					}
//
//					System.out.println("checkbox");
//					try{
//						if (countIngredientText == 20) {
//
//						} else {
//							
//							int counter = (countIngredientText - 20) / 4;// how much 4
//							System.out.println(counter + "counter");												
//							System.out.println(ingredientTextField.size()+ " save buttonfield a");
//							System.out.println(countIngredientText+"save button  text b");
//							System.out.println(ingredientTextField.get(0).getText());
//							System.out.println(ingredientTextField.get(1).getText());
//							for (int n = 0; n < counter; n++) {
//							
//								recipe2.addIngredient(new Ingredient(ingredientTextField.get((n) * 4).getText(),
//										Integer.parseInt(ingredientTextField.get(1 + (n) * 4).getText()),
//										ingredientTextField.get(2 + (n) * 4).getText(),
//										ingredientTextField.get(3 + (n) * 4).getText()));
//							}
//						}
//					} catch(Exception e2){
//						System.out.println("this ");
//					}
//					
////					recipe2.addPreparationStep(textField_9.getText());
////					recipe2.addPreparationStep(textField_12.getText());
////					recipe2.addPreparationStep(textField_13.getText());
////					recipe2.addPreparationStep(textField_14.getText());
////					recipe2.addPreparationStep(textField_15.getText());
//					if (countStepText == 100) {
//
//					} else {
//						System.out.println(stepList.size()+ " stepList a");
//						System.out.println(countStepText +  " countStep Text b");
//						int counter = countStepText - 100;
//						for (int n = 0; n < counter; n++) {
//							recipe2.addPreparationStep(stepList.get(n).getText());
//						}
//					}
//					controller.returnRecipe(recipe2);
//					revalidate();
//					// recipe.addIngredient(new Ingredient());l/
//
//					// for(int countIngredientText =20; countIngred)
//					// String value = comboBox.getSelectedItem().toString();
//					// location =
//
//				} catch (ClassNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				} catch (Exception e1) {
//					JOptionPane.showMessageDialog(null, "error");
//				}
//
//				finally {
//
//				}
				
				
				
				
				
				
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		horizontalBox.add(btnSave);

		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(horizontalBox_1);
		
		Component horizontalStrut_12 = Box.createHorizontalStrut(70);
		horizontalBox_1.add(horizontalStrut_12);

		JLabel lblNewLabel = new JLabel("Recipe name:");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalBox_1.add(lblNewLabel);

		Component horizontalStrut_1 = Box.createHorizontalStrut(70);
		horizontalBox_1.add(horizontalStrut_1);

		textField_1 = new JTextField();
		textField_1.setMaximumSize(new Dimension(250, 20));
		horizontalBox_1.add(textField_1);
		textField_1.setColumns(10);

		Box horizontalBox_13 = Box.createHorizontalBox();
		horizontalBox_13.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(horizontalBox_13);
		
		Component horizontalStrut_13 = Box.createHorizontalStrut(70);
		horizontalBox_13.add(horizontalStrut_13);

		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setAlignmentX(0.5f);
		horizontalBox_13.add(lblLocation);

		Component horizontalStrut_2 = Box.createHorizontalStrut(94);
		horizontalBox_13.add(horizontalStrut_2);
		
		textField_2 = new JTextField();
		textField_2.setMaximumSize(new Dimension(250, 20));
		textField_2.setColumns(10);
		horizontalBox_13.add(textField_2);

		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(horizontalBox_2);
		
		Component horizontalStrut_14 = Box.createHorizontalStrut(70);
		horizontalBox_2.add(horizontalStrut_14);

		JLabel lblNewLabel_1 = new JLabel("Flavor:");
		horizontalBox_2.add(lblNewLabel_1);

		Component horizontalStrut_3 = Box.createHorizontalStrut(105);
		horizontalBox_2.add(horizontalStrut_3);

		 chckbxSweet = new JCheckBox("Sweet");
		horizontalBox_2.add(chckbxSweet);

		 chckbxSalty = new JCheckBox("Salty");
		horizontalBox_2.add(chckbxSalty);

		 chckbxSpicy = new JCheckBox("Spicy");
		horizontalBox_2.add(chckbxSpicy);

		chckbxSour = new JCheckBox("Sour");
		horizontalBox_2.add(chckbxSour);

		Box horizontalBox_3 = Box.createHorizontalBox();
		horizontalBox_3.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(horizontalBox_3);
		
		Component horizontalStrut_15 = Box.createHorizontalStrut(70);
		horizontalBox_3.add(horizontalStrut_15);

		JLabel lblNewLabel_2 = new JLabel("Servings:");
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalBox_3.add(lblNewLabel_2);

		Component horizontalStrut_7 = Box.createHorizontalStrut(93);
		horizontalBox_3.add(horizontalStrut_7);

		comboBox = new JComboBox();
		comboBox.setMaximumRowCount(4);
		comboBox.setMaximumSize(new Dimension(100, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		//comboBox.setSelectedIndex(3);
		horizontalBox_3.add(comboBox);

		Box horizontalBox_4 = Box.createHorizontalBox();
		horizontalBox_4.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(horizontalBox_4);
		
		Component horizontalStrut_16 = Box.createHorizontalStrut(70);
		horizontalBox_4.add(horizontalStrut_16);

		JLabel lblNewLabel_3 = new JLabel("Preparing time:");
		lblNewLabel_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalBox_4.add(lblNewLabel_3);

		Component horizontalStrut_4 = Box.createHorizontalStrut(55);
		horizontalBox_4.add(horizontalStrut_4);
		
		textField_3 = new JTextField();
		textField_3.setMaximumSize(new Dimension(250, 20));
		textField_3.setColumns(10);
		horizontalBox_4.add(textField_3);

		Box horizontalBox_5 = Box.createHorizontalBox();
		horizontalBox_5.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(horizontalBox_5);
		
		Component horizontalStrut_17 = Box.createHorizontalStrut(70);
		horizontalBox_5.add(horizontalStrut_17);

		JLabel lblNewLabel_4 = new JLabel("Cooking time:");
		lblNewLabel_4.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalBox_5.add(lblNewLabel_4);

		Component horizontalStrut_11 = Box.createHorizontalStrut(60);
		horizontalBox_5.add(horizontalStrut_11);
		
		textField_4 = new JTextField();
		textField_4.setMaximumSize(new Dimension(250, 20));
		textField_4.setColumns(10);
		horizontalBox_5.add(textField_4);

		Box horizontalBox_6 = Box.createHorizontalBox();
		horizontalBox_6.setAlignmentX(Component.LEFT_ALIGNMENT);
		horizontalBox_6.setMinimumSize(new Dimension(1, 50));
		contentPane.add(horizontalBox_6);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(70);
		horizontalBox_6.add(horizontalStrut_5);

		JLabel lblIngredients = new JLabel("Ingredients:");
		horizontalBox_6.add(lblIngredients);

		Component horizontalStrut = Box.createHorizontalStrut(74);
		horizontalBox_6.add(horizontalStrut);

		JPanel panel = new JPanel();
		horizontalBox_6.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

		Box horizontalBox_8 = Box.createHorizontalBox();
		horizontalBox_8.setAlignmentY(Component.CENTER_ALIGNMENT);
		horizontalBox_8.setMaximumSize(new Dimension(1000, 20));
		panel_2.add(horizontalBox_8);

		JLabel lblName = new JLabel("Name");
		horizontalBox_8.add(lblName);

		Component horizontalStrut_8 = Box.createHorizontalStrut(100);
		horizontalBox_8.add(horizontalStrut_8);

		JLabel lblQuantity = new JLabel("Quantity");
		horizontalBox_8.add(lblQuantity);
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		horizontalBox_8.add(horizontalGlue_5);

		JLabel lblUnit = new JLabel("Unit");
		horizontalBox_8.add(lblUnit);

		Component horizontalStrut_10 = Box.createHorizontalStrut(100);
		horizontalBox_8.add(horizontalStrut_10);

		JLabel lblDescription = new JLabel("Description");
		horizontalBox_8.add(lblDescription);

		
		
		
		
		/*horizontalBox_9 = Box.createHorizontalBox();
		panel_2.add(horizontalBox_9);

		JTextField textField_5 = new JTextField();
		textField_5.setMaximumSize(new Dimension(1000, 20));
		textField_5.setColumns(10);
		horizontalBox_9.add(textField_5);

		JTextField textField_6 = new JTextField();
		textField_6.setMaximumSize(new Dimension(1000, 20));
		textField_6.setColumns(10);
		horizontalBox_9.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setMaximumSize(new Dimension(1000, 20));
		textField_7.setColumns(10);
		horizontalBox_9.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setMaximumSize(new Dimension(1000, 20));
		textField_8.setColumns(10);
		horizontalBox_9.add(textField_8);
		*/

		Box horizontalBox_11 = Box.createHorizontalBox();
		horizontalBox_11.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(horizontalBox_11);

		JButton btnAdd = new JButton("Add");

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				box = Box.createHorizontalBox();
				ingredientBoxList.add(box);

				panel_2.add(box);

				for (int i = 1; i <= 4; i++) {
					tfield = new JTextField();
					tfield.setColumns(10);
					tfield.setMaximumSize(new Dimension(1000, 20));
					box.add(tfield);

					countIngredientText = countIngredientText + 1;
				}

				revalidate();
			}
		});
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalBox_11.add(horizontalGlue_1);

		horizontalBox_11.add(btnAdd);

		JButton btnDelete_2 = new JButton("Delete");

		horizontalBox_11.add(btnDelete_2);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox_11.add(horizontalGlue_2);
		btnDelete_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				if (panel_2.getComponents().length == 2) {
					JOptionPane.showMessageDialog(null, "You cannot delete this!");
				} else {
					System.out.println(ingredientBoxList.size());
					int number = ingredientBoxList.size();
					ingredientBoxList.removeLast();
					System.out.println(panel_2.getComponents().length);
					
					panel_2.remove(panel_2.getComponent(number));   //number +1
					
					countIngredientText = countIngredientText - 4;
					revalidate();
				}
			}
		});

		Box horizontalBox_7 = Box.createHorizontalBox();
		horizontalBox_7.setAlignmentX(Component.LEFT_ALIGNMENT);
		horizontalBox_7.setMinimumSize(new Dimension(10, 20));
		contentPane.add(horizontalBox_7);
		
		Component horizontalStrut_19 = Box.createHorizontalStrut(70);
		horizontalBox_7.add(horizontalStrut_19);

		JLabel lblSteps = new JLabel("Steps:");
		horizontalBox_7.add(lblSteps);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(110);
		horizontalBox_7.add(horizontalStrut_6);

		JPanel panel_1 = new JPanel();
		horizontalBox_7.add(panel_1);
		panel_1.setMaximumSize(new Dimension(1000, 100));
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);

		panel_3 = new JPanel();
		panel_3.setForeground(Color.WHITE);
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane_1.setViewportView(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

		horizontalBox_10 = Box.createHorizontalBox();
		panel_3.add(horizontalBox_10);
	


		
		
		/*
		textField_9 = new JTextField();
		horizontalBox_10.add(textField_9);
		textField_9.setMaximumSize(new Dimension(1000, 20));
		textField_9.setColumns(10);
		*/

		Box horizontalBox_12 = Box.createHorizontalBox();
		horizontalBox_12.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(horizontalBox_12);

		JButton btnAddAStep = new JButton("Add");
		btnAddAStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				box = Box.createHorizontalBox();
				tfield = new JTextField();
				countStepText++;
				tfield.setColumns(10);
				tfield.setMaximumSize(new Dimension(1000, 20));
				panel_3.add(box);
				box.add(tfield);
				stepList.add(tfield);
				System.out.println(stepList.size()+"step List");
				System.out.println(countStepText + "stepText");
				revalidate();
			}
		});
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalBox_12.add(horizontalGlue_3);
		horizontalBox_12.add(btnAddAStep);

		JButton deleteStepButton = new JButton("Delete");
		horizontalBox_12.add(deleteStepButton);
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalBox_12.add(horizontalGlue_4);
		deleteStepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				if (panel_3.getComponents().length == 1) {
					JOptionPane.showMessageDialog(null, "You cannot delete this!");
				} else {
					System.out.println(stepList.size());
					int number = stepList.size();
					stepList.removeLast();
					System.out.println(panel_3.getComponents().length);
					panel_3.remove(panel_3.getComponent(number));
					countStepText = countStepText - 1;
					revalidate();
				}
			}
		});

	}




}

