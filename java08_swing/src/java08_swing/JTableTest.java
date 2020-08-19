package java08_swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame {/////����ó�� ���̺� �����
	//Jtable ����
	String title[] = {"��ȣ","�̸�","����ó","�̸���","�ּ�"};
	Object data[][] = { {1, "ȫ�浿", "010-1111-2222", "abcde@naver.com", "����� ������ �����"},
						{2, "�������", "010-2222-3333", "zzzzz@nate.com", "����� ���빮��"},
						{3, "�̼���", "010-3333-4444", "xzxzxz@ganmail.com", "����� ������ ������"},
						{4, "�念��", "010-4444-5555", "ttttt@nate.com", "����� ��������"},
						{5, "���·�", "010-6666-7777", "zkzkzkz@naver.com", "����� ���۱�"}};
	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	JLabel lbl = new JLabel("�����Ͱ� ǥ�õǴ°�..");
	public JTableTest() {
		lbl.setOpaque(true);
		lbl.setBackground(new Color(100,100,0)); //�ؿ� ���ֱ�
		add(BorderLayout.SOUTH, (lbl));
		//////////////////
		model = new DefaultTableModel(data, title);
		
		table = new JTable(model);
		sp = new JScrollPane(table);
		
		add(sp);
		
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		try {Thread.sleep(3000);}catch(Exception e) {}//3�� �ִٰ� 
		//���ڵ� �߰�
		//�߰��� ���ڵ� Object[](1�����迭) �迭�� ���� ������ �𵨿� �߰��Ѵ�.(������ model��ü)
		Object indata[] = {6, "AAAA", "010-9999-9999", "fffffff@nate.com", "����� ���ʱ�"};
		//�����͸� 1���� �迭�� �����. �̰� model���ٰ� �߰��Ѵ�.
		model.addRow(indata); //���� �ؿ� ���� �߰��ϴ°�. 3�ʵڿ� ������ �߰���
		
		//���ڵ� ���� //���� ���Ѵ�.
		try {Thread.sleep(3000);}catch(Exception e) {}//3�� �ִٰ�
		Object inData2[] = {7, "BBBB", "010-8888-8888", "djdjdjdj@nate.com", "����� ����"};
		model.insertRow(3, inData2); //�߰��� ���� �߰��ϴ°�
		
		try {Thread.sleep(3000);}catch(Exception e) {}//3�� �ִٰ�
		//���̵�
		model.moveRow(4, 6, 1); //4���� 6�ε������� 1���ε����� �̵��ض�.... 0,1,2,3,4,5,6,7(�����Ұ�. ���� ��ȣ�� �ƴ�)
		
		try {Thread.sleep(3000);}catch(Exception e) {}//3�� �ִٰ�
		//�÷� �߰�//���� ���Ѵ�.
		Object inData3[] = {"AAAA", "BBBB", "CCCC"};
		//model.addColumn("���");
		model.addColumn("���", inData3);
		
		
/* �����ϴ� �κ�		
		try {Thread.sleep(3000);}catch(Exception e) {}//3�� �ִٰ�
		//�����
		model.removeRow(3); //4���ε��� ����.
		
		try {Thread.sleep(3000);}catch(Exception e) {}//3�� �ִٰ�
		//������
		table.removeColumn(table.getColumn("���")); //���̺��� "���"��� �÷��� ��ü�� ���ؼ� �����ϰڴ�. 
													//table.getColumn�� �ϸ� tableColumn�� ���ϵǰ� �װ� removeColumn�� �־��ش�.
*/
		
		//MouseEventó�� //������ ������ ó�� �� ���� ������ ����ȴ�. �߰��� �����ٰ� �Ǵ°� �ƴ�
		table.addMouseListener(new MouseAdapter() {
			//���콺�� ���� �� ���� ������ ȣ��Ǵ� �޼ҵ�
			public void mouseReleased(MouseEvent me) {
				int btn = me.getButton(); //1:����, 2:��, 3:�����ʹ�ư
				if(btn ==1) { //���콺 ���� ��ư�� ���� ���
					int rowIndex = table.getSelectedRow(); //������ ���� index ���� ������
					
					//�÷��� ���ϱ�
					int columnCount = table.getColumnCount();
					String txt = "";
					for(int col=0; col<columnCount; col++) {
						txt+=table.getValueAt(rowIndex, col)+", "; //��, ��
						
					}
					lbl.setText(txt);
					
				}
			}
		});
		
	}

	public static void main(String[] args) {
		new JTableTest();
	}

}
