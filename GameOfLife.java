import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GameOfLife extends JFrame implements ActionListener {
	static final int width =20;	
	Timer t = null;
	JButton clearButton;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() instanceof JButton ) {
			if ( e.getSource() == clearButton) {
				for (int i = 0; i < width; i++) {
					for (int j = 0; j < width; j++) {
						buttons[i][j].setBackground(null);
					}
				}
			} else {
				if ( null == t) {
					t = new Timer(100,this);
					t.start();
					((JButton)e.getSource()).setText("Stop");
				} else {
					((JButton)e.getSource()).setText("Start");
					t.stop();
					t=null;
				}
			}
		} else {
			tick();
			
		}
	}
	
	JButton[][] buttons=null;
	boolean[][] state = new boolean[width][width];
	public void tick() {
		for (int i = 0; i < buttons.length; i++) {
			JButton[] arr = buttons[i];
			for ( int j=0; j<arr.length; j++) {
				if ( buttons[i][j].getBackground().equals(Color.YELLOW)) {
					if ( neighbours(i,j)!=2 && neighbours(i,j)!=3) {
						state[i][j]=false;
						//buttons[i][j].setBackground(null); //slightly incorrect
					} else
						state[i][j]=true;
				} else {
					if ( neighbours(i,j)==3) {
						//buttons[i][j].setBackground(Color.YELLOW); //slightly incorrect
						state[i][j]=true;
					} else
						state[i][j]=false;
				}
			}
		}
		for ( int i=0; i<width; i++) {
			for ( int j=0; j<width; j++) {
				if ( state[i][j])
					buttons[i][j].setBackground(Color.YELLOW); //slightly correct
				else
					buttons[i][j].setBackground(null); //slightly correct
			}
		}
	}
	public int fix(int x) {
		if ( x<0)
			x+=width;
		else if ( x>=width)
			x-=width;
		return x;
	}
	public int neighbours(int i, int j) {
		int total=0;
		for ( int a=i-1; a<=i+1; a++) {
			for ( int b=j-1; b<=j+1; b++) {
				if ( a==i && b==j)
					continue;
				int m =fix(a);
				int n=fix(b);
				if ( buttons[m][n].getBackground().equals(Color.YELLOW)) {
					total++;
				}
			}
		}
		return total;
	}
	
	public GameOfLife() {
		//JPanel/Layout
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(width,width));
		
		//Buttons
		buttons = new JButton[width][width];
		ActionListener al = new MyActionListener();
		for (int i = 0; i < buttons.length; i++) {
			for ( int j=0; j<buttons[0].length; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].addActionListener(al);
				p.add(buttons[i][j]);
			}
		}
		
		JPanel buttonPanel = new JPanel();
		JButton goButton = new JButton("Start");
		goButton.addActionListener(this);
		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		buttonPanel.add(goButton);
		buttonPanel.add(clearButton);
		
		setLayout(new BorderLayout());
		add(p,BorderLayout.CENTER);
		add(buttonPanel,BorderLayout.SOUTH);
		
		setTitle("Conway's Game of Life");
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public static void main(String[] args) {
		new GameOfLife();

	}

}
