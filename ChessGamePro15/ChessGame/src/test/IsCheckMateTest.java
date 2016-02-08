package test;

import static org.junit.Assert.*;
import model.Chessboard;

import org.junit.Test;


import controller.AdvancedMovesGenerator;
//import controller.AdvancedMovesGenerator;
import controller.IsCheckMate;
import controller.Move;

public class IsCheckMateTest {
	
	
	//crea la scacchiera e mette qualche mosse di un scacco matto e verifica se un scacco matto
	@Test
	public void checkMateTest() {
		Chessboard board = new Chessboard("black","white");
		System.out.println(board);
		Move whiteMove1 = new Move(6,4,5,4);
		Move blackMove1 = new Move(1,1,2,1);
		Move whiteMove2 = new Move(7,5,4,2);
		Move blackMove2 = new Move(0,1,2,2);
		Move whiteMove3 = new Move(7,3,5,5);
		Move blackMove3 = new Move(1,6,3,6);
		Move checkMateMoveWhiteQueen = new Move(5,5,1,5);
		whiteMove1.execute(board);
		System.out.println(board);
		blackMove1.execute(board);
		System.out.println(board);
		whiteMove2.execute(board);
		System.out.println(board);
		blackMove2.execute(board);
		System.out.println(board);
		whiteMove3.execute(board);
		System.out.println(board);
		blackMove3.execute(board);
		System.out.println(board);
		checkMateMoveWhiteQueen.execute(board);
		System.out.println(board);
		//ora verifichiamo se il re nero è sotto scacco matto
		IsCheckMate checkMate = new IsCheckMate("black",board);
		assertTrue(checkMate.isCheck());
		assertTrue(checkMate.cannotMove("black", board));
		//ora verifichiamo se il re bianco non è sotto scacco matto
		IsCheckMate checkMateWhite = new IsCheckMate("white",board);
		assertTrue(!checkMateWhite.isCheck());
		assertTrue(!checkMateWhite.cannotMove("white", board));
		Move[] kingMoves = new AdvancedMovesGenerator(0,4,board).getMoves();
		Move[] knightMoves = new AdvancedMovesGenerator(0,6,board).getMoves();
		Move[] pawnMoves = new AdvancedMovesGenerator(1,4,board).getMoves();
		assertTrue(kingMoves.length == 0);
		assertTrue(knightMoves.length == 0);
		assertTrue(pawnMoves.length == 0);
	}

}
