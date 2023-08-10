package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.uptc.view.MyFrame;

public class Presenter implements ActionListener {
	private MyFrame frame;

	public Presenter() {
		frame = new MyFrame(this);
	}

	public static void main(String[] args) {
		new Presenter();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		switch (source) {
			case "generate":
				frame.updateSize(frame.getSizeMatrix());
				break;
			case "calculate":
				frame.fillTransverse();
				break;
			default:
				break;
		}
	}
}
