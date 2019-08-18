package code;



import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;




public class MainGui {

	public static void runGUI(){
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Math");
        MainMenu panel=new MainMenu();
        JPanel Question=panel.getQuestion();
        JPanel x1=panel.getPanel();
        JPanel grade=panel.getTotal();
        x1.add(panel.getRange());
        x1.add(panel.getScorePanel());
        x1.add(panel.getControl());
        frame.add(x1, BorderLayout.NORTH);
        frame.add(Question, BorderLayout.CENTER);
        frame.add(grade,BorderLayout.EAST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);
	}
	 public static void main(String[] args){
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                runGUI();
	            }
	        });
	    }

}
