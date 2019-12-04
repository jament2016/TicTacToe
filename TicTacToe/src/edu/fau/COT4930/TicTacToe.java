package edu.fau.COT4930;


public class TicTacToe {

	
	public TicTacToe() {
		SerializeScore.init();
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
		/*
		Player p=new Player("P1",'x');
		Score s=new Score(p.getName(), 0);
		s.setScore(5);
		System.out.println(s.getScore());
		Player q=new Player("P1", 'x');
		Score x=SerializeScore.getScore(q);
		System.out.println("x score:"+x.getScore());
		*/
	}

}
