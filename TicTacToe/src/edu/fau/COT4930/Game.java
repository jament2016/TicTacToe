package edu.fau.COT4930;

import java.util.Scanner;

public class Game {

	private Player player1, player2;
	private char turn='X';
	private char empty='_';
	public char[] a=new char[9];
	
	public Game(Player player1, Player player2) {
		this.player1=player1;
		this.player2=player2;
		populate();
	}
	
	public Game() {
		this.player1=new Player();
		this.player2=new Player();
	}
	
	public void populate() {
		for(int i=0; i<a.length; i++) {
			a[i]=empty;
		}
		pickSpot(player1);
	}
	
	public void pickSpot(Player player ) {
		System.out.println("Player "+player.getName()+" turn \nPick a spot to play (0-9)");
		Scanner input=new Scanner(System.in);
		int spot= input.nextInt();
		if(isOver()) {
			System.out.println("game over");
		}
		else if(spotTaken(spot)) {
			System.out.println("Spot is taken, pick another spot");
			pickSpot(player);
		}
		else if (player.equals(player1)) {
			a[spot]=player.getChar();
			System.out.println(toString());
			if(!isOver())
				pickSpot(player2);
		}
		else if(player.equals(player2)) {
			a[spot]=player.getChar();
			System.out.println(toString());
			if(!isOver());
				pickSpot(player1);
		}
		
	}
	
	public boolean spotTaken(int x) {
		if(a[x]==empty) {
			return false;
		}
		return true;
	}
	
	public boolean isOver() {
		Results checkForEnd = new Results(a, this.turn);
		if(checkForEnd.winDiagonal(this.turn)||checkForEnd.winHorizantal(this.turn)||checkForEnd.winVertical(this.turn))
		{
			return true;
		}
		else if(checkForEnd.draw()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String s=a[0]+" "+a[1]+" "+a[2]+
				"\n"+a[3]+" "+a[4]+" "+a[5]+
				"\n"+a[6]+" "+a[7]+" "+a[8];
		return s;
	}
	
	public void askNewGame() {
		System.out.println("New game? (y/n)");
		Scanner input=new Scanner(System.in);
		char yn= input.next().charAt(0);
		if(yn=='y') {
			new Game(player1, player2);
		}
		else System.out.println("Thanks for playing ");
	}
}
