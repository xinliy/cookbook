
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.ComboBoxEditor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Stepgui {
	private static JTable table;
	private static JTable table1;
	private static JTextField textField;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Steps");
		frame.setSize(768, 480);
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dim = tool.getScreenSize();
		int width = (int) dim.getWidth();
		int height = (int) dim.getHeight();

		frame.setLocation((width - 768) / 2, (height - 480) / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);

		placeComponents(panel);

		

		

		JTextArea textArea = new JTextArea();
		textArea.setBounds(117, 88, 80, 19);
		panel.add(textArea);
		/*
		JScrollPane jScrollPane = new JScrollPane(textArea);
		jScrollPane.setBounds(117, 88, 80, 19);
	
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frame.add(jScrollPane);
**/
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(208, 16, 225, 29);
		panel.add(textArea_1);

		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(117, 115, 80, 19);
		panel.add(textArea_2);

		JButton btnShow = new JButton("Show");
		btnShow.setBounds(15, 409, 93, 23);
		panel.add(btnShow);

		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(15, 362, 80, 19);
		panel.add(textArea_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(352, 55, 141, 79);
		panel.add(panel_1);
		
		textField = new JTextField();
		panel_1.setLayout(new FlowLayout());
		panel_1.add(textField);
		textField.setColumns(10);
		
		
		
		JScrollPane scrollPane = new JScrollPane(textField);
		
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel_1.add(scrollPane);
		
		
		
		

		frame.setVisible(true);

		btnShow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controller controller = new Controller();
				try {
					String recipeName = "Suan La Fen";
					Recipe targetRecipe = controller.catchRecipe(recipeName);
					int ingredientNumber = controller.getIngredientNumbaer(recipeName);
					int stepNumber = controller.getStepNumber(recipeName);
					textArea.append(String.valueOf(targetRecipe.getPreparationTime()));
					textArea_1.append(targetRecipe.getDishName());
					textArea_2.append(String.valueOf(targetRecipe.getCookingTime()));

					textArea_3.append("STEP:");
					textArea_3.setBounds(20, 250, 80, 19);
					//textArea_3.setBounds(20, 180 + 16 * ingredientNumber, 80, 19);
					textArea_3.setBackground(new Color(238, 238, 238));

					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("ingredient");

					for (int i = 0; i < ingredientNumber; i++) {

						model.addRow(new Object[] { controller.getIngredientSentence(recipeName, i) });
					}

					table = new JTable(model);
					 //table.setBounds(15, 175, 483, 16 * ingredientNumber);
					table.setBounds(15, 175, 483, 50);
					table.setShowGrid(false);
					
					JScrollPane tableScrollPane = new JScrollPane(table);
					tableScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
					tableScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
					
					panel.add(table);

					panel.add(tableScrollPane);
					
					
					
					DefaultTableModel model1 = new DefaultTableModel();
					model1.addColumn("steps");

					for (int i = 0; i < stepNumber; i++) {

						model1.addRow(new Object[] { controller.getStepSentence(recipeName, i) });
					}

					table1 = new JTable(model1);
					 //table.setBounds(15, 175, 483, 16 * ingredientNumber);
					table1.setBounds(15, 275, 483, 50);
					table1.setShowGrid(false);
					panel.add(table1);



					frame.revalidate();

				} catch (ClassNotFoundException e1) {

					e1.printStackTrace();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}

		});

	}

	private static void placeComponents(JPanel panel) {
		/**
		 * 
		 */

		panel.setLayout(null);
		JLabel prepareTime = new JLabel("Preparing time:");
		prepareTime.setBounds(15, 80, 200, 25);
		panel.add(prepareTime);

		JLabel cookTime = new JLabel("Cooking time:");
		cookTime.setBounds(15, 110, 80, 25);
		panel.add(cookTime);
		JLabel ingredients = new JLabel("Ingredients:");
		ingredients.setBounds(15, 140, 200, 25);
		panel.add(ingredients);

		/**
		 * JLabel steps = new JLabel("Steps:"); steps.setBounds(15, 250, 200,
		 * 25); panel.add(steps);
		 **/

		JLabel serve = new JLabel("Servings:");
		serve.setBounds(550, 50, 100, 25);

		panel.add(serve);
		String[] number = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

		JComboBox serving = new JComboBox(number);
		serving.setEditable(true);
		ComboBoxEditor editor = serving.getEditor();
		serving.configureEditor(editor, serving);
		serving.setBounds(610, 50, 60, 25);
		panel.add(serving);

		JButton editButton = new JButton("EDIT");
		editButton.setBounds(670, 10, 80, 40);
		editButton.setBackground(new Color(22, 106, 255));
		panel.add(editButton);

		JButton backButton = new JButton("BACK");
		backButton.setBounds(18, 10, 80, 40);
		panel.add(backButton);

		JButton deleteButton = new JButton("DELETE");
		deleteButton.setBounds(550, 400, 110, 40);
		deleteButton.setBackground(new Color(197, 0, 0));
		panel.add(deleteButton);

	}
}
