package test;

import static org.junit.Assert.*;
import model.Chessboard;


import org.junit.Test;
import controller.BasicMoves;

import controller.MediumPawnMoves;
import controller.Move;

public class MediumPawnMovesTest {
	
	
	
	//crea una scacchiera e crea le mosse medie di una pedina e verifica che sono 2
	@Test
	public void initialTest() {
		Chessboard board = new Chessboard("black","white");
		BasicMoves  bmBlack = new MediumPawnMoves(1,3,board);
		Move[] blackPmoves = bmBlack.getMoves();
		System.out.println("Black Moves :");
		for(int i = 0; i < blackPmoves.length; i++)
			System.out.println(blackPmoves[i]);
		assertTrue(blackPmoves.length == 2);		
		
	}
	
	//crea una scacchiera e sposta la pedina avanti e 
	//crea le mosse medie di una pedina e verifica che è una sola
		@Test
		public void mediumTest() {
			Chessboard board = new Chessboard("black","white");
			Move pawnMove = new Move(1,3,2,3);
			pawnMove.execute(board);
			System.out.println(board);
			BasicMoves  bmBlack = new MediumPawnMoves(2,3,board);
			Move[] blackPmoves = bmBlack.getMoves();
			System.out.println("Black Moves :");
			for(int i = 0; i < blackPmoves.length; i++)
				System.out.println(blackPmoves[i]);
			assertTrue(blackPmoves.length == 1);	
			
			
		}
		
	//crea una scacchiera e mette una pedina oppenent sotto atacco
	//e crea le mosse medie di una pedina e verifica che sono 2
	@Test
	public void attackingTest() {
		Chessboard board = new Chessboard("black","white");
		Move pawnMove = new Move(1,3,2,3);
		pawnMove.execute(board);
		Move pawnOppenentMove = new Move(6,4,3,4);
		pawnOppenentMove.execute(board);
		System.out.println(board);
		BasicMoves  bmBlack = new MediumPawnMoves(2,3,board);
		Move[] blackPmoves = bmBlack.getMoves();
		System.out.println("Black Moves :");
		for(int i = 0; i < blackPmoves.length; i++)
			System.out.println(blackPmoves[i]);
		assertTrue(blackPmoves.length == 2);
		
		
	}
	
	//crea una scacchiera e mette una pedina di fronte 
	//e crea le mosse medie di una pedina e verifica che sono 0 mosse
	@Test
	public void noMoveTest() {
		Chessboard board = new Chessboard("black","white");
		Move pawnMove = new Move(1,3,2,3);
		pawnMove.execute(board);
		Move pawnOppenentMove = new Move(6,3,3,3);
		pawnOppenentMove.execute(board);
		System.out.println(board);
		BasicMoves  bmBlack = new MediumPawnMoves(2,3,board);
		Move[] blackPmoves = bmBlack.getMoves();
		System.out.println("Black Moves :");
		for(int i = 0; i < blackPmoves.length; i++)
			System.out.println(blackPmoves[i]);
		assertTrue(blackPmoves.length == 0);	
	}
}
