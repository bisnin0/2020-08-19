package java10_thread;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;


public class PackManEX2 extends JFrame implements Runnable{
	Image img;
	int x, y;
	int p=0;
	MyCanvas1 canvas;
	
	
	public PackManEX2() {
////		setSize(500,500);
//		img = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
//		canvas = new MyCanvas1();
//		add(canvas);
//		x = this.getWidth() / 2 -25;
//		y = this.getHeight() / 2 - 25;
//		
//		
//		setVisible(true);
////		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		//////방향키 안먹는데 이유가?
////		addKeyListener(new KeyAdapter() {
////			public void keyReleased(KeyEvent k) {
////				System.out.println("수정");
////				int key = k.getKeyCode();
////				if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
////					p=0; 
////				}else if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
////					p=2;
////				}else if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
////					p=4;
////				}else if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
////					p=6;
////				}
////			}
////		});
//		
//		/////////////////////////생성된 창을 마우스로 클릭하면 방향키전환 안먹힘. 캔버스 객체가 다른게 선택되어서? 아무튼 주의할것.
//		//keyEvent
//		addKeyListener(new KeyAdapter() {
//			public void keyReleased(KeyEvent ke) {
//				System.out.println("fdsfds");
//				int key = ke.getKeyCode();
//				if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
//					p=0; 
//				}else if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
//					p=2;
//				}else if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
//					p=4;
//				}else if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
//					p=6;
//				}
//			}
//		});
//		
//		
//		while(true) {
//			
//			canvas.repaint(); //Canvas가 객체 안에 있으니까.
//			
//			//방향전환
///*			
//			if(p==0) p++; //0->1
//			else if(p==1) p--; //1->0
//*/
//			if(p%2==0) p++; //0->1 //규칙이 있으니까 위에껄 계속해서 조건 식 안세우고 이렇게 바꾸면 간단하고 좋다. 이런걸 이해
//			else p--; //1->0
//			
//			
//			
//			//좌표이동
//			if(p==0 || p==1) { //왼쪽으로
//				x-=5;
//				if(x<=-50) {
//					x=canvas.getWidth(); //캔버스 폭만큼
//				}
//			}else if(p==2 || p==3) { //오른쪽으로
//				x+=5;
//				if(x>=canvas.getWidth()) {
//					x=-50;
//				}
//			}else if(p==4 || p==5) {
//				y-=5;
//				if(y<=-5) {
//					y=canvas.getHeight();
//				}
//			}else if(p==6 || p==7) {
//				y+=5;
//				if(y>=canvas.getHeight()) {
//					y=-50;
//				}
//			}
//			
//			
//			try {
//				Thread.sleep(150);
//			}catch(Exception e) {}
//		}
//		
	}
	
	
	class MyCanvas1 extends Canvas{
		
		MyCanvas1(){
		}
		public void paint(Graphics g) {
			//			canvas					      img
			g.drawImage(img, x, y, x+50, y+50, 		p*50, 0, p*50+50, 50, this);
		}
		
	}
	
	public void run() {
//		setSize(500,500);
		img = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
		canvas = new MyCanvas1();
		add(canvas);
		x = this.getWidth() / 2 -25;
		y = this.getHeight() / 2 - 25;
		
		
		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//////방향키 안먹는데 이유가?
//		addKeyListener(new KeyAdapter() {
//			public void keyReleased(KeyEvent k) {
//				System.out.println("수정");
//				int key = k.getKeyCode();
//				if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
//					p=0; 
//				}else if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
//					p=2;
//				}else if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
//					p=4;
//				}else if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
//					p=6;
//				}
//			}
//		});
		
		/////////////////////////생성된 창을 마우스로 클릭하면 방향키전환 안먹힘. 캔버스 객체가 다른게 선택되어서? 아무튼 주의할것.
		//keyEvent
		addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				System.out.println("fdsfds");
				int key = ke.getKeyCode();
				if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
					p=0; 
				}else if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
					p=2;
				}else if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
					p=4;
				}else if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
					p=6;
				}
			}
		});
		
		
		while(true) {
			
			canvas.repaint(); //Canvas가 객체 안에 있으니까.
			
			//방향전환
/*			
			if(p==0) p++; //0->1
			else if(p==1) p--; //1->0
*/
			if(p%2==0) p++; //0->1 //규칙이 있으니까 위에껄 계속해서 조건 식 안세우고 이렇게 바꾸면 간단하고 좋다. 이런걸 이해
			else p--; //1->0
			
			
			
			//좌표이동
			if(p==0 || p==1) { //왼쪽으로
				x-=5;
				if(x<=-50) {
					x=canvas.getWidth(); //캔버스 폭만큼
				}
			}else if(p==2 || p==3) { //오른쪽으로
				x+=5;
				if(x>=canvas.getWidth()) {
					x=-50;
				}
			}else if(p==4 || p==5) {
				y-=5;
				if(y<=-5) {
					y=canvas.getHeight();
				}
			}else if(p==6 || p==7) {
				y+=5;
				if(y>=canvas.getHeight()) {
					y=-50;
				}
			}
			
			
			try {
				Thread.sleep(150);
			}catch(Exception e) {}
		}
		
	}
	
//	public static void main(String[] args) {
//		new PackManEX();
//	}

}
