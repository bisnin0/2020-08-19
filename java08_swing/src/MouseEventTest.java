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
		mc.addMouseListener(ma); //�Ʒ�ó�� adapter�� ����� adapterŬ������ ��ü�� ���� �־�� �Ѵ�. �׳� this�ϸ�ȵȴ�.
		mc.addMouseMotionListener(ma);
	}
	class MyAdapter extends MouseAdapter{
		//���콺�� ���� �����϶�
		public void mousePressed(MouseEvent me) { //���콺 Ŭ���� ����� �̺�Ʈ
			//me���� x,y��ǥ�� ���콺�� �� ���������� ����ִ�.(���콺��ư �����)
			btn = me.getButton(); //���ʹ�ư:1, ���(��Ŭ��):2, �����ʹ�ư:3
			if(btn==MouseEvent.BUTTON1) {//���� �̺�Ʈ�� 1�� ������
				startX = me.getX(); //���콺�� Ŭ���� X��ǥ�� ��������.
				startY = me.getY(); //���콺�� Ŭ���� Y��ǥ�� ��������.
			}
		}
		public void mouseReleased(MouseEvent me) {//���콺�� Ŭ���ߴٰ� ������ ����� �̺�Ʈ.. ���콺���� ���� ������ ����
			
//1���ּ�			if(me.getButton() == MouseEvent.BUTTON1) {
//�����׸���		lastX = me.getX(); //���콺���� ���� ���� X��ǥ�� ���Ѵ�.
//				lastY = me.getY(); //���콺���� ���� ���� Y��ǥ�� ���Ѵ�.
//				mc.repaint(); //�׸��� �׷����� �Ѵ�.
//			}
			btn=0;
		}
		public void mouseDragged(MouseEvent me) { //���콺�� �����ΰ� ���󰡸鼭 �׷����°�.. �巡��
			lastX = me.getX(); 
			lastY = me.getY();
			
			if(btn == MouseEvent.BUTTON1) {//���ʹ�ư�� ������ ���¶��
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
