package java08_swing;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class GraphicsTest extends JFrame {

	

	public GraphicsTest() {
		super("�׸� �׸���");

		MyCanvas canvas = new MyCanvas(); //����Ŭ�������� ��ӹ޾Ƽ� ��ü����
		add(canvas);
		
		setSize(900,900);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	class MyCanvas extends Canvas{
		public void paint(Graphics g) {
			//���ڿ� �׸���
			g.drawString("���ڿ� �׸���", 430, 100);
			//���� �׸���
			g.drawLine(50, 50, 300, 300); //�밢������ ���� �׸���
			//�簢�� �׸���
			g.drawRect(100, 50, 300, 100);
			//�簢�� �׸��� - ä����

			g.fillRect(100, 200, 300, 100);
			//�׸����� ����
			g.setColor(Color.YELLOW);//�簢�� �ڽ� �׸��� ���� ���� ���� �����ؾ� ����ȴ�.
			g.fillRect(450, 200, 300, 100);
			
			
			g.setColor(Color.BLUE);
			//���׸���
			g.drawOval(50, 50, 300, 200);
			g.fillOval(50, 250, 200, 200);
			
			//�׵θ��� �ձ� �簢��
			g.fillRoundRect(10, 500, 300, 300, 150, 150);
			
			//�ٰ���
			int x[] = {760, 740, 570, 520, 485};
			int y[] = {455, 550, 700, 677, 555};
//			g.setColor(Color.BLUE); ������ �� �����ϸ� �� �Ƚᵵ �ڵ�����
			g.drawPolygon(x, y, x.length);
			
			
		}
		
	}

	public static void main(String[] args) {
		new GraphicsTest();
	}

}
