package edu.fau.COT4930;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class InstructionsPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InstructionsPage() {
		buildPage();
		this.setVisible(true);
	}
	
	private void buildPage() {
		this.setTitle("Tic Tac Toe Help");
		this.setVisible(true);
		this.setSize(new Dimension(700, 450));
		this.setBackground(Color.DARK_GRAY);
		buildContent();
	}
	
	private void buildContent() { 
		JPanel mainPanel=new JPanel(new GridLayout(3,1));
		mainPanel.setBackground(this.getBackground());
		
		//Title
		JLabel title=new JLabel("Instructions", SwingConstants.CENTER);
		Font f=new Font("SansSerif", Font.BOLD, 60);
		title.setFont(f);
		title.setForeground(Color.yellow);
		mainPanel.add(title);
		
		//How to play
		mainPanel.add(howTo());
		
		//Rules
		mainPanel.add(rules());
		
		this.add(mainPanel);
	}
	
	private JPanel howTo() {
		JPanel howToPlay=new JPanel(new GridLayout(4,1));
		Border b=BorderFactory.createLineBorder(Color.yellow);
		howToPlay.setBorder(b);
		howToPlay.setBackground(this.getBackground());
		JLabel header=new JLabel("How to play: ");
		JLabel instruction1=new JLabel("- Connect Three in a row either diagonally, vertically, or horizantally. Choose an empty spot available to place your X or O.");
		JLabel instruction2=new JLabel("- Once you or your opponent have connected three letters in a row, the game is ended and that person wins the gam. ");
		JLabel instruction3=new JLabel("- The game can also end in a draw if no player successfully connects three in a row and the board is completely full. ");
		//Setting font and color
		Font fo=new Font("SansSerif", Font.BOLD, 25);
		header.setForeground(Color.cyan);
		instruction1.setForeground(Color.cyan);
		instruction2.setForeground(Color.cyan);
		instruction3.setForeground(Color.cyan);
		//adding to the howTo panel
		header.setFont(fo);
		howToPlay.add(header);
		howToPlay.add(instruction1);
		howToPlay.add(instruction2);
		howToPlay.add(instruction3);
		
		return howToPlay;
	}
	
	private JPanel rules(){
		JPanel rule=new JPanel(new GridLayout(4,1));
		Border b=BorderFactory.createLineBorder(Color.yellow);
		rule.setBorder(b);
		rule.setBackground(this.getBackground());
		JLabel header=new JLabel("Rules: ");
		JLabel rule1=new JLabel("- You can not choose a tile that is already taken. You must choose a unique tile.");
		JLabel rule2=new JLabel("- Only two players can play at one time. You can play against yourself but no more than two. ");
		JLabel rule3=new JLabel("- If the game ends in a draw, no player gets anything added to or deducted from their score. ");
		
		Font fo=new Font("SansSerif", Font.BOLD, 25);
		header.setFont(fo);
		header.setForeground(Color.cyan);
		rule1.setForeground(Color.cyan);
		rule2.setForeground(Color.cyan);
		rule3.setForeground(Color.cyan);
		
		rule.add(header);
		rule.add(rule1);
		rule.add(rule2);
		rule.add(rule3);
		return rule;
	}
}
