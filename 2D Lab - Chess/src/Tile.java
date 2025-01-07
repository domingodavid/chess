import javax.swing.JButton;

public class Tile extends JButton{
	private Piece piece;

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public Piece getPiece() {
		return piece;
	}
	
}
