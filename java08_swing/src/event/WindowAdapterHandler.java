package event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


//////////�͸��� ���� Ŭ������ �̿��� �̺�Ʈ ó�� ���
//////////�͸��� ���� Ŭ������ �����ϱ� �����. ���⼭�� ��� ������

//////////������ �ٸ� Ŭ�������� �̺�Ʈ ó�� �ϴ� ����� WindowEventTest2�� 
public class WindowAdapterHandler extends JFrame{
	JFrame frm;
	public WindowAdapterHandler() {
		frm = this;
		
		setSize(500,500);
		setVisible(true);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		//�߻�޼ҵ尡 �������̵� �Ǿ��ִ� AdapterŬ������ ��������̵��Ѵ�.
		//�͸��� ���� Ŭ����
		addWindowListener(new WindowAdapter() { //Adapter�� ��ü������ �����ϴ�.
			public void windowClosing(WindowEvent we) {
				int status = JOptionPane.showConfirmDialog(frm,"���� �����Ͻðڽ��ϱ�?"); //���⼱ rhis�� �ȵȴ�. ������ ��ü�� ���� �ؾ��Ѵ�.
													//����Ŭ�������� �ܺ�Ŭ�������ִ� ��������� �� �� �ֱ⶧���� ����������� frm��ü ���� ������.
				if(status==JOptionPane.OK_OPTION){
					dispose(); //�ڿ� ������Ű��
					System.exit(0);
				}
			}
		}); //�̰� ����
		
	}

	public static void main(String[] args) {
		new WindowAdapterHandler();
	}

}
