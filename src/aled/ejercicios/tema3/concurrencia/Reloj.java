package aled.ejercicios.tema3.concurrencia;

import java.time.LocalDateTime;

// Nuestra clase ha de extender la clase Thread
public class Reloj extends Thread {

	// Ha de implementar el método run()
	@Override
	public void run() {
		try {
			while (true) {
				sleep(1000);
				System.out.println(LocalDateTime.now().toString());
			}
		} catch (InterruptedException e) {
			return;
		}
	}

}
