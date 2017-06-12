import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.naming.directory.SearchControls;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import com.sun.media.jfxmedia.events.NewFrameEvent;

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

	private Recipe recipe;
	private LinkedList<Recipe> recipeList;
	
	
	public DBConnector() {
		this.recipeList=new LinkedList<>();
	}
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

		} else if (tableName.equals("recipe_has_ingredients")) {
			while (resultSet.next()) {
				try {
					int recipeId = resultSet.getInt("recipeId");
					int ingredientId = resultSet.getInt("ingredientId");
					int quantity = resultSet.getInt("quantity");
					String unit = resultSet.getString("unit");
					String description = resultSet.getString("description");

					System.out.println("recipeId: " + recipeId);
					System.out.println("ingredientName: " + ingredientId);
					System.out.println("quantity: " + quantity);
					System.out.println("unit: " + unit);
					System.out.println("description: " + description);
				} catch (Exception e) {
				}
			}

		} else if (tableName.equals("ingredients")) {
			while (resultSet.next()) {
				try {
					int ingredientId = resultSet.getInt("ingredientId");
					String ingredientName = resultSet.getString("ingredientName");

					System.out.println("ingredientId: " + ingredientId);
					System.out.println("ingredientName: " + ingredientName);

				} catch (Exception e) {
				}
			}
		} else if (tableName.equals("recipe_has_tag")) {
			while (resultSet.next()) {
				try {
					int recipeId = resultSet.getInt("recipe_recipeId");
					int tagId = resultSet.getInt("tag_tagId");

					System.out.println("recipeId: " + recipeId);
					System.out.println("tagId: " + tagId);
				} catch (Exception e) {

				}
			}

		}
		close();
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

		statement.executeUpdate(
				"INSERT INTO recipe (recipeId, dishName, location,servings, preparationTime, cookingTime) VALUES("
						+ r.getRecipeId() + ",'" + r.getDishName() + "', '" + r.getLocation() + "'," + r.getServings()
						+ ", " + r.getCookingTime() + ", " + r.getPreparationTime() + ")");

		close();

	}

	public void addTag(Recipe recipe) throws SQLException, ClassNotFoundException {
		getAccess();

		LinkedList<Tag> tags = recipe.getTagList();
		statement.executeUpdate("ALTER TABLE tag auto_increment =1");

		for (int i = 0; i < tags.size(); i++) {
			String query = "SELECT * from tag where tagContent = " + "'" + tags.get(i).getTagContent() + "'";
			resultSet = statement.executeQuery(query);

			try {
				statement.executeUpdate(
						"INSERT INTO tag (tagContent) VALUES(" + "'" + tags.get(i).getTagContent() + "' ) ");
			} catch (SQLException exception) {

			}

		}

		close();
	}

	public void addPreparationStep(Recipe recipe) throws ClassNotFoundException {
		try {
			getAccess();
			LinkedList<String> steps = recipe.getSteps();

			for (int j = 0; j < steps.size(); j++) {
				statement.executeUpdate("INSERT INTO preparation_step(recipeId,step, description) VALUES("
						+ recipe.getRecipeId() + "," + (j + 1) + ", " + "'" + steps.get(j) + "')");

			}

			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addRecipeTag(Recipe recipe) throws SQLException, ClassNotFoundException {
		getAccess();

		LinkedList<Tag> tag = recipe.getTagList();

		for (int i = 0; i < tag.size(); i++) {
			String query = "SELECT * from tag where tagContent = " + "'" + tag.get(i).getTagContent() + "'";
			resultSet = statement.executeQuery(query);
			resultSet.next();
			int id = resultSet.getInt("tagId");
			statement.executeUpdate("INSERT INTO recipe_has_tag (recipe_recipeId, tag_tagId) VALUES("
					+ recipe.getRecipeId() + ",'" + id + "' " + ")");

		}
		close();

	}

	public void addRecipeIngredient(Recipe recipe) throws SQLException, ClassNotFoundException {
		getAccess();

		LinkedList<Ingredient> ingredient = recipe.getIngredient();

		for (int i = 0; i < ingredient.size(); i++) {
			String query = "SELECT * from ingredients where ingredientName = " + "'"
					+ ingredient.get(i).getIngredientName() + "'";
			resultSet = statement.executeQuery(query);
			resultSet.next();
			int id = resultSet.getInt("ingredientId");
			statement.executeUpdate(
					"INSERT INTO recipe_has_ingredients (recipe_recipeId, ingredients_ingredientId, quantity, unit, description) VALUES("
							+ recipe.getRecipeId() + ",'" + id + "', " + ingredient.get(i).getQuantity() + ", " + "'"
							+ ingredient.get(i).getUnit() + "'," + "'" + ingredient.get(i).getDescription() + "')");

		}
		close();

	}

	public void addIngredients(Recipe recipe) throws SQLException, ClassNotFoundException {
		getAccess();

		LinkedList<Ingredient> ingredient = recipe.getIngredient();
		statement.executeUpdate("alter table ingredients auto_increment = 1");
		for (int i = 0; i < ingredient.size(); i++) {
			try {
				statement.executeUpdate("INSERT INTO ingredients (ingredientName) VALUES(" + "'"
						+ ingredient.get(i).getIngredientName() + "' ) ");
			} catch (SQLException e) {

			}

		}
		close();

	}

	public LinkedList<Recipe> search(String input, String tagContent) throws SQLException, ClassNotFoundException {

		getAccess();

		String searchRecipe = " select DISTINCT t1.dishName from recipe as t1, tag as t2 where t1.dishName = '" + input
				+ "' and t2.tagContent = '" + tagContent + "'";
		String searchIngredient = "select DISTINCT t1.recipe_recipeId from recipe_has_ingredients as t1, ingredients as t2 where t1.ingredients_ingredientId = t2.ingredientId and t2.ingredientName = '"
				+ input + "'"
				+ "and t1.recipe_recipeId IN (select t3.recipe_recipeId  from recipe_has_tag as t3, tag as t4 where t3.tag_tagId = t4.tagId and t4.tagContent = '"
				+ tagContent + "')";
		resultSet = statement.executeQuery(searchRecipe);
		if (!resultSet.next()) {
			System.out.println("Not a recipe!");

		} else {
			resultSet.beforeFirst();
			while (resultSet.next()) {
				String searchResult = resultSet.getString("dishName");
				recipeList.add(selectRecipeByName(searchResult));
				//System.out.println(searchResult);

			}

		}

		resultSet = statement.executeQuery(searchIngredient);
		if (!resultSet.next()) {
			System.out.println("Not a ingredient!");
		} else {
			resultSet.beforeFirst();
			while (resultSet.next()) {
				int searchResult = resultSet.getInt("recipe_recipeId");
				String sql = "SELECT DISTINCT dishname from recipe, recipe_has_ingredients where recipe.recipeId= recipe_has_ingredients.recipe_recipeId and recipe_recipeId =  "+searchResult;
				ResultSet resultSet1 = statement.executeQuery(sql);
				while(resultSet1.next()){
					String dishName = resultSet1.getString("dishName");
					recipeList.add(selectRecipeByName(dishName));
				}
				
				//System.out.println(searchResult);

			}

		}
		close();
		return recipeList;
	}

	public Recipe selectRecipeByName(String recipeName) throws ClassNotFoundException, SQLException {
		getAccess();
		Integer recipeId;
		String dishName;
		String location;
		Integer servings;
		Integer preparationTime;
		Integer cookingTime;

		String ingredientName;
		Integer quantity;
		String unit;
		String description;

		Integer step;

		String tagContent;

		String sql = "SELECT * from recipe where recipe.dishName = " + "'" + recipeName + "'";
		resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			recipeId = resultSet.getInt("recipeId");
			dishName = resultSet.getString("dishName");
			location = resultSet.getString("location");
			servings = resultSet.getInt("servings");
			preparationTime = resultSet.getInt("preparationTime");
			cookingTime = resultSet.getInt("cookingTime");
			recipe = new Recipe(recipeId, dishName, location, servings);
			recipe.setPreparationTime(preparationTime);
			recipe.setCookingTime(cookingTime);
		}

		String sql1 = "SELECT ingredientId, ingredientName, quantity, unit,description from recipe as t1, recipe_has_ingredients as t2, ingredients as t3 "
				+ "where t1.dishName = " + "'" + recipeName + "'"
				+ " and t1.recipeId = t2.recipe_recipeId and t2.ingredients_ingredientId = t3.ingredientId";
		resultSet = statement.executeQuery(sql1);
		while (resultSet.next()) {
			ingredientName = resultSet.getString("ingredientName");
			quantity = resultSet.getInt("quantity");
			unit = resultSet.getString("unit");
			description = resultSet.getString("description");
			if (description.equals(null)) {
				recipe.addIngredient(new Ingredient(ingredientName, quantity, unit));
			} else {
				recipe.addIngredient(new Ingredient(ingredientName, quantity, unit, description));
			}

		}

		String sql2 = "SELECT step, description from recipe, preparation_step where recipe.recipeId = preparation_step.recipeId and recipe.dishName = "
				+ "'" + recipeName + "'";
		resultSet = statement.executeQuery(sql2);
		while (resultSet.next()) {
			step = resultSet.getInt("step");
			description = resultSet.getString("description");
			recipe.addPreparationStep(description);
		}
		
		
		String sql3 = "SELECT tagContent from recipe as t1, recipe_has_tag as t2, tag as t3 " + "where t1.dishName="
				+ "'" + recipeName + "'" + " and t1.recipeId=t2.recipe_recipeId and t2.tag_tagId= t3.tagId";
		resultSet = statement.executeQuery(sql3);
		while (resultSet.next()) {
			tagContent = resultSet.getString("tagContent");
			recipe.addTag(new Tag(tagContent));

		}
		
		return recipe;

	}
	
	public void updateServings(String recipeName,int newServings) throws ClassNotFoundException, SQLException{
		
		recipe= selectRecipeByName(recipeName);
		int originServings = recipe.getServings();
		System.out.println(originServings);
		float times = (float)newServings/originServings;
		System.out.println(times);
		String updateServingsTime = "Update recipe set recipe.preparationTime = "+times+"*recipe.preparationTime , "
				+ "recipe.cookingTime = "+times+"*recipe.cookingTime, recipe.servings = "+"'"+newServings+"'"+" where recipe.dishName = "+"'"+recipeName+"'";
		statement.executeUpdate(updateServingsTime);
		
		String updateServingQuantity = "Update recipe_has_ingredients inner join recipe on recipe.recipeId = recipe_has_ingredients.recipe_recipeId "
				+ "set quantity= "+times+"*quantity where recipe.dishName ="+"'"+recipeName+"'";
		statement.executeUpdate(updateServingQuantity);
		
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
