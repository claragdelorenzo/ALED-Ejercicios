package aled.ejercicios.tema2.complejidad;

public class BubbleSort {
	
	public static void ordenacionBubble(int[] lista) {
				
	}
	
	public static String toString (int[] lista) {
		String text = "";
		for(int i = 0; i < lista.length; i++)
			text += lista[i] + " ";	
		return text;
	}

	public static void main(String[] args) {
	// Array ORDENADO
			int[] list = { 5,3,73,92,11,23,1,32,8,66,23,45};		
			System.out.println("Lista de numeros SIN ORDENAR: " + toString(list) );
			ordenacionBubble(list);
			System.out.println("Lista de numeros ORDENADOS: " + toString(list) );
	}

}
