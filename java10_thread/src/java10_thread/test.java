package java10_thread;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class test extends JFrame {
	CalendarSwing2 calendar = new CalendarSwing2();
	PackManEX2 pm = new PackManEX2();
	DigitalClockEX2 dc2 = new DigitalClockEX2();
	RGBEX2 rgb = new RGBEX2();
	CalculatorSwing2 calculator = new CalculatorSwing2();
	public test() {

	JSplitPane sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, calendar, calculator);//�� ���ø��� �¿�� ������.
	
	JSplitPane sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, rgb, sp2); //�� ���ø��� �� �Ʒ��� �����ڴ�.
//	JSplitPane sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, dc2, calendar);
//	JSplitPane sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp2, pm);
	add(sp1);
	
	sp1.setDividerLocation(500);//������ 500�ȼ� ���������� ��輱�� �ߴ´�. ���Ʒ��� �������̶�.
	sp2.setDividerLocation(600);//���ʿ��� 600�ȼ� ���������� ��輱�� �ߴ´�. �¿�� �������̶�.
	
	sp1.setDividerSize(50); // ���Ʒ� ��輱�� ���� �����Ѵ�.
	sp2.setDividerSize(20); // �¿� ��輱�� ���� �����Ѵ�.
	
	sp1.setOneTouchExpandable(true); //��輱�� ������ ���� ���� ���� �� �ְ� ����
	sp2.setOneTouchExpandable(true); //
	
	setSize(1200, 1000);
	setVisible(true);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new test();
	}

}
