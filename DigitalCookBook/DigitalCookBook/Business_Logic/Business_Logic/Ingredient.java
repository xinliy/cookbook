package Business_Logic;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * ingredient's attributes and constructors
 * 
 * @author Bing Guanqi
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Ingredient implements Serializable {

	public String ingredientName;
	private double quantity;
	private String unit;
	private String description;
	

	/**
	 * one kind of constructor of Ingredient
	 * 
	 * @param ingredientName
	 *            the name of ingredient
	 * @param quantity
	 *            the quantity of ingredient
	 * @param unit
	 *            the unit of ingredient
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public Ingredient(String ingredientName, double quantity, String unit) throws ClassNotFoundException, SQLException {
		this.ingredientName = ingredientName;
		this.quantity = quantity;
		this.unit = unit;
		
		
	}

	/**
	 * one kind of constructor of Ingredient
	 * 
	 * @param ingredientName
	 * @param quantity
	 * @param unit
	 * @param description
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public Ingredient(String ingredientName, double quantity, String unit, String description) throws ClassNotFoundException, SQLException {
		this.ingredientName = ingredientName;
		this.quantity = quantity;
		this.unit = unit;
		this.description = description;
		
	
		
	}

	/**
	 * getter of the name of ingredient
	 * 
	 * @return
	 */
	public String getIngredientName() {
		return ingredientName;
	}

	/**
	 * getter of the quantity of ingredient
	 * 
	 * @return
	 */
	public double getQuantity() {
		return quantity;
	}

	/**
	 * getter of the unit of ingredient
	 * 
	 * @return
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * set the new name of ingredient
	 * 
	 * @param newIngredientName
	 */
	
	public String getDescription(){
		return description;
	}
	

	public void setIngredientName(String newIngredientName) {
		ingredientName = newIngredientName;
	}

	/**
	 * set the new quantity of ingredient
	 * 
	 * @param newQuantity
	 */
	public void setQuantity(Double newQuantity) {
		quantity = newQuantity;
	}

	/**
	 * set the new unit of ingredient
	 * 
	 * @param newUnit
	 */
	public void setUnit(String newUnit) {
		unit = newUnit;
	}

	/**
	 * override the method of toString
	 */
	@Override
	public String toString() {
		return "Ingredient [ingredientName=" + ingredientName + ", quantity=" + quantity + ", unit=" + unit
				+ ", description=" + description + "]" + "\n";
	}
	

}