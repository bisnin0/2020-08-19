import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ImageDrawTest extends JFrame implements ActionListener{
	JPanel pane = new JPanel();
		String[] btnLbl = {"원본그리기", "축소", "확대", "좌우뒤집기", "상하뒤집기", "일부그리기"};
	MyCanvas mc = new MyCanvas();
	Image img;
	String event = ""; //이벤트가 생기면 그 이벤트의 벨류어를 여기에 넣어놓고 다른곳에서 호출되면 사용되게끔
	public ImageDrawTest() {
		super("이미지 그리기");
		
		for(String lbl : btnLbl) {
			JButton btn = new JButton(lbl);
			pane.add(btn);
			//이벤트 등록
			btn.addActionListener(this);
		}
		add(BorderLayout.NORTH, pane);
		add(mc);
		setSize(700, 700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae) {
		event = ae.getActionCommand();
		//mc.paint(); 이렇게 하면 안된다.
		mc.repaint(); //페인트 메소드를 호출해주는 메소드
	}
	
	class MyCanvas extends Canvas{
		MyCanvas(){
			img = Toolkit.getDefaultToolkit().getImage("img/K1.jpg");
		}
		public void paint(Graphics g) {
			//이미지의 폭과 높이를 구한다.(반드시 paint()메소드에서 구한다.)
			//폭과높이는 이미지 객체를 통해서 구하면 된다.
			int w = img.getWidth(this);
			int h = img.getHeight(this);
			
			if(event.equals("원본그리기")) {
				//이미지 그리기
				g.drawImage(img, 1, 1, this);
			}else if(event.equals("축소")) { //누른 버튼이 축소인경우
				//					그릴 공간의 크기
				g.drawImage(img, 1, 1, w/2, h/2, this);
				
			}else if(event.equals("확대")) {
				g.drawImage(img, 1, 1, w*2, h*2, this);
			}else if(event.equals("좌우뒤집기")) {
//				g.drawImage(img, dx1, dy1, dx2, dy2,//// sx1, sy1, sx2, sy2, observer);
//									그림을 그릴 공간		그림   이미지 시작위치
				//									       X , Y
				g.drawImage(img, 0, 0,  w, h, 
								 w, 0,  0, h, this);
			}else if(event.equals("상하뒤집기")) {
				g.drawImage(img, 0, 0, w, h, 
								 0, h, w, 0, this);
			}else if(event.equals("일부그리기")) {
				int imgw = w/10; //이미지 사이즈 정한 객체
				int imgh = h/10;
				g.drawImage(img, 0, 0, w, h, imgw, imgh, imgw*5, imgh*5, this);
			}
			
			
		}
	}
	
	public static void main(String[] args) {
		new ImageDrawTest();
	}

}
