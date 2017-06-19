package Business_Logic;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBConnector db = new DBConnector();
		System.out.println(db.createMaxRecipeId());

 }
}