/**
 * @author Olivier Laforest
 * @date February 12th, 2015
 * 
 * StatusPanel class displays which player's turn it currently is.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class StatusPanel extends JPanel {
	
	JLabel statusLabel;
	
	public StatusPanel(boolean isXPlayersTurn) {
		
		setPreferredSize(new Dimension(300, 50));
		statusLabel = new JLabel();
		statusLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		setBackground(Color.lightGray);
		add(statusLabel);
		
		setText(isXPlayersTurn);
	}
	
	/**
	 * @param isXPlayersTurn specifies which player's turn it is.
	 */
	public void setText(boolean isXPlayersTurn) {
		
		if (isXPlayersTurn) {
			statusLabel.setText("'X' Player's Turn");
		} else {
			statusLabel.setText("'O' Player's Turn");
		}
	}
}
