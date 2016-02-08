package controller;

import model.Chessboard;

public class MediumQueenMoves extends BasicQueenMoves {

	public MediumQueenMoves(int x, int y, Chessboard board) {
		super(x, y, board);
	}
	
	//crea le mosse medie della torre e le torna
		public Move[] getRookMoves(int x, int y, Chessboard board){
			BasicMoves mediumRookMoves = new MediumRookMoves(x,y,board);
			return mediumRookMoves.getMoves();
		}
		
		
		//crea le mosse medie dell'alfiere e le torna
		public Move[] getBishopMoves(int x, int y, Chessboard board){
			BasicMoves mediumBishopMoves = new MediumBishopMoves(x,y,board);
			return mediumBishopMoves.getMoves();
		}

}
