
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class Board extends JPanel implements MouseListener, ActionListener{
	
	private boolean firstClick = false;
	private Piece firstClickPiece = null;
	private ChessLogic chessLogic = new ChessLogic();
	
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
//		board = new Piece[8][8];	
		setup();
		
	}

	public void setup() {
		frame.setSize(800, 800);

		

		setupBoard();
		addMenus();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);		
		frame.getContentPane().setCursor(new Cursor(Cursor.HAND_CURSOR));

 
		frame.setVisible(true);		
	}
	
	public void setupBoard() {
		JPanel jp = new JPanel();

		GridLayout g = new GridLayout(8,8);
		jp.setLayout(g);	


		Tile[][] board = chessLogic.getBoard();
		for(int i =0; i < board.length;i++) {
			for(int j = 0; j < board[0].length;j++) {
				jp.add(board[i][j]);
				board[i][j].addMouseListener(this);
			}
		}
		
		
		frame.add(jp);
	}
	
	
	public void addMenus() {
		//Where the GUI is created:
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;
		JRadioButtonMenuItem rbMenuItem;
		JCheckBoxMenuItem cbMenuItem;

		//Create the menu bar.
		menuBar = new JMenuBar();

		//Build the first menu.
		menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		menuBar.add(menu);

		//a group of JMenuItems
		menuItem = new JMenuItem("A text-only menu item",
		                         KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
		        "This doesn't really do anything");
		menu.add(menuItem);

		menuItem = new JMenuItem("Both text and icon",
		                         new ImageIcon("images/middle.gif"));
		menuItem.setMnemonic(KeyEvent.VK_B);
		menu.add(menuItem);

		menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
		menuItem.setMnemonic(KeyEvent.VK_D);
		menu.add(menuItem);

		//a group of radio button menu items
		menu.addSeparator();
		ButtonGroup group = new ButtonGroup();
		rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
		rbMenuItem.setSelected(true);
		rbMenuItem.setMnemonic(KeyEvent.VK_R);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Another one");
		rbMenuItem.setMnemonic(KeyEvent.VK_O);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);

		//a group of check box menu items
		menu.addSeparator();
		cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
		cbMenuItem.setMnemonic(KeyEvent.VK_C);
		menu.add(cbMenuItem);

		cbMenuItem = new JCheckBoxMenuItem("Another one");
		cbMenuItem.setMnemonic(KeyEvent.VK_H);
		menu.add(cbMenuItem);

		//a submenu
		menu.addSeparator();
		submenu = new JMenu("A submenu");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("An item in the submenu");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_2, ActionEvent.ALT_MASK));
		submenu.add(menuItem);

		menuItem = new JMenuItem("Another item");
		submenu.add(menuItem);
		menu.add(submenu);

		//Build second menu in the menu bar.
		menu = new JMenu("Another Menu");
		menu.setMnemonic(KeyEvent.VK_N);
		menu.getAccessibleContext().setAccessibleDescription(
		        "This menu does nothing");
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);

	}
	
	


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
 		
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (!firstClick) {
			firstClickPiece = (Piece) e.getComponent();
			firstClickPiece.setBorder(BorderFactory.createLineBorder(Color.green));
			firstClickPiece.setBorderPainted(true);
			
			Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
					((ImageIcon) ((Piece) e.getComponent()).getIcon()).getImage(), new Point(0, 0), "blank cursor");
			frame.getContentPane().setCursor(blankCursor);

		} else {
			System.out.println("swap");
			Piece curr = (Piece) e.getComponent();
			curr.setBorder(BorderFactory.createLineBorder(Color.green));
			Icon currIcon = curr.getIcon();
			Icon firstIcon = firstClickPiece.getIcon();
			curr.setIcon(firstIcon);
			firstClickPiece.setIcon(currIcon);
			firstClickPiece.setBorderPainted(false);
			frame.getContentPane().setCursor(new Cursor(Cursor.HAND_CURSOR));

			
 		}

		firstClick = !firstClick;

		
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
