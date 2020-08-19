import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class MouseEventTest extends JFrame {
	
	MyCanvas mc = new MyCanvas();
	MyAdapter ma = new MyAdapter();
	int startX, startY;
	int lastX, lastY;
	int btn=0;
	
	public MouseEventTest() {
		add(mc);

		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		mc.addMouseListener(ma); //아래처럼 adapter를 만들면 adapter클래스의 객체를 만들어서 넣어야 한다. 그냥 this하면안된다.
		mc.addMouseMotionListener(ma);
	}
	class MyAdapter extends MouseAdapter{
		//마우스를 누른 상태일때
		public void mousePressed(MouseEvent me) { //마우스 클릭시 생기는 이벤트
			//me에는 x,y좌표와 마우스를 뭘 눌렀는지가 담겨있다.(마우스버튼 어떤건지)
			btn = me.getButton(); //왼쪽버튼:1, 가운데(휠클릭):2, 오른쪽버튼:3
			if(btn==MouseEvent.BUTTON1) {//생긴 이벤트가 1과 같으면
				startX = me.getX(); //마우스가 클릭된 X좌표가 구해진다.
				startY = me.getY(); //마우스가 클릭된 Y좌표가 구해진다.
			}
		}
		public void mouseReleased(MouseEvent me) {//마우스를 클릭했다가 놨을때 생기는 이벤트.. 마우스에서 손을 놨을때 생김
			
//1번주석			if(me.getButton() == MouseEvent.BUTTON1) {
//직선그리기		lastX = me.getX(); //마우스에서 손을 놓은 X좌표를 구한다.
//				lastY = me.getY(); //마우스에서 손을 놓은 Y좌표를 구한다.
//				mc.repaint(); //그림이 그려져야 한다.
//			}
			btn=0;
		}
		public void mouseDragged(MouseEvent me) { //마우스를 움직인걸 따라가면서 그려지는것.. 드래그
			lastX = me.getX(); 
			lastY = me.getY();
			
			if(btn == MouseEvent.BUTTON1) {//왼쪽버튼이 눌러진 상태라면
				mc.repaint();
			}
			startX = lastX;
			startY = lastY;
		}
	}
	
	class MyCanvas extends Canvas{
		public void paint(Graphics g) {
			
			g.drawLine(startX, startY, lastX, lastY);
			
		}
		public void update(Graphics g) {
			paint(g);
		}
	}

	public static void main(String[] args) {
		new MouseEventTest();
		
	}

}
