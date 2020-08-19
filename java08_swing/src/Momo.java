import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java08_swing.RGBEX2;

public class Momo extends JFrame implements ActionListener{ //JFrame ��ӹ޴¼��� �������� �ϳ� ����°�.
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	//� Ŭ������ ��������� �˾ƾ� �̺�Ʈ�� ã�Ƴ� �� �ִ�. JMenuItem�� Ŭ���ϴ°Ŵϱ� 
	
	//�޴� ����
	JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("����");
			JMenuItem newMenu = new JMenuItem("������"); //����޴��� ������ JMenuItem
			JMenuItem openMenu = new JMenuItem("����");    ////ctrl+o �� ����Ű�� �����ҰŴ�. �Ʒ� ����Ű ���� Ȯ��
			JMenu saveMenu = new JMenu("����"); //����޴��� ������JMenu
				JMenuItem save = new JMenuItem("save");
				JMenuItem saveAs = new JMenuItem("save as");
			JMenuItem endMenu = new JMenuItem("����");
			
		JMenu editMenu = new JMenu("����");
			JMenuItem copyMenu = new JMenuItem("�����ϱ�");
			JMenuItem cutMenu = new JMenuItem("�����α�");
			JMenuItem pasteMenu = new JMenuItem("�ٿ��ֱ�");
			
		JMenu fontMenu = new JMenu("�۲�"); // RGBEX2�ϸ鼭 �߰��Ѻκ�
			JMenuItem fontColor = new JMenuItem("���ڻ�");
			
		JMenu runMenu = new JMenu("����");
			JMenuItem memoMenu = new JMenuItem("�޸���");
			JMenuItem editplusMenu = new JMenuItem("����Ʈ�÷���");
			JMenu browserMenu = new JMenu("��������");
				JMenuItem chromeMenu = new JMenuItem("ũ��");
				JMenuItem expMenu = new JMenuItem("�ͽ��÷η�");
			JMenuItem compileMenu = new JMenuItem("������");
			JMenuItem javaRunMenu = new JMenuItem("�ڹٽ���");
			
			String buffer;
			
			
	
	public Momo() {
		super("�޸���");
		add(sp);
		
		//�޴�
		mb.add(fileMenu); mb.add(editMenu); mb.add(runMenu); mb.add(fontMenu);
		
		fileMenu.add(newMenu); fileMenu.add(openMenu); fileMenu.add(saveMenu); fileMenu.add(endMenu);
		saveMenu.add(save); saveMenu.add(saveAs);
		
		editMenu.add(copyMenu); editMenu.add(cutMenu); editMenu.add(pasteMenu);
		
		fontMenu.add(fontColor);
		
		runMenu.add(memoMenu); runMenu.add(editplusMenu); runMenu.add(browserMenu);runMenu.add(compileMenu);
		runMenu.add(javaRunMenu);
		browserMenu.add(chromeMenu); browserMenu.add(expMenu);
		
		
		setJMenuBar(mb);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		//�̺�Ʈ ���
		newMenu.addActionListener(this);
		openMenu.addActionListener(this);
		save.addActionListener(this);
		saveAs.addActionListener(this);
		endMenu.addActionListener(this);
		
		copyMenu.addActionListener(this);
		cutMenu.addActionListener(this);
		pasteMenu.addActionListener(this);
		
		fontColor.addActionListener(this);
		
		
		memoMenu.addActionListener(this);
		editplusMenu.addActionListener(this);
		chromeMenu.addActionListener(this);
		expMenu.addActionListener(this);
		compileMenu.addActionListener(this);
		javaRunMenu.addActionListener(this);
		
		/////����Ű ����
		setShortCut();
		
	}
	
