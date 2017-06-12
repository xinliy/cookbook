import java.sql.SQLException;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Test {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String recipeName = "Hong Shao Rou";
		int changeServing= 10;
	Controller controller = new Controller();
	DBConnector dbConnector = new DBConnector();
	controller.changeServingRetunList(recipeName, changeServing);
	//dbConnector.updateServings(recipeName, changeServing);
	
}
}