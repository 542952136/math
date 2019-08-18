package code.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.MainMenu;

public class MakerListener implements ActionListener {
private MainMenu str;
public MakerListener(MainMenu mainMenu) {
	str=mainMenu;
}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		str.RNG();
	}

}
