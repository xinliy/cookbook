import java.sql.SQLException;
import java.util.LinkedList;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.sun.media.jfxmedia.events.NewFrameEvent;

public class Test {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

	
	Controller controller = new Controller();
	DBConnector dbConnector = new DBConnector();
	LinkedList<Recipe>recipes=new LinkedList<>();
	recipes=dbConnector.search("garlic", "sweet");
	System.out.println(recipes.get(0));
	//recipes.add(dbConnector.selectRecipeByName("Hong Shao Rou"));
	//Recipe recipe = dbConnector.selectRecipeByName("Hong Shao Rou");
	
	
	
	
	
}
}