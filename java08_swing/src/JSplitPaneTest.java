import javax.swing.JFrame;
import javax.swing.JSplitPane;

import java08_swing.CalculatorSwing2;
import java08_swing.CalendarSwing2;
import java08_swing.RGBEX2;
	//창을 분할해서 내용을 표시하는 방법
public class JSplitPaneTest extends JFrame {
	CalendarSwing2 calendar = new CalendarSwing2();
	RGBEX2 rgb = new RGBEX2();
	CalculatorSwing2 calculator = new CalculatorSwing2();
	
	public JSplitPaneTest() {
		
		
		
		JSplitPane sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, calendar, calculator);//이 스플릿을 좌우로 나눈다.
		
		JSplitPane sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, rgb, sp2); //이 스플릿을 위 아래로 나누겠다.
		add(sp1);
		
		sp1.setDividerLocation(500);//위에서 500픽셀 떨어진곳에 경계선을 긋는다. 위아래로 나뉜것이라.
		sp2.setDividerLocation(600);//왼쪽에서 600픽셀 떨어진곳에 경계선을 긋는다. 좌우로 나뉜것이라.
		
		sp1.setDividerSize(50); // 위아래 경계선의 폭을 결정한다.
		sp2.setDividerSize(20); // 좌우 경계선의 폭을 결정한다.
		
		sp1.setOneTouchExpandable(true); //경계선을 눌러서 한쪽 탭을 숨길 수 있게 만듬
		sp2.setOneTouchExpandable(true); //
		
		setSize(1200, 1000);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JSplitPaneTest();
	}

}
