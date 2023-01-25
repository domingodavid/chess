
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements MouseListener, ActionListener{
	
	private Piece[][] board;
	private boolean firstClick = false;
	private Piece firstClickPiece = null;
	JFrame frame;

	/* Initialize the 8x8 board with pieces
	 * The top 2 rows should have the black pieces
	 * The bottom 2 rows should have the white pieces
	 * 
	 * Please see https://en.wikipedia.org/wiki/Chess
	 * for the starting board positions and the rules of the game
	 * 
	 */
	public Board() {
		frame = new JFrame("Chess");
		board = new Piece[8][8];
		
		for(int i =0; i < board.length;i++) {
			for(int j = 0; j < board[0].length;j++) {
				board[i][j] = new Piece((i+j)%2==0);
				board[i][j].addMouseListener(this);
			}
		}		
		setup();
		
	}

	public void setup() {
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JPanel jp = new JPanel();

		
		for(int i =0; i < board.length;i++) {
			for(int j = 0; j < board[0].length;j++) {
				frame.add(board[i][j]);
			}
		}

		GridLayout g = new GridLayout(9,8);
		frame.setLayout(g);		frame.add(this);

		frame.getContentPane().setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		Timer t = new Timer(16, this);
		t.start();
		frame.setVisible(true);		
	}
	
	/* Swap the location of the two pieces, a and b, in the board*/
	public void swap(Piece a, Piece b) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
 		
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
 		// TODO Auto-generated method stub
		if(!firstClick) {
			firstClickPiece = (Piece) e.getComponent();
			firstClickPiece.setBorder(BorderFactory.createLineBorder(Color.green));
		}else {
			System.out.println("swap");
			
			Piece curr = (Piece) e.getComponent();
			
			firstClickPiece.setIcon(null);
			
			Icon currIcon = curr.getIcon();
			Icon firstIcon = firstClickPiece.getIcon();
			curr.setIcon(firstIcon);
			firstClickPiece.setIcon(currIcon);
			
		}
		firstClick = !firstClick;
		
			 if(((ImageIcon) ((Piece) e.getComponent()).getIcon()!=null)){
			Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
					((ImageIcon) ((Piece)e.getComponent()).getIcon()).getImage(), new Point(0, 0), "blank cursor");
				frame.getContentPane().setCursor(blankCursor);
			 }else{
				 
				   frame.getContentPane().setCursor(new Cursor(Cursor.HAND_CURSOR));    
			 }
		
	}
	
	
	
	public void paint(Graphics g) {
		System.out.println("paint");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
 	}


}
