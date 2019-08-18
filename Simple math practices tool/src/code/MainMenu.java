package code;

import java.awt.Font;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import code.listener.AddListener;
import code.listener.CheckListener;
import code.listener.ExitListener;
import code.listener.MakerListener;
import code.listener.MultiListener;

public class MainMenu {
	private JPanel panel1; //top main	
	private JPanel control; // control panel
	private JPanel RangePanel; // range panel
	private JPanel QuestionPanel; //Question Panel
	private JPanel ScorePanel; //panel for scoring
	private JLabel score;	    // score labels
	private JLabel sign;	 	// sign of question * / + -
	private JLabel num1;	    // the first number
	private JLabel num2;		// the second number	
	private JTextField ans;		// answer that type in 
	private JTextField rang;		// type in for range setting
	private JButton check;		// the button to check answer
	private JButton maker;		// the button to make question	
	private JPanel TotalGrade; // total number of question 
	private JPanel correct; // # of correct
	private JPanel wrong;   // # of wrong 
	private JPanel percent; // # of correctness
	private JLabel corrects; // # of correct
	private JLabel wrongs;   // # of wrong 
	private JLabel percents; // # of correctness
	public MainMenu() {
		// create MainMenu panel for starting
		this.correct=new JPanel();
		this.wrong=new JPanel();
		this.percent=new JPanel();
		this.corrects=new JLabel("0");
		this.wrongs=new JLabel("0");
		this.percents=new JLabel("0.0");
		JLabel cor=new JLabel("# of correct: ");
		JLabel wro=new JLabel("# of wro: ");
		JLabel per=new JLabel("percentage: ");
		this.TotalGrade=new JPanel();
		this.TotalGrade.add(correct);
		this.TotalGrade.add(wrong);
		this.TotalGrade.add(percent);
		this.correct.add(cor);
		this.correct.add(corrects);
		this.wrong.add(wro);
		this.wrong.add(wrongs);
		this.percent.add(per);
		this.percent.add(percents);
		this.panel1=new JPanel(); //main panel
		this.control=new JPanel();	// control panel
		this.ScorePanel=new JPanel(); // scorePanel
		this.score=new JLabel("0");// Label for score and set to initially 0
		score.setFont(new Font(Font.DIALOG,20, 20)); //set Font size
		this.RangePanel=new JPanel(); //Range panel
		this.QuestionPanel=new JPanel(); //Question Panel
		JLabel word=new JLabel("Range: "); // label for word
		JLabel sco=new JLabel("Score: "); // label for word
		RangePanel.add(word); // add to panel
		ScorePanel.add(sco);	 // add to panel
		ScorePanel.add(score);
		rang=new JTextField(5); //setting up label
		rang.setText("10"); //~~~~
		RangePanel.add(rang); // add rang to panel
		this.num1=new JLabel(); //setting up question panel
		this.num2=new JLabel();  //~~~~~~~~~~~~~~~~~~~~~~
		this.ans=new JTextField(5); //~~~~~~~~~~~~~~~~~~~~~~
		this.sign=new JLabel(); //~~~~~~~~~~~~~~~~~~~~~~
		JLabel equal=new JLabel(" = ");
		QuestionPanel.add(num1);// Completing fill up question panel
		QuestionPanel.add(sign);
		QuestionPanel.add(num2);
		QuestionPanel.add(equal);
		QuestionPanel.add(ans); 
		sign.setFont(new Font(Font.DIALOG,20, 20));
		num1.setFont(new Font(Font.DIALOG,20, 20));
		num2.setFont(new Font(Font.DIALOG,20, 20));
		this.check=new JButton("check");
		maker=new JButton("make question");
		check.addActionListener(new CheckListener(this));
		maker.addActionListener(new MakerListener(this));
		panel1.add(maker);
		panel1.add(check);
		JMenuBar menuBar = new JMenuBar();//menu bar
		JMenu Choice=new JMenu("Choose a Mode");
		JMenuItem multi= new JMenuItem("Multiplication");
		JMenuItem div=new JMenuItem("Division");
		JMenuItem add = new JMenuItem("Addition");
		JMenuItem minus=new JMenuItem("Subtraction");
		JMenuItem exit=new JMenuItem("Exit");
		exit.addActionListener(new ExitListener());
		multi.addActionListener(new MultiListener(this));
		add.addActionListener(new AddListener(this));
		div.addActionListener(new DivListener(this));
		minus.addActionListener(new MinusListener(this));
		Choice.add(multi);
		Choice.add(div);
		Choice.add(add);
		Choice.add(minus);
		Choice.add(exit);
		menuBar.add(Choice);
		panel1.add(menuBar);
	}
	public JPanel getControl() { //returning the control panel
		return this.control;
	}
	public JPanel getPanel() { // returning the main Panel
		return this.panel1;
	}
	public JPanel getRange() { //returning the range panel
		return this.RangePanel;
	}
	public JPanel getQuestion() {  //returning the Question Panel
		return this.QuestionPanel;
	}
	public JPanel getScorePanel() { 	//returning the ScorePanel
		return this.ScorePanel;
	}
	public JLabel getScore() { 	//returning the Score
		return this.score;
	}
	public JLabel getSign() {
		return this.sign;
	}
	public void addPoint() {
		String ori=this.score.getText();
		int score=Integer.parseInt(ori);
		int c=Integer.parseInt(corrects.getText());
		int w=Integer.parseInt(wrongs.getText());
		int total=c+w;
		score=score+5;
		this.score.setText(Integer.toString(score));
		this.corrects.setText(Integer.toString(c+1));
		this.percents.setText(Double.toString(((c+1)*100)/(total+1)));
	}
	public void minusPoint() {
		String ori=this.score.getText();
		int c=Integer.parseInt(corrects.getText());
		int w=Integer.parseInt(wrongs.getText());
		int total=c+w;
		int score=Integer.parseInt(ori);
		score=score-5;
		this.score.setText(Integer.toString(score));
		this.wrongs.setText(Integer.toString(w+1));
		this.percents.setText(Double.toString((c*100)/(total+1)));
	}
	public void update() {
		this.panel1.revalidate();
		this.panel1.repaint();
		this.RangePanel.revalidate();
		this.RangePanel.repaint();
		this.QuestionPanel.revalidate();
		this.QuestionPanel.repaint();
		this.ScorePanel.revalidate();
		this.ScorePanel.repaint();
	}
	/**
	 * random number generator
	 */
	public void RNG() {
		Random x=new Random();
		int range= Integer.parseInt(rang.getText());
		int two=x.nextInt(range-1)+1;
		int one=x.nextInt(range-1)+1;
		if(this.sign.getText().equals("/")) {
			while((one % two)!=0) {
				two=x.nextInt(range-1)+1;
				one=x.nextInt(range-1)+1;
			}
		}
		if(this.sign.getText().equals("-")) {
			while((one - two)<3) {
				two=x.nextInt(range-1)+1;
				one=x.nextInt(range-1)+1;
			} 
		}
		num2.setText(Integer.toString(two));
		num1.setText(Integer.toString(one));
	}
	/**
	 * answer clearing 
	 */
	public void clearAns() {
		this.ans.setText("");
	}
	/**
	 * check if input is numerical
	 */
	public boolean isNumber(String x) {
		try {
			Integer.parseInt(x);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	public JLabel getNum1() {
		return this.num1;
	}
	public JLabel getNum2() {
		return this.num2;
	}
	public JTextField getAns() {
		return this.ans;
	}
	public JTextField getRanggeNumber() {
		return this.rang;
	}
	public JPanel getTotal() {
		return this.TotalGrade;
	}
}
