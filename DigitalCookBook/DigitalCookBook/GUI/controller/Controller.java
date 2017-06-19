package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;

import Business_Logic.CookBook;
import Business_Logic.DBConnector;
import Business_Logic.Ingredient;
import Business_Logic.Recipe;
import Business_Logic.Tag;
import view.Stepgui;

public class Controller {
	
	//private CookBookApp cookBookApp;
	public DBConnector dbConnector;
	public Recipe recipe;
	public CookBook cookBook;
	

	
	public Controller() {
		this.dbConnector = new DBConnector();
	
	}
	
	
	
	
	
	
	public String getAllIngredientsName(String recipeName) throws ClassNotFoundException, SQLException {
		Recipe recipe = dbConnector.selectRecipeByName(recipeName);
		LinkedList<Ingredient> targetIngredients = recipe.getIngredient();
		String ingredients = "";
		ingredients = ingredients + targetIngredients.get(0).getIngredientName() + ", ";
		ingredients = ingredients + targetIngredients.get(1).getIngredientName() + "...";
		
		return ingredients;
		
	}

	//used in Search_GUI
	public LinkedList<String> getAllTags(String recipeName) throws ClassNotFoundException, SQLException {
		Recipe recipe = dbConnector.selectRecipeByName(recipeName);
		LinkedList<Tag> targetTags = new LinkedList<Tag>();
		targetTags = recipe.getTagList();
		LinkedList<String> targetTagsList = new LinkedList<String>();
		//targetTagsList.clear();
		for(int i = 0; i < targetTags.size(); i++) {
			String targetTagsContent = targetTags.get(i).getTagContent();
			targetTagsList.add(targetTagsContent);
		}
		
		return targetTagsList;
			
	}
	public int selectIdByName(String recipeName) throws ClassNotFoundException, SQLException{
		return dbConnector.selectIdByName(recipeName);
	}
	//used in Search_GUI
	public LinkedList<Recipe> searchByNameAndIngredient(String recipeName, String tagContent) throws ClassNotFoundException, SQLException {
		return dbConnector.search(recipeName, tagContent);
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
		String ingredientSentence = ingredient.getIngredientName()+" "+String.valueOf(ingredient.getQuantity())+" "+ingredient.getUnit()+" "+ingredient.getDescription();
		return ingredientSentence;
	}
	
	public String getInsideInredientSentence(Recipe recipe, int number){
		Ingredient ingredient= recipe.getIngredient().get(number);
		String ingredientSentence = ingredient.getIngredientName()+" "+String.valueOf(ingredient.getQuantity())+" "+ingredient.getUnit()+" "+ingredient.getDescription();
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
	public void updateIngredient(Ingredient ingredient) throws ClassNotFoundException, SQLException{
		//Recipe recipe = dbConnector.selectRecipeByName(recipeName);
		dbConnector.updateIngredient(ingredient);
	}
	public void updateRecipe(Recipe r) throws ClassNotFoundException, SQLException{
		//Recipe recipe = dbConnector.selectRecipeByName(recipeName);
		dbConnector.updateRecipe(r);		//return recipe;
	}
	public void updateStep(String recipeName, String stepDescription , int stepNumber) throws ClassNotFoundException, SQLException{
		Recipe recipe = dbConnector.selectRecipeByName(recipeName);
		dbConnector.updateStep(recipe, stepDescription, stepNumber);
	}
	public void updateTag(String recipeName,String tagDescription) throws ClassNotFoundException, SQLException{
		Recipe recipe = dbConnector.selectRecipeByName(recipeName);
//		for(int i = 0 ;i<recipe.getTagList().size();i++){
//			tagDescription = recipe.getTagList().get(i).getTagContent();
			dbConnector.updateTag(recipe, tagDescription);
		}
		
		
	
	public void addRecipe(int recipeId,String dishName,String location,int servings) throws ClassNotFoundException, SQLException{
		Recipe r = new Recipe(recipeId,dishName,location,servings);
		dbConnector.addRecipe(r);
	}
	public void addIngredient(Recipe r) throws ClassNotFoundException, SQLException{
		dbConnector.addIngredients(r);
	}
	public void addPreparationStep(Recipe r) throws ClassNotFoundException{
		dbConnector.addPreparationStep(r);
	}
	public void addTag(Recipe r) throws ClassNotFoundException, SQLException{
		dbConnector.addTag(r);
	}
	public void addRecipeTag(Recipe r) throws ClassNotFoundException, SQLException{
		dbConnector.addRecipeTag(r);
	}
	public void addRecipeIngredient(Recipe r) throws ClassNotFoundException, SQLException{
		dbConnector.addRecipeTag(r);
	}
	public int createRecipeId() throws ClassNotFoundException, SQLException{
		return dbConnector.createMaxRecipeId();
	
	}
	public void returnRecipe(Recipe r) throws SQLException{
		r.recipeToDatabase(dbConnector);
	}
	public void deleteRecipe(String dishname) throws ClassNotFoundException, SQLException{
		dbConnector.deleteRecipe(dishname);
	}
	public void removeAllTag(Recipe r) throws ClassNotFoundException, SQLException{
		dbConnector.removeAllTag(r);
	}
	
	public void addListener(ActionListener listen, JComboBox button){
		button.addActionListener(listen);
	}
}