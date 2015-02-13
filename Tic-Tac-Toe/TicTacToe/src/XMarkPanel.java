import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class XMarkPanel extends JPanel {
	
	private int[] xPosXMark = {5, 10, 50, 90, 95, 55, 95, 90, 50, 10, 5, 45};
	private int[] yPosXMark = {10, 5, 45, 5, 10, 50, 90, 95, 55, 95, 90, 50}; 
	
	public XMarkPanel() {
		setPreferredSize(new Dimension(100, 100));
		setBackground(Color.gray);
	}
	
	public void paintComponent(Graphics page) {
		
		super.paintComponent(page);
		
		page.setColor(Color.lightGray);
		page.fillPolygon(xPosXMark, yPosXMark, xPosXMark.length);
	}
}