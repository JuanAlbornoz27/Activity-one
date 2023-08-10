package co.edu.uptc.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;



public class MyFrame extends JFrame {
	private Image icon;
	private MatrixPanel matrix;
public  MyFrame(ActionListener listener) {
	super("matrix");
	matrix= new MatrixPanel(listener);
	add(matrix);
	initComponents(listener);
}

private void initComponents(ActionListener listener) {
	setSize(1100, 600);
	icon = Toolkit.getDefaultToolkit().getImage("resources/images/icons/iconYourComfort.jpeg");
	setIconImage(icon);
	setLocationRelativeTo(this);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
}

 public void updateSize(int number) {
	matrix.updateSize(number);
 }
 public int getSizeMatrix() {
	 return matrix.getSizeMatrix();
 }
 public ArrayList<Integer> fillMatrix(){
	 return matrix.fillMatrix();
 }
 public void fillTransverse() {
	 matrix.fillTransverse();
 }
}
