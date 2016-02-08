package test;

import static org.junit.Assert.*;
import model.Chessboard;

import org.junit.Test;

import controller.IsKingUnderCheck;
import controller.Move;

public class IsKingUnderCheckTest {

	//crea una scacchiera poi muove i pezzi in modo che il re è sotto scacco 
	//crea un IsKingUnderCheck e verifica che ritorni TRUE
	@Test
	public void checkTest() {
		Chessboard board = new Chessboard("black","white");
		Move checkMove = new Move(0, 6, 5, 5);
		checkMove.execute(board);
		System.out.println(board);
		IsKingUnderCheck kingChecked = new IsKingUnderCheck("white", board);
		assertTrue(kingChecked.isCheck());
	}
	
	
	//crea una scacchiera e crea un IsKingUnderCheck e verifica che ritorni FALSE
	@Test
	public void noCheckTest() {
		Chessboard board = new Chessboard("black","white");
		System.out.println(board);
		IsKingUnderCheck kingChecked = new IsKingUnderCheck("white", board);
		assertTrue(!kingChecked.isCheck());
		
	}
}
