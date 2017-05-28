import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * recipe's attribute and their functions
 * 
 * @author Group_Currywurst
 * @version 1.0
 */
public class Recipe implements Serializable{

	private String dishName;
	private String location;
	private Integer servings;
	private Integer preparationTime;
	private Integer cookingTime;
	private LinkedList<Ingredient> ingredient = new LinkedList<Ingredient>();
	private LinkedList<String> steps = new LinkedList<String>();

	/**
	 * constructor of Recipe
	 * 
	 * @param dishName
	 * @param location
	 * @param servings
	 */
	
	public Recipe(String dishName,String location,int servings) {
		this.dishName = dishName;
		this.location = location;
		this.servings = servings;
	}


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
		return dishName;
	}

	public String getLocation() {
		return location;
	}

	public int getServings() {
		return servings;
	}

	public int getPreparationTime() {
		return preparationTime;
	}

	public int getCookingTime() {
		return cookingTime;
	}
	
	public LinkedList<Ingredient> getIngredient() {
		return ingredient;
	}
	
	public void setDishName(String newDishName) {
		dishName = newDishName;
	}

	public void setLocation(String newLocation) {
		location = newLocation;
	}

	public void setServings(int newServings) {
		servings = newServings;
	}

	public void setPreparationTime(int newPreparationTime) {
		preparationTime = newPreparationTime;
	}

	public void setCookingTime(int newCookingTime) {
		cookingTime = newCookingTime;
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

	/**
	 * overriding the toString() method
	 */
	public String toString() {
		return "Dishname: " + dishName + "\nLocation: " + location + "\nservings: " + servings.toString()
				+ "\nPreparation time: " + preparationTime + "\nCooking time: " + cookingTime + "\nIngredient: "
				+ ingredient.toString() + "\nSteps: " + steps.toString();
	}

}