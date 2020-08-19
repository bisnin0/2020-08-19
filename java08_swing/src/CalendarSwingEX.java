import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarSwingEX extends JFrame implements ActionListener{
	Font fnt = new Font("돋움체", Font.BOLD, 20);
	Calendar date = Calendar.getInstance();
	int year, month;
	String weekStr[] = {"일","월","화","수","목","금","토"};
	
	//Frame -> North 프레임 상단에 들어갈것
	
	JPanel northPane = new JPanel();
		JButton prevMonth = new JButton("◀");
		JComboBox<Integer> yearCombo = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();//데이터를 세팅할 모델
		JLabel yearLbl = new JLabel("년 ");
		JComboBox<Integer> monthCombo = new JComboBox<Integer>();
			DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();
		JLabel monthLbl = new JLabel("월");
		JButton nextMonth = new JButton("▶");
		
	//Frame --> Center
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel titlePane = new JPanel(new GridLayout(1,7)); //요일 일,월,화,수,목...
		JPanel dayPane = new JPanel(new GridLayout(0,7)); //날짜 1,2,3,4,.....
		
	public CalendarSwingEX() {
		super("달력");
		//Frame -> North
		add(BorderLayout.NORTH, northPane); //프레임에 북쪽 패널 추가
			northPane.add(prevMonth); //북쪽 패널에 버튼추가
			northPane.add(yearCombo);
				year = date.get(Calendar.YEAR); //현재 년도
				for(int y=year-100; y<year+20; y++) { //현재 년도 기준으로 yearCombo에 추가되는 년도 구하기
					yearModel.addElement(y); //모델에 구한 년도 개체들 집어넣기
				}
				yearCombo.setModel(yearModel); //모델을 콤보박스에 세팅
				yearCombo.setSelectedItem(year);
			northPane.add(yearLbl);
			
			northPane.add(monthCombo);
				month = date.get(Calendar.MONTH);  //7
				for(int d=1; d<=12; d++) {
					monthModel.addElement(d);
				}
				monthCombo.setModel(monthModel);
				monthCombo.setSelectedItem(month+1); //8월되게
			northPane.add(monthLbl);
			northPane.add(nextMonth);
			
			northPane.setBackground(new Color(150,200,200)); //북쪽패널에 배경색 지정
			
			//오늘날짜출력
			add(centerPane);
				centerPane.add(BorderLayout.NORTH, titlePane);
					for(int i=0; i<weekStr.length; i++) {
						JLabel lbl = new JLabel(weekStr[i], JLabel.CENTER); //라벨 위치 여기서 설정.
						lbl.setFont(fnt);
						if(i==0) {
							lbl.setForeground(Color.RED);
						}else if(i==6) {
							lbl.setForeground(Color.BLUE);
						}
						titlePane.add(lbl);
					}
					
					centerPane.add("Center", dayPane);
					setDay();
				
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
		//이벤트 등록
		prevMonth.addActionListener(this);
		yearCombo.addActionListener(this);
		monthCombo.addActionListener(this);
		nextMonth.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		year = (int)yearCombo.getSelectedItem();
		month = (int)monthCombo.getSelectedItem() - 1; 
		if(obj==yearCombo || obj==monthCombo) {
			getNewDate(); 
		}else if(obj == prevMonth) { //방금 이벤트 발생한 버튼이 이전월이냐
			clearEvent();
			if(month==0) {  //month가 1월이면... 0이 1월임
				year--;
				month=11; //12월
			}else {//1월도 아니고 12월도 아닐떄
				month--;
			}
			yearCombo.setSelectedItem(year);
			monthCombo.setSelectedItem(month+1);
			/////여기까지 하면 에러발생..  이유는 clearEvent()에 있다. 이벤트중복? 데이터가 바뀌면서 자동으로 이벤트가 생기는것때문에 생기는문제
			//comboBox의 숫자가 바뀌면서 발생하는 이벤트와 버튼을 눌러서 생기는 이벤트가 중복되면서 에러발생한다.
			//ComboBox의 이벤트를 잠깐 멈췄다가 버튼이벤트 후 실행해주면 된다.
			
			getNewDate();
			addEvent(); ////이걸 한 묶음으로 메소드 만들어서 아래에 쓸거다.
		}else if(obj == nextMonth){
			clearEvent();
			if(month==11) {
				year++;
				month=0;
				
			}else {
				month++;
			}
			buttDateSet();
		}
		
	}
	
	public void buttDateSet() {
		clearEvent();
		yearCombo.setSelectedItem(year);
		monthCombo.setSelectedItem(month+1);
		getNewDate();
		addEvent();
	}
	public void addEvent() {
		yearCombo.addActionListener(this);
		monthCombo.addActionListener(this);
	}
	public void clearEvent() { 
		//버튼에서 이벤트 발생시 ComboBox의 Item을 변경하면서 ComboBox의 이벤트가 처리되므로 이벤트를 해제한다. 
		yearCombo.removeActionListener(this);
		monthCombo.removeActionListener(this);
	}
	
	public void getNewDate() {
		dayPane.setVisible(false); //패널이 떠있는 상태로 값이 바뀌면 창 크기 변경이 되기 전까지 변경값이 안바뀐다. 그래서 창을 안보이게했다가 보이게 해줘야함
		dayPane.removeAll();//날짜 지우기
		dayPane.setVisible(true);
		setDay();
	}
	
	public void setDay() {
		//요일
		date.set(year, month, 1); //입력된 년도와 월을 기준으로 1일 구하기
		int week = date.get(Calendar.DAY_OF_WEEK); //1일의 요일 구하기
		
		//공백처리
		for(int space=1; space<week; space++) {
			JLabel lbl =new JLabel(" ");
			dayPane.add(lbl);
		}
		//날짜 추가
		int lastDay = date.getActualMaximum(Calendar.DAY_OF_MONTH); //마지막 날 구하기
		for(int i=1; i<=lastDay; i++) {
			JLabel lbl = new JLabel(String.valueOf(i), JLabel.CENTER);
			lbl.setFont(fnt);
			date.set(year, month, i);
			int w = date.get(Calendar.DAY_OF_WEEK);
			if(w==1)lbl.setForeground(Color.RED); //지금 출력하는 날짜가 1이면 빨강색으로
			if(w==7)lbl.setForeground(Color.BLUE);
			dayPane.add(lbl);
		}
	}
	
	
	public static void main(String[] args) {
		new CalendarSwingEX();
	}

}
