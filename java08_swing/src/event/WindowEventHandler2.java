package event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class WindowEventHandler2 extends WindowAdapter {

	WindowEventTest2 w; //���� ������������ �ʱ����� �����ϴ� �������
	
	public WindowEventHandler2() {	}
	
	public WindowEventHandler2(WindowEventTest2 w) {
		//���ʿ��� this�� ���´�. �޴� ������ Ÿ����? 
		//���� this�� WindowEventTest2��. JFrame���� �޾Ƶ� �ȴ�.(JFrame�� ����Ŭ������ ��ӹް������ϱ�)
		//���⼭ ������ ������ ���������� ������ϱ� �� ���� ��������� �Ѱ��ش�.
		
		this.w = w; //�������� w�� ��������� �Ѱ��ش�.
	}
	
	
	//��������̵�
	public void windowClosing(WindowEvent we) {
		int status = JOptionPane.showConfirmDialog(w, "�����ұ��?"); //�������w�� �����´�.
		if(status==JOptionPane.OK_OPTION) {
			w.dispose();
			System.exit(0);
		}
		
		
	}

}
