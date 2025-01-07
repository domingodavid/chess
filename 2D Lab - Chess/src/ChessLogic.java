
public class ChessLogic {

	private Tile[][] board;

	public ChessLogic() {
		board = new Tile[8][8];
		for(int i =0; i < board.length;i++) {
			for(int j = 0; j < board[0].length;j++) {
				board[i][j].setPiece( new Piece((i+j)%2==0, i, j));
			}
		}	
	}
	
	/* Swap the location of the two pieces, a and b, in the board*/
	public void swap(Piece a, Piece b) {
		
	}

	public Tile[][] getBoard() {
		// TODO Auto-generated method stub
		return board;
	}	
	
}
