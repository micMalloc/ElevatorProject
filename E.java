package ATP;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

// 엘리베이터 문
class E extends JPanel implements Runnable {
	ImageIcon e1 = new ImageIcon("el1.png");
	ImageIcon e2 = new ImageIcon("el2.png");
	ImageIcon e3 = new ImageIcon("el3.png");
	ImageIcon e4 = new ImageIcon("el4.png");
	ImageIcon e5 = new ImageIcon("el5.png");
	ImageIcon e6 = new ImageIcon("el6.png");
	ImageIcon e7 = new ImageIcon("el7.png");
	ImageIcon e8 = new ImageIcon("el8.png");
	ImageIcon e9 = new ImageIcon("el9.png");
	ImageIcon e10 = new ImageIcon("el10.png");
	ImageIcon e11 = new ImageIcon("el11.png");
	ImageIcon e12 = new ImageIcon("el12.png");
	ImageIcon e13 = new ImageIcon("el13.png");
	ImageIcon e14 = new ImageIcon("el14.png");
	ImageIcon e15 = new ImageIcon("el15.png");
	Image[] originImg = new Image[5] ;
	Image[] changedImg= new Image[5];
	int i=0;
	static int value=0;
	E(int x, int y, int w, int z,  int fl) {
		setBounds(x, y, w, z);
		if(fl==4){
		originImg[0] = e13.getImage();
		originImg[1] = e14.getImage();
		originImg[2] = e15.getImage();
		originImg[3] = e14.getImage();
		originImg[4] = e13.getImage();
		for(int i =0; i<5;i++){
			changedImg[i]=originImg[i].getScaledInstance(100, 90, Image.SCALE_SMOOTH );
		}
		}
		else if(fl==5){
		originImg[0] = e4.getImage();
		originImg[1] = e5.getImage();
		originImg[2] = e6.getImage();
		originImg[3] = e5.getImage();
		originImg[4] = e4.getImage();
		for(int i =0; i<5;i++){
			changedImg[i]=originImg[i].getScaledInstance(100, 90, Image.SCALE_SMOOTH );
		}
		}
		else if(fl==3){
		originImg[0] = e7.getImage();
		originImg[1] = e8.getImage();
		originImg[2] = e9.getImage();
		originImg[3] = e8.getImage();
		originImg[4] = e7.getImage();
		for(int i =0; i<5;i++){
			changedImg[i]=originImg[i].getScaledInstance(100, 90, Image.SCALE_SMOOTH );
		}
		}
		else if(fl==2){
			originImg[0] = e10.getImage();
			originImg[1] = e11.getImage();
			originImg[2] = e12.getImage();
			originImg[3] = e11.getImage();
			originImg[4] = e10.getImage();
			for(int i =0; i<5;i++){
				changedImg[i]=originImg[i].getScaledInstance(100, 90, Image.SCALE_SMOOTH );
			}
			}
		else{
			originImg[0] = e1.getImage();
			originImg[1] = e2.getImage();
			originImg[2] = e3.getImage();
			originImg[3] = e2.getImage();
			originImg[4] = e1.getImage();
			for(int i =0; i<5;i++){
				changedImg[i]=originImg[i].getScaledInstance(100, 90, Image.SCALE_SMOOTH );
			}
			}
	}
	public static void cv(int v){
		value= v;
	}

	public synchronized void run() {
		if(value==0){
			while(i<2){
				System.out.println(i);
			repaint();
				try {
					Thread.sleep(1000);
				} catch (Exception ex) {
				}
				i++;
			}
		}
		else{
			while(i<5){
				System.out.println(i);
			repaint();
				try {
					Thread.sleep(1000);
				} catch (Exception ex) {
				}
				i++;
			}
			if(i==5)
				i=0;
		}
	}

	public void paint(Graphics g) {
		g.drawImage(changedImg[i], 0, 0, this);
		setOpaque(false);// 배경 띄워주기
		super.paint(g);
	}
}