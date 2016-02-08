package controller;

import model.Chessboard;
import model.King;
import model.Pawns;

public class IsKingUnderCheck {
	protected boolean check;
	private int kingX, kingY;
	private Move checkMove;
	
	public IsKingUnderCheck(String color, Chessboard board){
		findKing(color, board);
		String otherColor = 
						(board.getColor1().equals(color)) ? board.getColor2():board.getColor1();
		PawnsIterator it = new PawnsIterator(board, otherColor);
		while(it.hasNext()){
			it.next();
			if(isCheckingTheKing(it.getX(), it.getY(), board)){
				check = true;
				return;
			}
		}
		check = false;
	}
	
	//torna true se è scacco altrimento false
	public boolean isCheck(){
		return check;
	}
	
	//trova il re e mette la posizione del re dentro kingX e kingY
	public void findKing(String color, Chessboard board){
		PawnsIterator it = new PawnsIterator(board, color);
		while(it.hasNext()){
			Pawns p = it.next();
			if (p instanceof King){
				this.kingX = it.getX();
				this.kingY = it.getY();
				return;
			}
		}	
		throw new IllegalStateException("Il Re di colore " + color + " non è stato trovato");
	}
	
	//crea tutte le mosse della pedina la quale si trova a x,y e verifica se fa scacco
	public boolean isCheckingTheKing(int x, int y, Chessboard board){
		MediumMovesGenerator generator = new MediumMovesGenerator(x,y,board);
		Move[] moves = generator.getMoves();
		for (Move move:moves)
			if(isCheckMove(move)){
				this.checkMove = move;
				return true;
			}
		return false;
	}
	
	//torna true se la mossa corrente attacca il re
	public boolean isCheckMove(Move move){
		return move.getX() == kingX && move.getY() == kingY;
	}
	
	public int getKingX(){
		return kingX;
	}
	
	public int getKingY(){
		return kingY;
	}
	
	public Move getCheckMove(){
			return checkMove;
	}
}
