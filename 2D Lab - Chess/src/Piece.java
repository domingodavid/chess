import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Piece extends JButton{

	// position of a Piece in the 8x8 board
	private int row;
	private int col;
	private boolean color; 
	private static int num = 0;
	private ImageIcon icon;
	
	//color for white and black is a differed hue
	private Color black =  Color.decode("#62cbe7");
	private Color white = Color.decode("#104373");

	public Piece(boolean color, int row, int col) {
	    this.setFocusPainted(false);
	    this.setOpaque(true); // Ensure the background is painted
	    num++;	   
		this.color = color;
		this.row = row;
		this.col = col;
		 setStyle("");
		
	}
	
	public void setStyle(String imgFile) {
	    //Icon setup
		icon = new ImageIcon(num%2 ==1 ? "imgs/w_pawn.png" : "imgs/b_rook.png");
		Image img = ((ImageIcon) icon).getImage() ; 
		Image newimg = img.getScaledInstance( 30, 70,  java.awt.Image.SCALE_FAST) ;
		icon = new ImageIcon( newimg );
		setIcon(icon);
		setBackground( color ? black : white);
		this.setBorderPainted(false);
	}
	
	public Piece(String fileName) {
		this.setFocusPainted(false);
 		setOpaque(true);
		ImageIcon icon = new ImageIcon("imgs"+fileName);

		setBackground(num++%2==0 ? Color.white : Color.black);

		Image img = ((ImageIcon) icon).getImage() ; 
		Image newimg = img.getScaledInstance( 30, 70,  java.awt.Image.SCALE_SMOOTH) ;
		
		icon = new ImageIcon( newimg );
		setIcon(icon);
	}	
	

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public Piece(String fileName, boolean color) {
		this(fileName);
		this.color = color;
	}

	/*
	 * Return a 2D array of booleans indicating where on the board a particular
	 * piece can go
	 */
	public boolean[][] moves(Piece[][] board) {
		return new boolean[][] {};
	}

}
