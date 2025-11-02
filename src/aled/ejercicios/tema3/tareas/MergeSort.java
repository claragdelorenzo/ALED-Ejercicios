package aled.ejercicios.tema3.tareas;

import java.util.Arrays;

public class MergeSort {

	public static int[] mergeSort(int[] list) {
		// Caso base
		if (list.length == 1) {
			return list;
		}
		// Paso recursivo
		int[] left = Arrays.copyOfRange(list, 0, list.length/2);
		int[] right = Arrays.copyOfRange(list, list.length/2, list.length);
		int[] sortedLeft = mergeSort(left);
		int[] sortedRight = mergeSort(right);
		int[] sortedMerged = new int[list.length];
		int iMerged = 0, iLeft = 0, iRight = 0;
		while (iLeft < sortedLeft.length || iRight < sortedRight.length) {
			if (iLeft == sortedLeft.length) {
				sortedMerged[iMerged] = sortedRight[iRight];
				iMerged++;
				iRight++;
			}
			else if (iRight == sortedRight.length) {
				sortedMerged[iMerged] = sortedLeft[iLeft];
				iMerged++;
				iLeft++;
			}
			else if (sortedLeft[iLeft] <= sortedRight[iRight]) {
				sortedMerged[iMerged] = sortedLeft[iLeft];
				iMerged++;
				iLeft++;
			}
			else if (sortedLeft[iLeft] > sortedRight[iRight]) {
				sortedMerged[iMerged] = sortedRight[iRight];
				iMerged++;
				iRight++;
			}
		}
		return sortedMerged;
		
	}
	
	public static void main(String[] args) {
		// Para después
		int[] listBazillion = new int[1000000];
		for (int i = 0; i < listBazillion.length; i++) {
			listBazillion[i] = 1000000-i;
		}
		// Comparar tiempos
		int[] list = { 31, 29, 27, 25, 23, 21, 19, 17, 15, 13, 11, 9, 7, 5, 3, 1 };
		long t1 = System.nanoTime();
		int[] sortedList = mergeSort(listBazillion);
		long t2 = System.nanoTime();
		System.out.println("Tiempo: " + (t2-t1));
	}
}
