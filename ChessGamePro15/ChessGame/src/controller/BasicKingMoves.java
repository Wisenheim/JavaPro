package controller;

import model.Chessboard;

public class BasicKingMoves extends BasicMoves {

	public BasicKingMoves(int x, int y, Chessboard board) {
		super(x, y, board);
	
	}
	
	//crea le mosse base del re e se non sono fuori dalla scacchiera le aggiunge
	@Override
	public void fillTheVector(int x, int y, Chessboard board) {
		Move[] kingMoves = {
							new Move(x, y, x - 1, y), new Move(x, y, x - 1, y + 1),
							new Move(x, y, x - 1, y - 1), new Move(x, y, x, y + 1),
							new Move(x, y, x, y - 1), new Move(x, y, x + 1, y - 1),
							new Move(x, y, x + 1, y), new Move(x, y, x + 1, y + 1)};
		for (Move kingMove:kingMoves)
				if(isValid(kingMove, board))
						possibleMoves.add(kingMove);
	}

	@Override
	public boolean isValid(Move move, Chessboard board) {
		
		return !isOutOfTheBoard(move);
	}	

}
