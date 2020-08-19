package event;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ActionEventTest extends JFrame implements ActionListener{
											//��ưŬ�� �̺�Ʈ ���� �������̽� ���
	JPanel pane = new JPanel();
		JTextField tf = new JTextField(10); //10���� ���� ����������� �����δ� �� ���� ������
		JButton btn1 = new JButton("������");
		JButton btn2 = new JButton("������(��ü)");
	
	JTextArea ta = new JTextArea("a\nb\nc\n"); //inserText ��� Ȯ���� ���� �ؽ�Ʈ �߰���
	JScrollPane sp = new JScrollPane(ta); //ta�� ��ũ�ѱ�� 
	
	//��ü�� �ɹ����� ����� ����
	//ȭ���� �߰��� �� ������ ����ڰ� ���� ������ �۾��Ѵ�.
	//�׶� �̰͵��� ����� �Ǿ�� �Ѵ�. 
	//�׷��� �̰͵��� ���������� ����������
	//�޼ҵ尡 ����ǰ� ������ ���� �������� ���� ������⶧����
	//�ɹ������� �������� �޼ҵ尡 ������ ������ ������� �ʴ´�.
	
	public ActionEventTest() {
		pane.add(tf);
		pane.add(btn1);
		pane.add(btn2);
		//    ""NORTH"
		add(BorderLayout.NORTH, pane); //���ʿ�  ��ư�� �ؽ�Ʈ�ʵ带 ���´�.
		add(BorderLayout.CENTER, sp); //��ũ�� �߰�?
		
		
		///////��ư�� Ŭ���Ҷ� �����ϴ°��� �̺�Ʈ ó����� �Ѵ�.
		
		////addChangeListener
		
		////addActionListener(��ư�� �׼��̺�Ʈ�������. ���콺�� Ŭ���ߴ� ������ �׼��̺�Ʈ)
		// 1. �ش��̺�Ʈ�� interface���
		// 2. �߻�޼ҵ� �������̵�
		// 3. ���۳�Ʈ�� �̺�Ʈ ��� (addActionListener)
		
		//1.interface��� (���� implements�� ����)
		//2.�߻�޼ҵ� �������̵�
		//3.���۳�Ʈ �̺�Ʈ ���
		
		
		
		
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		
		//3. ���۳�Ʈ �̺�Ʈ ���
		btn1.addActionListener(this); //��ư1�� �̺�Ʈ�� ����� �Ʒ� �޼ҵ带 ȣ���ؼ� �����ϴ°�.
							//this�� ������ ���� Ŭ�������� �޼ҵ带 ã�Ƽ� �����ض�.�� �ȴ�.
		btn2.addActionListener(this);
		
		
		//////////////
		tf.addActionListener(this); //�̷��� �ϸ� textField���� ���͸� ġ�� �Ʒ� actionperformed�� ����.
		
		
		
		
		
		
		
		
		
	}
	
	
	//2. �߻�޼ҵ� �������̵�  //API���� ActionListener �������̽� ã�Ƽ� ���� �޼ҵ� ��ȯ���� Ȯ��
	public void actionPerformed(ActionEvent ae) { //JButton, JTextField  ��� �ΰ����̺�Ʈ�� �����ϴ��� �˾Ƶα�.
		//�����ļ� ������ �ƹ��͵� ���� �ȵȴ�. ������ ActionEventTest2 Ŭ������ �����Ǿ� �ִ�.
//		System.out.println(event);
		
		
//		System.out.println("�̺�Ʈ �߻���...");  //��ư�� ������ �ֿܼ� ������ ��µȴ�.
		///////////��ư�� Ŭ���ϴ¼��� �̺�Ʈ�� ������ �߻��Ѵ�.
		//�̺�Ʈ�� ����� �� ��ư�� �׼��̺�Ʈ����(ae)�� �־��ְ� �޼ҵ� �ȿ� �ִ°� ����ȴ�.
		
		//�̺�Ʈ�� �߻��� ���۳�Ʈ�� �˾Ƴ��� ���
		String event = ae.getActionCommand(); //��ü��.getActionCommand(); ��ü�� ������ ���°� �̺�Ʈ Ÿ�Կ� ���� �ٸ���.
		//���⼭ getActionCommand();�ϸ� �ɹ������� ����� btn1�� ���� ���Ѵ�."������(5��)".. ���� 5�� �־����� �߰��� �׳� ���������� ������
//		System.out.println(event);
		
		//�̺�Ʈ�� ��������ִ��� if������ Ȯ���Ѵ�.
		if(event.equals("������")) {
			String gugudan = "";
			int dan = Integer.parseInt(tf.getText()); //���۳�Ʈ�� �ִ� ���ڿ��� �о�ͼ� ������ �ٲ۴�.
			for(int i=2; i<=9; i++) {
				gugudan+=dan + " *" + i + " = " + dan*i+"\n"; //�ٹٲ� ����ڷ� �ؾ� �����ٷ� �Ѿ��. ����Ʈ������ �ֿܼ�����ϴ°�
				
			}
			//������ �ִ� ������ ���ΰ� �߰��� ����Ұǰ�, ������ ���� ����� ���� ����Ұǰ�
			//append() : ���� �߰��ϴ°�
			//setTest() : ���� ������ ����� ���� �߰�
			//insert() : �߰���(���ϴ� ��ġ��) �߰� insertText?
//			ta.append(gugudan);
//			ta.insert(gugudan,1); //1�� �ٷ� ������ �Էµ�
			ta.setText(gugudan);
		}else if(event.equals("������(��ü)")) {
			String gugudan="";
			for(int dan=2; dan<=9; dan++) {
				for(int i=2; i<=9; i++) {
					gugudan += dan+ " * " + i + "=" + dan*i + "\n";
				}
			}
			ta.setText(gugudan);
		}
		
		
		
	}
	

	public static void main(String[] args) {
		new ActionEventTest();
		
	}

}
