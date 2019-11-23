package game;

public class Model {
	private int size;
	private int score;
	private int[][] board;


	/**
	 * Movement directions
	 */
	public enum Direction {
		NORTH, SOUTH, EAST, WEST
	}


	/**
	 * Constructor sets up a new game
	 * @param size
	 */
	public Model(int size) {
		this.size = size;
		reset();
	}


	/**
	 * Gets the size of the game (width)
	 */
	public int getSize() {
		return size;
	}


	/**
	 * Gets the current game score
	 */
	public int getScore() {
		return score;
	}
	
	
	/**
	 * Gets the value at a certain board position (row, column)
	 */
	public int getTile(int r, int c) {
		return board[r][c];
	}


	/**
	 * Returns true if the game is over (i.e. no more moves can be made)
	 */
	public boolean isOver() {
		return (
			!canMove(Direction.WEST) &&
			!canMove(Direction.EAST) &&
			!canMove(Direction.NORTH) &&
			!canMove(Direction.SOUTH)
		);
	}


	/**
	 * Resets the game
	 */
	public void reset() {
		score = 0;
		board = new int[size][size];
		addRandomTile();
		addRandomTile();
	}


	/**
	 * Returns true if a move can be made in a given direction
	 */
	public boolean canMove(Direction dir) {
		boolean answer;
		switch (dir) {
		case NORTH:
			flipNW();
			answer = canMoveWest();
			flipNW();
			break;
		case SOUTH:
			flipNW();
			flipEW();
			answer = canMoveWest();
			flipEW();
			flipNW();
			break;
		case EAST:
			flipEW();
			answer = canMoveWest();
			flipEW();
			break;
		case WEST:
			answer = canMoveWest();
			break;
		default:
			throw new RuntimeException("Unreachable code");
		}
		return answer;
	}


	/**
	 * Attempts to move the board in a given direction
	 */
	public void move(Direction dir) {
		switch (dir) {
		case NORTH:
			flipNW();
			moveWest();
			flipNW();
			break;
		case SOUTH:
			flipNW();
			flipEW();
			moveWest();
			flipEW();
			flipNW();
			break;
		case EAST:
			flipEW();
			moveWest();
			flipEW();
			break;
		case WEST:
			moveWest();
			break;
		}
	}


	/**
	 * Adds a tile randomly somewhere on the board
	 */
	public void addRandomTile() {
		while (!isFull()) {
			int r = (int) (Math.random() * size);
			int c = (int) (Math.random() * size);
			if (board[r][c] == 0) {
				int value = (Math.random() < 0.9) ? 2 : 4;
				board[r][c] = value;
				return;
			}
		}
	}


	/**
	 * Moves the board west
	 */
	private void moveWest() {
		for (int[] row : board) {
			int i = 0;
			for (int j = 1; j < size; j++) {
				if (row[j] > 0) {
					if (row[i] == row[j]) { // Collapse
						row[i] = row[i] * 2;
						row[j] = 0;
						score += row[i];
						i++;
					} else if (row[i] == 0) { // Move into position i
						row[i] = row[j];
						row[j] = 0;
					} else if (row[i + 1] == 0) { // Move into position i+1
						i++;
						row[i] = row[j];
						row[j] = 0;
					} else {
						i++;
					}
				}
			}
		}
	}


	/**
	 * Transposes the board matrix (interchanges north and west)
	 */
	private void flipNW() {
		for (int r = 0; r < size; r++) {
			for (int c = r+1; c < size; c++) {
				int tmp = board[r][c];
				board[r][c] = board[c][r];
				board[c][r] = tmp;
			}
		}
	}


	/**
	 * Flips the board matrix about the y-axis (interchanges east and west)
	 */
	private void flipEW() {
		for (int[] row : board) {
			for (int c = 0; c < size/2; c++) {
				int tmp = row[c];
				row[c] = row[size-c-1];
				row[size-c-1] = tmp;
			}
		}
	}


	/**
	 * Returns true if the game board is full
	 */
	private boolean isFull() {
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (board[r][c] == 0) {
					return false;
				}
			}
		}
		return true;
	}


	/**
	 * Returns true if the board can be moved west
	 */
	private boolean canMoveWest() {
		for (int[] row : board) {
			boolean hasBlank = false;
			for (int c = 0; c < size-1; c++) {
				if (row[c] == 0) {
					hasBlank = true;
				} else if (hasBlank || row[c] == row[c+1]) {
					return true;
				}
			}
			if (hasBlank && row[size-1] > 0) {
				return true;
			}
		}
		return false;
	}
}
