package controller;

import model.Chessboard;

public class BasicKnightMoves extends BasicMoves {

	public BasicKnightMoves(int x, int y, Chessboard board) {
		super(x, y, board);
		
	}
	
	//crea le mosse base del cavallo e se non sono fuori della scacchiera le aggiunge
	@Override
	public void fillTheVector(int x, int y, Chessboard board) {
		Move[] knightMoves = {
								new Move(x, y, x - 1, y + 2), new Move(x, y, x - 2, y + 1),
								new Move(x, y, x - 1, y - 2), new Move(x, y, x - 2, y - 1),
								new Move(x, y, x + 1, y - 2), new Move(x, y, x + 2, y - 1),
								new Move(x, y, x + 1, y + 2), new Move(x, y, x + 2, y + 1)};
		for (Move knightMove:knightMoves)
			if ((isValid(knightMove, board)))
				possibleMoves.add(knightMove);
	}

	@Override
	public boolean isValid(Move move, Chessboard board) {
		
		return !isOutOfTheBoard(move);
	}
	

}
