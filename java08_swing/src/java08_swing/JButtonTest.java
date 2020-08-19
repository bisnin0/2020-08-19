package java08_swing;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class JButtonTest extends JFrame {
	ImageIcon ii1 = new ImageIcon("img/k1.jpg"); /////�̹��� �ֱ�
	ImageIcon ii2 = new ImageIcon("img/k2.jpg");
	ImageIcon ii3 = new ImageIcon("img/k3.jpg");
	ImageIcon ii4 = new ImageIcon("img/k4.jpg");
	ImageIcon ii5 = new ImageIcon("img/k5.jpg");
	public JButtonTest() {
		super("JButton");
		setLayout(new GridLayout(0,3,10,10));
		
		JButton btn1 = new JButton("ù��° ��ư"); //���常 �ֱ�
		add(btn1); //Grid�� �߰��Ǵ� ������� ����.
		
		//��ư ��Ȱ��ȭ���
		btn1.setEnabled(true); //true�� Ȱ��ȭ false�� ��Ȱ��ȭ
		
		
		
		JButton btn2 = new JButton(ii1);  //��ư�� �̹��� �ֱ�
		add(btn2);
		
		JButton btn3 = new JButton("����°", ii2); //����� �̹����� �Բ��ִ� ��ư //�̹����� ū�Ŷ� �ؽ�Ʈ�� ������ �Ⱥ���..âũ�� Ű��� �����ʿ� ���δ�.
		add(btn3);
		
		btn3.setRolloverIcon(ii3); //���콺�� �ö󰡸� �� ������.. �̹����� �ٲٴ� �۾��� �ҰŴ�.
								   //���콺 ������ icon����
		
		btn3.setPressedIcon(ii4);  //��ư�� ���������϶� icon�� �ٲ��.
		
		
		
		
		//RadioButton //üũ�ڽ�(�簢���� üũ�ϴ°�)�� �޸� ���׶� ����� �ڽ�. üũ�ڽ��� �޸� �ϳ��� �����ϸ� �������� ������ �� ���Եȴ�.
					  //�ϳ��� �����ϸ� �������� �����Ǵ°�. Ex)������ ��ġ�� �������� ����������� ��� ��ġ�Ұų� �����ϴ� â�� ���鶧 ���Ǵ°�
		
		JPanel pane = new JPanel(new GridLayout(3,1));
		JRadioButton rb1 = new JRadioButton("ONE");
		JRadioButton rb2 = new JRadioButton("TWO");
		JRadioButton rb3 = new JRadioButton("THREE");
		//�켱 �� ��ư 3���� �ϳ��� ��������Ѵ�. �׷��� �ϳ��� �����ϸ� �������� �����ȴ�.
		//�̶� ����ϴ� Ŭ���� ButtonGroup
		ButtonGroup bg = new ButtonGroup(); //������ư �����ϱ� ���ؼ� �׷��� �����ؾ��Ѵ�.
		bg.add(rb1); bg.add(rb2); bg.add(rb3);
		//3���� �� ��Ʈ�� �Ǿ���.
		//�̰��� �гο� ��ƾ��Ѵ�.
		pane.add(rb1); pane.add(rb2); pane.add(rb3);
		
		//�г��� �����ӿ� �߰�
		add(pane);
		
		
		//ToggleButton  //�� ��ư�� Ŭ���ϸ� ���ִ�. �ٽ� ������ ���´�.
		JToggleButton tBtn = new JToggleButton(ii5);
		add(tBtn);
		tBtn.setSelectedIcon(ii1); // ��ư�� ���û����϶� ������... ��ư�� �������� ii1���������� �ϰڴ�
		
		//JLabel
		JLabel lbl1 = new JLabel("��", JLabel.CENTER);  //���� ��ư�� �޸� Ŭ���� �ȵǴ°Ŵ�.
		JLabel lbl2 = new JLabel("��", ii2, JLabel.RIGHT);  //LEFT, RIGHT, CENTER
		add(lbl1);
		add(lbl2);
		
		
/*
		//����
		lbl1.setBackground(Color.YELLOW);
		pane.setBackground(Color.GREEN); //�̹����� ������ �Ⱥ������� ����ȰŴ�. //�ֳĸ� ���� ����� �������� ����Ǿ��ִ�.
		btn1.setBackground(Color.ORANGE); //��ư�� ����� ������ �ƴϴ�.
*/
		
		//���� ó�� ����
		lbl1.setOpaque(true);
		pane.setOpaque(true);  //Ȯ���ʿ�
		
		//����
		lbl1.setBackground(Color.YELLOW); // ���� �Ǿ����� ������ư�� ������ ������ ���� �׷��� �Ʒ��� rb1(������ư1)�� �� ����
		pane.setBackground(Color.GREEN); //
		btn1.setBackground(Color.ORANGE); //
		
		rb1.setBackground(Color.RED); //������ư1�� ������ �־���. ���� �������� �Ⱥ��̴°ʹ��
		
		JPanel pane2 = new JPanel();
		add(pane2);
		pane2.setOpaque(true);
		pane2.setBackground(Color.cyan);
		
		
		//���ڻ�
		Color clr = new Color(100,100,200); //���� �ʷ� ���  r g b ->0~255
		lbl1.setForeground(clr); //�� 1 ���� �����ض�. clr��ü ������
		
		//�۲� -> �۲�(����ü, ����, arial...), ��������(���ϰ�, ����Ӳ�, ����), ����ũ��(����:pixel)
		//�̰��� ó�����ִ� Ŭ���� = Font
		//Font Ŭ����
		Font fnt = new Font("�ü�ü", Font.BOLD+Font.ITALIC , 40); //�����쿡�� �����ϴ� ��Ʈ (c:)->windows->Font.. 
		lbl1.setFont(fnt); //�ü�ü�� ���ϰ�+����� 40����Ʈ ũ���. // ���������� 2������ �ϰ������ +�� ��Ʈ�� ���ϸ�ȴ�.
		

//		setSize(500,500);
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);		

		
		///////////////////////////JComboBox //��ư������ �Ʒ� ��� �����ϴ°� �����°�
		
		Vector<String> vec = new Vector<String>();
		vec.add("JAVA");
		vec.add("��Ʈ��");
		vec.add("HTML");
		vec.add("CSS");
		
		//���� vector�� ���� ����ְ� �̰ɷ� JComboBox�� �����
		JComboBox box1 = new JComboBox(vec);
		add(box1);
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		model.addElement("Red");
		model.addElement("Green");
		model.addElement("Blue");
		model.addElement("Yellow");
		
		// JComboBox�� �� ���ִ� ���� �����
		
		JComboBox box2 = new JComboBox(model);
		add(box2);
		
		//JList
		DefaultListModel<String> model2 = new DefaultListModel<String>();
//		model2.add(index, element); ���° index���� ���� �߰�
//		model2.addElement(element); ���� ������ ��ġ�� ���� �߰�
		for(int i=100; i<=1000; i+=100) {
			model2.addElement(String.valueOf(i));  //��Ʈ�� String���� �ٲٴ¹�.. �̷��� API���� ã���� �ȴ�. String ���� �˻��غ���.
									//String.valueOf(data)
		}
		JList<String> list = new JList<String>(model2); 
		JScrollPane sp = new JScrollPane(list); //API���� ã�� ��ũ��pane... ��ũ�ѹ� ����̴�.
		add(sp);
		
		
		
		//TextField: 1���� ���ڿ��� �Է�
		JTextField tf = new JTextField();
		add(tf);
		
		
		//JTextArea : �������� ���ڿ��Է�
		JTextArea ta = new JTextArea();
		//�̷��Ը��ϸ� �׳� ������ �ڽ� �ȿ� �۸������ִ�.
		JScrollPane sp2 = new JScrollPane(ta); //�̰� �߰��ϸ� ��ũ�� ����� ���ܼ� ��ũ�� �����鼭 ���� �߰� �����ϴ�.
		add(sp2);
		
		
		
		
		
		
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new JButtonTest();
	}

}
