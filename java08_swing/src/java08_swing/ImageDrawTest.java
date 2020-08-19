package java08_swing;
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
		String[] btnLbl = {"�����׸���", "���", "Ȯ��", "�¿������", "���ϵ�����", "�Ϻα׸���"};
	MyCanvas mc = new MyCanvas();
	Image img;
	String event = ""; //�̺�Ʈ�� ����� �� �̺�Ʈ�� ����� ���⿡ �־���� �ٸ������� ȣ��Ǹ� ���ǰԲ�
	public ImageDrawTest() {
		super("�̹��� �׸���");
		
		for(String lbl : btnLbl) {
			JButton btn = new JButton(lbl);
			pane.add(btn);
			//�̺�Ʈ ���
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
		//mc.paint(); �̷��� �ϸ� �ȵȴ�.
		mc.repaint(); //����Ʈ �޼ҵ带 ȣ�����ִ� �޼ҵ�
	}
	
	class MyCanvas extends Canvas{
		MyCanvas(){
			img = Toolkit.getDefaultToolkit().getImage("img/K1.jpg");
		}
		public void paint(Graphics g) {
			//�̹����� ���� ���̸� ���Ѵ�.(�ݵ�� paint()�޼ҵ忡�� ���Ѵ�.)
			//�������̴� �̹��� ��ü�� ���ؼ� ���ϸ� �ȴ�.
			int w = img.getWidth(this);
			int h = img.getHeight(this);
			
			if(event.equals("�����׸���")) {
				//�̹��� �׸���
				g.drawImage(img, 1, 1, this);
			}else if(event.equals("���")) { //���� ��ư�� ����ΰ��
				//					�׸� ������ ũ��
				g.drawImage(img, 1, 1, w/2, h/2, this);
				
			}else if(event.equals("Ȯ��")) {
				g.drawImage(img, 1, 1, w*2, h*2, this);
			}else if(event.equals("�¿������")) {
//				g.drawImage(img, dx1, dy1, dx2, dy2,//// sx1, sy1, sx2, sy2, observer);
//									�׸��� �׸� ����		�׸�   �̹��� ������ġ
				//									       X , Y
				g.drawImage(img, 0, 0,  w, h, 
								 w, 0,  0, h, this);
			}else if(event.equals("���ϵ�����")) {
				g.drawImage(img, 0, 0, w, h, 
								 0, h, w, 0, this);
			}else if(event.equals("�Ϻα׸���")) {
				int imgw = w/10; //�̹��� ������ ���� ��ü
				int imgh = h/10;
				g.drawImage(img, 0, 0, w, h, imgw, imgh, imgw*5, imgh*5, this);
			}
			
			
		}
	}
	
	public static void main(String[] args) {
		new ImageDrawTest();
	}

}
