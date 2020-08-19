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

public class ActionEventTest2 extends JFrame implements ActionListener{
											//��ưŬ�� �̺�Ʈ ���� �������̽� ���
	JPanel pane = new JPanel();
		JTextField tf = new JTextField(10); //10���� ���� ����������� �����δ� �� ���� ������
		JButton btn1 = new JButton("������");
		JButton btn2 = new JButton("������(��ü)");
	
	JTextArea ta = new JTextArea("a\nb\nc\n"); //inserText ��� Ȯ���� ���� �ؽ�Ʈ �߰���
	JScrollPane sp = new JScrollPane(ta); //ta�� ��ũ�ѱ�� 
	
	public ActionEventTest2() {
		pane.add(tf);
		pane.add(btn1);
		pane.add(btn2);
		//    ""NORTH"
		add(BorderLayout.NORTH, pane); //���ʿ�  ��ư�� �ؽ�Ʈ�ʵ带 ���´�.
		add(BorderLayout.CENTER, sp); //��ũ�� �߰�?
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		btn1.addActionListener(this); //��ư1�� �̺�Ʈ�� ����� �Ʒ� �޼ҵ带 ȣ���ؼ� �����ϴ°�.
		btn2.addActionListener(this);
		tf.addActionListener(this); //�̷��� �ϸ� textField���� ���͸� ġ�� �Ʒ� actionperformed�� ����.
		
		
		
	}
	
	
	public void actionPerformed(ActionEvent ae) { //JButton, JTextField  ��� �ΰ����̺�Ʈ�� �����ϴ��� �˾Ƶα�.
											//JButton���� ������ �̺�Ʈ���� JTextField������ ae�� ��� �´�.
		//�̺�Ʈ�� �߻��� ���۳�Ʈ �˾Ƴ���
		Object obj = ae.getSource();//�̺�Ʈ�� �߻��� ��ü�� ���´�. �������� ����Ŭ������ ����̵� ���� �� �ִ�.
									//��ü ��ü�� ���Ѵ�.
		//� Ŭ������ ������ ��ü���� Ȯ���Ѵ�.
		if(obj instanceof JButton) { //�� ������ ����صα�. �񱳿�����. ��ü�� ���� Ŭ������ ���� �˾Ƴ� �� �ִ°�.. obj�� JButton���� ������ ��ü�� �´��� Ȯ��
		  //������ ��ü           �������� Ŭ����
			JButton btn = (JButton)obj; //����Ŭ������ ����Ŭ������ ����ȯ.
			if(btn.getText().equals("������")) {
				//������(�� ��)
				oneDan();
			}else if(btn.getText().equals("������(��ü)")) {
				//������ ��ü
				allDan();
			}
		}else if(obj instanceof JTextField) {//JTextField���� �̺�Ʈ�� �����..
			//������(�� ��)
			oneDan();
		}
		
	}
	
	public void allDan() {
		ta.setText("");
		for(int dan =  2; dan<=9; dan++) {
			for(int i=2; i<=9; i++) {
				ta.append(dan+"*"+i+"="+dan*i+"\n");
			}
		}
	}
	public void oneDan() {
		ta.setText("");
		int dan = Integer.parseInt(tf.getText());
		for(int i=2; i<=9; i++) {
			ta.append(dan + "*" + i +"="+ dan*i+"\n"); //append�� ��������
		}
	}
	

	public static void main(String[] args) {
		new ActionEventTest2();
		
	}

}
