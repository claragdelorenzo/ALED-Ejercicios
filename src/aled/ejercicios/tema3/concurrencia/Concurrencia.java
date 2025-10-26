package aled.ejercicios.tema3.concurrencia;

import java.awt.Toolkit;

public class Concurrencia {

	public static void main(String[] args) {
		Toolkit.getDefaultToolkit().beep();
		Reloj r = new Reloj();
		// start() ejecuta run() y "se desentiende"
		r.start();
		Pitiditos p = new Pitiditos();
		p.start();
	}

}
