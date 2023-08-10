package co.edu.uptc.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.security.AlgorithmParameterGenerator;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MatrixPanel extends JPanel {
	private JPanel card1;
	private JPanel card2;
	private JLabel size;
	private JLabel matrixLabel;
	private JButton btnSize;
	private JScrollPane scrollTable;
	private JTable matrixTable;
	private JLabel transverse;
	private JScrollPane scrollTableTransverse;
	private JTable transverseTable;
	private JTextField Txtsize;
	private JButton btnGenerate;
	GridBagConstraints gbc = new GridBagConstraints();
	int sizematrix;
	public MatrixPanel(ActionListener listener) {
		initComponents(listener);
	}
	private void initComponents(ActionListener listener) {
		setLayout(new GridBagLayout());
		sizematrix=3;
		setSize(1100,600);
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=WIDTH;
		gbc.anchor= gbc.CENTER;
		size= new JLabel("Ingrese el tamaño de la matriz: ");
		add(size,gbc);
		gbc.insets = new Insets(10, 50, 20, 0);
		gbc.gridx=1;
		gbc.gridy=0;
		Txtsize = new JTextField(10);
		add(Txtsize,gbc);
		gbc.gridwidth=2;
		gbc.gridx=0;
		gbc.gridy=1;
		btnSize = new JButton("Generar Matriz");
		btnSize.addActionListener(listener);
		btnSize.setActionCommand("generate");
		add(btnSize,gbc);
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth=1;
		matrixLabel = new JLabel("Matriz");
		add(matrixLabel,gbc);
		gbc.gridx=1;
		gbc.gridy=2;
		transverse = new JLabel("Matriz Transversa");
		add(transverse,gbc);
		gbc.gridx=0;
		gbc.gridy=3;
		card1 = new JPanel();
		card1.setLayout(new CardLayout());
		matrixTable = new JTable(sizematrix,sizematrix);
		matrixTable.clearSelection();
		scrollTable = new JScrollPane(matrixTable);
		scrollTable.setPreferredSize(new Dimension(300,300));
		card1.add(scrollTable);
		add(card1,gbc);
		gbc.gridx=0;
		gbc.gridy=4;
		btnGenerate= new  JButton("Calcular");
		btnGenerate.setActionCommand("calculate");
		btnGenerate.addActionListener(listener);
		add( btnGenerate,gbc);
		gbc.gridx=1;
		gbc.gridy=3;
		card2 = new JPanel();
		card2.setLayout(new CardLayout());
		transverseTable = new JTable(sizematrix,sizematrix);
		scrollTableTransverse= new JScrollPane(transverseTable);
		scrollTableTransverse.setPreferredSize(new Dimension(300,300));
		card2.add(scrollTableTransverse);
		add(card2,gbc);
	}
	public void updateSize(int number) {
		matrixTable.clearSelection();
		card1.removeAll();
		gbc.gridx=0;
		gbc.gridy=3;
		matrixTable = new JTable(number,number);
		scrollTable = new JScrollPane(matrixTable);
		scrollTable.setPreferredSize(new Dimension(300,300));
		card1.add(scrollTable);
		card1.repaint();
		card1.revalidate();
		add(card1, gbc);
		card2.removeAll();
		gbc.gridx=1;
		gbc.gridy=3;
		transverseTable = new JTable(number,number);
		scrollTableTransverse= new JScrollPane(transverseTable);
		scrollTableTransverse.setPreferredSize(new Dimension(300,300));
		card2.add(scrollTableTransverse);
		card2.repaint();
		card2.revalidate();
		add(card2, gbc);
		sizematrix = number;
	}
	private int getNumberMatrix(int num1, int num2) {
		return Integer.parseInt(""+matrixTable.getValueAt(num1, num2));
	}
	public int getSizeMatrix() {
		return Integer.parseInt(Txtsize.getText());
	}
	public ArrayList<Integer> fillMatrix(){
		ArrayList<Integer> arrayMatrix = new ArrayList<>();
		for (int i = 0; i < sizematrix; i++) {
			for (int j = 0; j < sizematrix; j++) {
				arrayMatrix.add(getNumberMatrix(i, j));
			}
		}
		return arrayMatrix;
	}
	public void fillTransverse() {
		matrixTable.clearSelection();
		int cont=0;
		for (int i = 0; i < sizematrix; i++) {
			for (int j = 0; j < sizematrix; j++) {
				transverseTable.setValueAt(fillMatrix().get(cont), j, i);
				cont++;
			}
			
		}
	}
}
