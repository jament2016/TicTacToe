package edu.fau.COT4930;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class HomePage  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomePage() {
		buildPage();
	}
	protected void buildPage() {
		
		JFrame frame=new JFrame();
		frame.setTitle("TicTacToe");
		frame.setVisible(true);
		frame.setSize(new Dimension(1280, 720));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.DARK_GRAY);
		
		JPanel mainPanel=new JPanel(new GridLayout(4,1));
		mainPanel.setBackground(frame.getBackground());
		
		Font f=new Font("SansSerif", Font.BOLD, 70);
		
		JLabel titlePanel=new JLabel("Welcome to\n Tic Tac Toe",SwingConstants.CENTER);
		titlePanel.setPreferredSize(new Dimension(1200,680));
		titlePanel.setFont(f);
		titlePanel.setForeground(Color.YELLOW);
		
		
		JPanel buttonPanel=new JPanel(new GridLayout(2,10));
		buttonPanel.setBackground(frame.getBackground());
		JLabel empty=new JLabel("",SwingConstants.CENTER);
		JLabel empty2=new JLabel("",SwingConstants.CENTER);
		JLabel empty3=new JLabel("",SwingConstants.CENTER);
		JLabel empty4=new JLabel("",SwingConstants.CENTER);
		JLabel empty5=new JLabel("",SwingConstants.CENTER);
		JLabel empty6=new JLabel("",SwingConstants.CENTER);
		JLabel empty7=new JLabel("",SwingConstants.CENTER);
		JLabel empty8=new JLabel("",SwingConstants.CENTER);
		JButton newGame=new JButton("Press To Begin");
		JButton instructions=new JButton("Help");
		newGame.setMaximumSize(new Dimension(40,40));
		instructions.setPreferredSize(new Dimension(200,400));
		buttonPanel.add(empty);
		buttonPanel.add(empty2);
		buttonPanel.add(empty3);
		buttonPanel.add(empty4);
		buttonPanel.add(empty5);
		buttonPanel.add(empty6);
		buttonPanel.add(newGame);
		buttonPanel.add(empty7);
		buttonPanel.add(instructions);
		buttonPanel.add(empty8);
		
		JPanel textLabel=new JPanel(new GridLayout(1,2));
		f=new Font("SansSerif", Font.PLAIN,35);
		JLabel player1=new JLabel("Player 1: ", SwingConstants.CENTER);
		player1.setForeground(Color.YELLOW);
		player1.setFont(f);
		JLabel player2=new JLabel("Player 2: ", SwingConstants.CENTER);
		player2.setForeground(Color.YELLOW);
		player2.setFont(f);
		textLabel.add(player1);
		textLabel.add(player2);
		textLabel.setForeground(Color.YELLOW);
		textLabel.setBackground(frame.getBackground());
		
		JPanel text=new JPanel(new GridLayout(2,5));
		text.setBackground(frame.getBackground());
		JTextField p1=new JTextField("Player 1", SwingConstants.RIGHT);
		JTextField p2=new JTextField("Player 2",SwingConstants.RIGHT);
		p1.setHorizontalAlignment(JTextField.CENTER);
		p2.setHorizontalAlignment(JTextField.CENTER);
		
		for(int i=0; i<10; i++) {
			if(i==1)
				text.add(p1);
			if(i==3)
				text.add(p2);
			else 
				text.add(new JLabel(""));
		}

		newGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				Player play1=new Player(p1.getText());
				Player play2=new Player(p2.getText());
				new GamePage(play1, play2);
				
			}
			
		});
		
		instructions.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InstructionsPage();
			}
			
		});
		mainPanel.add(titlePanel);
		mainPanel.add(buttonPanel);
		mainPanel.add(textLabel);
		mainPanel.add(text);
		
		frame.add(mainPanel);
		frame.setVisible(true);
		
	}
}
