package edu.fau.COT4930;

import java.util.Scanner;

public class Game {

	private Player player1, player2;
	private Player currentTurn;
	private String turn="X";
	private char empty='_';
	public String[] a=new String[9];
	
	public Game(Player player1, Player player2) {
		this.player1=player1;
		this.player2=player2;
		currentTurn=this.player1;
		populate();
	}
	
	public Game() {
		this.player1=new Player();
		this.player2=new Player();
	}
	
	public void populate() {
		for(int i=0; i<a.length; i++) {
			a[i]="";
		}
	}
	
	public void pickSpot(Player player, int i ) {
		if(player.equals(player1)) {
			a[i]=player.getChar();
			if(!isOver())
				currentTurn=player2;
		}
		else {
			a[i]=player.getChar();
			currentTurn=player1;
		}
	}
	
	public boolean spotTaken(int x) {
		System.out.println("Spot: " + a[x]);
		if(a[x]=="") {
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
	
	public void askNewGame() {
		System.out.println("New game? (y/n)");
		Scanner input=new Scanner(System.in);
		char yn= input.next().charAt(0);
		if(yn=='y') {
			new Game(player1, player2);
		}
		else System.out.println("Thanks for playing ");
	}

	public Player getTurn() {
		// TODO Auto-generated method stub
		return currentTurn;
	}
	
	public Player getPlayer(int i) {
		if(i==1)
			return player1;
		return player2;
	}
}
