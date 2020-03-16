package Swings;
//내가 만들다 만  코드

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
	
	/*----중단에 필요한 패널들----*/
	private JButton a = new JButton("원두");
	private JButton b = new JButton("우유");
	private JButton c = new JButton("시럽");
	private JButton d = new JButton("딸기");
	private JButton e = new JButton("망고");
	private JButton f = new JButton("녹차");
	private JButton g = new JButton("홍차");
	private JButton h = new JButton("초코");
	
	/*----하단에 필요한 패널들----*/
	private JButton i = new JButton("Pos");
	private JButton j = new JButton("주문");
	private JButton k = new JButton("판매현황");
	private JButton l = new JButton("초기화");
	
//	private JLabel jL1 = new JLabel("재고 현황");
	private JLabel jL2 = new JLabel("물품 주문");
	private JLabel jL3 = new JLabel("주문 수량 입력: ");
	
	//-----------첫판넬 테이블 부분------
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
		
		// 재고 목록
		jP2.add(a);
		jP2.add(b);
		jP2.add(c);
		jP2.add(d);
		jP2.add(e);
		jP2.add(f);
		jP2.add(g);
		jP2.add(h);
		
		//하단 목록
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
