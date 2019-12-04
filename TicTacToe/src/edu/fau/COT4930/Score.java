package edu.fau.COT4930;

import java.io.IOException;
import java.io.Serializable;

public class Score implements Serializable {
	
	String name;
	int score;
	
	public Score(String name, int score) {
		this.name=name;
		this.score=score;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getScore() {
		return Integer.toString(score);
	}
	
	public void setScore(int score) {
		this.score=score;
		try {
			save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addScore() {
		this.score+=1;
		try {
			save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void save() throws IOException {
		SerializeScore.saveScore(this);
	}
}
