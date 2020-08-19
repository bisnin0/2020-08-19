import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

////////랜덤으로 이미지가 계속 출력되게 만들기
public class GraphicsTest2 extends JFrame {

	MyCanvas mc = new MyCanvas();
	Random ran = new Random();
	int x,y,w,h;
	public GraphicsTest2() {
		add(mc);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		while(true) {
			x = ran.nextInt(300);
			y = ran.nextInt(300);
			w = ran.nextInt(100)+5;
			h = ran.nextInt(100)+5;
			
			mc.repaint(); /////repaint()는 update();가 있으면 update를 갔다가 paint로 간다. 없으면 바로 paint로 간다.
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				
			}
		}
	}
	public class MyCanvas extends Canvas{
		public void paint(Graphics g) {
			g.fillOval(x, y, w, h);
		}
		public void update(Graphics g) { //이렇게 하면 repaint를 만날때 여기와서 먼저 실행한다.  //이부분 없으면 원 찍혔다가 사라진다.
			paint(g);  //원이 사라지지않고 누적된다. //찍은게 남겨지게 하려면 이렇게 업데이트메소드 만들면된다. 
		}
	}

	public static void main(String[] args) {
		new GraphicsTest2(); 
	}

}
