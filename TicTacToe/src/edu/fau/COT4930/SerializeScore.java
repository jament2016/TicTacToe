package edu.fau.COT4930;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializeScore {

	static ArrayList<Score> scores=new ArrayList<>();
	
	public static void init() {
		try {
			getScores();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void saveScore(Score s) throws IOException {
		scores.add(s);
		File f=new File("score.txt");
		FileOutputStream fos=new FileOutputStream(f);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(scores);
	}
	
	public static void getScores() throws IOException {
		File f=new File("score.txt");
		FileInputStream fis=new FileInputStream(f);
		ObjectInputStream ois=new ObjectInputStream(fis);
		try {
			scores=(ArrayList<Score>) ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Score getScore(Player p) {
		for(int i=0; i<scores.size(); i++) {
			if(scores.get(i).getName().equals(p.getName()))
				return scores.get(i);
		}
		return new Score(p.getName(), 0);
	}
}
