package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class View_Superclass {
	
	
	public void addListener(ActionListener actionListener, JButton button){
		button.addActionListener(actionListener);
	}
	
	public void addComboxListener(ActionListener actionListener, JComboBox jComboBox){
		jComboBox.addActionListener(actionListener);
	}

}
