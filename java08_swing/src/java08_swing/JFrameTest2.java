package java08_swing;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameTest2 {
	JFrame frm = new JFrame("â�� ����"); //�⺻ ���̾ƿ� = BoderLayout (��,��,��,��,�߾�)
	
	
	public JFrameTest2() {
		//���̾ƿ� ���� ��ǥ�� �̿��ؼ� ���۳�Ʈ ��ġ�ϱ�

		//�⺻���̾ƿ�(BoderLayout) �����
		frm.setLayout(null);
		
		JButton btn = new JButton("��ǥ�� ���̾ƿ� ����");
		//��ư ũ�� ����
		btn.setSize(200, 50);
		//��ư ��� ǥ������ xy ��ǥ����
		btn.setLocation(50, 100);
		
		frm.add(btn); //�����ӿ� ��ư�� �߰��ض�
		
		////////�̰��Ǵ����� â�� ũ�Ⱑ Ŀ���� ���̾ƿ��� ����������� �ߴ°��̴�. â�� ũ�⸦ �����ع����� ������ ���� �ʴ´�.
		frm.setResizable(false);  //âũ�� ���� �Ұ�. â�� ũ�� ���ٲٰ� �����. true���� ũ�⺯�� �����ϴ�.
		
		///////�����Ӱ� âũ�⸦ �����Ϸ��� �̰� ���� �ٸ��� ���°� ���ٰ��Ѵ�.
		
		
		frm.setSize(500,500);
		frm.setVisible(true);
		
	}

	public static void main(String[] args) {
		new JFrameTest2();
	}

}
