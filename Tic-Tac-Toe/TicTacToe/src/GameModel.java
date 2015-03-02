/**
 * @author Olivier Laforest
 * @date February 12th, 2015
 * 
 * GameModel class which is responsible of maintaining and updating the game model state.
 */

public class GameModel {
	
	public static final int BOARD_SIZE = 3;
	
	public static enum GameStatus {ongoing, draw, xPlayerWin, oPlayerWin};
	
	private GameStatus gameStatus;
	private int playCount;
	private boolean isXPlayersTurn;
	private Mark[][] board;
	
	public GameModel() {
		
		gameStatus = GameStatus.ongoing;
		playCount = 0;

		board = new Mark[BOARD_SIZE][BOARD_SIZE];
		
		isXPlayersTurn = true;
	}
	
	/**
	 * This method places the mark (i.e. mark are 'X' or 'O') on the board where the player clicked.
	 * 
	 * @param xPos x coordinate of the mark to be placed on the board (origin is on the right side of the board)
	 * @param yPos y coordinate of the mark to be placed on the board (origin is on the top side of the board)
	 * @return returns true if the desired location of the new mark is a location that has not been used already, false otherwise.
	 */
	public boolean placeMark(int xPos, int yPos) {
		
		if (isLocationFree(xPos, yPos)) {
			
			if (isXPlayersTurn) {
				board[yPos][xPos] = new Mark(true);
				isXPlayersTurn = false;
			}
			else {
				board[yPos][xPos] = new Mark(false);
				isXPlayersTurn = true;
			}
			playCount++;
			updateGameStatus();
			return true;
		}
		return false;
	}
	
	/**
	 * @return the board containing the state of the game.
	 */
	public Mark[][] getBoard() {
		return board;
	}
	
	/**
	 * @return true if it is the turn of the player placing 'X', false it is the turn of the player placing 'O'.
	 */
	public boolean isXPlayersTurn() {
		return isXPlayersTurn;
	}
	
	/**
	 * @return the status in which the game is. There are four possible game status, either the game is ongoing,
	 * the game ended in a draw, the game ended and the player placing 'X' won or the game ended and the player 
	 * placing 'O' won.
	 */
	public int getGameStatus() {
		return gameStatus.ordinal();
	}
	
	// Verifies if the location on the grid specified by the parameters has not been marked with an 'X' or an 'O'.
	private boolean isLocationFree(int xPos, int yPos) {
		
		if (board[yPos][xPos] == null) {return true;}
		
		return false;
	}
	
	// Verifies in which of the four possible game states the game is actually in and updates the gameStatus variable.
	private void updateGameStatus() {
		
		if (checkHorizontalRunsOfThree())
			return;
		else if (checkVerticalRunsOfThree())
			return;
		else if (checkDiagonalRunsOfThree())
			return;
		
		if (playCount == 9) {
			gameStatus = GameStatus.draw;
		}
	}
	
	// Verifies if one the rows of the board has a sequence of three consecutive 'O' or three consecutive 'x',
	// and updates the game status accordingly.
	private boolean checkHorizontalRunsOfThree() {
		
		for (int i = 0; i < BOARD_SIZE; i++) {
			
			if (board[i][0] == null || board[i][1] == null || board[i][2] == null)
				continue;
			else {
				if (board[i][0].isXMark() && board[i][1].isXMark() && board[i][2].isXMark()) {
					gameStatus = GameStatus.xPlayerWin;
					return true;
				}
				else if (!board[i][0].isXMark() && !board[i][1].isXMark() && !board[i][2].isXMark()) {
					gameStatus = GameStatus.oPlayerWin;
					return true;
				}
			}
		}
		return false;
	}
	
	// Verifies if one the columns of the board has a sequence of three consecutive 'O' or three consecutive 'x',
	// and updates the game status accordingly.
	private boolean checkVerticalRunsOfThree() {
		
		for (int i = 0; i < BOARD_SIZE; i++) {
			
			if (board[0][i] == null || board[1][i] == null || board[2][i] == null)
				continue;
			else {
				if (board[0][i].isXMark() && board[1][i].isXMark() && board[2][i].isXMark()) {
					gameStatus = GameStatus.xPlayerWin;
					return true;
				}
				else if (!board[0][i].isXMark() && !board[1][i].isXMark() && !board[2][i].isXMark()) {
					gameStatus = GameStatus.oPlayerWin;
					return true;
				}
			}
		}
		return false;
	}
	
	// Verifies if one the diagonals of the board has a sequence of three consecutive 'O' or three consecutive 'x',
	// and updates the game status accordingly.
	private boolean checkDiagonalRunsOfThree() {
		
		if (board[0][0] != null && board[1][1] != null && board[2][2] != null) {
			
			if (board[0][0].isXMark() && board[1][1].isXMark() && board[2][2].isXMark()) {
				gameStatus = GameStatus.xPlayerWin;
				return true;
			}
			else if (!board[0][0].isXMark() && !board[1][1].isXMark() && !board[2][2].isXMark()) {
				gameStatus = GameStatus.oPlayerWin;
				return true;
			}
		}
		
		if (board[0][2] != null && board[1][1] != null && board[2][0] != null) {
			
			if (board[0][2].isXMark() && board[1][1].isXMark() && board[2][0].isXMark()) {
				gameStatus = GameStatus.xPlayerWin;
				return true;
			}
			else if (!board[0][2].isXMark() && !board[1][1].isXMark() && !board[2][0].isXMark()) {
				gameStatus = GameStatus.oPlayerWin;
				return true;
			}
		}
		return false;
	}
}
