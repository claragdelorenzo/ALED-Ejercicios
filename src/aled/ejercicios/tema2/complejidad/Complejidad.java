package aled.ejercicios.tema2.complejidad;

import java.util.ArrayList;
import java.util.List;

public class Complejidad {

	// Si el array mide 100
	// Devolver la suma de todos los enteros de un array
	// O(n-1+1+1) => O(n)
	public static int sumIntArray(int[] lista) {
		int sum = 0;
		// Esto se ejecuta tantas veces como el tamaño del array - 1
		// Esto se ejecuta 100 veces
		for (int i = 0; i < lista.length; i++) {
			sum += lista[i];
		}
		return sum;
	}

	// Si el array mide 100
	// Devolver la suma de todos los enteros de un array dos veces
	// O(n-1+n-1+1+1) => O(2n) => O(n)
	public static int sumIntArrayTwice(int[] lista) {
		int sum = 0;
		// Esto se ejecuta tantas veces como el tamaño del array - 1
		// Esto se ejecuta 100 veces
		for (int i = 0; i < lista.length; i++) {
			sum += lista[i];
		}
		// Esto se ejecuta tantas veces como el tamaño del array - 1
		// Esto se ejecuta 100 veces
		for (int j = 0; j < lista.length; j++) {
			sum += lista[j];
		}
		return sum;
		// Se ha sumado 200 veces
	}

	// Si el array mide 100 y el 69 está en la posición 23
	// Devolver la suma de todos los enteros de un array
	// Caso peor: el 69 está al final (en N)
	// O(n)
	public static int sumIntArrayStop69(int[] lista) {
		int sum = 0;
		// Esto se ejecuta tantas veces como el tamaño del array - la posición de 69
		// Esto se ejecuta 23 veces
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] == 69) {
				return sum;
			}
			sum += lista[i];
		}
		return sum;
	}
	
	// Si el array mide 100
	// O(n*n+1+1) => O(n^2)
	public static int numDuplicates(int[] lista) {
		int numDupl = 0;
		for (int i = 0; i < lista.length; i++) {
			for (int j = 0; j < lista.length; j++) {
				// Esto se ejecuta tantas veces como (tamaño de array)^2
				// Esto se ejecuta 10.000 veces
				if ((i<j) && (lista[i] == lista[j])) {
					numDupl++;
					System.out.println("HOLA");
					System.out.println("CARA");
					System.out.println("COLA");
					System.out.println("MOLA");
				}
			}
		}
		return numDupl;
	}
	
	// O(6+n^3) => O(n^3)
	public static int[][] multiplyMatrix(int A[][], int B[][]) {
		int rows1 = A.length;
		int rows2 = B.length;
		int cols1 = A[0].length;
		int cols2 = B[0].length;
		List<Integer> miLista = new ArrayList<Integer>();
		
		int C[][] = new int[rows1][cols2];
		
		// Asumimos que rows1 = rows2 = cols1 = cols2 = n
		for (int i = 0; i < rows1; i++) {
			for (int j = 0; j < cols2; j++) {
				for (int k = 0; k < cols1; k++) {
					// Esto va a pasar rows1*cols2*cols1 veces
					// Esto va a pasar n^3 veces
					C[i][j] += A[i][k] * B[k][j];
					miLista.contains(7); // +N
				}
			}
		}
		
		return C;
	}
	
	
	
	
	
	
	
	
}
