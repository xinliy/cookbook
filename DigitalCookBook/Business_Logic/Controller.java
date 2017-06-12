import java.sql.SQLException;
import java.util.LinkedList;

public class Controller {
	
	private CookBookApp cookBookApp;
	private DBConnector dbConnector;
	
	
	
	
	
	public Recipe catchRecipe(String recipeName) throws ClassNotFoundException, SQLException{
		
		
		return dbConnector.selectRecipeByName(recipeName);
		
	}
	public int getIngredientNumbaer(String recipeName) throws ClassNotFoundException, SQLException{
		
		
		return dbConnector.selectRecipeByName(recipeName).getIngredient().size();
	}
	
	
	
	public int getStepNumber(String recipeName) throws ClassNotFoundException, SQLException{
		
		
		return dbConnector.selectRecipeByName(recipeName).getSteps().size();
	}
	
	public String getStepSentence(String recipeName, int number) throws ClassNotFoundException, SQLException{
		
		String stepSentence = dbConnector.selectRecipeByName(recipeName).getSteps().get(number);
		//System.out.println(stepSentence);
		return stepSentence;
	}
	
	public String getIngredientSentence(String recipeName, int number) throws ClassNotFoundException, SQLException{
		
		
		Ingredient ingredient = dbConnector.selectRecipeByName(recipeName).getIngredient().get(number);
		String ingredientSentence = ingredient.getIngredientName()+String.valueOf(ingredient.getQuantity())+ingredient.getUnit()+ingredient.getDescription();
		return ingredientSentence;
	}
	
	public LinkedList<Integer>  changeServingRetunList(String recipeName,int changeServing) throws ClassNotFoundException, SQLException{
		CookBookApp cookBookApp = new CookBookApp();
		cookBookApp.cookBook.reviseServings(recipeName, changeServing);
		System.out.println(dbConnector.selectRecipeByName(recipeName).getPreparationTime());
		LinkedList<Integer> result = new LinkedList<>();
		result.add(cookBookApp.cookBook.getRecipe(recipeName).getCookingTime());
		result.add(cookBookApp.cookBook.getRecipe(recipeName).getPreparationTime());
		return result;
	}

}
