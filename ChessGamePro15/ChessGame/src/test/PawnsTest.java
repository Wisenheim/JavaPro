package test;

import static org.junit.Assert.*;
import model.Bishop;
import model.King;
import model.Knight;
import model.Pawn;
import model.Queen;
import model.Rook;

import org.junit.Test;

public class PawnsTest {

	@Test
	public void test() {
		//test pawn
		Pawn pb = new Pawn("black",1);
		Pawn pw = new Pawn("white", -1);
		System.out.println("black pawn :" + pb);
		assertTrue (pb.toString().equals("p"));
		System.out.println("white pawn :" + pw);
		assertTrue(pw.toString().equals("P"));
		
		//test Queen
		Queen qb = new Queen("black");
		Queen qw = new Queen("white");
		System.out.println("black queen :" + qb);
		assertTrue (qb.toString().equals("q"));
		System.out.println("white queen :" + qw);
		assertTrue(qw.toString().equals("Q"));
		
		//test King
		King lb = new King ("black");
		King lw = new King ("white");
		System.out.println("black king :" + lb);
		assertTrue (lb.toString().equals("a"));
		System.out.println("white king :" + lw);
		assertTrue(lw.toString().equals("A"));
		
		//test Bishop
		Bishop bb = new Bishop ("black");
		Bishop bw = new Bishop ("white");
		System.out.println("black Bishop :" + bb);
		assertTrue (bb.toString().equals("b"));
		System.out.println("white Bishop :" + bw);
		assertTrue(bw.toString().equals("B"));
		
		//test Knight
		Knight kb = new Knight ("black");
		Knight kw = new Knight ("white");
		System.out.println("black Knight :" + kb);
		assertTrue (kb.toString().equals("k"));
		System.out.println("white Knight :" + kw);
		assertTrue(kw.toString().equals("K"));
		
		//test Rook
		Rook rb = new Rook ("black");
		Rook rw = new Rook ("white");
		System.out.println("black rook :" + rb);
		assertTrue (rb.toString().equals("r"));
		System.out.println("white rook :" + rw);
		assertTrue(rw.toString().equals("R"));
		
	}

}
