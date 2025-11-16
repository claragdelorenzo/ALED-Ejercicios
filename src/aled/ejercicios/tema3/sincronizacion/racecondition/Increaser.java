package aled.ejercicios.tema3.sincronizacion.racecondition;

public class Increaser extends Thread {

	protected Counter counter;
	
	public Increaser(Counter counter) {
		super();
		this.counter = counter;
	}
	
	// Incrementa el contador 1.000.000 de veces
	@Override
	public void run() {
		for (int i = 0; i < 1000000; i ++) {
			counter.increase();
		}
	}
}
