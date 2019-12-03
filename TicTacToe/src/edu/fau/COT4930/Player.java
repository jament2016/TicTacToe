package edu.fau.COT4930;
/**
The Player class for the COT4930 project. This class must be extended for the project.
*/

public class Player
{
	private String name;
	private char c;

	/**
		The constructor creates a default Player object.
	*/
	public Player()
	{
		name = "";
	}
	/**
		The constructor creates a Player object with the specified name.
		@param n represents the name of the Player.
	*/
	public Player(String n, char c)
	{
		name = n;
		this.c=c;
	}  

	/**
		Method to retrieve the name of the player.
		@return a String representing the name of the Player.
	*/
	public String getName()
	{ // return the name
		return name;
	}

	/**
		Method to set the Players name.
		@param n represents the name of the Player.
	*/
	public void setName(String n)
	{ // set the PLayers name
		name = n;
	}
	
	/**
	Method to return the Players character
	@return a character representing the players character
	*/
	public char getChar() {
		return this.c;
	}
}
