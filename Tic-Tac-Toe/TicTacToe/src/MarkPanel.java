/**
 * @author Olivier Laforest
 * @date February 12th, 2015
 * 
 * MarkPanel class displays the individual marks on the game board.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MarkPanel extends JPanel {
	
	private enum PanelStatus {empty, X, O}
	PanelStatus panelStatus;
	
	// X and y coordinate required to draw the 'X's.
	private int[] xPosXMark = {5, 10, 50, 90, 95, 55, 95, 90, 50, 10, 5, 45};
	private int[] yPosXMark = {10, 5, 45, 5, 10, 50, 90, 95, 55, 95, 90, 50}; 
	
	public MarkPanel() {
		
		panelStatus = PanelStatus.empty;
		
		setPreferredSize(new Dimension(100, 100));
		setBackground(Color.gray);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics page) {
		
		super.paintComponent(page);
		
		if (panelStatus == PanelStatus.X) {
			
			// Draws the 'X's.
			page.setColor(Color.lightGray);
			page.fillPolygon(xPosXMark, yPosXMark, xPosXMark.length);
		}
		else if (panelStatus == PanelStatus.O) {
			
			// Draws the 'O's.
			page.setColor(Color.lightGray);
			page.fillOval(4, 4, 90, 90);
			
			page.setColor(Color.gray);
			page.fillOval(11, 11, 76, 76);
		}
	}
	
	/**
	 * Sets the mark panel to an 'X'.
	 */
	public void setPanelStatusToX() {
		panelStatus = PanelStatus.X;
	}
	
	/**
	 * Sets the mark panel to an 'O'.
	 */
	public void setPanelStatusToO() {
		panelStatus = PanelStatus.O;
	}
}
