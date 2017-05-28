import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * the connector to connect the java code to database
 * @author Zhang Xiaoyue
 * @version 1.0
 */
public class DBConnector {

	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public void getAccess() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		// Setup the connection with the DB
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cookbook", "root", "");
		statement = connection.createStatement();

	}

	public void delete() throws ClassNotFoundException, SQLException {
		getAccess();

		preparedStatement = connection.prepareStatement("delete from tag where tagId = 123;");
		preparedStatement.executeUpdate();
		close();
	}

	public void insert(int tagId, String tagContent) throws SQLException, ClassNotFoundException {

		getAccess();
		preparedStatement = connection.prepareStatement("insert into tag(tagId,tagContent) values (?,?)");
		preparedStatement.setInt(1, tagId);
		preparedStatement.setString(2, tagContent);
		preparedStatement.executeUpdate();
		close();
	}

	public void printTable(String tableName) throws SQLException, ClassNotFoundException {
		getAccess();
		resultSet = statement.executeQuery("select * from " + tableName);
		writeResultSet(resultSet);
		close();
	}

	public void getColumnName(String tableName) throws SQLException, ClassNotFoundException {

		getAccess();
		resultSet = statement.executeQuery("select * from " + tableName);
		System.out.println("The columns are:");

		System.out.println("Table:" + resultSet.getMetaData().getTableName(1));
		for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
			System.out.println("Column " + i + " :" + resultSet.getMetaData().getColumnName(i));

		}
		close();

	}

	private void writeResultSet(ResultSet resultSet) throws SQLException {

		while (resultSet.next()) {

			try {
				int tagID = resultSet.getInt("tagID");
				String tagContent = resultSet.getString("tagContent");

				System.out.println(tagID);
				System.out.println(tagContent);
			} catch (Exception e) {
				System.out.println("GGGGGGGGGGGGGGG");
			}

		}
	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();

			}

			if (statement != null) {
				statement.close();

			}

			if (connection != null) {
				connection.close();

			}
		} catch (Exception e) {
		}
	}

	public void addRecipe(Recipe r) throws ClassNotFoundException, SQLException {
		getAccess();

		statement.executeUpdate("INSERT INTO recipe (recipe_id, name, servings, preparationTime, cookingTime) VALUES("
				+ r.getRecipeId() + ",'" + r.getDishName() + "', " + r.getServings() + ", " + r.getCookingTime() + ", "
				+ r.getPreparationTime() + ")");

		close();

	}

	public void addTag(Tag t) throws SQLException, ClassNotFoundException {
		getAccess();

		statement.executeUpdate(
				"INSERT INTO tag (tagId, tagContent) VALUES(" + t.getTagId() + ",'" + t.getTagContent() + "')");

		close();
	}

}
