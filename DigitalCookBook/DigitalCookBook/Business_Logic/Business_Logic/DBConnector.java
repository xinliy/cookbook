package Business_Logic;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;



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
	
	
	//delete
	public void deleteRecipe(String dishname) throws SQLException, ClassNotFoundException{
		getAccess();
		preparedStatement =connection.prepareStatement("delete from recipe where dishName = '" + dishname + "';");
		preparedStatement.executeUpdate();
		close();
	}
	
	
	
	public void deleteTag(String tagContent) throws ClassNotFoundException, SQLException{
		getAccess();
		preparedStatement =connection.prepareStatement("delete from tag where tagContent= '" + tagContent + "';");
		preparedStatement.executeUpdate();
		close();
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

	
	
	
	// insert
	



	
	
//print
	
	
	
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

	
	
	
	// getColumnName
	
	
	
	
	
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

	
	
	
	// add
	
	
	 
	
	public void addRecipe(Recipe r) throws ClassNotFoundException, SQLException {
		getAccess();

		statement
				.executeUpdate("INSERT INTO recipe (recipeId, dishName,location, servings, preparationTime, cookingTime) VALUES("
						+ r.getRecipeId() + ",'" + r.getDishName() + "', " +"'"+ r.getLocation()+"',"+ r.getServings() + ", " + r.getPreparationTime()
						+ ", " + r.getCookingTime() + ")");

		close();

	}

	public void addTag(Recipe r) throws SQLException, ClassNotFoundException {
		getAccess();
		
		LinkedList<Tag>tags = r.getTagList();
		statement.executeUpdate("ALTER TABLE tag auto_increment =1");
		System.out.println("111111111111111");
		
		for(int i =0; i<tags.size();i++){
			String query = "SELECT * from tag where tagContent = "+ "'" + tags.get(i).getTagContent() +"'";
			resultSet= statement.executeQuery(query);
			System.out.println("22222222222");
			
			
			try{
				statement.executeUpdate( "INSERT INTO tag (tagContent) VALUES(" 
					 + "'" + tags.get(i).getTagContent() + "' ) " );
			}catch(SQLException exception){
				System.out.println("5555555555");
			}
				
		}

		
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
	
	public void addRecipeTag(Recipe r) throws SQLException, ClassNotFoundException {
		getAccess();

		LinkedList<Tag> tag = r.getTagList();

		for (int i = 0; i < tag.size(); i++) {
			String query = "SELECT * from tag where tagContent = " + "'" + tag.get(i).getTagContent()+"'";
			resultSet =statement.executeQuery(query);
			resultSet.next();
			int id = resultSet.getInt("tagId");
			statement.executeUpdate(
					"INSERT INTO recipe_has_tag (recipe_recipeId, tag_tagId) VALUES("
							+ r.getRecipeId() + ",'" + id + "' "
							+ ")");

			
		}
		close();

	}


	public void addRecipeIngredient(Recipe r) throws SQLException, ClassNotFoundException {
		getAccess();

		LinkedList<Ingredient> ingredient = r.getIngredient();

		for (int i = 0; i < ingredient.size(); i++) {
			String query = "SELECT * from ingredients where ingredientName = " + "'"+ingredient.get(i).getIngredientName()+"'";
			resultSet =statement.executeQuery(query);
			resultSet.next();
			int id2 = resultSet.getInt("ingredientId");
			statement.executeUpdate(
					"INSERT INTO recipe_has_ingredients (recipe_recipeId, ingredients_ingredientId, quantity, unit, description) VALUES("
							+ r.getRecipeId() + ",'" + id2 + "', "
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
			try{
				statement.executeUpdate( "INSERT INTO ingredients (ingredientName) VALUES(" 
					 + "'" + ingredient.get(i).getIngredientName() + "' ) " );
			}catch (SQLException e) {
				
			}
			

			
		}
	close();	

	}

	
	//update
	
	
	
	
	/**
	 *  change the servings and  dishname
	 * @param r
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void updateRecipe(Recipe r) throws ClassNotFoundException, SQLException {
		getAccess();
		//String sql = "update recipe set dishname='" + r.getDishName() + "' where recipeId='" + r.getRecipeId() + "'";
		//String sql = "update recipe set dishName='" + r.getDishName() + "' where recipeId='" + r.getRecipeId() + "'";
	    String sql = "update recipe set dishName =? ,servings = ?,preparationTime = ?,cookingTime = ? where recipeId=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, r.getDishName());
		preparedStatement.setInt(2, r.getServings());
		preparedStatement.setInt(3,r.getPreparationTime());
		preparedStatement.setInt(4, r.getCookingTime());
		preparedStatement.setInt(5,r.getRecipeId());
		preparedStatement.executeUpdate();
		close();

	}
	/**
	 *   edit can not change the name if you change the name you must add a new ingredient
	 * @param ingredient
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void updateIngredient(Ingredient ingredient) throws ClassNotFoundException, SQLException {
		getAccess();
			String query = "select ingredientId from ingredients where ingredientName = " + "'"+ingredient.getIngredientName()+"'";
		resultSet = statement.executeQuery(query);
		resultSet.next();
		int id = resultSet.getInt("ingredientId");
		String sql = "update recipe_has_ingredients set  quantity=?,unit=?,description=?" + "where ingredients_ingredientId ="
				+ id+ "";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setDouble(1, ingredient.getQuantity());
		preparedStatement.setString(2, ingredient.getUnit());
		preparedStatement.setString(3, ingredient.getDescription());
		preparedStatement.executeUpdate();
			
			
	
	
		close();		
	}
	
	public void updateStep(Recipe r,String s,int n) throws ClassNotFoundException, SQLException {
		getAccess();
	
		
		
		String sql = "update  preparation_step set description= ?  where recipeId=? and step =?";	
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, "s");
		preparedStatement.setInt(2, r.getRecipeId());
		preparedStatement.setInt(3, n);
		preparedStatement.executeUpdate();
		close();
		
	}
	
	public void updateTag(Recipe r,String s) throws ClassNotFoundException, SQLException{
		getAccess();
		String query = "select tag_tagId from recipe_has_tag where recipe_recipeId = " + "" + r.getRecipeId() + "";
		resultSet =statement.executeQuery(query);
		int id =0;
		while(resultSet.next()){
			id = resultSet.getInt("tag_tagId");
		}
		
		
		String sql = "insert  tag set tagContent =  ? " + "where tagId = " + id +"";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,s );
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
	/*public void update(Recipe recipe, Ingredient ingredient,String s,int n){
		
	}*/
	
	
	public void updateServings(String recipeName, int newServings) throws ClassNotFoundException, SQLException {

		recipe = selectRecipeByName(recipeName);
		int originServings = recipe.getServings();
		System.out.println(originServings);
		float times = (float) newServings / originServings;
		System.out.println(times);
		String updateServingsTime = "Update recipe set recipe.preparationTime = " + times + "*recipe.preparationTime , "
				+ "recipe.cookingTime = " + times + "*recipe.cookingTime, recipe.servings = " + "'" + newServings + "'"
				+ " where recipe.dishName = " + "'" + recipeName + "'";
		statement.executeUpdate(updateServingsTime);

		String updateServingQuantity = "Update recipe_has_ingredients inner join recipe on recipe.recipeId = recipe_has_ingredients.recipe_recipeId "
				+ "set quantity= " + times + "*quantity where recipe.dishName =" + "'" + recipeName + "'";
		statement.executeUpdate(updateServingQuantity);

	}
	
	//search
	
	
	public LinkedList<Recipe> search(String input, String tagContent) throws SQLException, ClassNotFoundException {



		getAccess();

		LinkedList<Integer> idlist = new LinkedList<>();
		LinkedList<Recipe> recipeList = new LinkedList<>();


		if (tagContent.equals("All flavor")) {

			tagContent = "%";



		}

		String input_notexactly = "%" + input + "%";

		System.out.println(input);



		String searchRecipe = "  select DISTINCT t1.dishName from recipe as t1, tag as t2, recipe_has_tag as t3 "

				+ "where t1.recipeId=t3.recipe_recipeId and t2.tagId = t3.tag_tagId  and t1.dishName like '"

				+ input_notexactly + "' and t2.tagContent like '" + tagContent + "'";

		String searchIngredient = "select DISTINCT t1.recipe_recipeId, t2.ingredientName from recipe_has_ingredients as t1, ingredients as t2 "

				+ "where t1.ingredients_ingredientId = t2.ingredientId and t2.ingredientName like '" + input_notexactly

				+ "'"

				+ "and t1.recipe_recipeId IN (select t3.recipe_recipeId  from recipe_has_tag as t3, tag as t4 where t3.tag_tagId = t4.tagId and t4.tagContent like '"

				+ tagContent + "')" + "group by t1.recipe_recipeId";

		resultSet = statement.executeQuery(searchRecipe);

		if (!resultSet.next()) {

			System.out.println("Not a recipe!");



		} else {

			resultSet.beforeFirst();

			while (resultSet.next()) {

				String searchResult = resultSet.getString("dishName");

				System.out.println(searchResult);



				String[] word = searchResult.split("\\s+");

				for (String string : word) {



					if (string.equals(input)) {



						recipeList.add(selectRecipeByName(searchResult));

					}

				}



			}



		}



		resultSet = statement.executeQuery(searchIngredient);

		if (!resultSet.next()) {

			System.out.println("Not a ingredient!");

		} else {

			resultSet.beforeFirst();

			while (resultSet.next()) {



				int searchResult = resultSet.getInt("recipe_recipeId");

				String ingredientName = resultSet.getString("ingredientName");

				String[] word = ingredientName.split("\\s+");

				for (String string : word) {

					if (string.equals(input)) {

						idlist.add(searchResult);

					}

				}



			}



			for (int i = 0; i < idlist.size(); i++) {

				recipeList.add(selectRecipeById(idlist.get(i)));

			}



		}



		return recipeList;

	}
	
	
	
// select recipe by name	
	
	public Recipe selectRecipeById(int RecipeId) throws SQLException, ClassNotFoundException {

		getAccess();

		String sql = "SELECT DISTINCT dishname from recipe, recipe_has_ingredients where recipe.recipeId= recipe_has_ingredients.recipe_recipeId and recipe_recipeId = "

				+ RecipeId;



		String dishName;

		resultSet = statement.executeQuery(sql);

		//System.out.println("11111111111111");

		while (resultSet.next()) {

			dishName = resultSet.getString("dishName");

			recipe = selectRecipeByName(dishName);

		}



		return recipe;



	}
	
	public int selectIdByName(String recipeName) throws ClassNotFoundException, SQLException{
		getAccess();
		int recipeId = 0;
		recipe = selectRecipeByName(recipeName);
		String sql = "select recipeId from recipe where dishname = " + "'" + recipe.getDishName() + "'";
		resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
			recipeId = resultSet.getInt("recipeId");
		}
		return recipeId;
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

	public int createMaxRecipeId() throws ClassNotFoundException, SQLException{
		getAccess();


		String sql = "SELECT MAX(recipeId) FROM RECIPE";
		resultSet =statement.executeQuery(sql);
		int id = 0;
		while( resultSet.next())
		{
			id =resultSet.getInt("Max(recipeId)");
		}
		return id + 1;

	}
	
	
	
	
	
/*	public void saveRecipe(String newRecipeName) throws ClassNotFoundException, SQLException{
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
		String sql = "SELECT dishName from recipe where dishName = " + "'" + newRecipeName + "'";
		resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
			String oldDishName = resultSet.getString("dishname");
			if(newRecipeName.equals(oldDishName)){
				dbC
			}else{
				
			}
		}
		
	}*/
	
	
	public void  removeAllTag(Recipe r) throws ClassNotFoundException, SQLException{
		getAccess();

		preparedStatement =connection.prepareStatement("delete from recipe_has_tag where recipe_recipeId = " + r.getRecipeId()  + ";");
		preparedStatement.executeUpdate();
				
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
