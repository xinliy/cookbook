import java.sql.SQLException;

public class Controller {
	
	private CookBookApp cookBookApp;
	
	
	
	public Recipe catchRecipe(String recipeName) throws ClassNotFoundException, SQLException{
		
		CookBookApp cookBookApp = new CookBookApp();
		return cookBookApp.cookBook.getRecipe(recipeName);
		
	}
	public int getIngredientNumbaer(String recipeName) throws ClassNotFoundException, SQLException{
		
		CookBookApp cookBookApp = new CookBookApp();
		return cookBookApp.cookBook.getRecipe(recipeName).getIngredient().size();
	}
	
	
	
	public int getStepNumber(String recipeName) throws ClassNotFoundException, SQLException{
		
		CookBookApp cookBookApp = new CookBookApp();
		return cookBookApp.cookBook.getRecipe(recipeName).getSteps().size();
	}
	
	public String getStepSentence(String recipeName, int number) throws ClassNotFoundException, SQLException{
		CookBookApp cookBookApp = new CookBookApp();
		String stepSentence = cookBookApp.cookBook.getRecipe(recipeName).getSteps().get(number);
		//System.out.println(stepSentence);
		return stepSentence;
	}
	
	public String getIngredientSentence(String recipeName, int number) throws ClassNotFoundException, SQLException{
		
		CookBookApp cookBookApp = new CookBookApp();
		Ingredient ingredient = cookBookApp.cookBook.getRecipe(recipeName).getIngredient().get(number);
		String ingredientSentence = ingredient.getIngredientName()+String.valueOf(ingredient.getQuantity())+ingredient.getUnit()+ingredient.getDescription();
		return ingredientSentence;
	}

}
