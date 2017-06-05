import java.io.Serializable;
import java.util.LinkedList;

/**
 * CookBook contains some recipes
 * 
 * @author Song Yuchao, Ma Qiang, Shan Xue
 * @version 1.0
 */
public class CookBook implements Serializable {

	private static final long serialVersionUID = 1L;
	private String cookBookName;
	private LinkedList<Recipe> recipeList = new LinkedList<Recipe>();
	

	/**
	 * constructor
	 * 
	 * @param cookBookName
	 *            the name of our cookbook
	 */

	public CookBook(String cookBookName) {

		this.cookBookName = cookBookName;

	}

	/**
	 * adding recipes to the CookBook
	 * 
	 * @param recipe
	 *            the recipe
	 */
	public void add(Recipe recipe) {
		this.recipeList.add(recipe);
	}

	/**
	 * Getting recipes according to recipe's name from CookBook
	 * 
	 * @param recipeName
	 *            the name of recipe
	 * @return
	 */
	
	

	public Recipe getRecipe(String name) {

		Recipe buf = null;
		for (Recipe i : recipeList) {
			if (i.getDishName().equals(name)) {
				buf = i;
			}
		}
		return buf;

	}

	/**
	 * Revise the number of the guests
	 * 
	 * @param Recipe
	 *            the recipe which you want to revise
	 * @param servings
	 *            the new servings amount
	 */

	public void reviseServings(String Recipe, int servings) {
		int buffer = getRecipe(Recipe).getServings();

		getRecipe(Recipe).setServings(servings);

		int oldPT = getRecipe(Recipe).getPreparationTime();

		int oldCT = getRecipe(Recipe).getCookingTime();

		getRecipe(Recipe).setPreparationTime(oldPT * servings / buffer);

		getRecipe(Recipe).setCookingTime(oldCT * servings / buffer);

		for (int i = 0; i <= getRecipe(Recipe).getIngredient().size() - 1; i++) {

			double oldQuantity = getRecipe(Recipe).getIngredient().get(i).getQuantity();
			getRecipe(Recipe).getIngredient().get(i).setQuantity(oldQuantity * servings / buffer);

		}

	}

}