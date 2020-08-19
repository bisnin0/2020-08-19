import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java08_swing.CalendarSwing2;

public class JInternalFrameTest extends JFrame implements ActionListener {
	JDesktopPane dp = new JDesktopPane();
	JPanel butPane = new JPanel();
		JButton saveBtn = new JButton("저장하기");
		JButton openBtn = new JButton("불러오기");
	
	public JInternalFrameTest() {
		super("JInternalFrame");
		butPane.add(openBtn); butPane.add(saveBtn);
		add("North", butPane);
		saveBtn.addActionListener(this);
		openBtn.addActionListener(this);
		
		
		add(dp);
		
		//InternalFrame 객체. 패널에 인터널 프레임을 추가한다.
		JInternalFrame if1 = new JInternalFrame("달력");
		CalendarSwing2 cal = new CalendarSwing2();
		if1.add(cal);
		if1.setSize(400, 300);
		if1.setVisible(true);
		dp.add(if1);
											//  제목, resize,closing,maximum,icon //일반적인 창의 기능을 담는다.
		JInternalFrame if2 = new JInternalFrame("메모장", true, true, true, true); //리사이즈 가능하게
		JTextArea ta = new JTextArea();
		if2.add(ta);
//		if2.setSize(400, 300); //좌표, 폭, 높이지정하려면 다른거
		if2.setBounds(100, 100, 400, 300);
		if2.setVisible(true);
		dp.add(if2);
		if2.toFront(); //현재 컨테이너를 앞에 표시하라(달력 뒤에있던게 달력 앞으로 감)
		
		JInternalFrame if3 = new JInternalFrame("메모장", true, true, true, true);
		JTextArea ta2 = new JTextArea();
		if3.add(ta2);
		if3.setBounds(150, 150, 400, 300);
		if3.setVisible(true);
		dp.add(if3);
		if3.toFront();
		
		
		setSize(1000, 800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		String btn = ae.getActionCommand();
		if(btn.equals("불러오기")) {
			openFile();
		}else if(btn.equals("저장하기")) {
			saveFile();
		}
	}
	
	public void openFile() { //불러오기로 창 새로 열기
		JFileChooser fc = new JFileChooser();
		int state = fc.showOpenDialog(this);
		if(state == 0) {
			try {
			File f = fc.getSelectedFile();
			FileReader fr = new FileReader(f); //예외처리피요
			BufferedReader br = new BufferedReader(fr);
			
			char readData[] = new char[(int)f.length()];//f.length(); //파일의 크기 .. f.length()는 long이라 int형으로
			int cnt = br.read(readData, 0, (int)f.length());//몇글자 읽었는지가 돌아온다. + 예외처리
			
			if(cnt>0) { //읽은 데이터가 있을때
				JInternalFrame f4 = new JInternalFrame(f.getPath(), true, true, true, true);
				JTextArea ta = new JTextArea(new String(readData));
				f4.add(ta);
				f4.setBounds(200, 200, 700, 700);
				f4.setVisible(true);
				dp.add(f4);
				f4.toFront();
			}
			
			}catch(FileNotFoundException fnfe) {
				System.out.println("파일이 없을때");
			}catch(IOException e) {
				System.out.println("파일 읽기 에러..");
			}
		}
	}
	
	public void saveFile() {
		//먼저 어떤 인터널 프레임이 활성화 된건지 확인해야한다.
		//DesktopPane에서 활성화된 JInternalFrame 객체를 얻어온다.
		JInternalFrame frm = dp.getSelectedFrame();
		//글이 입력된 객체 얻어오기
		JTextArea ta = (JTextArea)frm.getFocusOwner();
		String title = frm.getTitle(); //창 제목 구해오기
		File f;
		if(title.equals("메모장")) { //제목이 메모장하고 같으면 처음으로 저장하는것.. //처음으로 저장할때
			JFileChooser fc = new JFileChooser();
			int state = fc.showSaveDialog(this);
			if(state==0) {
				try{
				f = fc.getSelectedFile();
				FileWriter fw = new FileWriter(f);
				fw.write(ta.getText(), 0, ta.getText().length());
				fw.close();
				}catch(Exception e) {}
			}
		}else{ //처음저장이 아닐때
			try {
			f = new File(title);
			FileWriter fw = new FileWriter(f);
			fw.write(ta.getText(), 0, ta.getText().length());
			fw.close();
			}catch(Exception e) {}
		}
		
	}

	public static void main(String[] args) {
		new JInternalFrameTest();
	}

}
