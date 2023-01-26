import java.awt.Color;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Piece extends JButton{

	// position of a Piece in the 8x8 board
	private int row;
	private int col;
	private boolean color; 
	private static int num = 0;
	private ImageIcon icon;
	private Color black =  Color.decode("#62cbe7");
	private Color white = Color.decode("#104373");

	public Piece(boolean color) {
		//this.setBorderPainted(false);
		this.setFocusPainted(false);
 		setOpaque(true);
		icon = new ImageIcon(num%2 ==1 ? "imgs/w_pawn.png" : "imgs/b_rook.png");

		setBackground( color ? black : white);

		Image img = ((ImageIcon) icon).getImage() ; 
		Image newimg = img.getScaledInstance( 30, 70,  java.awt.Image.SCALE_SMOOTH) ;
		
		icon = new ImageIcon( newimg );
		setIcon(icon);
		
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

	}

	/*
	 * Return a 2D array of booleans indicating where on the board a particular
	 * piece can go
	 */
	public boolean[][] moves(Piece[][] board) {
		return new boolean[][] {};
	}

}
