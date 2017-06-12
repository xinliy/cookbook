import java.sql.SQLException;
import java.util.LinkedList;

public class Controller {
	
	//private CookBookApp cookBookApp;
	public DBConnector dbConnector;
	public Recipe recipe;
	
	public Controller() {
		this.dbConnector = new DBConnector();
	}
	
	
	
	
	
	public Recipe catchRecipe(String recipeName) throws ClassNotFoundException, SQLException{
		
		recipe = dbConnector.selectRecipeByName(recipeName);
		
		
		return recipe;
		
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
	
	public void changeServingRetunList(String recipeName,int changeServing) throws ClassNotFoundException, SQLException{
		dbConnector.updateServings(recipeName, changeServing);
		
	}
	
	public LinkedList<Integer> getTimeList(String recipeName) throws ClassNotFoundException, SQLException{
		Recipe recipe = dbConnector.selectRecipeByName(recipeName);
		LinkedList<Integer> result = new LinkedList<>();
		result.add(recipe.getCookingTime());
		result.add(recipe.getPreparationTime());
		return result;
	}
	
	public LinkedList<Integer> getQuantityList(String recipeName) throws ClassNotFoundException, SQLException{
		Recipe recipe = dbConnector.selectRecipeByName(recipeName);
		LinkedList<Integer> result = new LinkedList<>();
		for(int i=0;i<recipe.getIngredient().size();i++){
			result.add((int)recipe.getIngredient().get(i).getQuantity());
		}
		return result;
	}

}
