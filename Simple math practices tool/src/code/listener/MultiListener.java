package code.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import code.MainMenu;

public class MultiListener implements ActionListener{
	private MainMenu main;
	public MultiListener(MainMenu menu) {
		main=menu;


	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		main.update();
		main.getScore().setText("0");
		main.getRanggeNumber().setText("10");
		main.getSign().setText("x");
	}

}
