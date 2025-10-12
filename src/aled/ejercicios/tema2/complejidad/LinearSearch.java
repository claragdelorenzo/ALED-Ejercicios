package aled.ejercicios.tema2.complejidad;

public class LinearSearch {

	// Hemos hecho indexOf()
	// Devuelve la posición, -1 si no está
	public static int linearSearch(int[] lista, int valor) {
		// Recorro la lista
		for (int i = 0; i < lista.length; i++) {
			// ¿Son iguales?
			if (lista[i] == valor) {
				return i;
			}
		}
		// No estaba
		return -1;
	}
}
