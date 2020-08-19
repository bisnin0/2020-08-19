package java10_thread;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class JSplitPane0819 extends JFrame { //이걸 스레드로 해야하나?
	CalendarSwing2 calendar = new CalendarSwing2();
	PackManEX2 pm = new PackManEX2();
	DigitalClockEX2 dc2 = new DigitalClockEX2(); 
	RGBEX2 rgb = new RGBEX2();
	CalculatorSwing2 calculator = new CalculatorSwing2();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	
	public JSplitPane0819() {
		
		JSplitPane sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, dc2, calendar);
		JSplitPane sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp2, pm);
		add(sp1);
		
		sp1.setDividerLocation(500);
		sp2.setDividerLocation(300);
		
		sp1.setDividerSize(50); // 위아래 경계선의 폭을 결정한다.
		
		
		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
		
	}
	public void p3() {
	}
	
				


	public static void main(String[] args) {
		new JSplitPane0819();
		
	}

}
