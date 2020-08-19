import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;


public class PackManEX extends JFrame {
	Image img;
	int x, y;
	int p=0;
	MyCanvas1 canvas;
	
	
	public PackManEX() {
		setSize(500,500);
		img = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
		canvas = new MyCanvas1();
		add(canvas);
		x = this.getWidth() / 2 -25;
		y = this.getHeight() / 2 - 25;
		
		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//////����Ű �ȸԴµ� ������?
//		addKeyListener(new KeyAdapter() {
//			public void keyReleased(KeyEvent k) {
//				System.out.println("����");
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
		
		/////////////////////////������ â�� ���콺�� Ŭ���ϸ� ����Ű��ȯ �ȸ���. ĵ���� ��ü�� �ٸ��� ���õǾ? �ƹ�ư �����Ұ�.
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
			
			canvas.repaint(); //Canvas�� ��ü �ȿ� �����ϱ�.
			
			//������ȯ
/*			
			if(p==0) p++; //0->1
			else if(p==1) p--; //1->0
*/
			if(p%2==0) p++; //0->1 //��Ģ�� �����ϱ� ������ ����ؼ� ���� �� �ȼ���� �̷��� �ٲٸ� �����ϰ� ����. �̷��� ����
			else p--; //1->0
			
			
			
			//��ǥ�̵�
			if(p==0 || p==1) { //��������
				x-=5;
				if(x<=-50) {
					x=canvas.getWidth(); //ĵ���� ����ŭ
				}
			}else if(p==2 || p==3) { //����������
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
	
	
	class MyCanvas1 extends Canvas{
		
		MyCanvas1(){
		}
		public void paint(Graphics g) {
			//			canvas					      img
			g.drawImage(img, x, y, x+50, y+50, 		p*50, 0, p*50+50, 50, this);
		}
		
	}
	
	public static void main(String[] args) {
		new PackManEX();
	}

}