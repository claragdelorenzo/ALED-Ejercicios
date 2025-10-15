package aled.ejercicios.tema2.complejidad;

public class BubbleSort {
	
	public static void ordenacionBubble(int[] lista) {
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
			
			}while(!flag);
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
