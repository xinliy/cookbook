import java.io.Serializable;

/**
 * ingredient's attributes and constructors
 * 
 * @author Group_Currywurst
 * @version 1.0
 */
public class Ingredient implements Serializable {

	public String ingredientName;
	public double quantity;
	public String unit;
	private String description;

	/**
	 * one kind of constructor of Ingredient
	 * 
	 * @param ingredientName
	 * @param quantity
	 * @param unit
	 */
	Ingredient(String ingredientName, double quantity, String unit) {
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
	 */

	public String getIngredientName() {
		return ingredientName;
	}

	public double getQuantity() {
		return quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setIngredientName(String newIngredientName) {
		ingredientName = newIngredientName;
	}

	public void setQuantity(Double newQuantity) {
		quantity = newQuantity;
	}

	public void setUnit(String newUnit) {
		unit = newUnit;
	}

	Ingredient(String ingredientName, double quantity, String unit, String description) {
		this.ingredientName = ingredientName;
		this.quantity = quantity;
		this.unit = unit;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Ingredient [ingredientName=" + ingredientName + ", quantity=" + quantity + ", unit=" + unit
				+ ", description=" + description + "]"+"\n";
	}

}