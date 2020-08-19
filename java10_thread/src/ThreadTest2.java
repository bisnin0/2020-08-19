//스레드를 상속받지 못하면 Runnable인터페이스를 상속받아서 활용하라.
public class ThreadTest2 implements Runnable{
	int i=0;
	String title;
	public ThreadTest2() {
	}
	
	public ThreadTest2(String title) {
		this.title = title;
	}
	
	//짝수만 출력
	public void run() {
		for(int i=2; i<=Integer.MAX_VALUE; i+=2) //Int의 제일 큰값까지만
			System.out.println(title+"="+i);
	}
	
}
