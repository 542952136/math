package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DivListener implements ActionListener {
	private MainMenu main;
	public DivListener(MainMenu menu) {
		main=menu;

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		main.getScore().setText("0");
		main.getRanggeNumber().setText("10");
		main.update();
		main.getSign().setText("/");
	}

}
