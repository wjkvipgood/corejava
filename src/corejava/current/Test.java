package corejava.current;

public class Test implements Runnable{
	
	private int c;
	
	@Override
	public void run() {
		for (int i=0;i<10000;i++) {
			c++;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		final int SIZE = 2;
		Test t = new Test();
		Thread[] ts = new Thread[SIZE];
		for(int i=0;i<SIZE;i++){
			ts[i] = new Thread(t);
			ts[i].start();
		}
		for(int i=0;i<SIZE;i++){
			ts[i].join();
		}
		System.out.println(t.c);
	}

}
