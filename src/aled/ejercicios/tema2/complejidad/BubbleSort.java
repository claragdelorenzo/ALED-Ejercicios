package aled.ejercicios.tema2.complejidad;

public class BubbleSort {
	
	// ORDENACION BUBBLESORT COMO ME SALIÓ DEL PAPO (con do-while & CON FLAG)
	private static void ordenacionBubbleDoWhile(int[] lista) {
		boolean flag;
		do {
			flag = true;
			for(int i =0; i < (lista.length-1); i++) {
				if(lista[i]>lista[i+1] && (i+1)<lista.length) {
					int aux = lista[i];
					lista[i] = lista[i+1];
					lista[i+1] = aux;
					flag = false;
				}
			}
			
			} while(!flag);
	}
	
	
	// ORDENACIÓN BUBBLESORT DE CLASE (con x2 for & SIN FLAG)
	private static void ordenacionBubble(int[] lista) {
		for (int i = 0; i < lista.length; i++) {
			for (int j = 0; j < lista.length -1 -i; j++) {
				// Si es mayor que el segundo, los cambiamos
				if (lista[j] > lista [j+1]) {
					// Permutación de elementos
					int aux = lista[i];
					lista[i] = lista[i+1];
					lista[i+1] = aux;
				}
			}
		}
	}
	
	
	// TOSTRING: para meter en un String los elementos del Array
	public static String toString (int[] lista) {
		String text = "";
		for(int i = 0; i < lista.length; i++)
			text += lista[i] + " ";	
		return text;
	}

	
	public static void main(String[] args) {
		
		// COMPROBACIÓN BUBBLESORT(DOWHILE)
		// Array 
		int[] list = { 5,3,73,92,11,23,1,32,8,66,23,45};		
		// Imprimir array SIN ORDENAR
		System.out.println("Lista de numeros SIN ORDENAR: " + toString(list) );
		// Imprimir array ORDENADO
		ordenacionBubbleDoWhile(list);
		System.out.println("Lista de numeros ORDENADOS: " + toString(list) );
		
		// COMPROBACIÓN BUBBLESORT(DOWHILE)
		// Array 
		int[] list2 = { 5,3,73,92,11,23,1,32,8,66,23,45};		
		// Imprimir array SIN ORDENAR
		System.out.println("Lista de numeros SIN ORDENAR: " + toString(list) );
		// Imprimir array ORDENADO
		ordenacionBubble(list2);
		System.out.println("Lista de numeros ORDENADOS: " + toString(list) );
	}

}
