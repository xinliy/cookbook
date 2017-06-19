package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Cover extends JFrame {

	private JLabel pictureLabel = new JLabel();
	private Icon background = null;
	
	private JButton enter = new JButton("Just Cook It!");
	
	public Cover() {
		super("Welcome to our recipe world!");
		
		//getting the center of user's pc, place the windows in the center
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dim = tool.getScreenSize();
		int width = (int)dim.getWidth();
		int height = (int)dim.getHeight();
		this.setSize(800, 600);
		this.setLocation((width - 800)/2, (height - 600)/2);
		
		
		background = new ImageIcon(this.getClass().getResource("/icon/background.jpg"));
		pictureLabel.setIcon(background);
		pictureLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		this.getLayeredPane().add(pictureLabel, new Integer(Integer.MIN_VALUE));
		this.add(pictureLabel);
		
		
		enter.setBounds(260, 370, 280, 40);
		enter.setBackground(new Color(127,255,170));
		enter.setFont(new Font("Arial", Font.BOLD, 30));
		enter.setBorder(BorderFactory.createLineBorder(Color.blue, 4, true));
		this.add(enter);
		
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		enter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Cover.this.dispose();
				new Search_GUI();
			}
		});
	}
	
	public static void main(String[] args) {
		new Cover();

	}

}
