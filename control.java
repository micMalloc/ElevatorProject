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

public class control extends JFrame {
	private JPanel contentPane;

	public control(Panel panel, client c, HashMap<Integer, ArrayList<Integer>> path) {
		setTitle("eli");
		setSize(500, 500);
		setResizable(false);
		setLocation(200, 300);
		getContentPane().setLayout(null);
		setVisible(true);

		JButton Button1 = new JButton("1F");
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if ((JButton) obj == Button1) {
					dispose();
					f_start(c, path);
					c.d_set(720, 1);
					Center center = new Center(c.assign, c.want);
					Ethread a = new Ethread(c, panel, center.getPath());
					new Thread(a).start();

				}
			}
		});
		Button1.setBounds(0, 0, 500, 92);
		getContentPane().add(Button1);

		JButton Button2 = new JButton("2F");
		Button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if ((JButton) obj == Button2) {
					dispose();
					f_start(c, path);
					c.d_set(540, 2);
					Center center = new Center(c.assign, c.want);
					Ethread a = new Ethread(c, panel, center.getPath());
					new Thread(a).start();
					// new Thread(panel).start();

				}
			}
		});
		Button2.setBounds(0, 92, 500, 92);
		getContentPane().add(Button2);

		JButton Button3 = new JButton("3F");
		Button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if ((JButton) obj == Button3) {
					dispose();
					f_start(c, path);
					c.d_set(360, 3);
					Center center = new Center(c.assign, c.want);
					Ethread a = new Ethread(c, panel, center.getPath());
					new Thread(a).start();
					// new Thread(panel).start();

				}
			}
		});
		Button3.setBounds(0, 184, 500, 92);
		getContentPane().add(Button3);

		JButton Button4 = new JButton("4F");
		Button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if ((JButton) obj == Button4) {
					dispose();
					f_start(c, path);
					c.d_set(180, 4);
					Center center = new Center(c.assign, c.want);
					Ethread a = new Ethread(c, panel, center.getPath());
					new Thread(a).start();
					// new Thread(panel).start();

				}
			}
		});
		Button4.setBounds(0, 276, 500, 92);
		getContentPane().add(Button4);

		JButton Button5 = new JButton("5F");
		Button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object obj = arg0.getSource();
				if ((JButton) obj == Button5) {
					dispose();
					f_start(c, path);
					c.d_set(0, 5);
					Center center = new Center(c.assign, c.want);
					Ethread a = new Ethread(c, panel, center.getPath());
					new Thread(a).start();
					// new Thread(panel).start();

				}
			}
		});
		Button5.setBounds(0, 368, 500, 92);
		getContentPane().add(Button5);
		// 사람
		// ImageIcon icon2= new ImageIcon("people.jpg");
		// Image originImg = icon2.getImage();
		// Image changedImg= originImg.getScaledInstance(100, 180,
		// Image.SCALE_SMOOTH );
		// ImageIcon Icon = new ImageIcon(changedImg);
		// // 엘리베이터 문
		// ImageIcon icon = new ImageIcon("el1.png");

	}

	public void f_start(client c, HashMap<Integer, ArrayList<Integer>> path) {
		Thread T=null;
		if (c.assign == 1) {
			section.s1.c = c;
			section.s1.path = path;
			T = new Thread(section.s1);
			T.start();
			
		} else if (c.assign == 2) {
			section.s2.c = c;
			section.s2.path = path;
		 T = new Thread(section.s2);
			T.start();
			
		} else if (c.assign == 3) {
			section.s3.c = c;
			section.s3.path = path;
			T = new Thread(section.s3);
			T.start();
			
		} else if (c.assign == 4) {
			section.s4.c = c;
			section.s4.path = path;
			 T = new Thread(section.s4);
			T.start();
		}
		else if(c.assign ==5){
			section.s5.c=c;
			section.s5.path= path;
			T = new Thread(section.s5);
			T.start();
		}
		try {
			T.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}