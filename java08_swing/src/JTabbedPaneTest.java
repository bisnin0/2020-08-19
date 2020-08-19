import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import java08_swing.CalculatorSwing2;
import java08_swing.CalendarSwing2;
import java08_swing.RGBEX2;

public class JTabbedPaneTest extends JFrame {
	JTabbedPane pane = new JTabbedPane(); 
	JButton btn = new JButton("탭패널 테스트 중");
	ImageIcon ii =new ImageIcon("img/k2.jpg");
	JLabel lbl = new JLabel(ii);
	ImageIcon ii2 = new ImageIcon("img/k6.jpg");
	ImageIcon ii3 = new ImageIcon("img/k7.jpg");
	
			
	
	RGBEX2 rgb = new RGBEX2(); //ta가없으니까 적용은 안된다.
	
	CalculatorSwing2 cs2 = new CalculatorSwing2();
	
	CalendarSwing2 cs3 = new CalendarSwing2();
	
	
	public JTabbedPaneTest() {
		super("탭메뉴");
		//		     제목, 내용
		pane.add("버튼", btn);
		pane.add("이미지", lbl);
		pane.add("색상표", rgb);
		
		
		//탭메뉴 삽입							     1번째 탭에 추가. 0,1,2,3,4
		pane.insertTab("계산기", ii2, cs2, "계산기입니다", 1); //중간에 삽입.. //4번째 tip부분은 마우스 올리면 나오는 풍선도움말
		pane.insertTab("달력", null, cs3, null, 3); //이미지 안넣을때 null	
		
		
		add(pane);
		setSize(700, 700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		try {
			Thread.sleep(3000);
		}catch(Exception e) {} ///3초 있다가
		//탭메뉴의 활성화(true), 비활성화(false)
		//setEnabled() : 첫번째 탭(선택한?)만 활성화하고 나머지 탭은 비활성화시킨다.
//		pane.setEnabled(false); ///3초 있다가 이걸 만들거다.
		//전체비활성화를 해버리면 아래의 일부활성화를 사용할 수 없다.
		
		pane.setEnabledAt(3, false); //위에서 전부 비활성화해버리면 재활성화가 안되니까 일부만 비활성화해봄
		
		try {
			Thread.sleep(3000);
		}catch(Exception e) {} ///3초 있다가
		//원하는 탭만 활성화, 비활성화
		pane.setEnabledAt(3, true); //3번탭 활성화
		
		//탭메뉴 위치 이동
		pane.setTabPlacement(JTabbedPane.LEFT);
		
		
	}

	public static void main(String[] args) {
		new JTabbedPaneTest();
	}

}
