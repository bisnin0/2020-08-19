package java08_swing;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalClock2 extends JPanel { /////////JTabbedPane �Ϸ��ٰ� ������. Ȥ�ø��� ������Ʈ�� �÷��³��´�.
	
//////////�� �ɹ������� �����Ǿ����� �����ϱ�.
//////////�Ʒ� setTime�޼ҵ忡�� ����� ���� ����ؼ� ���⿡ ������ �� �����Ͱ� digitalclock�޼ҵ忡�� ���Ǵϱ�
	//////�޼ҵ带 ������ ����Ǵ� �޼ҵ��� ���� �ǽð����� ����ؼ� ��������� �� �ִ�.
	
	JLabel lbl = new JLabel("11:50:10");
	Font ftn = new Font("Arial", Font.BOLD, 100);
	
	public DigitalClock2() {
		setLayout(new BorderLayout());
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image icon = tk.getImage("img/k2.jpg");
//		setIconImage(icon);  //�������� ����
		//JLabel ���ڿ� ��� ����.. 
		lbl.setHorizontalAlignment(JLabel.CENTER);  //��ġ�� ���� �������� ���ͷ� ����. 
		lbl.setFont(ftn);
		add(lbl);
		
		setTime(); //�Ʒ� �ð� ���� ��������
	}
	//�ð� ���� ����
	public void setTime() {  
		/////////JTabbedPaneTest���� �̰� ��ü�� �ҷ�������
		//�̰� ���ѷ����⶧���� DigitalClock2�� ��ü�� new �ϰ� �������¼��� ���ѷ�����������Ѵ�. �� ���۾��� �ȵǱ⶧���� ���� ���ѵ���
		
		do {
			//���� �ð� ���ϱ�
			Calendar now = Calendar.getInstance();
			
			//���ڿ� ���ϱ�
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			String clock = sdf.format(now.getTime()); //Calendar�� Date�� �������ִ°� getTime�̴�.
			
			
			//�󺧿� ����
			//���÷��� �Ǿ��ִ� ���ڸ� ��������ִ� �۾� setText
			lbl.setText(clock); //swing API�� ����
			
			//�Ͻ�����
			try { //Thread�� ������ ����ó���� �ؾ���.
			Thread.sleep(500);
			}catch(Exception e) {}
			
			
			
			
		}while(true);
	}
	
	
}
