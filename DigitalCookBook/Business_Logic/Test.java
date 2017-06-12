import java.sql.SQLException;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Test {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

	DBConnector dbConnector =  new DBConnector();
	Recipe recipe = dbConnector.selectRecipeByName("Hong Shao Rou");
	dbConnector.updateServings("Hong Shao Rou", 9);
}
}