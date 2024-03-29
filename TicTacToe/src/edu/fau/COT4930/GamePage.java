package edu.fau.COT4930;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class GamePage  {

	private JFrame f;
	private Game g;
	private String turn;
	JButton button[]=new JButton[9];
	JPanel buttonPanel;
	JLabel player1 ,player2, getTurn, score1, score2;
	Border b=BorderFactory.createLineBorder(Color.yellow);
	Score p1,p2;
	
	public GamePage(Player p1, Player p2) {
		this.g=new Game(p1, p2);
		this.p1=SerializeScore.getScore(p1);
		this.p2=SerializeScore.getScore(p2);
		f= new JFrame("Tic Tac Toe");
		f.setSize(new Dimension(1280, 720));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBackground(Color.DARK_GRAY);
		turn=g.getTurn().getName()+"'s turn";
		getTurn=new JLabel(turn, SwingConstants.CENTER);
		buildContent();
		
	}
	
	private void buildContent() {
		
		JPanel mainPanel=new JPanel(new GridLayout(5,1));
		mainPanel.setBackground(f.getBackground());
		f.setJMenuBar(menuBar());
		Font font=new Font("SansSerif", Font.BOLD, 70);
		
		getTurn.setFont(font);
		getTurn.setForeground(Color.yellow);
		
		mainPanel.add(getTurn);
		
		buttonPanel=buildButtonPanel();
		mainPanel.add(buttonPanel);
		mainPanel.add(new JLabel(""));
		JPanel textLabel=new JPanel(new GridLayout(1,3,15,5));
		font=new Font("SansSerif", Font.PLAIN,35);
		player1=new JLabel(g.getPlayer(1).getName(), SwingConstants.CENTER);
		player1.setForeground(Color.YELLOW);
		player1.setFont(font);
		player1.setBorder(b);
		player2=new JLabel(g.getPlayer(2).getName(), SwingConstants.CENTER);
		player2.setForeground(Color.YELLOW);
		player2.setFont(font);
		textLabel.add(player1);
		
		JButton homePage=new JButton("Home Page");
		textLabel.add(homePage);
		JButton newGame=new JButton("New Game");
		textLabel.add(newGame);
		JButton help=new JButton("Help");
		textLabel.add(help);
		
		newGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(false);
				new GamePage(g.getPlayer(1), g.getPlayer(2));
				
			}
			
		});
		
		homePage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				f.setVisible(false);
				new HomePage();
			}
			
		});
		
		help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InstructionsPage();
			}
			
		}); 
		textLabel.add(player2);
		textLabel.setForeground(Color.YELLOW);
		textLabel.setBackground(f.getBackground());
		
		mainPanel.add(textLabel);
		
		JPanel score=new JPanel(new GridLayout(1,5));
		score.setBackground(f.getBackground());
		score1=new JLabel(p1.getScore(),SwingConstants.CENTER);
		score1.setFont(font);
		score1.setForeground(Color.yellow);
		score2=new JLabel(p2.getScore(), SwingConstants.CENTER);
		score2.setFont(font);
		score2.setForeground(Color.yellow);
		for(int i=0; i<5; i++) {
			if(i==0)
				score.add(score1);
			if(i==4)
				score.add(score2);
			else score.add(new JLabel(""));
		}
		mainPanel.add(score);
		
		f.add(mainPanel);
		f.setVisible(true);
	}
	
	public JPanel buildButtonPanel() {
		JPanel buttonPanel=new JPanel(new GridLayout(3,3,3,3));
		buttonPanel.setBackground(f.getBackground());	

		for(int i=0; i<9; i++) {
			button[i]=new JButton();
			button[i].addActionListener(actList(i));
		}
		Font font=new Font("SansSerif", Font.BOLD, 50);
		button[0].setFont(font);
		buttonPanel.add(new JLabel(""));
		buttonPanel.add(button[0]);
		for(int i=1; i<9; i++) {
			if((i)%3==0) {
				buttonPanel.add(new JLabel(""));
				buttonPanel.add(new JLabel(""));
			}
			button[i].setFont(font);
			buttonPanel.add(button[i]);
		}

		
		
		return buttonPanel;
	}

	private ActionListener actList(int i) {
		// TODO Auto-generated method stub
		ActionListener li=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//String text=((JButton) e.getSource()).getText();
				if(!g.spotTaken(i)&&!g.isOver()) {
					
					if(g.getTurn().equals(g.getPlayer(1)))
						((JButton) e.getSource()).setText("X");
					else 
						((JButton) e.getSource()).setText("O");
					g.pickSpot(g.getTurn(), i);
					if(g.isOver()) {
						turn=g.getWinner();
						if(g.getWinner().equals(g.getPlayer(1).getName()+" Wins!")) {
							p1.addScore();
							score1.setText(p1.getScore());
						}
						if(g.getWinner().equals(g.getPlayer(2).getName()+" Wins!")) {
							p2.addScore();
							score2.setText(p2.getScore());
						}
					}
					else {
						if(g.getTurn()==g.getPlayer(1)) {
							player1.setBorder(b);
							player2.setBorder(null);
						}
						if(g.getTurn()==g.getPlayer(2)) {
							player2.setBorder(b);
							player1.setBorder(null);
						}
						turn=g.getTurn().getName()+"'s turn";
						
					}
					getTurn.setText(turn);
				}
			}
			
		};
		return li;
	}
	
	private JMenuBar menuBar() {
		JMenuBar mb=new JMenuBar();
		JMenu x=new JMenu("Menu");
		JMenuItem m1=new JMenuItem("Home Page");
		JMenuItem m2=new JMenuItem("Help Window");
		JMenuItem m3=new JMenuItem("New Game");
		
		m1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				f.setVisible(false);
				new HomePage();
			}
			
		});
		
		m2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				new InstructionsPage();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		m3.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(false);
				new GamePage(g.getPlayer(1), g.getPlayer(2));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		x.add(m1);
		x.add(m2);
		x.add(m3);
		mb.add(x);
		return mb;
	}
}
