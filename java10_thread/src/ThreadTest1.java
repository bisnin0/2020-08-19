

public class ThreadTest1 extends Thread{
	int i=1;
	String title;
	
	public ThreadTest1() {
	}
	
	public ThreadTest1(String title) {
		this.title = title;
	}
//	public void numOutput() {
//		while(true) {
//			System.out.println(title+"-->"+i++);
//		}
//	}
	public void run() { //오버라이딩 .. 스레드 구현
		while(true) {
			System.out.println(title+"-->"+i++);
		}
	}

}
//Thread클래스를 이용한 스레드 구현
//Thread 클래스를 상속받아 스레드가 구현되어야 하는 기능을 
//run()메소드에 오버라이딩 한다.
//start()메소드로 스레드 스케쥴러에 스레드구현 등록한다.