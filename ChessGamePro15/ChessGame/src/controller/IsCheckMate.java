package controller;

import model.Chessboard;

public class IsCheckMate extends IsKingUnderCheck {

	public IsCheckMate(String color, Chessboard board) {
		super(color, board);
		if(isCheck() && cannotMove(color, board))
			check = true;
		else
			check = false;
	}
	
	//ritorna true se nessuna pedina di colore "Color" puo togliere lo scacco
	public boolean cannotMove(String color, Chessboard board){
		PawnsIterator it = new PawnsIterator(board,color);
		while(it.hasNext()){
			it.next();
			Move[] moves = new AdvancedMovesGenerator(it.getX(), it.getY(), board).getMoves();
			if(moves.length != 0)
				return false;
		}	
		return true;
	}
}
//old exectue
/*Pawns p = board.getPawn(oldx, oldy);
board.changePawnTo(x, y, p);
board.removePawn(oldx, oldy);
*/

// new excute
/*Pawns p = board.getPawn(oldx, oldy);
		if(!(p instanceof Pawn))
			board.changePawnTo(x, y, p);
		if(p.getcolor().equals("black") && x == 7)
			board.changePawnTo(x, y, new Queen(p.getcolor()));
		if(p.getcolor().equals("white") && x == 0)
			board.changePawnTo(x, y, new Queen(p.getcolor()));
		board.removePawn(oldx, oldy);*/