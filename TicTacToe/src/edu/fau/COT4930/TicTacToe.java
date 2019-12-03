package edu.fau.COT4930;


public class TicTacToe {

	public static final int WINDOW_WIDTH = 1280;/// CHANGE RES HERE ONLY!
	public static final int WINDOW_HEIGHT = WINDOW_WIDTH / 16 * 9; // 16 by 9 aspect ratio
	
	public TicTacToe() {
		new HomePage();
	//	PageManager.init();
		//WindowManager.init();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Player player1=new Player("Player 1", 'X');
//		Player player2=new Player("Player 2", 'O');
//		Game beginGame=new Game(player1, player2);
		

		new TicTacToe();
	}

}
