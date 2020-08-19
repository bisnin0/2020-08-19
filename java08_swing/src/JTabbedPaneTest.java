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
	JButton btn = new JButton("���г� �׽�Ʈ ��");
	ImageIcon ii =new ImageIcon("img/k2.jpg");
	JLabel lbl = new JLabel(ii);
	ImageIcon ii2 = new ImageIcon("img/k6.jpg");
	ImageIcon ii3 = new ImageIcon("img/k7.jpg");
	
			
	
	RGBEX2 rgb = new RGBEX2(); //ta�������ϱ� ������ �ȵȴ�.
	
	CalculatorSwing2 cs2 = new CalculatorSwing2();
	
	CalendarSwing2 cs3 = new CalendarSwing2();
	
	
	public JTabbedPaneTest() {
		super("�Ǹ޴�");
		//		     ����, ����
		pane.add("��ư", btn);
		pane.add("�̹���", lbl);
		pane.add("����ǥ", rgb);
		
		
		//�Ǹ޴� ����							     1��° �ǿ� �߰�. 0,1,2,3,4
		pane.insertTab("����", ii2, cs2, "�����Դϴ�", 1); //�߰��� ����.. //4��° tip�κ��� ���콺 �ø��� ������ ǳ������
		pane.insertTab("�޷�", null, cs3, null, 3); //�̹��� �ȳ����� null	
		
		
		add(pane);
		setSize(700, 700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		try {
			Thread.sleep(3000);
		}catch(Exception e) {} ///3�� �ִٰ�
		//�Ǹ޴��� Ȱ��ȭ(true), ��Ȱ��ȭ(false)
		//setEnabled() : ù��° ��(������?)�� Ȱ��ȭ�ϰ� ������ ���� ��Ȱ��ȭ��Ų��.
//		pane.setEnabled(false); ///3�� �ִٰ� �̰� ����Ŵ�.
		//��ü��Ȱ��ȭ�� �ع����� �Ʒ��� �Ϻ�Ȱ��ȭ�� ����� �� ����.
		
		pane.setEnabledAt(3, false); //������ ���� ��Ȱ��ȭ�ع����� ��Ȱ��ȭ�� �ȵǴϱ� �Ϻθ� ��Ȱ��ȭ�غ�
		
		try {
			Thread.sleep(3000);
		}catch(Exception e) {} ///3�� �ִٰ�
		//���ϴ� �Ǹ� Ȱ��ȭ, ��Ȱ��ȭ
		pane.setEnabledAt(3, true); //3���� Ȱ��ȭ
		
		//�Ǹ޴� ��ġ �̵�
		pane.setTabPlacement(JTabbedPane.LEFT);
		
		
	}

	public static void main(String[] args) {
		new JTabbedPaneTest();
	}

}
