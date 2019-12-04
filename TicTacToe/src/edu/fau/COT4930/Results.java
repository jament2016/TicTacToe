package edu.fau.COT4930;

public class Results {

	String[] board=new String[9];
	String p;
	String winner;
	public Results(String[] board, String p) {
		this.board=board;
		this.p=p;
	}
	public boolean winVertical(String player) {
		if(board[0].equals(player) && board[3].equals(player) && board[6].equals(player)) {
			winner=player;
			return true;
		}
		if(board[1].equals(player) && board[4].equals(player) && board[7].equals(player)) {
			winner=player;
			return true;
		}
		if(board[2].equals(player) && board[5].equals(player) && board[8].equals(player)) {
			winner=player;
			return true;
		}
		return false;
	}
	
	public boolean winHorizantal(String player) {
		if(board[0].equals(player) && board[1].equals(player) && board[2].equals(player)) {
			winner=player;
			return true;
		}
		if(board[3].equals(player) && board[4].equals(player) && board[5].equals(player)) {
			winner=player;
			return true;
		}
		if(board[6].equals(player) && board[7].equals(player) && board[8].equals(player)) {
			winner=player;
			return true;
		}
		return false;
	}
	
	public boolean winDiagonal(String player) {
		if(board[0].equals(player) && board[4].equals(player) && board[8].equals(player)) {
			winner=player;
			return true;
		}
		if(board[2].equals(player) && board[4].equals(player) && board[6].equals(player)) {
			winner=player;
			return true;
		}
		return false;
	}
	
	public boolean isNotFinished() {
		for(int i=0; i<board.length; i++) {
			if(board[i].equals("")) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isWinner() {
		return winHorizantal("X")||winHorizantal("O")||winVertical("X")||winVertical("O")||winDiagonal("X")||winDiagonal("O");
	}
	
	public boolean draw() {
		if(winHorizantal("X")||winHorizantal("O")||winVertical("X")||winVertical("O")||winDiagonal("X")||winDiagonal("O")) {
			System.out.println("Winner found");
			return false;
		}
		else if(!isNotFinished()) {
			System.out.println("Is Finished");
			winner="draw";
			return true;
		}
		return false;
	}
	
	public String getWinner() {
		return this.winner;
	}
	
}
