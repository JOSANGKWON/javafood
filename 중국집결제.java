package 자바응용;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class 중국집결제 {
	static int foodcount1 = 0, foodcount2 = 0, foodcount3 =0;//클래스 전체에서 접근이 가능하다
	static int fooPrice1 = 5000, fooPrice2 =4500,fooPrice3 = 3000;
	 
	//main안에서 사용하기 위해서는 main이 static이 붙어있음.
	//main밖에 있는 변수도 static이 붙어 있어야함.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f.setSize(700, 800);
		JLabel l1 = new JLabel();
		
		JButton b1 = new JButton();
		b1.setText("짬뽕");

		JButton b2 = new JButton();
		b2.setText("우동");
		JButton b3 = new JButton();
		b3.setText("짜장");
		JLabel bottom = new JLabel();
		ImageIcon icon = new ImageIcon("jambong.jpg");
		JLabel l2 = new JLabel();
		l2.setText("결제금액 : ");
		
		FlowLayout fl = new FlowLayout();

		Font font = new Font("맑은 굴림", 1, 30);
		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		l1.setFont(font);
		l2.setFont(font);

		f.setLayout(fl);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(l1);
		f.add(bottom);
		bottom.setIcon(icon);
		f.add(l2);
		
		
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("짬뽕 선택함");
				foodcount1++;
				l1.setText("개수 :"+(foodcount1+foodcount2+foodcount3)+ "개");
				
				
				int total = (foodcount1*fooPrice1) + (foodcount2*fooPrice2) + (foodcount3*fooPrice3);
				l2.setText("결제금액 : " + total+"원");
				
			}
		});
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("우동 선택함");
				foodcount2++;
				l1.setText("개수 :"+(foodcount1+foodcount2+foodcount3)+ "개");
				
				
				int total = (foodcount1*fooPrice1) + (foodcount2*fooPrice2) + (foodcount3*fooPrice3);
				l2.setText("결제금액 : " + total+"원");
			}
		});
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("짜장 선택함");
				foodcount3++;
				l1.setText("개수 :"+(foodcount1+foodcount2+foodcount3)+ "개");
				
				
				int total = (foodcount1*fooPrice1) + (foodcount2*fooPrice2) + (foodcount3*fooPrice3);
				l2.setText("결제금액 : " + total+"원");
			}
			
		});
		
		f.setVisible(true);

	}

}
