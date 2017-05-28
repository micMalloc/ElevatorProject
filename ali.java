package ATP;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;

import javax.swing.BoxLayout;

public class ali extends JFrame{
	private JPanel contentPane;
	static ImageIcon icon2 = new ImageIcon("people.jpg");
	static Image originImg = icon2.getImage();
	static Image changedImg = originImg.getScaledInstance(50, 100, Image.SCALE_SMOOTH);
	static ImageIcon Icon = new ImageIcon(changedImg);
	static ImageIcon icon6 = new ImageIcon("back3.png");
	static Image originImg2= icon6.getImage();
	static Image changedImg2 = originImg2.getScaledInstance(200, 900, Image.SCALE_SMOOTH);
	static ImageIcon Icon2 = new ImageIcon(changedImg2);
	static ImageIcon icon3 = new ImageIcon("back2.png");
	static Image originImg3= icon3.getImage();
	static Image changedImg3 = originImg3.getScaledInstance(900, 900, Image.SCALE_SMOOTH);
	static ImageIcon Icon3 = new ImageIcon(changedImg3);
	static ImageIcon icon = new ImageIcon("el1.png");
	static ImageIcon icon4 = new ImageIcon("el4.png");
	static ImageIcon icon5 = new ImageIcon("el.png");
	static ImageIcon icon7 = new ImageIcon("back4.png");
	static Image originImg4= icon7.getImage();
	static Image changedImg4 = originImg4.getScaledInstance(300, 900, Image.SCALE_SMOOTH);
	static ImageIcon Icon4 = new ImageIcon(changedImg4);
	static ImageIcon icon8 = new ImageIcon("1.png");
	static Image originImg5= icon8.getImage();
	static Image changedImg5 = originImg5.getScaledInstance(83, 60, Image.SCALE_SMOOTH);
	static ImageIcon Icon5 = new ImageIcon(changedImg5);
	static ImageIcon icon9 = new ImageIcon("2.png");
	static Image originImg6= icon9.getImage();
	static Image changedImg6 = originImg6.getScaledInstance(83, 60, Image.SCALE_SMOOTH);
	static ImageIcon Icon6 = new ImageIcon(changedImg6);
	static ImageIcon icon10 = new ImageIcon("3.png");
	static Image originImg7= icon10.getImage();
	static Image changedImg7 = originImg7.getScaledInstance(83, 60, Image.SCALE_SMOOTH);
	static ImageIcon Icon7 = new ImageIcon(changedImg7);
	static ImageIcon icon11 = new ImageIcon("4.png");
	static Image originImg8= icon11.getImage();
	static Image changedImg8 = originImg8.getScaledInstance(83, 60, Image.SCALE_SMOOTH);
	static ImageIcon Icon8 = new ImageIcon(changedImg8);
	static ImageIcon icon12 = new ImageIcon("5.png");
	static Image originImg9= icon12.getImage();
	static Image changedImg9 = originImg9.getScaledInstance(83, 60, Image.SCALE_SMOOTH);
	static ImageIcon Icon9 = new ImageIcon(changedImg9);

	
	//Thread k = new Thread();
	public static void main(String[] args) {
		/* Make a Floor List */
		for (int i = 1; i <= 10; ++i) {
			Center.floor[i] = new Floor(i);
			// priorityQueue.offer(floor[i]);
		}
		/* Make a Elevator List */
		for (int i = 1; i <= 5; ++i) {
	         int input = i % 5;;
	         Center.elevator[i] = new Elevator(input);
	      }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ali frame = new ali();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ali() {
		setTitle("eli");
		setSize(1300, 1000);
		setResizable(false);
		setLocation(0, 0);
		getContentPane().setLayout(null);
		Panel panel = new Panel();
		getContentPane().add(panel);
		// 파트나누는 판넬
		
		JButton b5 = new JButton("5F");
		b5.setBounds(0, 0, 50, 180);
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HashMap<Integer, ArrayList<Integer>> path = new HashMap<Integer, ArrayList<Integer>>();
				Object obj = arg0.getSource();
				if ((JButton) obj == b5) {
					client c1 = new client(ali.Icon, 5);
					c1.assign = Center.targeting(c1);
					Center center = new Center(c1.assign, c1.current);
					path = center.getPath();
					c1.dy_set(0);
					c1.set(0,0);
					Panel.e1.add(c1);
					new control(panel,c1,path);	
				}
			}
		});
		getContentPane().add(b5);

		JButton b4 = new JButton("4F");
		b4.setBounds(0, 180, 50, 180);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HashMap<Integer, ArrayList<Integer>> path = new HashMap<Integer, ArrayList<Integer>>();
				Object obj = arg0.getSource();
				if ((JButton) obj == b4) {
					client c1 = new client(ali.Icon, 4);
					c1.assign = Center.targeting(c1);
					Center center = new Center(c1.assign, c1.current);
					path = center.getPath();
					c1.dy_set(180);
					c1.set(0,180);
					Panel.e1.add(c1);
					new control(panel,c1,path);
				}
			}
		});
		getContentPane().add(b4);

		JButton b3 = new JButton("3F");
		b3.setBounds(0, 360, 50, 180);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HashMap<Integer, ArrayList<Integer>> path = new HashMap<Integer, ArrayList<Integer>>();
				Object obj = arg0.getSource();
				if ((JButton) obj == b3) {
					client c1 = new client(ali.Icon, 3);
					c1.assign = Center.targeting(c1);
					Center center = new Center(c1.assign, c1.current);
					path = center.getPath();
					c1.dy_set(360);
					c1.set(0,360);
					Panel.e1.add(c1);
					new control(panel,c1,path);
				}
			}
		});
		getContentPane().add(b3);

		JButton b2 = new JButton("2F");
		b2.setBounds(0, 540, 50, 180);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HashMap<Integer, ArrayList<Integer>> path = new HashMap<Integer, ArrayList<Integer>>();
				Object obj = arg0.getSource();
				if ((JButton) obj == b2) {
					client c1 = new client(ali.Icon, 2);
					c1.assign = Center.targeting(c1);
					Center center = new Center(c1.assign, c1.current);
					path = center.getPath();
					c1.dy_set(540);
					c1.set(0,540);
					
					Panel.e1.add(c1);
					new control(panel,c1,path);
				}
			}
		});
		getContentPane().add(b2);

		JButton b1 = new JButton("1F");
		b1.setBounds(0, 720, 50, 180);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HashMap<Integer, ArrayList<Integer>> path = new HashMap<Integer, ArrayList<Integer>>();
				Object obj = arg0.getSource();
				if ((JButton) obj == b1){
					client c1 = new client(ali.Icon, 1);
					c1.assign = Center.targeting(c1);
					Center center = new Center(c1.assign, c1.current);
					path = center.getPath();
					c1.dy_set(720);
					c1.set(0,720);
					
					Panel.e1.add(c1);
					new control(panel,c1,path);
				}
			}
		});
		getContentPane().add(b1);
	}
}

