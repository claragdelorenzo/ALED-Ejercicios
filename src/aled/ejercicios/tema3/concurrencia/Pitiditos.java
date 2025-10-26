package aled.ejercicios.tema3.concurrencia;

import java.awt.Toolkit;

public class Pitiditos extends Thread {

	@Override
	public void run() {
		try {
			while (true) {
				sleep(666);
				Toolkit.getDefaultToolkit().beep();
			}
		} catch (InterruptedException e) {
			return;
		}
	}

}
