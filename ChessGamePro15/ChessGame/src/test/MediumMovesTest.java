package test;

import static org.junit.Assert.*;
import model.Chessboard;

import org.junit.Test;

import controller.BasicMoves;
import controller.MediumBishopMoves;
import controller.MediumKingMoves;
import controller.MediumKnightMoves;
import controller.MediumQueenMoves;
import controller.MediumRookMoves;
import controller.Move;

public class MediumMovesTest {

	//crea una scacchiera e calcola le mosse medie di una torre e le stampa 
		//e verifica che sono 0 mosse 
		@Test
		public void rookTest() {
			Chessboard board = new Chessboard("black","white");
			BasicMoves mediumRookMoves = new MediumRookMoves(7,7,board);
			Move[] rookMoves = mediumRookMoves.getMoves();
			System.out.println("Rook Moves :");
			for(Move move:rookMoves)
					System.out.println(move);
			assertTrue(rookMoves.length == 0);
			
		}
		
		//crea una scacchiera e calocola le mosse medie di un'alfiere e le stampa
		// e verifica che sono 0 mosse
		@Test
		public void bishopTest() {
			Chessboard board = new Chessboard("black","white");
			BasicMoves mediumBishopMoves = new MediumBishopMoves(7,5,board);
			Move[] bishopMoves = mediumBishopMoves.getMoves();
			System.out.println("Bishop Moves :");
			for(Move move:bishopMoves)
					System.out.println(move);
			assertTrue(bishopMoves.length == 0);
			
		}
		
		//crea una scacchiera e calocola le mosse medie di una regina e le stampa
		// e verifica che sono 0 mosse
		@Test
		public void queenTest() {
			Chessboard board = new Chessboard("black","white");
			BasicMoves mediumQueenMoves = new MediumQueenMoves(7,3,board);
			Move[] queenMoves = mediumQueenMoves.getMoves();
			System.out.println("Queen Moves :");
			for(Move move:queenMoves)
					System.out.println(move);
			assertTrue(queenMoves.length == 0);
			
		}
		
		//crea una scacchiera e calocola le mosse medie di una cavallo e le stampa
		// e verifica che sono 2 mosse
		@Test
		public void knightTest() {
			Chessboard board = new Chessboard("black","white");
			BasicMoves mediumKnightMoves = new MediumKnightMoves(7,6,board);
			Move[] knightMoves = mediumKnightMoves.getMoves();
			System.out.println("Knight Moves :");
			for(Move move:knightMoves)
					System.out.println(move);
			assertTrue(knightMoves.length == 2);
			
		}
		
		//crea una scacchiera e calocola le mosse medie di un RE e le stampa
		// e verifica che sono 0 mosse
		@Test
		public void kingTest() {
			Chessboard board = new Chessboard("black","white");
			BasicMoves mediumKingMoves = new MediumKingMoves(7,4,board);
			Move[] kingMoves = mediumKingMoves.getMoves();
			System.out.println("King Moves :");
			for(Move move:kingMoves)
					System.out.println(move);
			assertTrue(kingMoves.length == 0);			
		}
}