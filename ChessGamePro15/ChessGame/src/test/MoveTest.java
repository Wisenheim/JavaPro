package test;

import static org.junit.Assert.*;
import model.Chessboard;

import org.junit.Test;

import controller.Move;

public class MoveTest {
	
	//crea una scacchiera e esegue la mossa (1:6) --> (3:6) e stampa la scacchiera
	@Test
	public void testExecute() {
		Chessboard board = new Chessboard("black","white");
		Move mossa = new Move(1,6,3,6);
		mossa.execute(board);
		System.out.println(board);
		assertTrue(board.getPawn(3, 6) != null);
		assertTrue(board.getPawn(1, 6) == null);

	}
	
	//crea due mosse diverse poi verifica se sono uguale
	//crea altre due mosse uguale poi verifica se sono uguale
	@Test
	public void testEquals() {
		Move mossa1 = new Move(1,1,3,1);
		Move mossa2 = new Move(1,1,2,1);
		Move mossa3 = new Move(6,1,4,1);
		Move mossa4 = new Move(6,1,4,1);
		assertTrue(!mossa1.equals(mossa2));
		assertTrue(mossa3.equals(mossa4));
	}
	
	//crea tre mosse e le stampa
	@Test
	public void testToString() {
		Move mossa1 = new Move(1,1,3,1);
		Move mossa2 = new Move(1,1,2,1);
		Move mossa3 = new Move(6,1,4,1);
		
		System.out.println(mossa1 + "\n" + mossa2 + "\n"  + mossa3 + "\n");
	}
	

}
