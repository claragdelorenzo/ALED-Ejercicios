package es.upm.aled.parking;

public class Parking {

	private final int capacity;
	private int cars;
	
	public Parking(int capacity) {
		this.capacity = capacity;
		this.cars = 0;
	}
	
	public synchronized void enter(int plate) {
		// Si cars < capacidad, le dejo pasar
		// Si no, a esperar
		// Una vez entre, aumentar cars en uno
		try {
			while (cars >= capacity) { // SIEMPRE WHILE, NUNCA IF, HAY QUE SER PESIMISTA SIEMPRE
				System.out.println("Car " + plate + " is waiting to enter.");
				wait(); // Espero en la entrada
			}
			// He conseguido entrar
			System.out.println("Car " + plate + " has managed to enter.");
			cars++;
		} catch(InterruptedException e) {
			System.out.println("Thread interrupted.");
		}
	}
	
	public synchronized void exit(int plate) {
		// Reducir cars en uno
		cars--;
		// Avisar a uno que estuviera esperando
		System.out.println("Car " + plate + " has exited.");
		notify(); // Despierta a un coche que espere al azar
	}
}
