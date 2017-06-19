package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Business_Logic.CookBook;
import Business_Logic.Recipe;
import controller.Controller;

public class Stepgui extends View_Superclass {
	static Recipe recipe;
	static JPanel topPanel;

	static JPanel flavorPanel;
	static JPanel servingPanel;
	static JPanel prepareTimePanel;
	static JPanel cookTimePanel;
	static JPanel ingredientPanel;
	static JPanel ingredientsPanel;
	static JPanel stepPanel;
	static JPanel stepsPanel;
	static JPanel bottomPanel;
	static public JComboBox servingComboBox;
	static JLabel dishName;

	static public JLabel prepareTimeLabel;

	static JLabel step1;
	static JLabel step2;
	static JButton changeServings;

	static void createTopPanel() {
		JButton backButton = new JButton("BACK");
		JButton editButton = new JButton("EDIT");
		dishName = new JLabel("dish name");
		topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

		topPanel.add(backButton);
		topPanel.add(Box.createHorizontalGlue());
		topPanel.add(dishName);
		topPanel.add(Box.createHorizontalGlue());
		topPanel.add(editButton);
		// topPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

	}

	static void createFlavorPanel() {

		JLabel flavorLabel = new JLabel("Flavors:");
		// flavorLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

		flavorPanel = new JPanel();
		flavorPanel.setLayout(new BoxLayout(flavorPanel, BoxLayout.X_AXIS));
		flavorPanel.add(flavorLabel);
		flavorPanel.add(Box.createHorizontalStrut(75));

		flavorPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

	}

	static void createServingPanel() {
		String[] str = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		servingComboBox = new JComboBox(str);
		servingComboBox.setMaximumRowCount(4);
		servingComboBox.setMaximumSize(new Dimension(80, 20));
		JLabel servingLabel = new JLabel("Servings:");
		changeServings = new JButton("change");
		servingLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		servingPanel = new JPanel();
		servingPanel.setLayout(new BoxLayout(servingPanel, BoxLayout.X_AXIS));
		servingPanel.add(servingLabel);
		servingPanel.add(Box.createHorizontalStrut(70));
		servingPanel.add(servingComboBox);
		servingPanel.add(Box.createHorizontalStrut(70));
		servingPanel.add(changeServings);
		servingPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

	}

	static void createPrepareTimePanel() {
		JLabel prepareTimeLabel = new JLabel("Preparing time:");
		prepareTimeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

		prepareTimePanel = new JPanel();
		prepareTimePanel.setLayout(new BoxLayout(prepareTimePanel, BoxLayout.X_AXIS));
		prepareTimePanel.add(prepareTimeLabel);
		prepareTimePanel.add(Box.createHorizontalStrut(36));

		prepareTimePanel.setAlignmentX(Component.LEFT_ALIGNMENT);

	}

	static void createCookTimePanel() {
		JLabel cookTimeLabel = new JLabel("Cooking time:");
		cookTimeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

		cookTimePanel = new JPanel();
		cookTimePanel.setLayout(new BoxLayout(cookTimePanel, BoxLayout.X_AXIS));
		cookTimePanel.add(cookTimeLabel);
		cookTimePanel.add(Box.createHorizontalStrut(50));

		cookTimePanel.setAlignmentX(Component.LEFT_ALIGNMENT);

	}

	static void createIngredientPanel() {
		JLabel ingredientLabel = new JLabel("Ingredients:");
		ingredientLabel.setAlignmentY(Component.TOP_ALIGNMENT);

		ingredientLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

		ingredientPanel = new JPanel();
		ingredientPanel.setLayout(new BoxLayout(ingredientPanel, BoxLayout.X_AXIS));
		ingredientsPanel = new JPanel();
		ingredientsPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		ingredientsPanel.setLayout(new BoxLayout(ingredientsPanel, BoxLayout.Y_AXIS));

		ingredientPanel.add(ingredientLabel);
		ingredientPanel.add(Box.createHorizontalStrut(55));
		
		ingredientPanel.add(ingredientsPanel);
		ingredientPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

	}

	static void createStepPanel() {
		JLabel stepLabel = new JLabel("Steps:");
		stepLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		stepLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		stepPanel = new JPanel();
		stepPanel.setLayout(new BoxLayout(stepPanel, BoxLayout.X_AXIS));
		stepsPanel = new JPanel();
		stepsPanel.setLayout(new BoxLayout(stepsPanel, BoxLayout.Y_AXIS));
		stepsPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		stepPanel.add(stepLabel);
		stepPanel.add(Box.createHorizontalStrut(93));
		// stepPanel.add(step1);
		stepPanel.add(stepsPanel);
		stepPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
	}

