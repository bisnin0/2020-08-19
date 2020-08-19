
public class DigitalClockStart_ME {

	public DigitalClockStart_ME() {
	}

	public static void main(String[] args) {
		DigitalClock d1 = new DigitalClock(0);
		DigitalClock d2 = new DigitalClock(201);
		DigitalClock d3 = new DigitalClock(401);
		
		Thread dd1 = new Thread(d1);
		Thread dd2 = new Thread(d2);
		Thread dd3 = new Thread(d3);
		
		dd1.start();
		dd2.start();
		dd3.start();
		
		
		
	}

}
