class ATM extends Thread{ //ATM클래스 생성
	private int deposiMoney = 10000; //예금액
	
//	 동기화 전
//	public void run() {
//		for(int i=1; i<7; i++) {
//			try {
//				Thread.sleep(1000);
//			}catch(Exception e) {}
//			outputMoney();
//		}
//	}
	
	
	//1. run()메소드에 동기화
//	public synchronized void run() {
//		for(int i=1; i<7; i++) {
//			try {
//				Thread.sleep(1000);
//			}catch(Exception e) {}
//			outputMoney();
//		}
//	}//이렇게 되면 mother가 먼저 출금을 다 하고 son이 나중에 출금을 하게된다. 

	
	//2. 메소드 내에서 동기화설정
	public void run() {
		synchronized(this) {
			for(int i=1; i<7; i++) {
				try {
					Thread.sleep(1000);
				}catch(Exception e) {}
				outputMoney();
			}
		}
	}//결과는 위와 같다. 한쪽의 작업이 다 끝나야 다른쪽 작업이 시작된다.
	
	public void outputMoney() {
		if(deposiMoney>0) {
			deposiMoney-=1000; 
			
			//이부분때문에 싱크가 필요. 객체하나로 두명이 돈을 꺼낼때 처음에 mother가 -1000을 했고 잔액이 출력되기 직전에 son이 출력을 해버려서 둘 다 출력이 8000이 된것.
			//빼고 출력하기전에 다른 스레드가 들어오는것때문에 출력값이 정상적으로 표시가 되지 않는 현상발생
			//한쪽에서 실행중이면 다른 스레드는 실행 못하게, 한쪽이 끝나면 다른쪽이 실행되게끔 하는걸 동기화(싱크로나이즈드)라고 한다.
			//동기화는 run()에 구현한다.
			
			//현재 실행중인 스레드 이름 구하기
//			System.out.println("잔액"+deposiMoney); //이렇게하면 누가 출금했는지 확인 못함
			System.out.println(Thread.currentThread().getName()+"잔액"+deposiMoney); //스레드 이름 출력
		}else {
			System.out.println(Thread.currentThread().getName()+"잔액이 부족합니다.");
		}
	}
}



public class SynchronizedTest {

	public SynchronizedTest() {
	}

	public static void main(String[] args) {
		ATM atm = new ATM(); //ATM클래스 객체로만듬
		Thread mother = new Thread(atm, "mother"); //스레드 네임 지정 .. //그냥 위에서 잔액만 찍으면 누가 출금했는지 모른다. 그래서 스레드 이름 지정
		Thread son = new Thread(atm, "son");
		
		mother.start();
		son.start();
		
	}

}
