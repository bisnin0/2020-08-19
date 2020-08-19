import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class GraphicsTest extends JFrame {

	

	public GraphicsTest() {
		super("그림 그리기");

		MyCanvas canvas = new MyCanvas(); //내부클래스에서 상속받아서 객체생성
		add(canvas);
		
		setSize(900,900);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	class MyCanvas extends Canvas{
		public void paint(Graphics g) {
			//문자열 그리기
			g.drawString("문자열 그리기", 430, 100);
			//직선 그리기
			g.drawLine(50, 50, 300, 300); //대각선으로 직선 그리기
			//사각형 그리기
			g.drawRect(100, 50, 300, 100);
			//사각형 그리기 - 채워진

			g.fillRect(100, 200, 300, 100);
			//그림색상 설정
			g.setColor(Color.YELLOW);//사각형 박스 그리기 전에 색상 먼저 설정해야 적용된다.
			g.fillRect(450, 200, 300, 100);
			
			
			g.setColor(Color.BLUE);
			//원그리기
			g.drawOval(50, 50, 300, 200);
			g.fillOval(50, 250, 200, 200);
			
			//테두리가 둥근 사각형
			g.fillRoundRect(10, 500, 300, 300, 150, 150);
			
			//다각형
			int x[] = {760, 740, 570, 520, 485};
			int y[] = {455, 550, 700, 677, 555};
//			g.setColor(Color.BLUE); 위에서 색 설정하면 또 안써도 자동적용
			g.drawPolygon(x, y, x.length);
			
			
		}
		
	}

	public static void main(String[] args) {
		new GraphicsTest();
	}

}
