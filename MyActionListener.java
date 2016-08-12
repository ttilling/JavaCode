import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		//b.setForeground(Color.YELLOW);
		if ( b.getBackground().equals(Color.YELLOW))
			b.setBackground(null);
		else
		    b.setBackground(Color.YELLOW);
		

	}

	public static void main(String[] args) {
		new GameOfLife();

	}

}