class Panel extends JPanel {
	
	static E E1 = new E(0, 90, 100, 100, 5);
	static E E2 = new E(216, 90, 100, 100, 5);
	static E E3 = new E(436, 90, 100, 100, 5);
	static E E4 = new E(650, 90, 100, 100, 5);
	static 	E E5 = new E(0, 270, 100, 100, 4);
	static 	E E6 = new E(216, 270, 100, 100, 4);
	static 	E E7 = new E(436, 270, 100, 100, 4);
	static 	E E8 = new E(650, 270, 100, 100,4);
	static 	E E9 = new E(0, 457, 100, 100, 3);
	static 	E E10 = new E(216, 457, 100, 100, 3);
	static 	E E11 = new E(436, 457, 100, 100, 3);
	static 	E E12 = new E(650, 457, 100, 100, 3);
	static 	E E13 = new E(0, 634, 100, 100, 2);
	static 	E E14 = new E(216, 634, 100, 100, 2);
	static 	E E15 = new E(436, 634, 100, 100, 2);
	static 	E E16 = new E(650, 634, 100, 100, 2);
	static 	E E17 = new E(0, 810, 100, 100, 1);
	static 	E E18 = new E(216, 810, 100, 100, 1);
	static 	E E19 = new E(436, 810, 100, 100, 1);
	static 	E E20 = new E(650, 810, 100, 100, 1);
	client c;
	static section f1 ;
	static JPanel e1 = new JPanel(){	public void paintComponent(Graphics g) {
		g.drawImage(ali.Icon2.getImage(), 0, 0, null);
		setOpaque(false);// 배경 띄워주기
		super.paintComponent(g);
	}
	};
	 JPanel e2 = new JPanel();
	static JPanel e = new JPanel(){	public void paintComponent(Graphics g) {
		g.drawImage(ali.Icon3.getImage(), 0, 0, null);
		setOpaque(false);// 배경 띄워주기
		super.paintComponent(g);
	}
	};
	Panel(){
		f1 = new section(0, 0, Color.WHITE) {
			public void paintComponent(Graphics g) {
				g.drawImage(ali.Icon4.getImage(), 0, 0, null);
				setOpaque(false);// 배경 띄워주기
				super.paintComponent(g);
			}
		};
		setBounds(50,0,1250,1000);
		setLayout(null);
		e1.setBounds(0, 0, 850, 1000);
		this.add(e1);
		e1.setLayout(null);
		e2.setBounds(1000, 0, 300, 1000);		
		e2.setLayout(null);
		e2.add(f1);

		// 사람
		e.setBounds(200, 0, 800, 1000);
		e.setLayout(null);
		this.add(e);
		this.add(e2);
		// 엘리베이터 문
		JLabel L1 = new JLabel("Elevator 1", JLabel.CENTER);
		L1.setBounds(0, 900, 200, 100);
		JLabel L2 = new JLabel("Elevator 2", JLabel.CENTER);
		L2.setBounds(200, 900, 200, 100);
		JLabel L3 = new JLabel("Elevator 3", JLabel.CENTER);
		L3.setBounds(400, 900, 200, 100);
		JLabel L4 = new JLabel("Elevator 4", JLabel.CENTER);
		L4.setBounds(600, 900, 200, 100);
		e.add(E1);
		e.add(E2);
		e.add(E3);
		e.add(E4);
		e.add(E5);
		e.add(E6);
		e.add(E7);
		e.add(E8);
		e.add(E9);
		e.add(E10);
		e.add(E11);
		e.add(E12);
		e.add(E13);
		e.add(E14);
		e.add(E15);
		e.add(E16);
		e.add(E17);
		e.add(E18);
		e.add(E19);
		e.add(E20);
		e.add(L1);
		e.add(L2);
		e.add(L3);
		e.add(L4);
	}
	public void set(client c){
		this.c=c;
	}


	public  void change(){
		int i=0;
		int j=0;
		if(c.d_y>c. y){
			int t=c.y;
			for(i=0;i<=(c.d_y-c.y)/180;i++){
				change();
				t=t+(180);
				try{
					Thread.sleep(1000);
				} catch (Exception ex) {
				}
			}
		}
		else{
			int t=c.y;
			for(j=0;j<=(c.y-c.d_y)/180;j++){
				t=t-(180);
				try{
					Thread.sleep(1000);
				} catch (Exception ex) {
				}
			}
		}	
		
	}
	
}
