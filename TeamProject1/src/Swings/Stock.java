package Swings;
//���� ����� ��  �ڵ�

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Stock extends JFrame{
	
	
	
	private JPanel jP1 = new JPanel();
	private JPanel jP2 = new JPanel();
	private JPanel jP3 = new JPanel();
	
	/*----�ߴܿ� �ʿ��� �гε�----*/
	private JButton a = new JButton("����");
	private JButton b = new JButton("����");
	private JButton c = new JButton("�÷�");
	private JButton d = new JButton("����");
	private JButton e = new JButton("����");
	private JButton f = new JButton("����");
	private JButton g = new JButton("ȫ��");
	private JButton h = new JButton("����");
	
	/*----�ϴܿ� �ʿ��� �гε�----*/
	private JButton i = new JButton("Pos");
	private JButton j = new JButton("�ֹ�");
	private JButton k = new JButton("�Ǹ���Ȳ");
	private JButton l = new JButton("�ʱ�ȭ");
	
//	private JLabel jL1 = new JLabel("��� ��Ȳ");
	private JLabel jL2 = new JLabel("��ǰ �ֹ�");
	private JLabel jL3 = new JLabel("�ֹ� ���� �Է�: ");
	
	//-----------ù�ǳ� ���̺� �κ�------
	private String[]columnType = {"a","b","c","d"};
	private String[][]data = {
			{"1","2","3","4"},
			{"5","6","7","8"}
	};
	private JTable jT1 = new JTable(data,columnType);
	JScrollPane scrollpane = new JScrollPane(jT1);
	
	public Stock() {
		setTitle("CofeeStock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setBackground(Color.gray);
		cp.setLayout(new GridLayout(5,1,10,10));

		jP1.setLayout(new GridLayout(2,4,5,5));
		jP2.setLayout(new GridLayout(3,4,10,10));
		jP3.setLayout(new GridLayout(2,4,10,10));
		
		cp.add(jP1);
		cp.add(jP2);
		cp.add(jP3);
		
		jP1.add(scrollpane);
		
//		jP1.add(jL1);
		jP2.add(jL2);
		jP3.add(jL3);
		
		// ��� ���
		jP2.add(a);
		jP2.add(b);
		jP2.add(c);
		jP2.add(d);
		jP2.add(e);
		jP2.add(f);
		jP2.add(g);
		jP2.add(h);
		
		//�ϴ� ���
		jP3.add(i);
//		i.setSize(30, 30);
		jP3.add(j);
		jP3.add(k);	
		jP3.add(l);
		
		
		
		setSize(550,500);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Stock();
	}

}
