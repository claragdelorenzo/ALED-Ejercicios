package aled.ejercicios.tema3.sincronizacion.racecondition;

// This class is Thread-Safe
public class CounterMonitor extends Counter {

	@Override
	public synchronized int getCount() {
		return count;
	}
	
	@Override
	public synchronized void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public synchronized void increase() {
		count++; // Tampoco es atómico
	}
}
