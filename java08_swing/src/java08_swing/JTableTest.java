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

public class JTableTest extends JFrame {/////엑셀처럼 테이블 만들기
	//Jtable 제목
	String title[] = {"번호","이름","연락처","이메일","주소"};
	Object data[][] = { {1, "홍길동", "010-1111-2222", "abcde@naver.com", "서울시 마폭구 백범로"},
						{2, "세종대왕", "010-2222-3333", "zzzzz@nate.com", "서울시 서대문구"},
						{3, "이순신", "010-3333-4444", "xzxzxz@ganmail.com", "서울시 강남구 논현로"},
						{4, "장영실", "010-4444-5555", "ttttt@nate.com", "서울시 영등포구"},
						{5, "유승룡", "010-6666-7777", "zkzkzkz@naver.com", "서울시 동작구"}};
	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	JLabel lbl = new JLabel("데이터가 표시되는곳..");
	public JTableTest() {
		lbl.setOpaque(true);
		lbl.setBackground(new Color(100,100,0)); //밑에 색넣기
		add(BorderLayout.SOUTH, (lbl));
		//////////////////
		model = new DefaultTableModel(data, title);
		
		table = new JTable(model);
		sp = new JScrollPane(table);
		
		add(sp);
		
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		try {Thread.sleep(3000);}catch(Exception e) {}//3초 있다가 
		//레코드 추가
		//추가할 레코드 Object[](1차원배열) 배열에 담은 다음에 모델에 추가한다.(저위에 model객체)
		Object indata[] = {6, "AAAA", "010-9999-9999", "fffffff@nate.com", "서울시 서초구"};
		//데이터를 1차원 배열로 만든다. 이걸 model에다가 추가한다.
		model.addRow(indata); //제일 밑에 행을 추가하는것. 3초뒤에 데이터 추가됨
		
		//레코드 삽입 //행을 말한다.
		try {Thread.sleep(3000);}catch(Exception e) {}//3초 있다가
		Object inData2[] = {7, "BBBB", "010-8888-8888", "djdjdjdj@nate.com", "서울시 은평구"};
		model.insertRow(3, inData2); //중간에 행을 추가하는것
		
		try {Thread.sleep(3000);}catch(Exception e) {}//3초 있다가
		//행이동
		model.moveRow(4, 6, 1); //4에서 6인덱스까지 1번인덱스로 이동해라.... 0,1,2,3,4,5,6,7(주의할것. 행의 번호가 아님)
		
		try {Thread.sleep(3000);}catch(Exception e) {}//3초 있다가
		//컬럼 추가//열을 말한다.
		Object inData3[] = {"AAAA", "BBBB", "CCCC"};
		//model.addColumn("비고");
		model.addColumn("비고", inData3);
		
		
/* 삭제하는 부분		
		try {Thread.sleep(3000);}catch(Exception e) {}//3초 있다가
		//행삭제
		model.removeRow(3); //4번인덱스 삭제.
		
		try {Thread.sleep(3000);}catch(Exception e) {}//3초 있다가
		//열삭제
		table.removeColumn(table.getColumn("비고")); //테이블에서 "비고"라는 컬럼을 객체를 구해서 삭제하겠다. 
													//table.getColumn을 하면 tableColumn이 리턴되고 그걸 removeColumn에 넣어준다.
*/
		
		//MouseEvent처리 //위에서 데이터 처리 다 끝난 다음에 실행된다. 중간에 누른다고 되는게 아님
		table.addMouseListener(new MouseAdapter() {
			//마우스를 누른 후 손을 놓으면 호출되는 메소드
			public void mouseReleased(MouseEvent me) {
				int btn = me.getButton(); //1:왼쪽, 2:휠, 3:오른쪽버튼
				if(btn ==1) { //마우스 왼쪽 버튼을 누른 경우
					int rowIndex = table.getSelectedRow(); //선택한 행의 index 정보 얻어오기
					
					//컬럼수 구하기
					int columnCount = table.getColumnCount();
					String txt = "";
					for(int col=0; col<columnCount; col++) {
						txt+=table.getValueAt(rowIndex, col)+", "; //행, 열
						
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
