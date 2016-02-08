package controller;

import model.Chessboard;

public class BasicRookMoves extends BasicMoves {
	
	public BasicRookMoves(int x, int y, Chessboard board) {
		super(x, y, board);
			
	}
	
	//crea le mosse base della torre
	@Override
	public void fillTheVector(int x, int y, Chessboard board) {
		
		moveUp(x,y,x,y, board, false);
		moveDown(x,y,x,y, board, false);
		moveLeft(x,y,x,y, board, false);
		moveRight(x,y,x,y, board, false);
		
	}

	/*crea una nuova mossa verso destra e verifica se non è fuori la scacchiera 
	 aggiunge la mossa al vettore e richiama ricorsivamente sulla nuova posizione */
	private void moveRight(int oldx, int oldy, int x, int y, Chessboard board,
						   boolean oppenentOvercome) {
		Move rightMove = new Move(oldx, oldy, x, y + 1);
		if (!isValid(rightMove, board))
			return;
		if(!oppenentOvercome){
			possibleMoves.add(rightMove);
			moveRight(oldx, oldy, x, y + 1, board, rightMove.isOppenent(board));
		}
	}

	private void moveLeft(int oldx, int oldy, int x, int y, Chessboard board,
			   			  boolean oppenentOvercome) {
		Move leftMove = new Move(oldx, oldy, x, y - 1);
		if (!isValid(leftMove, board))
			return;
		if(!oppenentOvercome){
			possibleMoves.add(leftMove);
			moveLeft(oldx, oldy , x, y - 1, board, leftMove.isOppenent(board));
		}
	}

	private void moveDown(int oldx, int oldy, int x, int y, Chessboard board,
			   			  boolean oppenentOvercome) {
		Move downMove = new Move(oldx, oldy, x + 1, y);
		if (!isValid(downMove, board))
			return;
		if(!oppenentOvercome){
			possibleMoves.add(downMove);
			moveDown(oldx, oldy , x + 1, y, board, downMove.isOppenent(board));
		}
	}
	
	
	private void moveUp(int oldx, int oldy, int x, int y, Chessboard board,
			   			boolean oppenentOvercome) {
		Move upMove = new Move(oldx, oldy, x - 1, y);
		if (!isValid(upMove, board))
			return;
		if(!oppenentOvercome){
			possibleMoves.add(upMove);
			moveUp(oldx, oldy, x - 1, y, board, upMove.isOppenent(board));
		}
		
	}

	@Override
	public boolean isValid(Move move, Chessboard board) {
		
		return !isOutOfTheBoard(move);
	}
}
