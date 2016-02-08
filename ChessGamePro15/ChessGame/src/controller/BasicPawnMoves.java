package controller;

import model.Chessboard;
import model.Pawn;
import model.Pawns;
import model.Queen;

public class BasicPawnMoves extends BasicMoves {

	public BasicPawnMoves(int x, int y, Chessboard board) {
		super(x, y, board);
	}

	@Override
	public void fillTheVector(int x, int y, Chessboard board) {
		
		Pawn p = (Pawn) board.getPawn(x, y);
		Move m1 = new Move(x,y,x + (1 * p.getForward()),y);
		Move m2 = new Move(x,y,x + (1 * p.getForward()),y + 1);
		Move m3 = new Move(x,y,x + (1 * p.getForward()),y - 1);
		Move m4 = null;
		if(x == 7 || x == 0)
			board.changePawnTo(x, y, new Queen(p.getcolor()));
		if(x == 6 || x == 1)
			m4 = new Move(x,y,x + (2 * p.getForward()),y);
		
		if (isValid(m1,board))
			possibleMoves.add(m1);
		if (isValid(m2,board))
			possibleMoves.add(m2);
		if (isValid(m3,board))
			possibleMoves.add(m3);
		//qui dobbiamo verificare che non c'è un pezzo d'avanti la pedina
		//cosi non diamo una mossa che salta la pedina 
			if (m4 != null && isValid(m4,board)){
				Pawns pawn = board.getPawn(m4.getOldX() + p.getForward() , m4.getOldY());
				if (pawn == null)
					possibleMoves.add(m4);
			}
	}

	@Override
	public boolean isValid(Move move, Chessboard board) {
		return !isOutOfTheBoard(move);
	}	
}
