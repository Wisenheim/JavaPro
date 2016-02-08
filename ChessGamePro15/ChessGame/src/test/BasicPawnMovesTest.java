package test;

import static org.junit.Assert.*;
import model.Chessboard;
import model.Pawns;

import org.junit.Test;

import controller.BasicMoves;
import controller.BasicPawnMoves;
import controller.Move;

public class BasicPawnMovesTest {
	
	//crea una scacchiera e crea le mosse di una pedina bianca e una pedina nera
	@Test
	public void baseTest() {
		Chessboard board = new Chessboard("black","white");
		BasicMoves  bmBlack = new BasicPawnMoves(1,3,board);
		BasicMoves  bmWhite = new BasicPawnMoves(6,4,board);
		Move[] blackPmoves = bmBlack.getMoves();
		Move[] whitePmoves = bmWhite.getMoves();
		System.out.println("Black Moves :");
		for(int i = 0; i < blackPmoves.length; i++)
			System.out.println(blackPmoves[i]);
		System.out.println("White Moves :");
		for(int i = 0; i < whitePmoves.length; i++)
			System.out.println(whitePmoves[i]);
		assertTrue(blackPmoves.length == 4);
		assertTrue(whitePmoves.length == 4);
	}
	
	/*crea una scacchiera emettiamo le pedine alla 
	posizione penultima della scacchiera e creamo le mosse*/
	
	@Test
	public void advancedTest(){
		Chessboard board = new Chessboard("black","white");
		Pawns p1 = board.getPawn(1, 3);
		Pawns p2 = board.getPawn(6, 4);
		board.changePawnTo(6, 4, p1);
		board.changePawnTo(1, 3, p2);
		BasicMoves  bmBlack = new BasicPawnMoves(6,4,board);
		BasicMoves  bmWhite = new BasicPawnMoves(1,3,board);
		
		Move[] blackPmoves = bmBlack.getMoves();
		Move[] whitePmoves = bmWhite.getMoves();
		System.out.println("Black Moves :");
		for(int i = 0; i < blackPmoves.length; i++)
			System.out.println(blackPmoves[i]);
		System.out.println("White Moves :");
		for(int i = 0; i < whitePmoves.length; i++)
			System.out.println(whitePmoves[i]);
		assertTrue(blackPmoves.length == 3);
		assertTrue(whitePmoves.length == 3);
		
	}
	
	//è come il advancedTest ma le pedine sono alla fine della scacchiera
	@Test
	public void veryAdvancedTest(){
		Chessboard board = new Chessboard("black","white");
		Pawns p1 = board.getPawn(1, 3);
		Pawns p2 = board.getPawn(6, 4);
		board.changePawnTo(7, 4, p1);
		board.changePawnTo(0, 3, p2);
		BasicMoves  bmBlack = new BasicPawnMoves(7,4,board);
		BasicMoves  bmWhite = new BasicPawnMoves(0,3,board);
		
		Move[] blackPmoves = bmBlack.getMoves();
		Move[] whitePmoves = bmWhite.getMoves();
		System.out.println("Black Moves :");
		for(int i = 0; i < blackPmoves.length; i++)
			System.out.println(blackPmoves[i]);
		System.out.println("White Moves :");
		for(int i = 0; i < whitePmoves.length; i++)
			System.out.println(whitePmoves[i]);
		assertTrue(blackPmoves.length == 0);
		assertTrue(whitePmoves.length == 0);
		
	}


}
