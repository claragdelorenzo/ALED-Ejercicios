package es.upm.aled.livelock;

public class TestThreads {

	public static void main(String[] args) {
		Resources r = new Resources();
		for (int i=0; i< 100; i++) {
			Thread1 t1 = new Thread1(r, i);
			Thread2 t2 = new Thread2(r, i);
			t1.start();
			t2.start();
		}
	}
}
