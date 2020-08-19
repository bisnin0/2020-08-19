package event;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;


public class ItemEventTest extends JFrame implements ActionListener, ItemListener{ //�߻�Ŭ���� �߰� 
	JTextArea ta = new JTextArea("10�� ���û�� ������ �帶�� ���� �ʰ� ���� �ش� 1987�� 8�� 10���̾���.\n ���� �帶�� �ߺ����� �������� ���� 6�� 24�� ������ �̳����� �̾����鼭 \n33�� ���� �帶�� ���� �ʰԱ��� �̾��� �� '���� 1��'�� �ö���.");
	JScrollPane sp = new JScrollPane(ta);
	
	JToolBar tb = new JToolBar();
		JComboBox<String> fontCombo = new JComboBox<String>();
			DefaultComboBoxModel<String> modelFont = new DefaultComboBoxModel<String>();
										//���� ��ǻ�Ϳ� �ִ� �۲� ������ �о.. (�����쿡�ִ� �۲�)
		JComboBox<Integer> fontSize = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> modelSize = new DefaultComboBoxModel<Integer>();
		JToggleButton plainBtn = new JToggleButton("��"); //�ѹ� ������ ���ְ� �ٽ� ������ �����°�
		JToggleButton boldBtn = new JToggleButton("��");
		JToggleButton italicBtn = new JToggleButton("��");
		
	
	Font fnt = new Font("����", Font.PLAIN, 10);
	String selectFontName = "����ü"; //�⺻�۲� ������ ���� ����
	Integer selectFontSize = 13; //�۲� ũ�� ������ ���� ����.. 13�� Int������ Integer�� ����ڽ̵ȴ�. 
//	int fontStyle=0; //0�̸� �����̰� 1�̸� ���ϰ�, 2�� ����Ӳ�, 3�̸� ���ϰ�+����Ӳ��̴�.
	//�ٸ�������� �ϸ�
	int styleBold=0; //���ϰ� ������ ����
	int styleItalic=0; //���Ÿ� ����Ӳ� ������ ����
	
	public ItemEventTest() {
		//�ؽ�Ʈ�ڽ��� �������� ���Ϳ� �ִ� �۾�
		add(sp);
		//�������� �۲��� �����ִ� Ŭ����.. �ý����� �۲� ������    //API���� abstract ������ = �߻�޼ҵ�
		String fontList[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); 
		for(String f : fontList) { //���� ������Ÿ�� ���� ������ �迭��
			modelFont.addElement(f);
		}
		fontCombo.setModel(modelFont); //������� �۲��� �����
		fontCombo.setSelectedItem("����ü"); //�⺻���� �� ��Ʈ�� ���ڴ�.
		

		//����ũ������
		for(int i=7; i<100; i+=3) {
			modelSize.addElement(i);
			
		}
		fontSize.setModel(modelSize);
		fontSize.setSelectedItem(13); //�⺻���� �� ũ�⸦ �ϰڴ�.
		
		//���� ����
		plainBtn.setFont(fnt);
		boldBtn.setFont(new Font("����", Font.BOLD, 10));
		italicBtn.setFont(new Font("����", Font.ITALIC, 10));
		
		tb.add(fontCombo); //�۲�
		tb.add(fontSize); //����ũ��
		tb.add(plainBtn); tb.add(boldBtn); tb.add(italicBtn); //���� ����
		
		add("North", tb); //���� �߰�
		
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//�̺�Ʈ ���
		plainBtn.addActionListener(this); //���� Ŭ�������� �ҰŸ� this
		boldBtn.addActionListener(this);
		italicBtn.addActionListener(this);
		
		//�߻�Ŭ���� ��� �ϰ� 
		fontCombo.addItemListener(this);
		fontSize.addItemListener(this);
		
		
		////////�� ���ٴ� â �����ϰ� ���ʿ� �������� Ŭ���ؼ� �巡���ϸ� �Ȱ����⵵�Ѵ�.
		
		JButton btn = new JButton ("eeeeeeeeeeeeeeeeee");
		add("South", btn);
		
	}
	public void actionPerformed(ActionEvent ae) {
		//��ư ������ ����ǰ� �ؾ��ϴµ� ��ư ������ �� ����. �׷��⶧���� ��ü������ ��ư�� �νĵǰ� �ؾ��Ѵ�.
		//��ư �������� �۲� ���� ���ϰԱ���� ����ǰ� ���
		JToggleButton event = (JToggleButton)ae.getSource(); 
		if(event.equals(plainBtn)) { //��� �̺�Ʈ�� ���� ��ư�� ȭ�鿡 �ִ� �÷��� ��ư�ϰ� ������ 
			if(plainBtn.isSelected()) {
				styleBold = 0;
				styleItalic = 0;
			}
		}else if(event.equals(boldBtn)) {
			if(boldBtn.isSelected()) {
				styleBold = Font.BOLD; //1 �ᵵ �Ǵµ� ��Ʈ�� �ִ� ���尡 ������ �ִ� ������ ���°� �� ��Ȯ
				
			}else {
				styleBold = 0;
			}
		}else if(event.equals(italicBtn)) {
			if(italicBtn.isSelected()) {
				styleItalic = Font.ITALIC; //2�� �ᵵ �Ǵµ� ���� ��������
			}else {
				styleItalic = 0;
			}
		}
		fnt = new Font(selectFontName, styleBold+styleItalic, selectFontSize);
		ta.setFont(fnt);
		
	}
	//ItemEvent �߻�޼ҵ� �������̵�
	public void itemStateChanged(ItemEvent ie) {
		JComboBox event = (JComboBox)ie.getSource();
		if(event==fontCombo) {
			selectFontName = (String)fontCombo.getSelectedItem();
			
		}else if(event == fontSize) {
			selectFontSize = (Integer)fontSize.getSelectedItem();
		}
		fnt = new Font(selectFontName, styleBold+styleItalic, selectFontSize);
		ta.setFont(fnt);
	}

	public static void main(String[] args) {
		new ItemEventTest();
	}

}
