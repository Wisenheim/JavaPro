package model;

public class Chessboard {
	private Pawns[][] board = new Pawns[8][8];
	private final String color1, color2;
	//inizializza la scacchiera
	public Chessboard(String color1, String color2){
		this.color1 = color1;
		this.color2 = color2;
		board [0][0] = new Rook (color1); 
		board [0][7] = new Rook (color1);
		board [7][0] = new Rook (color2); 
		board [7][7] = new Rook (color2);
		board [0][1] = new Knight (color1); 
		board [0][6] = new Knight (color1);
		board [7][1] = new Knight (color2);
		board [7][6] = new Knight (color2);
		board [0][2] = new Bishop (color1);
		board [0][5] = new Bishop (color1);
		board [7][2] = new Bishop (color2);
		board [7][5] = new Bishop (color2);
		board [0][3] = new Queen  (color1);
		board [7][3] = new Queen  (color2);
		board [0][4] = new King   (color1);
		board [7][4] = new King   (color2);
		
		for (int i = 0; i < 8; i++){
			board [1][i] = new Pawn (color1, 1);
			board [6][i] = new Pawn (color2, -1);
		}
		
	}
	
	public Chessboard(Chessboard other){
		this.color1 = other.color1;
		this.color2 = other.color2;
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				this.board[i][j] = other.board[i][j];
	}
	
	public String getColor1(){
		return color1;
	}
	
	public String getColor2(){
		return color2;
	}
	//ritorna la pedina in posizione x,y
	public Pawns getPawn(int x, int y){
		return board [x][y];
		
	}
	
	//rimuove la pedina in posizione x,y
	public void removePawn(int x, int y){
		board [x][y] = null;
	}
	
	//cambia una pedina in posizione x,y alla pedina pawn
	public void changePawnTo(int x,int y, Pawns pawn){
		board [x][y] = pawn;
	}
	
	//ritorna la scacchiera in una stringa
	public String toString(){
		String result = "";
		for(int i = 0; i < 8; i++)
			result += toStringRow(i) + "\n";
		return result;
		

	}
	
	//ritorna una riga della scacchiera
	private String toStringRow(int row){
		String result = "";
		for(int i = 0; i < 8; i++){
			result += board[row][i] == null ?  "  " : board[row][i] + " ";
		}
		return result;
		
		
		
	}
	
}