	public void actionPerformed(ActionEvent ae) {  //ae���� �̺�Ʈ�� �߻��� ��ü�� ����. 
//		String eventMenu = ae.getActionCommand();
		Object event = ae.getSource();
		if(event == endMenu) {
			dispose(); //�ڿ�����.. �������� ������ �ڿ�����
			System.exit(0);
		}else if(event == newMenu) { //������
			ta.setText(""); 
			setTitle("�޸���"); //������ ���� �޸������� ���� �ٽ� ��ġ��
		}else if(event == openMenu) { //����޴� ����
			openMenu(); //�� �޼ҵ� ���� ����
		}else if(event == save) { //����޴�
			saveMenu();
		}else if(event == copyMenu) {
			copyMenu();
		}else if(event == pasteMenu) {
			pasteMenu();
		}else if(event == cutMenu) {
			cutMenu();
		}else if(event == memoMenu) { //�޸��� ����
			startProcess("notepad.exe");
		}else if(event == editplusMenu) { //����Ʈ�÷��� ����
			startProcess("C://Program Files/EditPlus/editplus.exe");
		}else if(event == chromeMenu) {
			startProcess("C://Program Files (x86)/Google/Chrome/Application/chrome.exe https://www.nate.com"); //ó�� �����Ҷ� �ߴ� â �����Ϸ��� �����̽��� �ϰ� �ּ�
		}else if(event == expMenu) {
			startProcess("C://Program Files/Internet Explorer/iexplore.exe");
		}else if(event == compileMenu) { //������ �ϴµ� ���� �ڵ峻�뿡 ���������� ������ �ȵ�
			startProcess("javac " + getTitle()); //javac d:\test.java 
			System.out.println("�����ϵ�.");
		}else if(event == javaRunMenu) {  ////////////////////////�̺κ� ���� �ȵǴµ� ���� ���߿� �˷��ֱ����
			// d:\test.java --> d:\java Test ���ʿ��� .java�� �������Ѵ�.
//			String file = getTitle(); //������ �����´�
//			String filename = file.substring(0, file.lastIndexOf(".")); //���ϸ� �ڿ��� .�� ��ġ?
//			startProcess("java "+filename);
			javaRunStart();
		}else if(event == fontColor) {
			setFontColor();
		}
	}
	//���ڻ�
	public void setFontColor() { //RGBEX2 �ϸ鼭 �߰��Ѻκ�
		//Dialog : �⺻ ���̾ƿ��� BorderLayout �̴�.
		JDialog dialog = new JDialog(this, "RGB�ڵ�", true); //JFrame�� ��ӹް��־ this // true : modal ����, false : modal ����
		dialog.add("Center", new RGBEX2(ta, dialog));//��Ű���� �ٸ��⶧���� ����Ʈ�ؾ��Ѵ�.
								
		
		
		dialog.setSize(500, 400); //�̰͵� �����̳ʱ⶧���� ������ ���������
		dialog.setVisible(true);
		
		
	}
	
