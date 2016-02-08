package controller;

import model.Chessboard;

public class BasicBishopMoves extends BasicMoves {

	public BasicBishopMoves(int x, int y, Chessboard board) {
		super(x, y, board);
		
	}

	@Override
	public void fillTheVector(int x, int y, Chessboard board) {
		moveUpRight(x, y, x, y, board, false);
		moveDownRight(x , y, x, y, board, false);
		moveUpLeft(x , y, x, y, board, false);
		moveDownLeft(x, y, x, y, board, false);
	}

	/*crea una nuova mossa verso basso_sinistra e verifica se non è fuori la scacchiera 
	 aggiunge la mossa al vettore e richiama ricorsivamente sulla nuova posizione */
	private void moveDownLeft(int oldx, int oldy, int x, int y, Chessboard board,
							  boolean oppenentOvercome) {
		Move downLeftMove = new Move(oldx, oldy, x + 1, y - 1);
		if (!isValid(downLeftMove,board))
			return;
		if(!oppenentOvercome){
			possibleMoves.add(downLeftMove);
			moveDownLeft(oldx, oldy, x + 1, y - 1, board, downLeftMove.isOppenent(board));
		}
	}
	
	private void moveUpLeft(int oldx, int oldy, int x, int y, Chessboard board,
			  				boolean oppenentOvercome) {
		Move upLeftMove = new Move(oldx, oldy, x - 1, y - 1);
		if (!isValid(upLeftMove, board))
			return;
		if(!oppenentOvercome){
			possibleMoves.add(upLeftMove);
			moveUpLeft(oldx, oldy, x - 1, y - 1, board, upLeftMove.isOppenent(board));
		}
	}

	private void moveDownRight(int oldx, int oldy, int x, int y, Chessboard board,
			  				   boolean oppenentOvercome) {
		Move downRightMove = new Move(oldx, oldy, x + 1, y + 1);
		if (!isValid(downRightMove, board))
			return;
		if(!oppenentOvercome){
			possibleMoves.add(downRightMove);
			moveDownRight(oldx, oldy, x + 1, y + 1, board, downRightMove.isOppenent(board));
		}
	}

	private void moveUpRight(int oldx, int oldy, int x, int y, Chessboard board,
			  				 boolean oppenentOvercome) {
		Move upRightMove = new Move(oldx, oldy, x - 1, y + 1);
		if (!isValid(upRightMove, board))
			return;
		if(!oppenentOvercome){
			possibleMoves.add(upRightMove);
			moveUpRight(oldx, oldy, x - 1, y + 1, board, upRightMove.isOppenent(board));
		}
	}

	@Override
	public boolean isValid(Move move, Chessboard board) {
		
		return !isOutOfTheBoard(move);
	}

}
