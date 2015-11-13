package corejava.current;

public class StaticSync {
	
	public static synchronized void doSomething() {
		for(int i=0;i<5;i++){
			System.out.println(Thread.currentThread().getName() + ": " + "doSomething()");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { }
		}
	}
	
	public class A implements Runnable {

		@Override
		public void run() {
			doSomething();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		StaticSync.A sa = new StaticSync().new A();
		
		Thread t1 = new Thread(sa, "thread-t1");
		t1.start();
		Thread t2 = new Thread(new StaticSync().new A(), "thread-t2");
		t2.start();
		doSomething();
		Thread.sleep(1000);
	}
}
