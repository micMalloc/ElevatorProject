package ATP;

import java.awt.Color;
import java.util.*;

public class Ethread extends Thread {
	public client c;
	public Panel p;
	public HashMap<Integer, ArrayList<Integer>> path;

	Ethread(client c, Panel panel, HashMap<Integer, ArrayList<Integer>> path) {
		this.c = c;
		p = panel;
		this.path = path;
	}

	public void run() {
		int f_fl=0,f_sec=0,l_fl=0,l_sec=0,init=0;
		for (int floor : path.keySet()) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp = path.get(floor);
			for (int i = 0; i < tmp.size(); ++i) {
				if(init == 0){
					f_fl = floor;
					f_sec = tmp.get(i);
				}
				l_fl = floor;
				l_sec = tmp.get(i);
				init++;
			}
		}
		start(f_fl,f_sec);
		circle();
		move(l_fl,l_sec);
		try {
			Thread.sleep(10);
		} catch (Exception ex) {
		}
		System.out.println("할당 체크");
		for (int i = 1; i <= 5; ++ i) {
			for (int j = 0; j < 8; ++ j) {
				System.out.print(Center.floor[i].section[j] + " ");
			}System.out.println("");
		}
	}
	public void get_in(E ele,int x){
		for (int i = 0; i < x; i++) {
			c.addx(i);
			if (x == 200) {
				if (i == x / 5) {
					Thread K = new Thread(ele);
					K.start();
				}
			} else {
				if (i == x / 2) {
					Thread K = new Thread(ele);
					K.start();
				}
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c.setVisible(false);
		}
		ele.cv(1);
		Thread K1 = new Thread(ele);
		K1.start();
		try {
			K1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void start(int floor, int sec) {
		if (floor == 1){
			if(sec == 1)
				get_in(Panel.E17,200);
			else if(sec == 3)
				get_in(Panel.E18,400);
			else if(sec == 5)
				get_in(Panel.E19,600);
			else
				get_in(Panel.E20,850);
		}
		else if (floor == 2){
			if(sec == 1)
				get_in(Panel.E13,200);
			else if(sec == 3)
				get_in(Panel.E14,400);
			else if(sec == 5)
				get_in(Panel.E15,600);
			else
				get_in(Panel.E16,850);
		}
		else if (floor == 3){
			if(sec == 1)
				get_in(Panel.E9,200);
			else if(sec == 3)
				get_in(Panel.E10,400);
			else if(sec == 5)
				get_in(Panel.E11,600);
			else
				get_in(Panel.E12,850);
		}
		else if (floor == 4){
			if(sec == 1)
				get_in(Panel.E5,200);
			else if(sec == 3)
				get_in(Panel.E6,400);
			else if(sec == 5)
				get_in(Panel.E7,600);
			else
				get_in(Panel.E8,850);
		}
		else if (floor == 5){
			if(sec == 1)
				get_in(Panel.E1,200);
			else if(sec == 3)
				get_in(Panel.E2,400);
			else if(sec == 5)
				get_in(Panel.E3,600);
			else
				get_in(Panel.E4,850);
		}		
	}
	public void circle() {
		Thread k=null;
		if (c.assign == 1) {
			section.s1.c = this.c;
			section.s1.path = this.path;
			 k = new Thread(section.s1);
			k.start();
		} else if (c.assign == 2) {
			section.s2.c = this.c;
			section.s2.path = this.path;
			 k = new Thread(section.s2);
			k.start();
		} else if (c.assign == 3) {
			section.s3.c = this.c;
			section.s3.path = this.path;
			k = new Thread(section.s3);
			k.start();
		} else if (c.assign == 4) {
			section.s4.c = this.c;
			section.s4.path = this.path;
			k = new Thread(section.s4);
			k.start();
		}else if (c.assign == 5) {
			section.s5.c = this.c;
			section.s5.path = this.path;
			k = new Thread(section.s5);
			k.start();
		}
		try {
			k.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// else if(Center.target==2)
		// section.s2.u_cir(section.s2.x,i+180);
		// else if(Center.target==3)
		// section.s3.u_cir(section.s3.x,i+50);
		// else if(Center.target==4)
		// section.s4.u_cir(section.s4.x,i);

	}
	public void get_out(E ele,int x){
		ele.cv(0);
		Thread K2 = new Thread(ele);
		K2.start();
		try {
			K2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = x; i < 1000; i++) {
			c.add_x(i);
			if (i == x+100) {
				ele.cv(1);
				Thread K3 = new Thread(ele);
				K3.start();
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void move(int floor, int sec) {
		if (floor == 1){
			if(sec == 1)
				get_out(Panel.E17,200);
			else if(sec == 3)
				get_out(Panel.E18,400);
			else if(sec == 5)
				get_out(Panel.E19,600);
			else
				get_out(Panel.E20,850);
		}
		else if (floor == 2){
			if(sec == 1)
				get_out(Panel.E13,200);
			else if(sec == 3)
				get_out(Panel.E14,400);
			else if(sec == 5)
				get_out(Panel.E15,600);
			else
				get_out(Panel.E16,850);
		}
		else if (floor == 3){
			if(sec == 1)
				get_out(Panel.E9,200);
			else if(sec == 3)
				get_out(Panel.E10,400);
			else if(sec == 5)
				get_out(Panel.E11,600);
			else
				get_out(Panel.E12,850);
		}
		else if (floor == 4){
			if(sec == 1)
				get_out(Panel.E5,200);
			else if(sec == 3)
				get_out(Panel.E6,400);
			else if(sec == 5)
				get_out(Panel.E7,600);
			else
				get_out(Panel.E8,850);
		}
		else if (floor == 5){
			if(sec == 1)
				get_out(Panel.E1,200);
			else if(sec == 3)
				get_out(Panel.E2,400);
			else if(sec == 5)
				get_out(Panel.E3,600);
			else
				get_out(Panel.E4,850);
		}
	}
}
