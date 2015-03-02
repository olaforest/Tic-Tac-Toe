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
	
	public void setText(boolean isXPlayersTurn) {
		
		if (isXPlayersTurn) {
			statusLabel.setText("'X' Player's Turn");
		} else {
			statusLabel.setText("'O' Player's Turn");
		}
	}
}
