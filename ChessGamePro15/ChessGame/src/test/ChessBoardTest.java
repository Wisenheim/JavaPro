package test;

import static org.junit.Assert.*;
import model.Chessboard;
import model.Pawns;
import model.Queen;

import org.junit.Test;

public class ChessBoardTest {
	
	//crea una scacchiera e la stampa
	@Test
	public void testToString() {
		Chessboard c = new Chessboard ("black","white");
		System.out.println(c);
	}
	
	//crea una scacchiera e rimuove una pedina in posizione x,y
	@Test
	public void testRemovePawn(){
		Chessboard c = new Chessboard ("black","white");
		c.removePawn(6, 4);
		System.out.println(c);
		assertTrue (c.getPawn(6, 4) == null);
	}
	
	//crea una scacchiera e cambia la pedina in posizione x,y a pawn
	@Test
	public void testChangePawnTo(){
		Queen q1 = new Queen("black");
		Chessboard c = new Chessboard ("black","white");
		c.changePawnTo(1, 3, q1);
		assertTrue ((c.getPawn(1, 3) == q1));
		System.out.println(c);	
		
	}
		
	@Test
	public void testChangePawnTo2(){
		Queen q1 = new Queen("black");
		Chessboard c = new Chessboard ("black","white");
		c.changePawnTo(3, 3, q1);
		assertTrue ((c.getPawn(3, 3) == q1));
		System.out.println(c);	
		
	}
	
	
	//crea una scacchiera e ritorna la pedina in posizione x,y
	@Test
	public void testGetPawn(){
		Chessboard c = new Chessboard ("black","white");
		Pawns p = c.getPawn(7, 7);
		System.out.println(p);
		assertTrue (c.getPawn(7, 7) == p);
		System.out.println(c);
		
	}

}
