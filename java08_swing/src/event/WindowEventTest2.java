package event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
//////////WindowEventHandler2�� �ܺ�Ŭ������ �̺�Ʈó��
public class WindowEventTest2 extends JFrame{ //Frame�� ��ӹ����� Adapter�� ��ӹ��� �� ����. Ŭ�����ϱ�. Ŭ������ 1���� ��� �����ϴ�.

	public WindowEventTest2() {
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		//�ܺ�Ŭ�������� ��������
		addWindowListener(new WindowEventHandler2(this));//�̺�Ʈ�� ����� WindowEventHandler2���� �������̵� �� �̺�Ʈ�� ã�� �����϶�
											//WindowEventHandler2�� �̺�Ʈ�� this �� ���´�.
											//this = ����Ŭ����.. ���⼭ this�� WindowEventTest2��� �̾߱��.
		//�Ʒ� �ִ� ����Ŭ�������� ó���ϱ�. �̰� Ȱ��ȭ�ϰ� ������ �ּ�ó���ϸ�ȴ�.
//		addWindowListener(new WindowEventInner());
		
	}

	public static void main(String[] args) {
		new WindowEventTest2();
	}
	
	
	///////////////////////������� �ܺ�Ŭ������ �̺�Ʈ ó�� ����
	//���� Ŭ������ �̺�Ʈó��
	class WindowEventInner extends WindowAdapter{
		public void windowClosing(WindowEvent we) {
			System.out.println("���α׷��� ����Ǿ����ϴ�.");
			dispose(); //�ܺ�Ŭ������ �ٸ��� �� �ȿ��ִ°� ���°Ŷ� �տ� ��ü��Ⱥ���
			System.exit(0);
		}
	}
}
