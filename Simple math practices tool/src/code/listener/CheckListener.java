package code.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.MainMenu;

public class CheckListener implements ActionListener {
private MainMenu str;
public CheckListener(MainMenu mainMenu) {
	str=mainMenu;
}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(str.getAns().getText().equals("")) {
			str.minusPoint();
			return;
		}
		int one=Integer.parseInt(str.getNum1().getText());
		int two=Integer.parseInt(str.getNum2().getText());
		String sign=str.getSign().getText();
		if(str.isNumber(str.getAns().getText()) && !sign.equals("")) {
			int ans=Integer.parseInt(str.getAns().getText());
			if(sign=="x") {
				if(ans==(one*two)) {
					str.addPoint();
				}else {
					str.minusPoint();
				}
			}else if(sign=="+") {
				if(ans==(one+two)) {
					str.addPoint();
				}else {
					str.minusPoint();
				}
			}else if(sign=="/") {
				if(ans==(one/two)) {
					str.addPoint();
				}else {
					str.minusPoint();
				}
			}else if(sign=="-") {
				if(ans==(one-two)) {
					str.addPoint();
				}else {
					str.minusPoint();
				}
			}else {
				str.minusPoint();
			}
		}else {
			str.minusPoint();
		}
		str.RNG();
		str.clearAns();
	}

}
