import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	
	public final int PLACEHOLDER_SIZE = 100, GAP = 4;
	
	private int panelSize = PLACEHOLDER_SIZE * GameModel.BOARD_SIZE + GAP * (GameModel.BOARD_SIZE - 1);
	
	private Mark[][] boardRef;
	
	public GamePanel(Mark[][] boardRef, MouseListener mouseListener) {
		
		setPreferredSize(new Dimension(panelSize, panelSize));
		setLayout(new GridLayout(GameModel.BOARD_SIZE, GameModel.BOARD_SIZE, GAP, GAP));
		addMouseListener(mouseListener);
		
		this.boardRef = boardRef;
		
		setupPanel();
	}
	
	public void paintComponent(Graphics page) {
		
		super.paintComponent(page);
		
		removeAll();
		
		setupPanel();
		
		revalidate();
	}
	
	public void updateBoardRef(Mark[][] boardRef) {
		this.boardRef = boardRef;
	}
	
	private void setupPanel() {
		
		for (int i = 0; i < GameModel.BOARD_SIZE; i++) {
			for (int j = 0; j < GameModel.BOARD_SIZE; j++) {
				
				if (boardRef[i][j] == null) {
					add(new EmptyPanel());
				} 
				else if (boardRef[i][j].isXMark()) {
					add(new XMarkPanel());
				}
				else {
					add(new OMarkPanel());
				}
			}
		}
	}
}