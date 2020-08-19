package java08_swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
//Memo와 연결해서 폰트색상을 이걸로 변경할수있게끔

//여기서 주의하면서 볼것은 memo의 데이터를 여기서 넘겨받아 작업해서 저쪽에 다시 넘겨주는것. 이걸 이해해야함
public class RGBEX2 extends JPanel implements ChangeListener, ActionListener{ //패널로 변경했음. 다른곳에서 사용하기 위해서
	JTextArea ta;//memo에서 받는 변수 같은 주소
	JDialog dialog;//memo에서  받는 변수 같은 주소
	
	JButton setBtn = new JButton("적용");
	
	
	Font fnt = new Font("굴림체", Font.BOLD, 30);
	JLabel rgbLbl = new JLabel("RGB(150,150,150)", JLabel.CENTER);
	int red=150, green=150, blue=150;
	
	//Franme의 센터에 들어갈 패널 만들기
	JPanel centerPane = new JPanel(new BorderLayout()); //기본은 FlowLayout
		JPanel rgbColor = new JPanel();
		JPanel rgbSlider = new JPanel(new BorderLayout()); //Red, Green, Blue
		
	//JSlider영역
	JPanel colorNamePane = new JPanel(new GridLayout(3,1));
		JLabel[] colorName = {new JLabel("RED"), new JLabel("Green"), new JLabel("BLUE")}; //객체를 만들어서 바로 배열에 넣을 수 있다.
	JPanel colorSliderPane = new JPanel(new GridLayout(3,1));
		JSlider[] colorSlider = {new JSlider(0, 250), new JSlider(0, 250), new JSlider(0, 250)};
	JPanel colorPane = new JPanel(new GridLayout(3,1));
		Color[] color = {new Color(150,0,0), new Color(0,150,0), new Color(0,0,150)};
		JLabel[] colorLbl = new JLabel[3];
	
	public RGBEX2() {
		setLayout(new BorderLayout()); ////JFrame을 JPanel로 바꿀때는 기본 레이아웃이 다르기때문에 JFrame의 기본 레이아웃으로 변경해줘야한다.
		
		
		
		
		rgbLbl.setFont(fnt);
		add("North", rgbLbl);
		
		add(centerPane);
		centerPane.add(rgbColor); //센터에 넣을때는 위치 안써도 기본으로 들어간다.
			rgbColor.setBackground(new Color(red, green, blue));
		centerPane.add("South", rgbSlider);
			rgbSlider.add("West", colorNamePane);
			rgbSlider.add("Center", colorSliderPane);
			rgbSlider.add("East", colorPane);
		for(int i = 0; i<colorName.length; i++) { //3개가 똑같은 배열이니 하나의 길이 가지고 한다. // i= 0,1,2
			colorNamePane.add(colorName[i]);
			colorSliderPane.add(colorSlider[i]);
			////눈금
			colorSlider[i].setMajorTickSpacing(50); //주눈금
			colorSlider[i].setMinorTickSpacing(5); //보조눈금
			colorSlider[i].setPaintTicks(true); //눈금보이기
			colorSlider[i].setPaintLabels(true); //라벨보이기
			colorSlider[i].addChangeListener(this);
			
			colorLbl[i] = new JLabel("           "); //라벨 크기때문에 스페이스바
			colorLbl[i].setOpaque(true);
			colorLbl[i].setBackground(color[i]);
			colorPane.add(colorLbl[i]);
			
			
		}
		
		//rgbSlider에 border설정하기. 
		LineBorder lb =new LineBorder(Color.ORANGE, 5, true); //true는 라운드.. 박스 테두리 둥글게.. 없으면 기본 false
		
		TitledBorder tb = new TitledBorder(lb, "Color Slider", TitledBorder.CENTER, TitledBorder.CENTER);
		rgbSlider.setBorder(tb);
		
		add("South", setBtn);
		//적용버튼 이벤트 등록
		setBtn.addActionListener(this);
		
	}
	public RGBEX2(JTextArea ta, JDialog dialog) { //Memo이 텍스트박스를 가져와서 여기서 색상 변경을 해줘야한다.
		this(); //현재클래스의 다른 생성자 // //생성자에서 같은 클래스의 다른 생성자 호출하는 메소드 this.. 항상 가장 위에 있어야함
		this.ta = ta; //멤버변수 // 위의 this랑 다른것
		
		this.dialog = dialog;         /////memo에서 받는다. // 적용 버튼 누르면 창 닫히게 만들기
		
		
	}

	public void stateChanged(ChangeEvent ce) {
		Object obj = ce.getSource();
		if(obj == colorSlider[0]) {
			red = colorSlider[0].getValue();
			colorLbl[0].setBackground(new Color(red,0,0));
		}else if(obj == colorSlider[1]) {
			green = colorSlider[1].getValue();
			colorLbl[1].setBackground(new Color(0,green,0));
		}else if(obj == colorSlider[2]) {
			blue = colorSlider[2].getValue();
			colorLbl[2].setBackground(new Color(0,0,blue));
		}
		
		rgbColor.setBackground(new Color(red, green, blue));
		rgbLbl.setText("RGB("+red+","+green+","+blue+")");
		
	}
	
	public void actionPerformed(ActionEvent ae) { //적용 버튼을 누르면 Memo의 텍스트박스 색상이 변하게된다.
		Object obj = ae.getSource();
		if(obj == setBtn) {
			ta.setForeground(new Color(red, green, blue)); //폰트색
			dialog.setVisible(false); //적용 누르면 창 닫히게 만들기
			dialog.dispose(); //완전히 값을 지우고 다음에 창을 또 눌렀을때 남은 데이터 없게 만들기
			
			
			
			
			
			
		}
		
	}

	public static void main(String[] args) {
		new RGBEX2();
	}

}
