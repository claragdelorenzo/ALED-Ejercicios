package es.upm.aled.buffer;

public class Buffer<Tipo> {

	private Tipo dato;
	
	public Buffer() {
		dato = null;
	}

	public synchronized void store(int id, Tipo dato) {
		try {
			// Si el buffer está vacío
			while (this.dato != null) {
				System.out.println("Productor " + id + " está esperando.");
				wait();
			}
			this.dato = dato;
			System.out.println("Productor " + id + " ha producido el dato " + dato);
			notifyAll();
		} catch (InterruptedException e) {
		}
	}

	public synchronized Tipo retrieve(int id) {
		Tipo aDevolver = null;
		try {
			// Si el buffer está lleno
			while (dato == null) {
				System.out.println("Consumidor " + id + " está esperando.");
				wait();
			}
			aDevolver = dato;
			dato = null;
			System.out.println("Consumidor " + id + " ha consumido el dato " + aDevolver);
			notifyAll();
		} catch (InterruptedException e) {}
		return aDevolver;
	}

}
