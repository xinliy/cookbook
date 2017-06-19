package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.Controller;
import Business_Logic.Ingredient;
import Business_Logic.Recipe;
import Business_Logic.Tag;
import Business_Logic.DBConnector;
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
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class Create extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private int countIngredientText;
	private int countStepText;
	private int countBox;
	private Box box;
	private JTextField tfield;
	private String boxName;
	private String nameTField;
	private JTextField textField_16;
	private LinkedList<JTextField> ingredientTextField = new LinkedList<JTextField>();
	private LinkedList<Box> ingredientBoxList = new LinkedList<Box>();
	private LinkedList<JTextField> stepList = new LinkedList<JTextField>();
	DBConnector dbconnector;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create frame = new Create();
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
	public Create() {
		countStepText = 100;
		countIngredientText = 20;
		countBox = 20;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		contentPane.add(horizontalBox);

		JButton btnNewButton = new JButton("Back");
		horizontalBox.add(btnNewButton);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);

		JButton btnSave = new JButton("Save");
		horizontalBox.add(btnSave);

		Box horizontalBox_1 = Box.createHorizontalBox();
		contentPane.add(horizontalBox_1);

		JLabel lblNewLabel = new JLabel("Recipe name:");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalBox_1.add(lblNewLabel);

		Component horizontalStrut_1 = Box.createHorizontalStrut(30);
		horizontalBox_1.add(horizontalStrut_1);

		textField_1 = new JTextField();
		textField_1.setMaximumSize(new Dimension(200, 20));
		horizontalBox_1.add(textField_1);
		textField_1.setColumns(10);

		Box horizontalBox_13 = Box.createHorizontalBox();
		contentPane.add(horizontalBox_13);

		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setAlignmentX(0.5f);
		horizontalBox_13.add(lblLocation);

		Component horizontalStrut_2 = Box.createHorizontalStrut(30);
		horizontalBox_13.add(horizontalStrut_2);

		textField_2 = new JTextField();
		textField_2.setMaximumSize(new Dimension(200, 20));
		textField_2.setColumns(10);
		horizontalBox_13.add(textField_2);

		Box horizontalBox_2 = Box.createHorizontalBox();
		contentPane.add(horizontalBox_2);

		JLabel lblNewLabel_1 = new JLabel("Flavor:");
		horizontalBox_2.add(lblNewLabel_1);

		Component horizontalStrut_3 = Box.createHorizontalStrut(30);
		horizontalBox_2.add(horizontalStrut_3);

		JCheckBox chckbxSpicy = new JCheckBox("Sweet");
		horizontalBox_2.add(chckbxSpicy);

		JCheckBox chckbxSalty = new JCheckBox("Salty");
		horizontalBox_2.add(chckbxSalty);

		JCheckBox chckbxSweet = new JCheckBox("Spicy");
		horizontalBox_2.add(chckbxSweet);

		JCheckBox chckbxSour = new JCheckBox("Sour");
		horizontalBox_2.add(chckbxSour);

		Box horizontalBox_3 = Box.createHorizontalBox();
		contentPane.add(horizontalBox_3);

		JLabel lblNewLabel_2 = new JLabel("Servings:");
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalBox_3.add(lblNewLabel_2);

		Component horizontalStrut_7 = Box.createHorizontalStrut(30);
		horizontalBox_3.add(horizontalStrut_7);

		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(4);
		comboBox.setMaximumSize(new Dimension(100, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		horizontalBox_3.add(comboBox);

		Box horizontalBox_4 = Box.createHorizontalBox();
		contentPane.add(horizontalBox_4);

		JLabel lblNewLabel_3 = new JLabel("Prepare time:");
		lblNewLabel_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalBox_4.add(lblNewLabel_3);

		Component horizontalStrut_4 = Box.createHorizontalStrut(30);
		horizontalBox_4.add(horizontalStrut_4);

		JTextField textField_3 = new JTextField();
		textField_3.setMaximumSize(new Dimension(200, 20));

		horizontalBox_4.add(textField_3);
		textField_3.setColumns(10);

		Box horizontalBox_5 = Box.createHorizontalBox();
		contentPane.add(horizontalBox_5);

		JLabel lblNewLabel_4 = new JLabel("Cooking time:");
		lblNewLabel_4.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalBox_5.add(lblNewLabel_4);

		Component horizontalStrut_11 = Box.createHorizontalStrut(30);
		horizontalBox_5.add(horizontalStrut_11);

		JTextField textField_4 = new JTextField();
		textField_4.setMaximumSize(new Dimension(200, 20));

		horizontalBox_5.add(textField_4);
		textField_4.setColumns(10);

		Box horizontalBox_6 = Box.createHorizontalBox();
		horizontalBox_6.setMinimumSize(new Dimension(1, 50));
		contentPane.add(horizontalBox_6);

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		horizontalBox_6.add(horizontalStrut_5);

		JLabel lblIngredients = new JLabel("Ingredients:");
		horizontalBox_6.add(lblIngredients);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalBox_6.add(horizontalStrut);

		JPanel panel = new JPanel();
		horizontalBox_6.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

		Box horizontalBox_8 = Box.createHorizontalBox();
		horizontalBox_8.setAlignmentY(Component.CENTER_ALIGNMENT);
		horizontalBox_8.setMaximumSize(new Dimension(1000, 20));
		panel_2.add(horizontalBox_8);

		JLabel lblName = new JLabel("Name       ");
		horizontalBox_8.add(lblName);

		Component horizontalStrut_8 = Box.createHorizontalStrut(100);
		horizontalBox_8.add(horizontalStrut_8);

		JLabel lblQuantity = new JLabel("Quantity   ");
		horizontalBox_8.add(lblQuantity);

		Component horizontalStrut_9 = Box.createHorizontalStrut(100);
		horizontalBox_8.add(horizontalStrut_9);

		JLabel lblUnit = new JLabel("Unit       ");
		horizontalBox_8.add(lblUnit);

		Component horizontalStrut_10 = Box.createHorizontalStrut(100);
		horizontalBox_8.add(horizontalStrut_10);

		JLabel lblDescription = new JLabel("Description");
		horizontalBox_8.add(lblDescription);

		Box horizontalBox_9 = Box.createHorizontalBox();
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

		Box horizontalBox_11 = Box.createHorizontalBox();
		contentPane.add(horizontalBox_11);

	
		
		// ingredient add
		
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
					ingredientTextField.add(tfield);
					countIngredientText = countIngredientText + 1;
				}

				revalidate();
			}
		});

		horizontalBox_11.add(btnAdd);

		
		
		
		
		JButton btnDelete_2 = new JButton("Delete");

		horizontalBox_11.add(btnDelete_2);
		btnDelete_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				if (panel_2.getComponents().length == 2) {
					JOptionPane.showMessageDialog(null, "You cannot delete this!");
				} else {
					System.out.println(ingredientBoxList.size()  + "  delete ingrdientBoxList 329 ");
					int number = ingredientBoxList.size();
					ingredientBoxList.removeLast();
					System.out.println(panel_2.getComponents().length  +  " panel_2   332");
					panel_2.remove(panel_2.getComponent(number + 1));
					countIngredientText = countIngredientText - 4;
					for(int i =0; i<4;i++){
					ingredientTextField.removeLast();
					}
					revalidate();
				}
			}
		});

		Box horizontalBox_7 = Box.createHorizontalBox();
		horizontalBox_7.setMinimumSize(new Dimension(10, 20));
		contentPane.add(horizontalBox_7);

		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		horizontalBox_7.add(horizontalStrut_6);

		JLabel lblSteps = new JLabel("Steps:");
		horizontalBox_7.add(lblSteps);

		JPanel panel_1 = new JPanel();
		horizontalBox_7.add(panel_1);
		panel_1.setMaximumSize(new Dimension(1000, 100));
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);

		JPanel panel_3 = new JPanel();
		scrollPane_1.setViewportView(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

		Box horizontalBox_10 = Box.createHorizontalBox();
		panel_3.add(horizontalBox_10);

		textField_9 = new JTextField();
		horizontalBox_10.add(textField_9);
		textField_9.setMaximumSize(new Dimension(1000, 20));
		textField_9.setColumns(10);

		Box horizontalBox_12 = Box.createHorizontalBox();
		contentPane.add(horizontalBox_12);

		
		
		
		// step add
		
		
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
				
				revalidate();
			}
		});
		horizontalBox_12.add(btnAddAStep);

		JButton deleteStepButton = new JButton("Delete");
		horizontalBox_12.add(deleteStepButton);
		deleteStepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				if (panel_3.getComponents().length == 1) {
					JOptionPane.showMessageDialog(null, "You cannot delete this!");
				} else {
					System.out.println(stepList.size() + "deleteStep 407");
					int number = stepList.size();
					stepList.removeLast();
					System.out.println(panel_3.getComponents().length   +   "panel_3 of length 410");
					panel_3.remove(panel_3.getComponent(number));
					countStepText = countStepText - 1;

					revalidate();
				}
			}
		});


		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
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

				// contentPane.removeAll();

				Controller controller = new Controller();
				try {
					recipeId = controller.createRecipeId();
					dishName = textField_1.getText();
					location = textField_2.getText();
					// servings = comboBox.getSelectedItem();
					servings = comboBox.getSelectedIndex() + 1;
					Recipe recipe2 = new Recipe(recipeId, dishName, location, servings);
					preparationTime = Integer.parseInt(textField_3.getText());
					cookingTime = Integer.parseInt(textField_4.getText());
					recipe2.setPreparationTime(preparationTime);
					recipe2.setCookingTime(cookingTime);
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
					
					recipe2.addIngredient(new Ingredient(textField_5.getText(),
							Double.parseDouble(textField_6.getText()), textField_7.getText(), textField_8.getText()));
;

					if (countIngredientText == 20) {

					} else {
						int counter = (countIngredientText - 20) / 4;// how much
																		// 4
						System.out.println(ingredientTextField.size()+"  ingredient Textfield479  ");
						System.out.println(countIngredientText  + " countIngredientText  480");
						for (int n = 0; n < counter; n++) {
							if(ingredientTextField.get(3 + (n) * 4).getText().equals("")){
								recipe2.addIngredient(new Ingredient(ingredientTextField.get((n) * 4).getText(),
										Integer.parseInt(ingredientTextField.get(1 + (n) * 4).getText()),
										ingredientTextField.get(2 + (n) * 4).getText()));
										
							}else{
								recipe2.addIngredient(new Ingredient(ingredientTextField.get((n) * 4).getText(),
										Integer.parseInt(ingredientTextField.get(1 + (n) * 4).getText()),
										ingredientTextField.get(2 + (n) * 4).getText(),
										ingredientTextField.get(3 + (n) * 4).getText()));
							}

						}
					}
					recipe2.addPreparationStep(textField_9.getText());
//					recipe2.addPreparationStep(textField_12.getText());
//					recipe2.addPreparationStep(textField_13.getText());
//					recipe2.addPreparationStep(textField_14.getText());
//					recipe2.addPreparationStep(textField_15.getText());
					if (countStepText == 100) {

					} else {
						int counter = countStepText - 100;
						for (int n = 0; n < counter; n++) {
							recipe2.addPreparationStep(stepList.get(n).getText());
						}
					}
					controller.returnRecipe(recipe2);
					revalidate();
					// recipe.addIngredient(new Ingredient());

					// for(int countIngredientText =20; countIngred)
					// String value = comboBox.getSelectedItem().toString();
					// location =

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "error");
				}

				finally {

				}
				// tex1
			}

		});
	}

}
