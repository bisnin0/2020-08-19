package java08_swing;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameTest extends JFrame {
	JButton btn1 = new JButton("11111");
	JButton btn2 = new JButton("22222");
	JButton btn3 = new JButton("33333");
	JButton btn4 = new JButton("44444");
	JButton btn5 = new JButton("55555");
	
	JPanel pane = new JPanel();
		JButton btn6 = new JButton("66666");
		JButton btn7 = new JButton("77777");
		JButton btn8 = new JButton("88888");
	public JFrameTest() {
/*
		setSize(500,500);
		setVisible(true);
		
		//�̴�� â�� ���� X��ư���� �������� ������ �۾������ڿ� �������� ���� javaw.exe�� �����ִ�. ��� â�� ���� ��� �߰��ȴ�. �̰� �����ؾ���
		//�����̳ʰ� ����Ǹ� �ڿ������Ѵ�.
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //(operation) ġ�� ���콺 ��� �Ʒ��� �����ٺ��� change to~�ϸ鼭 �ߴµ� ���߿��� �ϰ������ ����
								//â�� ������ �ڿ��� �����ض�.
*/		
//------------------------------------------------------------
/*		
		//�� �����̳ʸ��� �⺻ ���̾ƿ��� �ִ�.
		//JFrame, JDailog : BorderLayout
		//JPanel : FlowLayout
		//GridLayout, CardLayout, GridbagLayout

		//BorderLayout: ��,��,��,��,��� �̷��� 5�������� ���������ִ�.
		//FlowLayout: �߰��ϴ� ������Ʈ ������� ��ġ
		//GridLayout: �ٵ��ǽ����� ���μ��� �࿭ ũ�Ⱑ ����.
		add(btn1); //��ư �߰�
		add(BorderLayout.NORTH,btn2); //add("North", btn2); �ʵ庯���ΰͰ�(�ҹ���) FINAL�����ΰ�(�빮��) �����ϱ�. 
		add("West", btn3);   //BorderLayout�� import�Ǿ������� �����Ѱǰ�?  //ù���� �빮�� �Ⱦ��ϱ� �ȿ�����.
		add(BorderLayout.EAST, btn4);
		add("South", btn5);  
		
		setSize(500,500);
		setVisible(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		
*/		
//-------------------------------------------------------------
/*		
		//FlowLayout : �߰��ϴ� ������Ʈ ������ ��ġ�ϴµ� �� �ڸ�(�ȼ�)�� ������ ������ ���� ������ �ڸ��ִ°����� ������ ��
		//JPanel J�г� ����Ʈ�� 
		add(btn1); 
		add(BorderLayout.NORTH,btn2);  
		add("West", btn3);   
		
		pane.add(btn6); //�г� ��ư �߰�
		pane.add(btn7);
		pane.add(btn8);
		
		add(BorderLayout.EAST, pane); //�г� ��ư �� ��ġ ����
		
		
		add("South", btn5);  
		
		setSize(500,500);
		setVisible(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
*/
//--------------------------------------------------------------
		//�г��� GridLayout���� �����ϱ�.
		//JPanel J�г� ����Ʈ�� 
		add(btn1); 
		add(BorderLayout.NORTH,btn2);  
		add("West", btn3);   
		
		//FlowLayout�� GridLayout���� �����ϱ�(�ٵ��ǽ�)
		pane.setLayout(new GridLayout(2,0, 10,5)); //(�� ��,�� ��) (3,1)= 3��1��.. �ȳ����� 1�࿡ �ٵ� 
							//(��,��,��ư �¿찣��, ��ư���Ʒ�����)
							//�࿡ 0�� ������ �� ���� �������̶�°��̴�.
		pane.add(btn6); //�г� ��ư �߰�
		pane.add(btn7);
		pane.add(btn8);
		pane.add(new JButton("AAAA"));
		pane.add(new JButton("BBBB")); //(0,2, 10,5)������ ���� 0���� �س��⶧���� ���� �������̰� ���� 2�����̴�.
									   // �ݴ�� (2, 0, 10,5)�� �����ϴ�. ���� 2�������� �����̰� ���� �������̴�.
		
		
		
		add(BorderLayout.EAST, pane); //�г� ��ư �� ��ġ ����
		
		
		add("South", btn5);  
		
		setSize(500,500);
		setVisible(true);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 		
		
	}

	public static void main(String[] args) {
		new JFrameTest();
	}

}
