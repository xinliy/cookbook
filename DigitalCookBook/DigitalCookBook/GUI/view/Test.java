package view;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Test {
	static JPanel prepareTimePanel;
	static JPanel servingPanel;
	static int i=0;
	
	public static void main(String[] args) {
	
		
		
		JFrame frame = new JFrame("Steps");
		frame.setSize(768, 480);
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dim = tool.getScreenSize();
		int width = (int) dim.getWidth();
		int height = (int) dim.getHeight();

		frame.setLocation((width - 768) / 2, (height - 480) / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_1.add(lblNewLabel);

		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				lblNewLabel.setText(Integer.toString(i));
				i++;
			}
		});
		
	
	frame.setVisible(true);
	}
	
	
}
