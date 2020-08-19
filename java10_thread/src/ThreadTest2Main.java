

public class ThreadTest2Main {

	public ThreadTest2Main() {
	}

	public static void main(String[] args) {
		//Runnable 인터페이스 상속받은 클래스를 객체로 가져와서 실행
		ThreadTest2 t3 = new ThreadTest2("first");
		ThreadTest2 t4 = new ThreadTest2("second");
		
		//Thread에 넣어준다. Thread 객체 생성
		Thread tt3 = new Thread(t3);
		Thread tt4 = new Thread(t4);
		
		
		tt4.setPriority(Thread.MAX_PRIORITY);//우선순위 설정 .. 이 클래스에선 적용되지않는듯?
		
		tt3.start(); //Thread객체에 start();를 눌러서 시작
		tt4.start();
		
	}

}
