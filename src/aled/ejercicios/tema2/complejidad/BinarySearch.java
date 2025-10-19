package aled.ejercicios.tema2.complejidad;

public class BinarySearch {

	private static int binarySearch(int[] list, int lo, int hi, int value) {
		do {
			int me = (int) Math.floor(lo + (hi-lo)/2);
			int v = list[me]; // O(1)
			if (v == value) {
				return me;
			}
			else if (v > value) {
				hi = me;
			}
			else {
				lo = me +1;
			}
		} while (lo<hi);
		return -1;
	}
	
	// Método facade
	public static int binarySearch(int[] list, int value) {
		return binarySearch(list, 0, list.length, value);
	}
	
	
	
	/* 
	 * IMPLEMEMENTACION DE RECURSIVIDAD PARA PROGRAMAR BÚSQUEDA BINARIA
	 * @return: entero que sera la posicion del valor dado o -1 sino se encuentra en la lista.
	 */
	
	private static int binarySearchRecursivo(int[] list, int lo, int hi, int value) {
		//Código general
		int me = (int) Math.floor(lo + (hi-lo)/2);
		int v = list[me];
		
		//Caso Base
		if(v == value)
			return me;
		if(lo>=hi)
			return -1;
		
		//Paso recursivo
		if (v<value)
			return binarySearchRecursivo(list, me, hi, value);
		else
			return binarySearchRecursivo(list, lo, (me-1), value);
	}
	
	// Método fachada
	public static int binarySearchRecursivo(int[] list, int value) {
		return binarySearchRecursivo(list, 0, list.length, value);
	}
	
	public static void main(String[] args) {
		// Array ORDENADO
		int[] list = { 1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31 };
		int value = 13;
		int posicion = binarySearchRecursivo(list, value);
		System.out.println("Posición: " + posicion);
	}
	
	
	
	
	
	
	
}
