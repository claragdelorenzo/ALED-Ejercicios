package es.upm.aled.livelock;

public class Thread1 extends Thread {

	private Resources r;
	private int id;
	
	public Thread1(Resources r, int id) {
		this.r = r;
		this.id = id;
	}
	
	@Override
	public void run() {
		boolean success = false;
		// Hasta que no logre tener A y B a la vez
		while (!success) {
			// Cojo A
			while (!r.getA()) {}
			System.out.println("Thread Type 1 with ID " + id + " has resource A.");
			// Intento coger B
			if (r.getB()) {
				// Si lo consigo, libero A y B
				System.out.println("SUCCESS: Thread Type 1 with ID " + id + " has resource B.");
				System.out.println("SUCCESS: Thread Type 1 with ID " + id + " releases resource A.");
				r.releaseA();
				System.out.println("SUCCESS: Thread Type 1 with ID " + id + " releases resource B.");
				r.releaseB();
				// Éxito
				success = true;
			}
			else {
				// Si no lo consigo, libero A
				System.out.println("FAIL: Thread Type 1 with ID " + id + " doesn´t have resource B.");
				System.out.println("FAIL: Thread Type 1 with ID " + id + " releases resource A.");
				r.releaseA();
			}
		}
	}
}
