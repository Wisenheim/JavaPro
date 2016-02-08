package view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import model.Chessboard;

public class Game extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private TilesPanel tilespanel;
	public Game(){
		setTitle("Chess Game Pro 3.02");
		Chessboard board = new Chessboard("black","white");
		this.tilespanel = new TilesPanel(board,"white", this);
		add(tilespanel, BorderLayout.CENTER);
		setIconImage(new ImageIcon("resources/chesspro.png").getImage());
		pack();
		
	}
	
	public TilesPanel getTilesPanel(){
			return tilespanel;
	}
	
	public void resetBoard(){
		getContentPane().removeAll();
		Chessboard board = new Chessboard("black","white");
		this.tilespanel = new TilesPanel(board,"white", this);
		add(tilespanel, BorderLayout.CENTER);
		pack();
		
	}
	
	public static void main(String[] args){
		
		Game game = new Game();
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setVisible(true);
		
	}
	
}
