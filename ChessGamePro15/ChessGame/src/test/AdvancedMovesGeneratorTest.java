package test;

import static org.junit.Assert.*;
import model.Chessboard;

import org.junit.Test;

import controller.AdvancedMovesGenerator;
import controller.Move;

public class AdvancedMovesGeneratorTest {

	//crea una scacchiera e mette un esempio di scacco 
	//e verifica che le mosse della torre sono 0 , le mosse della pedina è 1
	//le mosse del re sono 6
	@Test
	public void test() {
		Chessboard board = new Chessboard("white","black");
		Move queenMove = new Move(0,3,1,4);
		Move knightMove = new Move(0,6,3,5);
		Move kingMove = new Move(7,4,5,4);
		Move pawnMove = new Move(6,6,4,6);
		Move rookMove = new Move(7,7,4,4);
		Move pawnMoveToQueen = new Move(6,0,0,0);
		queenMove.execute(board);
		knightMove.execute(board);
		kingMove.execute(board);
		pawnMove.execute(board);
		rookMove.execute(board);
		pawnMoveToQueen.execute(board);
		System.out.println(board);
		pawnMoveToQueen.execute(board);
		System.out.println(board);
		
		Move[] rookMoves = new AdvancedMovesGenerator(4,4,board).getMoves();
		Move[] pawnMoves = new AdvancedMovesGenerator(4,6,board).getMoves();
		Move[] kingMoves = new AdvancedMovesGenerator(5,4,board).getMoves();
		System.out.println("rook Moves :");
		for(Move move:rookMoves)
			System.out.println(move);
		System.out.println("King Moves :");
		for(Move move:kingMoves)
			System.out.println(move);
		System.out.println("pawn Moves :");
		for(Move move:pawnMoves)
			System.out.println(move);
		assertTrue(rookMoves.length == 0);
		//assertTrue(pawnMoves.length == 1);
		assertTrue(kingMoves.length == 3);
	}

}
