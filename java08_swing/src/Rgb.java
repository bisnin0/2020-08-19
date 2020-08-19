import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Rgb extends JFrame implements ChangeListener {
	int r = 193;
	int g = 78;
	int b = 35;	
	String text = "RGB("+r+","+g+","+b+")";
	Font font = new Font("Arial", Font.BOLD, 17);
	Font font2 = new Font("Arial", Font.BOLD, 12);
	
	JPanel Pane = new JPanel(new GridLayout(2,1));
	JPanel topPane = new JPanel(new BorderLayout()); //프레임 윗부분
		JLabel topLbl = new JLabel(text, JLabel.CENTER); //라벨 윗부분
		JLabel colorLbl = new JLabel(); //라벨 중간부분. 색이 종합되어서 바뀌는부분
		JLabel southLbl = new JLabel("Color Slider", JLabel.CENTER); //라벨 아랫부분
	
	JPanel bottomPane = new JPanel(new BorderLayout()); //프레임 아랫부분
		JPanel centerPane = new JPanel(new GridLayout(3,1)); //아랫부분 중간
			JSlider redSd = new JSlider(0, 250, r); //그리드로 3행1열로 넣기
			JSlider greenSd = new JSlider(0, 250, g);
			JSlider blueSd = new JSlider(0, 250, b);
		JPanel leftPane = new JPanel(new GridLayout(3,1)); //아랫부분 왼쪽 
			JLabel left1Lbl = new JLabel("RED"); //왼쪽도 그리드로 3행1열
			JLabel left2Lbl = new JLabel("GREEN");  
			JLabel left3Lbl = new JLabel("BLUE");
		JPanel rightPane = new JPanel(new GridLayout(3,1)); //아랫부분 오른쪽
			JLabel redLbl = new JLabel();
			JLabel greenLbl = new JLabel();
			JLabel blueLbl = new JLabel();
	
		
		
	public Rgb() {
		colorLbl.setOpaque(true);
		redLbl.setOpaque(true);
		greenLbl.setOpaque(true);
		blueLbl.setOpaque(true);
		redLbl.setPreferredSize(new Dimension(40,50));

		
		colorLbl.setBackground(new Color(r,g,b));
		redLbl.setBackground(new Color(r,0,0));
		greenLbl.setBackground(new Color(0,g,0));
		blueLbl.setBackground(new Color(0,0,b));
		
		topLbl.setFont(font2);
		southLbl.setFont(font);
		
		topPane.add(BorderLayout.NORTH, topLbl); 
		topPane.add(BorderLayout.CENTER, colorLbl); 
		topPane.add(BorderLayout.SOUTH, southLbl);
		
		Pane.add(topPane); 

		leftPane.add(left1Lbl); leftPane.add(left2Lbl); leftPane.add(left3Lbl);
		bottomPane.add(BorderLayout.WEST, leftPane);
		
		sliderSet();
//		bottomPane.setBorder(new TitledBorder(new LineBorder(Color.cyan,5),"Color slider"));
		
		centerPane.add(redSd); centerPane.add(greenSd); centerPane.add(blueSd);
		bottomPane.add(BorderLayout.CENTER, centerPane);

		rightPane.add(redLbl); rightPane.add(greenLbl); rightPane.add(blueLbl);
		bottomPane.add(BorderLayout.EAST, rightPane);
		Pane.add(bottomPane);
		
		add(Pane);
		
		setSize(500,350);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void sliderSet() {
		redSd.setMajorTickSpacing(50);
		redSd.setMinorTickSpacing(5);
		redSd.setPaintTicks(true);
		redSd.setPaintLabels(true);
		redSd.addChangeListener(this);
		
		greenSd.setMajorTickSpacing(50);
		greenSd.setMinorTickSpacing(5);
		greenSd.setPaintTicks(true);
		greenSd.setPaintLabels(true);
		greenSd.addChangeListener(this);
		
		blueSd.setMajorTickSpacing(50);
		blueSd.setMinorTickSpacing(5);
		blueSd.setPaintTicks(true);
		blueSd.setPaintLabels(true);
		blueSd.addChangeListener(this);
	}
	
	
	public void stateChanged(ChangeEvent e) { //Slider 이벤트
		JSlider slider = (JSlider)e.getSource();
		
		if(slider==redSd) {
			changeLbl();
			r = slider.getValue();
			colorLbl.setBackground(new Color(r,g,b));
			redLbl.setBackground(new Color(r,0,0));
		}else if(slider==greenSd) {
			changeLbl();
			g = slider.getValue();
			colorLbl.setBackground(new Color(r,g,b));
			greenLbl.setBackground(new Color(0,g,0));
		}else if(slider==blueSd) {
			changeLbl();
			b = slider.getValue();
			colorLbl.setBackground(new Color(r,g,b));
			blueLbl.setBackground(new Color(0,0,b));
		}
		
	}
	public void changeLbl() {
		text = "RGB("+r+","+g+","+b+")";
		topLbl.removeAll();
		topLbl.repaint(); 
		topLbl.setText(text);
	}
	
	

	public static void main(String[] args) {
		new Rgb();
	}

}