	public void javaRunStart() {
		String fileName = getTitle(); //������ �����´�
		if(!fileName.equals("�޸���")) {
			try {
				Runtime runtime = Runtime.getRuntime();
				Process process = runtime.exec("java "+ fileName);
				InputStreamReader isr = new InputStreamReader(process.getInputStream());
				BufferedReader br = new BufferedReader(isr);
				while(true) {
					String buffer = br.readLine();
					if(buffer==null)break;
					System.out.println(buffer);
				}
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			System.out.println("����Ϸ�......."); //�ڹ�8�� �������� ī���ٽ��� ���� �� �������ϰ� �����ϸ� �ȴ�. �� ������ �� â�� ������������µȴ�.
		}
	}
	
	
	
	public void startProcess(String filename) { //�޸��� �޴��� �����ϸ� �̰� �����ϸ鼭 notepad.exe�� �Ѱܹ޾� �����Ѵ�.
		try {
		Runtime runtime = Runtime.getRuntime();
		runtime.exec(filename); //����ó�� ������Ѵ�.
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void cutMenu() {
//		buffer = ta.getSelectedText(); //���ۿ� ������ ���� ��´�.
		copyMenu(); //�ּ��� ���� ���� //���ۿ� ������ ���� ��´�.
		ta.replaceSelection("");//�����.
	
	}
	
	public void pasteMenu() {
		ta.replaceSelection(buffer); //���ۿ� ��� ������ �ִ´�.
	}
	
	public void copyMenu() {
		buffer = ta.getSelectedText(); //���ۿ� ������ ������ ��´�.
		System.out.println(buffer);
	}
	
	
	/////////�����ϱ�
	public void saveMenu() {
		JFileChooser fc = new JFileChooser(); //��� �����Ұ��� â�� �����ϴϱ� Ž���� ȣ��
		int result = fc.showSaveDialog(this); //��ư�� �� �����ߴ���. ���� �ݱ�
		if(result == 0) { //0:����, 1:���
			try {
			File f = fc.getSelectedFile();//������ ��ο� ���ϸ� ������ .. �Է��س��� ���ϸ��� ���ϰ�ü�� ���´�.
			FileWriter fw = new FileWriter(f);//����ó��
			
			String txt = ta.getText();
			fw.write(txt); 
			fw.close();
			
			setTitle(f.getPath());
			
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/////////����
	public void openMenu() {
		File f = new File("D://javaDev"); //ó�� �����Ҷ� ���� ��ġ ����. ���ϸ� ����â���� �⺻���� 
		JFileChooser fc = new JFileChooser(f); //���� ���̽�.. ���� Ž����
		
		//Filter���� //�������� ����â
		FileFilter f1= new FileNameExtensionFilter("�ڹ�(.java)", "java", "JAVA", "Java"); //FileFilter�� ���� �������̽��� omport �ؾ��Ѵ�.
		fc.addChoosableFileFilter(f1); //���͸�����
		
		FileFilter f2 = new FileNameExtensionFilter("�ڹ�(.class)", "class"); //ȭ�鿡 ���̴� ���ڴ� �ڹ�(.class)�� �����δ� class�� ���õȴ�.
		fc.addChoosableFileFilter(f2);
		
		FileFilter f3 = new FileNameExtensionFilter("�̹���", "jpg", "gif", "png"); //ȭ�鿡 ���̴°� �̹�����. jpg�� gif, png������ �����Ѵ�.
		fc.addChoosableFileFilter(f3);
		
		int result = fc.showOpenDialog(this); //������ ���̾�α׹ڽ��� ���ο� ������ �����ش�. ���Ͽ���â
		////result�� 0�̸� ���⸦ �����Ŵ�. 1�̸� ��ҹ�ư �����Ŵ�.
		////���� ��ư�� �������� Ȯ���Ϸ��� result�� ���� Ȯ���ϸ� �ȴ�.
		if(result ==0) {//�����ư �������
			try {
			
			File selectFile = fc.getSelectedFile();//������ ���ϸ�� ��θ� ��ü�� �����
			
			FileInputStream fis = new FileInputStream(selectFile); //����ó�� �ʿ�
			byte data[] = new byte[(int)selectFile.length()]; //������ ������ ���̸� ���ϸ� ũ�Ⱑ ��������. �������� ����ȯ
			int cnt = fis.read(data);
			
			if(cnt>0) {
				ta.setText(new String(data)); //������ ���Ͽ��� �о�� ������ �ؽ�Ʈ�ʵ忡 ����ִ´�.(���)
			}
			
			setTitle(selectFile.getPath()); //���ϸ�� ������ �� ���ϴ°� getPath. ���� �����ؼ� ���� ������ ���ϰ�ο� ���ϸ����� �ٲ��ش�.
			
			
			}catch(FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	////////����Ű ����
	public void setShortCut() {
		//���� �޴��� ctrl+o�� ����
		//   ctrl�� mask   o�� key��� �θ���.
		openMenu.setMnemonic(KeyEvent.VK_O); //API���� awt.event->KeyEvent�� Ű������ ��� Ű���� �������� �װ� ����
		openMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK)); //ActionEvent. ġ�� ����ũ ���� ���´�.
		
		//���� ��ư�� alt + s�� �����
		save.setMnemonic(KeyEvent.VK_S); //�޴� �̸� Ȯ�� ����� �ϱ�. saveMenu�� ���س���
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
	}

	public static void main(String[] args) {
		new Momo();
		
	}

}















