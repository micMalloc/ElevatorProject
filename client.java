package ATP;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

// 사람 조절용
class client extends JPanel {
	int x, d_x;
	int y, d_y;
	ImageIcon icon;
	public double weight;
	public int direction;
	public int current;
	public int assign;
	/* The Destination person want */
	public int want;
	/* This Person is in or not elevator */
	public boolean isIn;

	public client(ImageIcon a, int current) {
		setOpaque(false);
		setBounds(x, y + 80, 50, 100);
		icon = a;
		setVisible(false);
		this.current = current;
		weight = (int)(Math.random() * 100) + 1;
		isIn = false;
		/* Set direction */
		if (want - current > 0) {
			/* UP */
			direction = 1;
		}
		else {
			/* Down */
			direction = -1;
		}
	}

	public void addx(int i) {
		setVisible(true);
		setBounds(i, y + 80, 50, 100);
	}

	public void add_x(int i) {
		setVisible(true);
		setBounds(i, d_y + 80, 50, 100);
	}

	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void d_set(int y, int want) {
		d_y = y;
		this.want = want;
	}
	public void dy_set(int y){
		d_y=y;
	}

	public void dset(int x) {
		d_x = x;
	}

	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
		super.paintComponent(g);
	}
}
