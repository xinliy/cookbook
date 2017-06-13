import java.sql.SQLException;
import java.util.LinkedList;

public class Controller {

	// private CookBookApp cookBookApp;

	public Recipe recipe;
	public CookBook cookBook;

	public Controller() {
		this.cookBook = new CookBook();
	}

	public Recipe catchRecipe(String recipeName) throws ClassNotFoundException, SQLException {

		recipe = cookBook.dbConnector.selectRecipeByName(recipeName);
		cookBook.dbConnector.close();

		return recipe;

	}

	public int getIngredientNumbaer(String recipeName) throws ClassNotFoundException, SQLException {

		cookBook.dbConnector.close();

		return cookBook.dbConnector.selectRecipeByName(recipeName).getIngredient().size();

	}

	public int getStepNumber(String recipeName) throws ClassNotFoundException, SQLException {

		cookBook.dbConnector.close();

		return cookBook.dbConnector.selectRecipeByName(recipeName).getSteps().size();

	}

	public String getStepSentence(String recipeName, int number) throws ClassNotFoundException, SQLException {

		String stepSentence = cookBook.dbConnector.selectRecipeByName(recipeName).getSteps().get(number);

		cookBook.dbConnector.close();
		return stepSentence;
	}

	public String getIngredientSentence(String recipeName, int number) throws ClassNotFoundException, SQLException {

		Ingredient ingredient = cookBook.dbConnector.selectRecipeByName(recipeName).getIngredient().get(number);
		String ingredientSentence = ingredient.getIngredientName() + " " + String.valueOf(ingredient.getQuantity())
				+ " " + ingredient.getUnit() + " ";
		if (ingredient.getDescription().equals("null")) {

		} else {
			ingredientSentence = ingredientSentence + ingredient.getDescription();
		}

		cookBook.dbConnector.close();
		return ingredientSentence;
	}

	public void changeServingRetunList(String recipeName, int changeServing)
			throws ClassNotFoundException, SQLException {

		cookBook.dbConnector.updateServings(recipeName, changeServing);
		cookBook.dbConnector.close();
	}

	public LinkedList<Integer> getTimeList(String recipeName) throws ClassNotFoundException, SQLException {

		Recipe recipe = cookBook.dbConnector.selectRecipeByName(recipeName);
		LinkedList<Integer> result = new LinkedList<>();
		result.add(recipe.getCookingTime());
		result.add(recipe.getPreparationTime());
		cookBook.dbConnector.close();
		return result;
	}

	public LinkedList<Integer> getQuantityList(String recipeName) throws ClassNotFoundException, SQLException {

		Recipe recipe = cookBook.dbConnector.selectRecipeByName(recipeName);
		LinkedList<Integer> result = new LinkedList<>();
		for (int i = 0; i < recipe.getIngredient().size(); i++) {
			result.add((int) recipe.getIngredient().get(i).getQuantity());
		}
		cookBook.dbConnector.close();
		return result;
	}

}
