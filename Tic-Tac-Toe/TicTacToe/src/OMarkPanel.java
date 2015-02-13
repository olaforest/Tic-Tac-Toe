import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class OMarkPanel extends JPanel {
	
	public OMarkPanel() {
		setPreferredSize(new Dimension(100, 100));
		setBackground(Color.gray);
	}
	
	public void paintComponent(Graphics page) {
		
		super.paintComponent(page);
		
		page.setColor(Color.lightGray);
		page.fillOval(4, 4, 90, 90);
		
		page.setColor(Color.gray);
		page.fillOval(11, 11, 76, 76);
	}
}
