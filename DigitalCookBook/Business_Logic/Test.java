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
	
	// dbConnector.selectRecipeById(1);
	
	recipes=dbConnector.search("Suan La Fen", "All flavr");
	for(int i=0;i<recipes.size();i++){
		System.out.println(recipes.get(i));
	}
	
	//recipes.add(dbConnector.selectRecipeByName("Hong Shao Rou"));
	//Recipe recipe = dbConnector.selectRecipeByName("Hong Shao Rou");
	
	
	
	
	
}
}