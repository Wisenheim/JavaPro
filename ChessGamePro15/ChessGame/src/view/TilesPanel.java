package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.AdvancedMovesGenerator;
import controller.IsCheckMate;
import controller.IsKingUnderCheck;
import controller.Move;
import model.Chessboard;
import model.King;
import model.Knight;
import model.Pawn;
import model.Pawns;
import model.Queen;
import model.Rook;



public class TilesPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private final JButton [][] buttons = new JButton[8][8]; 
	private final Chessboard board;
	private String turn;
	private final Game owner;
	
	private final static ImageIcon blackPawnImg = new ImageIcon("resources/bp.gif");
	private final static ImageIcon blackRookImg = new ImageIcon("resources/br.gif");
	private final static ImageIcon blackKingImg = new ImageIcon("resources/bk.gif");
	private final static ImageIcon blackQueenImg = new ImageIcon("resources/bq.gif");
	private final static ImageIcon blackBishopImg = new ImageIcon("resources/bb.gif");
	private final static ImageIcon blackKnightImg = new ImageIcon("resources/bn.gif");
	private final static ImageIcon whitePawnImg = new ImageIcon("resources/wp.gif");
	private final static ImageIcon whiteRookImg = new ImageIcon("resources/wr.gif");
	private final static ImageIcon whiteKingImg = new ImageIcon("resources/wk.gif");
	private final static ImageIcon whiteQueenImg = new ImageIcon("resources/wq.gif");
	private final static ImageIcon whiteBishopImg = new ImageIcon("resources/wb.gif");
	private final static ImageIcon whiteKnightImg = new ImageIcon("resources/wn.gif");

	
	public TilesPanel(Chessboard board, String startingColor, Game owner){
		this.board = board;
		this.owner = owner;
		this.turn = startingColor;
		createButtons();
	}
	private void createButtons() {
		setLayout(new GridLayout(8,8));
		for(int x = 0; x < 8; x++)
			for(int y = 0; y < 8; y++){
				buttons[x][y] = mkButton(x,y,board.getPawn(x, y));
				add(buttons[x][y]);
			}
	}
	
	private JButton mkButton(final int x, final int y, final Pawns pawn) {
		JButton button = new JButton();
		button.setBackground((x + y) % 2 == 1 ? Color.BLACK : Color.WHITE);
		button.setContentAreaFilled(false);
		button.setOpaque(true);
		button.setIcon(selectIcon(pawn));
		button.addActionListener(event -> {
			focusOnDestination(x,y,pawn);
		});
		return button;
	}
	private void focusOnDestination(int x, int y, final Pawns pawn) {
		IsKingUnderCheck kingUnderCheck = new IsKingUnderCheck("black",board);
			if(pawn == null ||!pawn.getcolor().equals(turn))
					return;
			Move[] moves = new AdvancedMovesGenerator(x,y,board).getMoves();
			onConfigurationChange();
			for(Move move : moves){
				int destX = move.getX();
				int destY = move.getY();
				buttons[destX][destY].setBackground(Color.BLUE);
				for(ActionListener al : buttons[destX][destY].getActionListeners())
							buttons[destX][destY].removeActionListener(al);
				buttons[destX][destY].addActionListener(event -> {
					move.execute(board);
					if(pawn instanceof Pawn && (move.getX() == 7 || move.getX() == 0))
						board.changePawnTo(move.getX(), move.getY(), new Queen(pawn.getcolor()));
					if(kingUnderCheck.isCheckMove(move))
						buttons[move.getOldX()][move.getOldY()].setBackground(Color.RED);
					turn = turn.equals("white") ? "black" : "white";
					onConfigurationChange();
					if(isGameOver())
						new GameOverDialog(owner).setVisible(true);
					
				});
			}
	}
	private Icon selectIcon(Pawns pawn) {
		if(pawn == null)
			return null;
		if(pawn instanceof Pawn)
			return pawn.getcolor().equals("white") ? whitePawnImg : blackPawnImg;
		if(pawn instanceof Rook)
			return pawn.getcolor().equals("white") ? whiteRookImg : blackRookImg;
		if(pawn instanceof King)
			return pawn.getcolor().equals("white") ? whiteKingImg : blackKingImg;
		if(pawn instanceof Queen)
			return pawn.getcolor().equals("white") ? whiteQueenImg : blackQueenImg;
		if(pawn instanceof Knight)
			return pawn.getcolor().equals("white") ? whiteKnightImg : blackKnightImg;
		return pawn.getcolor().equals("white") ? whiteBishopImg : blackBishopImg;
	}
	
	public void onConfigurationChange(){
		System.out.println(board);
		for(int x = 0; x < 8; x++)
			for(int y = 0; y < 8; y++){
				buttons[x][y].setBackground((x + y) % 2 == 1 ? Color.BLACK : Color.WHITE);
				buttons[x][y].setIcon(selectIcon(board.getPawn(x, y)));
				warnMyKing(board, turn = turn.equals("white") ? "black" : "white");
				for(ActionListener al : buttons[x][y].getActionListeners())
					buttons[x][y].removeActionListener(al);
				final int finalX = x;
				final int finalY = y;
				buttons[x][y].addActionListener(event -> {
					focusOnDestination(finalX , finalY,board.getPawn(finalX, finalY));
					
				});
			}
	}
	
	public String getTurn(){
		return turn;
	}
	
	public boolean isGameOver(){
		return new IsCheckMate(turn,board).isCheck();
	}
	
	public void warnMyKing(Chessboard board, String color){
		IsKingUnderCheck kingUnderCheck = new IsKingUnderCheck(color,board);
		if(kingUnderCheck.isCheck()){
			Move checkMove = kingUnderCheck.getCheckMove();
			buttons[checkMove.getOldX()][checkMove.getOldY()].setBackground(Color.RED);
			buttons[kingUnderCheck.getKingX()][kingUnderCheck.getKingY()].setBackground(Color.RED);
		}
	}
}
