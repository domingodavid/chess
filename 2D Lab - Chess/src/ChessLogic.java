
public class ChessLogic {
	
	
	private Tile[][] board;
	boolean playerTurn = true; //true = white, false = black
	
	/*
	 * The constructor setups up the 2D array of Tiles for the chess board
	 * The constructor calls 3 helper methods with add chess pieces on the board
	 * A tile in the board either have a piece or not have a piece
	 */
	public ChessLogic() {
		board = new Tile[8][8];
		
		for(int i =0; i < board.length;i++) {
			for(int j = 0; j < board[0].length;j++) {
				board[i][j] = new Tile(i, j);
			}
		}	
		
		//setup pawns
		addPawns();
		
		//setup other pieces
		setupPieces(COLOR.BLACK);
		setupPieces(COLOR.WHITE);
	}
	
	public void setupPieces(COLOR color) {
		
		String prefix = color == COLOR.BLACK ? "b_" : "w_";
		
		
		//Queen & King
		board[color == COLOR.BLACK? 0 : board.length-1][3].setPiece(new Queen(prefix+"_queen.png", color,board.length-2,3, board ));
		board[color == COLOR.BLACK? 0 : board.length-1][4].setPiece(new King(prefix+"_king.png", color,board.length-2,3, board ));

		//Bishops
		board[color == COLOR.BLACK? 0 : board.length-1][2].setPiece(new Bishop(prefix+"_bishop.png", color,board.length-2,3, board));
		board[color == COLOR.BLACK? 0 : board.length-1][5].setPiece(new Bishop(prefix+"_bishop.png", color,board.length-2,3, board ));

		//Knights
		board[color == COLOR.BLACK? 0 : board.length-1][1].setPiece(new Knight(prefix+"_knight.png", color,board.length-2,3, board ));
		board[color == COLOR.BLACK? 0 : board.length-1][6].setPiece(new Knight(prefix+"_knight.png", color,board.length-2,3, board ));

		//Rooks
		board[color == COLOR.BLACK? 0 : board.length-1][0].setPiece(new Rook(prefix+"_rook.png", color,board.length-2,3, board ));
		board[color == COLOR.BLACK? 0 : board.length-1][7].setPiece(new Rook(prefix+"_rook.png", color,board.length-2,3, board ));

	}
	
	public void addPawns() {
		
		for(int c = 0; c < board[0].length; c++) {
			board[1][c].setPiece( new Pawn("b_pawn.png", COLOR.BLACK, 1, c, board) );
		}
		
		for(int c = 0; c < board[0].length; c++) {
			board[board.length-2][c].setPiece(new Pawn("w_pawn.png", COLOR.WHITE, board.length-2, c, board));
		}

	}
	
	/*
	 * return true if any King is in check
	 */
	public boolean check() {
		return false;
		
	}
	
	
	/*
	 * Getter for board
	 */
	public Tile[][] getBoard() {
		return this.board;
	}	
	
	
	
}
