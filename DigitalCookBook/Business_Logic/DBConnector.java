import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

/**
 * the connector to connect the java code to database
 * 
 * @author Zhang Xiaoyue
 * @version 1.0
 */
public class DBConnector {

	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public void getAccess() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		// Setup the connection with the DB
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cookbook", "root", "");
		statement = connection.createStatement();

	}

	public void deleteIngredient(String ingredientName) throws ClassNotFoundException, SQLException {
		getAccess();

		preparedStatement = connection
				.prepareStatement("delete from ingredient where ingredientName = '" + ingredientName + "';");

		preparedStatement.executeUpdate();
		close();
	}

	public void deleteStep(int recipeId, int step) throws ClassNotFoundException, SQLException {
		getAccess();

		String sql = "delete from preparation_step where recipeId = ? and step = ? ";

		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, recipeId);
		preparedStatement.setInt(2, step);
		preparedStatement.executeUpdate();
		close();
	}

	public void insertIntoTag(int tagId, String tagContent) throws SQLException, ClassNotFoundException {

		getAccess();
		preparedStatement = connection.prepareStatement("insert into tag(tagId,tagContent) values (?,?)");
		preparedStatement.setInt(1, tagId);
		preparedStatement.setString(2, tagContent);
		preparedStatement.executeUpdate();
		close();
	}



	public void printTable(String tableName) throws SQLException, ClassNotFoundException {
		getAccess();
		resultSet = statement.executeQuery("select * from " + tableName);

		if (tableName.equals("tag")) {
			while (resultSet.next()) {

				try {
					int tagID = resultSet.getInt("tagID");
					String tagContent = resultSet.getString("tagContent");

					System.out.println("tagID: " + tagID);
					System.out.println("tagContent: " + tagContent);
				} catch (Exception e) {

				}

			}
		} else if (tableName.equals("recipe")) {
			while (resultSet.next()) {
				try {

					int recipeId = resultSet.getInt("recipeId");
					String dishName = resultSet.getString("dishName");
					int servings = resultSet.getInt("servings");
					int preparationTime = resultSet.getInt("preparationTime");
					int cookingTime = resultSet.getInt("cookingTime");

					System.out.println("recipeID: " + recipeId);
					System.out.println("dishName: " + dishName);
					System.out.println("servings: " + servings);
					System.out.println("preparationTime: " + preparationTime);
					System.out.println("cookingTime: " + cookingTime);

				} catch (Exception e) {

				}

			}
		} else if (tableName.equals("preparation_step")) {
			while (resultSet.next()) {
				try {

					int recipeID = resultSet.getInt("recipeId");
					int step = resultSet.getInt("step");
					String description = resultSet.getString("description");

					System.out.println("recipeID: " + recipeID);
					System.out.println("step: " + step);
					System.out.println("description: " + description);

				} catch (Exception e) {

				}
			}

		} else if (tableName.equals("ingredient")) {
			while (resultSet.next()) {
				try {
					int recipeId = resultSet.getInt("recipeId");
					String ingredientName = resultSet.getString("ingredientName");
					int quantity = resultSet.getInt("quantity");
					String unit = resultSet.getString("unit");
					String description = resultSet.getString("description");

					System.out.println("recipeId: " + recipeId);
					System.out.println("ingredientName: " + ingredientName);
					System.out.println("quantity: " + quantity);
					System.out.println("unit: " + unit);
					System.out.println("description: " + description);
				} catch (Exception e) {
				}
			}
			close();
		}

	}

	public void getColumnName(String tableName) throws SQLException, ClassNotFoundException {

		getAccess();
		resultSet = statement.executeQuery("select * from " + tableName);
		System.out.println("The columns are:");

		System.out.println("Table:" + resultSet.getMetaData().getTableName(1));
		for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
			System.out.println("Column " + i + " :" + resultSet.getMetaData().getColumnName(i));

		}
		close();

	}

	public void addRecipe(Recipe r) throws ClassNotFoundException, SQLException {
		getAccess();

		statement
				.executeUpdate("INSERT INTO recipe (recipeId, dishName, servings, preparationTime, cookingTime) VALUES("
						+ r.getRecipeId() + ",'" + r.getDishName() + "', " + r.getServings() + ", " + r.getCookingTime()
						+ ", " + r.getPreparationTime() + ")");

		close();

	}

	public void addTag(Tag t) throws SQLException, ClassNotFoundException {
		getAccess();

		statement.executeUpdate(
				"INSERT INTO tag (tagId, tagContent) VALUES(" + t.getTagId() + ",'" + t.getTagContent() + "')");

		close();
	}

	public void addPreparationStep(Recipe r) throws ClassNotFoundException {
		try {
			getAccess();
			LinkedList<String> steps = r.getSteps();

		
			for (int j = 0; j < steps.size(); j++) {
				statement.executeUpdate("INSERT INTO preparation_step(recipeId,step, description) VALUES("
						+ r.getRecipeId() + "," + (j + 1) + ", " + "'" + steps.get(j) + "')");
				
			}

			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addRecipeIngredient(Recipe r) throws SQLException, ClassNotFoundException {
		getAccess();

		LinkedList<Ingredient> ingredient = r.getIngredient();

		for (int i = 0; i < ingredient.size(); i++) {
			String query = "SELECT * from ingredients where ingredientName = " + "'"+ingredient.get(i).getIngredientName()+"'";
			resultSet =statement.executeQuery(query);
			resultSet.next();
			int id = resultSet.getInt("ingredientId");
			statement.executeUpdate(
					"INSERT INTO recipe_has_ingredients (recipe_recipeId, ingredients_ingredientId, quantity, unit, description) VALUES("
							+ r.getRecipeId() + ",'" + id + "', "
							+ ingredient.get(i).getQuantity() + ", " + "'" + ingredient.get(i).getUnit() + "'," + "'"
							+ ingredient.get(i).getDescription() + "')");

			
		}
		close();

	}
	
	

	public void addIngredients(Recipe r) throws SQLException, ClassNotFoundException {
		getAccess();

		LinkedList<Ingredient> ingredient = r.getIngredient();
		statement.executeUpdate("alter table ingredients auto_increment = 1" );
		for (int i = 0; i < ingredient.size(); i++) {
			
			statement.executeUpdate( "INSERT INTO ingredients (ingredientName) VALUES(" 
					 + "'" + ingredient.get(i).getIngredientName() + "' ) " );

			
		}
	close();	

	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();

			}

			if (statement != null) {
				statement.close();

			}

			if (connection != null) {
				connection.close();

			}
		} catch (Exception e) {
		}
	}

}
