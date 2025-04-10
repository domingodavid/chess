

public class Pawn extends Piece{
	
	//Any needed instance variables?
	
	//constructor
	public Pawn(String fileName, COLOR color, int row, int col, Tile[][] board) {
		super(fileName.contains("b_") ? "b_pawn.png" : "w_pawn.png", color, row, col, board);
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
		return moves()[to.getRow()][to.getCol()];
	}

	/*
	 * Return a 2D array of booleans indicating where on the board a particular
	 * piece can go
	 */
	public boolean[][] moves() {
		
		boolean[][] result = new boolean[board.length][board[0].length];
		
		//
		if(this.color == COLOR.BLACK) {
			if(this.row+1<8) {
				result[row+1][this.col] = true;
			}
			if(this.row+2<8) {
				result[row+2][this.col] = true;
			}
		}
		
		
		return result;
		
	}

	@Override
	protected boolean capture(Tile t) {
		
		if(t.getPiece()!=null && t.getPiece().getColor() != this.getColor()) {
			return true;
		}
		return false;
		
		
	}
	
}
