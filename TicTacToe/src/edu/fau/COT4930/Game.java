package edu.fau.COT4930;

import java.util.Scanner;

public class Game {

	private Player player1, player2;
	private Player currentTurn;
	private String turn="X";
	private char empty='_';
	public String[] a=new String[9];
	private String winner;
	
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
		if(player.equals(player2)) {
			a[i]=player.getChar();
			if(!isOver())
				currentTurn=player1;
		}
		else {
			a[i]=player.getChar();
			if(!isOver())
				currentTurn=player2;
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
		turn=currentTurn.getChar();
		Results checkForEnd = new Results(a, turn);
		if(checkForEnd.winDiagonal(this.turn)||checkForEnd.winHorizantal(this.turn)||checkForEnd.winVertical(this.turn))
		{
			winner=checkForEnd.getWinner();
			return true;
		}
		else if(checkForEnd.draw()) {
			winner=checkForEnd.getWinner();
			return true;
		}
		else {
			return false;
		}
	}

	public String getWinner() {
		if(winner.equals("X"))
			return player1.getName()+" Wins!";
		if(winner.equals("O"))
			return player2.getName()+" Wins!";
		return "Draw!";
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