	static void createBottomPanel() {
		JButton deleteButton = new JButton("DELETE");
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
		bottomPanel.add(Box.createHorizontalGlue());
		bottomPanel.add(deleteButton);
		bottomPanel.add(Box.createHorizontalGlue());

	}

	public static void main(String[] args) {

		createTopPanel();

		createFlavorPanel();
		createServingPanel();
		createPrepareTimePanel();
		createCookTimePanel();
		createIngredientPanel();
		createStepPanel();
		createBottomPanel();

		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		panel.add(topPanel);
		panel.add(Box.createVerticalStrut(20));
		panel.add(flavorPanel);
		panel.add(Box.createVerticalStrut(20));
		panel.add(servingPanel);
		panel.add(Box.createVerticalStrut(20));
		panel.add(prepareTimePanel);
		panel.add(Box.createVerticalStrut(20));
		panel.add(cookTimePanel);
		panel.add(Box.createVerticalStrut(20));
		panel.add(ingredientPanel);
		panel.add(Box.createVerticalStrut(20));
		panel.add(stepPanel);
		panel.add(Box.createVerticalStrut(20));
		panel.add(bottomPanel);

		JFrame frame = new JFrame();
		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				Controller controller = new Controller();
				try {
					recipe = controller.catchRecipe("Gong Bao Jiding");
					for (int i = 0; i < recipe.getTagList().size(); i++) {
						JLabel label = new JLabel();
						label.setFont(new Font("Arial", Font.BOLD, 12));

						label.setText(recipe.getTagList().get(i).getTagContent());
						if (recipe.getTagList().get(i).getTagContent() == "sweet") {
							label.setOpaque(true);
							label.setBorder(BorderFactory.createLineBorder(Color.green));
							label.setForeground(Color.white);
							label.setBackground(Color.green);
						}
						flavorPanel.add(label);
						flavorPanel.add(Box.createHorizontalStrut(15));

					}

					servingComboBox.setSelectedIndex(recipe.getServings() - 1);
					prepareTimeLabel = new JLabel();
					JLabel min = new JLabel("min");
					prepareTimeLabel.setText(Integer.toString(recipe.getPreparationTime()));
					prepareTimePanel.add(prepareTimeLabel);
					prepareTimePanel.add(Box.createHorizontalStrut(10));
					prepareTimePanel.add(min);
					System.out.println("11111111111111");

					JLabel cookTimeLabel = new JLabel();
					cookTimeLabel.setText(Integer.toString(recipe.getCookingTime()));
					cookTimePanel.add(cookTimeLabel);
					JLabel min2 = new JLabel("min");
					cookTimePanel.add(Box.createHorizontalStrut(10));
					cookTimePanel.add(min2);
					for (int i = 0; i < recipe.getIngredient().size(); i++) {
						JLabel label = new JLabel();

						label.setText(controller.getIngredientSentence(recipe.getDishName(), i));
						ingredientsPanel.add(label);
						ingredientsPanel.add(Box.createVerticalStrut(10));
						// label.setText(recipe.getIngredient().get(i).get);
					}
					for (int i = 0; i < recipe.getSteps().size(); i++) {
						JLabel label = new JLabel();
						label.setText(controller.getStepSentence(recipe.getDishName(), i));
						stepsPanel.add(label);
						stepsPanel.add(Box.createVerticalStrut(10));
					}
					frame.revalidate();

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		/**
		 * servingComboBox.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * 
		 *           try {
		 * 
		 *           int changedServing = servingComboBox.getSelectedIndex() +
		 *           1; Controller controller = new Controller();
		 * 
		 *           String recipeName = "Gong Bao Jiding";
		 * 
		 *           Recipe recipe = controller.catchRecipe(recipeName);
		 *           recipe.reviseServings(changedServing);
		 * 
		 *           prepareTimeLabel = new JLabel(); //
		 *           prepareTimeLabel.setText("111111"); // JLabel min = new
		 *           JLabel("min");
		 *           prepareTimeLabel.setText(Integer.toString(recipe.getPreparationTime()));
		 * 
		 *           prepareTimePanel.add(prepareTimeLabel); //
		 *           prepareTimePanel.add(Box.createHorizontalStrut(10)); //
		 *           prepareTimePanel.add(min);
		 *           System.out.println("2222222222222222222222"); JLabel
		 *           cookTimeLabel = new JLabel();
		 *           cookTimeLabel.setText(Integer.toString(recipe.getCookingTime()));
		 *           cookTimePanel.add(cookTimeLabel); // JLabel min2 = new
		 *           JLabel("min"); //
		 *           cookTimePanel.add(Box.createHorizontalStrut(10)); //
		 *           cookTimePanel.add(min2); // ingredientPanel.removeAll();
		 *           for (int i = 0; i < recipe.getIngredient().size(); i++) {
		 *           JLabel label = new JLabel();
		 * 
		 *           label.setText(controller.getIngredientSentence(recipe.getDishName(),
		 *           i)); ingredientsPanel.add(label); //
		 *           ingredientsPanel.add(Box.createVerticalStrut(10)); //
		 *           label.setText(recipe.getIngredient().get(i).get);
		 * 
		 *           frame.revalidate();
		 * 
		 *           }
		 * 
		 *           } catch (ClassNotFoundException e1) { // TODO
		 *           Auto-generated catch block e1.printStackTrace(); } catch
		 *           (SQLException e1) { // TODO Auto-generated catch block
		 *           e1.printStackTrace(); }
		 * 
		 *           } });
		 **/
		
		/**
		changeServings.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					System.out.println("111111111111111111111111");
					int changedServing = servingComboBox.getSelectedIndex() + 1;
					Controller controller = new Controller();

					String recipeName = "Gong Bao Jiding";

					Recipe recipe;

					recipe = controller.catchRecipe(recipeName);
					recipe.reviseServings(changedServing);

					prepareTimePanel.removeAll();
					JLabel prepareTimeLabel1 = new JLabel("Preparing time:");
					JLabel min = new JLabel("min");
					JLabel prepareTimeLabel = new JLabel();

					prepareTimeLabel1.setAlignmentX(Component.LEFT_ALIGNMENT);

					prepareTimePanel.setLayout(new BoxLayout(prepareTimePanel, BoxLayout.X_AXIS));
					prepareTimePanel.add(prepareTimeLabel1);

					prepareTimePanel.add(Box.createHorizontalStrut(36));

					prepareTimePanel.setAlignmentX(Component.LEFT_ALIGNMENT);

					prepareTimeLabel.setText(Integer.toString(recipe.getPreparationTime()));
					prepareTimePanel.add(prepareTimeLabel);
					prepareTimePanel.add(Box.createHorizontalStrut(10));
					prepareTimePanel.add(min);
					
					
					
					cookTimePanel.removeAll();
					JLabel cookTimeLabel = new JLabel("Cooking time:");
					cookTimeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

					//cookTimePanel = new JPanel();
					cookTimePanel.setLayout(new BoxLayout(cookTimePanel, BoxLayout.X_AXIS));
					cookTimePanel.add(cookTimeLabel);
					cookTimePanel.add(Box.createHorizontalStrut(50));

					cookTimePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
					JLabel cookTimeLabel1 = new JLabel();
					cookTimeLabel1.setText(Integer.toString(recipe.getCookingTime()));
					cookTimePanel.add(cookTimeLabel1);
					JLabel min2 = new JLabel("min");
					cookTimePanel.add(Box.createHorizontalStrut(10));
					cookTimePanel.add(min2);


					ingredientPanel.removeAll();
					ingredientsPanel.removeAll();
					
					JLabel ingredientLabel = new JLabel("Ingredients:");
					ingredientLabel.setAlignmentY(Component.TOP_ALIGNMENT);

					ingredientLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

					//ingredientPanel = new JPanel();
					ingredientPanel.setLayout(new BoxLayout(ingredientPanel, BoxLayout.X_AXIS));
					//ingredientsPanel = new JPanel();
					ingredientsPanel.setAlignmentY(Component.TOP_ALIGNMENT);
					ingredientsPanel.setLayout(new BoxLayout(ingredientsPanel, BoxLayout.Y_AXIS));

					ingredientPanel.add(ingredientLabel);
					ingredientPanel.add(Box.createHorizontalStrut(55));
					
					ingredientPanel.add(ingredientsPanel);
					ingredientPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
					
					for (int i = 0; i < recipe.getIngredient().size(); i++) {
						JLabel label = new JLabel();

						label.setText(controller.getInsideInredientSentence(recipe, i));
						ingredientsPanel.add(label);
						ingredientsPanel.add(Box.createVerticalStrut(10));
						// label.setText(recipe.getIngredient().get(i).get);
					}
					
					
					frame.revalidate();

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
**/
		
		changeServings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				prepareTimePanel.removeAll();
				createPrepareTimePanel();
				
				
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setOpaque(true);
		scrollPane.setOpaque(true);
		frame.setSize(new Dimension(768, 480));
		frame.setContentPane(scrollPane);
		frame.setVisible(true);
	}

}