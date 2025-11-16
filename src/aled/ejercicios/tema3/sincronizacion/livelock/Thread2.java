package es.upm.aled.livelock;

public class Thread2 extends Thread {

	private Resources r;
	private int id;
	
	public Thread2(Resources r, int id) {
		this.r = r;
		this.id = id;
	}
	
	@Override
	public void run() {
		boolean success = false;
		// Hasta que no logre tener A y B a la vez
		while (!success) {
			// Cojo B
			while (!r.getB()) {}
			System.out.println("Thread Type 2 with ID " + id + " has resource B.");
			// Intento coger A
			if (r.getA()) {
				// Si lo consigo, libero A y B
				System.out.println("SUCCESS: Thread Type 2 with ID " + id + " has resource A.");
				System.out.println("SUCCESS: Thread Type 2 with ID " + id + " releases resource B.");
				r.releaseB();
				System.out.println("SUCCESS: Thread Type 2 with ID " + id + " releases resource A.");
				r.releaseA();
				// Éxito
				success = true;
			}
			else {
				// Si no lo consigo, libero B
				System.out.println("FAIL: Thread Type 2 with ID " + id + " doesn´t have resource A.");
				System.out.println("FAIL: Thread Type 2 with ID " + id + " releases resource B.");
				r.releaseB();
			}
		}
	}
}
