package aled.ejercicios.tema3.sincronizacion.racecondition;

public class IncreaserGetSet extends Increaser {

	public IncreaserGetSet(Counter counter) {
		super(counter);
	}

	// Incrementa el contador 1.000.000 de veces
	@Override
	public void run() {
		for (int i = 0; i < 1000000; i++) {
			// START Region Critica
			synchronized(counter) {
				int count = counter.getCount();
				count++;
				counter.setCount(count);
			}
			// END Region Critica
		}
	}
}
