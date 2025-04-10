
public class Bishop extends Piece{
	
	public Bishop(String fileName, COLOR color, int row, int col, Tile[][] board) 
	{
		super(fileName.contains("b_") ? "b_bishop.png" : "w_bishop.png", color, row, col, board);	
	}
	

	  /*
     * Determines if a pawn can move from the "from" tile to the "to" tile.
     * 
     * This method will return true if the pawn can legally move based on the rules of chess 
     * (e.g., moving one square forward, or two squares forward from its starting position,
     * and ensuring it is not attempting an illegal move such as moving diagonally unless 
     * capturing an opponent's piece).
     * 
     * For now, this is a placeholder implementation that always returns false.
     * 
     * @param from The tile from which the pawn is attempting to move.
     * @param to The tile to which the pawn is attempting to move.
     * @return false (default implementation).
     */
	public boolean validMove(Tile from, Tile to) {
		return false;
	}

	/*
	 * Return a 2D array of booleans indicating where on the board a particular
	 * piece can go
	 */
	public boolean[][] moves(Tile[][] board) {
		
		//You must use the validMove helper method here
		return null;
		
	}
}
