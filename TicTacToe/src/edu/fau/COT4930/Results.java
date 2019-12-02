package edu.fau.COT4930;

public class Results {

	char[] board=new char[9];
	char p;
	public Results(char[] board, char p) {
		this.board=board;
		this.p=p;
	}
	public boolean winVertical(char player) {
		if(board[0]==player && board[3]==player && board[6]==player) 
			return true;
		if(board[1]==player && board[4]==player && board[7]==player)
			return true;
		if(board[2]==player && board[5]==player && board[8]==player)
			return true;
		return false;
	}
	
	public boolean winHorizantal(char player) {
		if(board[0]==player && board[1]==player && board[2]==player) 
			return true;
		if(board[3]==player && board[4]==player && board[5]==player)
			return true;
		if(board[6]==player && board[7]==player && board[8]==player)
			return true;
		return false;
	}
	
	public boolean winDiagonal(char player) {
		if(board[0]==player && board[4]==player && board[8]==player)
			return true;
		if(board[2]==player && board[4]==player && board[6]==player)
			return true;
		return false;
	}
	
	public boolean isNotFinished() {
		for(int i=0; i<board.length; i++) {
			if(board[i]=='_')
				return true;
		}
		return false;
	}
	
	public boolean draw() {
		boolean draw=(winHorizantal('X')||winHorizantal('O')||winVertical('X')||winVertical('O')||winDiagonal('X')||winDiagonal('Y'));
		return draw && !isNotFinished();
	}
}
