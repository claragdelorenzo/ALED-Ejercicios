package es.upm.aled.parking;

import java.util.Random;

public class Car extends Thread{

	private int plate;
	private Parking parking;
	
	public Car(int plate, Parking parking) {
		this.plate = plate;
		this.parking = parking;
	}
	
	@Override
	public void run() {
		try {
			// Entro
			parking.enter(plate);
			// Hago exámenes, estudio, paso el día en clubes
			Random rand = new Random(plate);
			sleep(rand.nextLong(1000, 5000));
			// Salgo
			parking.exit(plate);
		} catch (InterruptedException e) {
			System.out.println("Thread interruoted");
		}
	}
}
