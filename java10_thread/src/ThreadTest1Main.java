

public class ThreadTest1Main {

	public ThreadTest1Main() {
	}

	public static void main(String[] args) {
		ThreadTest1 t1 = new ThreadTest1("첫번째");
//		t1.numOutput();
		t1.start(); // 스레드 등록 start();
		ThreadTest1 t2 = new ThreadTest1("두번쨰");
//		t2.numOutput();
		t2.start();
		
	}

}
