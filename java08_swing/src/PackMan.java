

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PackMan extends JFrame {
	MyCanvas mc = new MyCanvas();
	MyAdapter ma = new MyAdapter();
	int x=170,y=150,w=220,h=200;
	Image img;
	int a=0, b=1; //이미지 바꾸기
	int q=1; //방향설정
	int start = 0;
	
	public PackMan() {
		super("Pack-Man");

		add(mc);
		mc.repaint();
		
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		while(true) { //방향설정
			mc.addKeyListener(ma);
			if(q==1) {
				left();
			}else if(q==2) {
				right();
			}else if(q==3) {
				top();
			}else if(q==4) {
				bottom();
			}
			mc.repaint();
			try {
				Thread.sleep(100);
			}catch(Exception e) {}
		}
	}
	
	public void left() {
		x-=10;
		w-=10;	
		if(a==0) {
			a++; b++;
		}else if(a==1) {
			a--; b--;
		}
		if(w==0) {
			x+=400; w+=400;
		}
	}
	
	public void right() {
		x+=10;
		w+=10;	
		if(a==2) {
			a++; b++;
		}else if(a==3) {
			a--; b--;
		}
		if(w==430) {
			x-=400; w-=400;
		}
	}
	
	public void top() {
		y-=10;
		h-=10;	
		if(a==4) {
			a++; b++;
		}else if(a==5) {
			a--; b--;
		}
		if(h==0) {
			y+=400; h+=400;
		}
	} 
	
	public void bottom() {
		y+=10;
		h+=10;	
		if(a==6) {
			a++; b++;
		}else if(a==7) {
			a--; b--;
		}
		if(h==430) {
			y-=400; h-=400;
		}
	}
	
	class MyAdapter extends KeyAdapter{
		public void keyPressed(KeyEvent ke) {
			int key = ke.getKeyCode();
			if("A".equals(ke.getKeyText(key)) || key==KeyEvent.VK_LEFT) {
				a=0; b=1; q=1;
			}else if("D".equals(ke.getKeyText(key)) || key==KeyEvent.VK_RIGHT) {
				a=2; b=3; q=2;
			}else if("W".equals(ke.getKeyText(key)) || key==KeyEvent.VK_UP) {
				a=4; b=5; q=3;
			}else if("S".equals(ke.getKeyText(key)) || key==KeyEvent.VK_DOWN) {
				a=6; b=7; q=4;
			}		
		}
	} 

	public class MyCanvas extends Canvas{
		MyCanvas(){
			img = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
		}
		
		public void paint(Graphics g) {
			g.drawString("화면을 한번 누르면 시작합니다.", 105, 80);
			g.drawString("조작키 : W,A,S,D or 방향키", 120, 100);
			int pw = img.getWidth(this);
			int ph = img.getHeight(this);
			int imgw = pw/8;
			int imgh = ph/10;
			g.drawImage(img, x, y, w, h, imgw*a, imgh/3, imgw*b, imgh*10, this);
			
		}
	}
	
	public static void main(String[] args) {
		new PackMan();
	}

}
