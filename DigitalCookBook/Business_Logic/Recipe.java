import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * recipe's attribute and their functions
 * 
 * @author Bing Guanqi
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Recipe implements Serializable {

	private Integer recipeId;
	private String dishName;
	private String location;
	private Integer servings;
	private Integer preparationTime;
	private Integer cookingTime;
	private LinkedList<Ingredient> ingredient = new LinkedList<Ingredient>();
	private LinkedList<String> steps = new LinkedList<String>();
	private LinkedList<Tag> tag = new LinkedList<Tag>();

	/**
	 * constructor of Recipe
	 * 
	 * @param dishName
	 * @param location
	 * @param servings
	 */
	public Recipe(int recipeId, String dishName, String location, int servings) {
		this.recipeId = recipeId;
		this.dishName = dishName;
		this.location = location;
		this.servings = servings;
	}

	/**
	 * serializing method
	 */
	public void serializing() {
		try {

			FileOutputStream fos = new FileOutputStream("Recipe.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(this);

			oos.close();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	/**
	 * deserializing method
	 * 
	 * @throws ClassNotFoundException
	 */
	public static void deserializing() throws ClassNotFoundException {

		try {

			FileInputStream fis = new FileInputStream("Recipe.txt");

			ObjectInputStream ois = new ObjectInputStream(fis);

			System.out.println(ois.readObject());

			ois.close();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	/**
	 * getters and setters
	 */
	public String getDishName() {
		return this.dishName;
	}

	public String getLocation() {
		return this.location;
	}

	public int getServings() {
		return this.servings;
	}

	public int getPreparationTime() {
		return this.preparationTime;
	}

	public int getCookingTime() {
		return this.cookingTime;
	}

	public LinkedList<Ingredient> getIngredient() {
		return this.ingredient;
	}

	public int getRecipeId() {
		return this.recipeId;
	}

	public LinkedList<String> getSteps() {
		return this.steps;
	}

	public LinkedList<Tag> getTagList() {
		return this.tag;
	}

	public void setDishName(String newDishName) {
		this.dishName = newDishName;
	}

	public void setLocation(String newLocation) {
		this.location = newLocation;
	}

	public void setServings(int newServings) {
		this.servings = newServings;
	}

	public void setPreparationTime(int newPreparationTime) {
		this.preparationTime = newPreparationTime;
	}

	public void setCookingTime(int newCookingTime) {
		this.cookingTime = newCookingTime;
	}

	public void setRecipeId(int newRecipeId) {
		this.recipeId = newRecipeId;
	}

	public void setTagList(LinkedList<Tag> tagList) {
		this.tag = tagList;
	}

	/**
	 * adding ingredients to the recipe
	 * 
	 * @param ingredient
	 */
	public void addIngredient(Ingredient ingredient) {
		this.ingredient.add(ingredient);

	}

	/**
	 * adding prepared steps to the recipe
	 * 
	 * @param steps
	 */
	public void addPreparationStep(String steps) {
		this.steps.add(steps);
	}
	
	public void addTag(Tag tag){
		this.tag.add(tag);
	}

	/**
	 * overriding the toString() method
	 */
	public String toString() {
		return "Recipe_id" + this.recipeId + "Dishname: " + this.dishName + "\nLocation: " + this.location
				+ "\nservings: " + this.servings.toString() + "\nPreparation time: " + this.preparationTime
				+ "\nCooking time: " + this.cookingTime + "\nIngredient: " + this.ingredient.toString() + "\nSteps: "
				+ this.steps.toString();
	}

	/**
	 * the method which you can send the recipe to database
	 * 
	 * @param dbconnector
	 *            the instance of the class "DBConnector"
	 * @throws SQLException
	 */
	public void recipeToDatabase(DBConnector dbconnector) throws SQLException {
		try {
			dbconnector.addRecipe(this);
			dbconnector.addPreparationStep(this);
			dbconnector.addIngredients(this);
			dbconnector.addRecipeIngredient(this);
			dbconnector.addTag(this);
			dbconnector.addRecipeTag(this);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}