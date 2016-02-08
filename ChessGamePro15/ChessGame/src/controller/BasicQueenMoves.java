package controller;

import model.Chessboard;

public class BasicQueenMoves extends BasicMoves {

	public BasicQueenMoves(int x, int y, Chessboard board) {
		super(x, y, board);
		
	}

	/*crea le mosse base della torre le aggiunge al vettore
	 crea le mosse base dell'alfiere le aggiunge al vettore
 	 */
	@Override
	public void fillTheVector(int x, int y, Chessboard board) {
		
		//adesso prendiamo le mosse base possibile della torre e le copiamo dentro l arraylist 
		Move[] rookMoves = getRookMoves(x,y,board);
		for(int i = 0; i < rookMoves.length; i++)
				this.possibleMoves.add(rookMoves[i]);
		//adesso prendiamo le mosse base possibile della alfiere e le copiamo dentro l arraylist
		Move[] bishopMoves = getBishopMoves(x, y, board);
		for(int i = 0; i < bishopMoves.length; i++)
				this.possibleMoves.add(bishopMoves[i]);
	}

	@Override
	public boolean isValid(Move move, Chessboard board) {
		
		return !isOutOfTheBoard(move);
	}
	
	//crea le mosse della torre e le torna
	public Move[] getRookMoves(int x, int y, Chessboard board){
		BasicMoves basicRookMoves = new BasicRookMoves(x,y,board);
		return basicRookMoves.getMoves();
	}
	
	
	//crea le mosse della alfiere e le torna
	public Move[] getBishopMoves(int x, int y, Chessboard board){
		BasicMoves basicBishopMoves = new BasicBishopMoves(x,y,board);
		return basicBishopMoves.getMoves();
	}
}
