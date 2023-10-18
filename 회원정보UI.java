package 회원정보;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import db연결.MemberDAO;

public class 회원정보UI {

	public static void main(String[] args) {
		//필요한 부품들을 RAM에 가져다 놓아야한다
		//jframe
		JFrame f = new JFrame();
		f.setSize(390, 900);
		f.setTitle("태선병원 회원가입");
		f.getContentPane().setBackground(Color.white);
		
		//flowlayout
		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);
		//img
		ImageIcon icon1 = new ImageIcon("taesun.jpg");
		
		
		//jlabel *5
		JLabel l1 = new JLabel("");
		JLabel l2 = new JLabel("회원ID : ");
		JLabel l3 = new JLabel("회원PW : ");
		JLabel l4 = new JLabel("회원이름 : ");
		JLabel l5 = new JLabel("회원TEL : " );
		
		//jtextfield *4
		JTextField t1 = new JTextField(10); //10은 글자수
		JTextField t2 = new JTextField(10);
		JTextField t3 = new JTextField(10);
		JTextField t4 = new JTextField(10);
		t1.setBackground(Color.yellow);
		t2.setBackground(Color.yellow);
		t3.setBackground(Color.yellow);
		t4.setBackground(Color.yellow);
		
		//jbutton *2
		JButton b1 = new JButton("회원가입 요청");
		JButton b2 = new JButton("회원탈퇴 요청");
		JButton b3 = new JButton("회원수정 요청");
		
		
		b1.setBackground(Color.green);
		b2.setBackground(Color.red);
		b3.setBackground(Color.yellow);
		
		//font
		Font font = new Font("한컴 소망 B",Font.BOLD,30);
		
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		l5.setFont(font);
		
		t1.setFont(font);
		t2.setFont(font);
		t3.setFont(font);
		t4.setFont(font);
		
		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		l1.setIcon(icon1);
		
		
		f.add(l1); //이미지
		f.add(l2); //회원ID
		f.add(t1);
		f.add(l3); //회원pw
		f.add(t2);
		f.add(l4); //회원이름
		f.add(t3);
		f.add(l5); //회원 tel
		f.add(t4);
		f.add(b1); //가입버튼
		f.add(b2); //탈퇴버튼
		f.add(b3); //수정버튼
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//b1을 클릭했을 때 처리 내용을 넣어줌
				
				//1. 입력한 값을 가지고 온다
				String id = t1.getText();
				String pw = t2.getText();
				String name = t3.getText();
				String tel = t4.getText();
				
				//2. db처리 하는 부품을 사용
				MemberDAO dao = new MemberDAO();
				
				
				//3. db처리 하는 부품에 입력한 값을 주면서 db해달라고 요청
				dao.insert(id, pw, name, tel);
				
			}
			
			
			
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 탈퇴할 id를 입력받아라
				// DAO를 이용한다
				// id를 전달하면서 delete()
				String id = t1.getText();
				MemberDAO dao = new MemberDAO();
				dao.delete(id);
				
				
			}
		});
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// b3을 눌렀을 때 처리내용을 코딩
				// 입력한 값 2개를 가지고 와서 저장
				// dao를 이용해서 db처리
				// sql문을 전송
				String id = t1.getText();
				String tel = t4.getText();
				MemberDAO dao = new MemberDAO();
				dao.update(tel, id);
				
			}
		});
		
		
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
