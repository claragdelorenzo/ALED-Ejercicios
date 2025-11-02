package aled.ejercicios.tema3.tareas;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentMergeSort implements Callable<int[]> {

	private static ExecutorService ex;
	private int[] list;

	public ConcurrentMergeSort(int[] list) {
		this.list = list;
	}

	@Override
	public int[] call() throws Exception {
		// Caso base
		if (list.length == 1) {
			return list;
		}
		// Paso recursivo
		int[] left = Arrays.copyOfRange(list, 0, list.length / 2);
		int[] right = Arrays.copyOfRange(list, list.length / 2, list.length);
		// Ahora lo hago lanzando dos nuevos threads con dos nuevas tareas
		Callable<int[]> taskLeft = new ConcurrentMergeSort(left);
		Callable<int[]> taskRight = new ConcurrentMergeSort(right);
		Future<int[]> futureSortedLeft = ex.submit(taskLeft);
		Future<int[]> futureSortedRight = ex.submit(taskRight);
		int[] sortedLeft = futureSortedLeft.get();
		int[] sortedRight = futureSortedRight.get();
		//
		int[] sortedMerged = new int[list.length];
		int iMerged = 0, iLeft = 0, iRight = 0;
		while (iLeft < sortedLeft.length || iRight < sortedRight.length) {
			if (iLeft == sortedLeft.length) {
				sortedMerged[iMerged] = sortedRight[iRight];
				iMerged++;
				iRight++;
			} else if (iRight == sortedRight.length) {
				sortedMerged[iMerged] = sortedLeft[iLeft];
				iMerged++;
				iLeft++;
			} else if (sortedLeft[iLeft] <= sortedRight[iRight]) {
				sortedMerged[iMerged] = sortedLeft[iLeft];
				iMerged++;
				iLeft++;
			} else if (sortedLeft[iLeft] > sortedRight[iRight]) {
				sortedMerged[iMerged] = sortedRight[iRight];
				iMerged++;
				iRight++;
			}
		}
		return sortedMerged;
	}

	public static void main(String[] args) {
		int[] listBazillion = new int[1000000];
		for (int i = 0; i < listBazillion.length; i++) {
			listBazillion[i] = 1000000 - i;
		}
		long t1 = System.nanoTime();
		try {
			ex = Executors.newCachedThreadPool();
			Callable<int[]> task = new ConcurrentMergeSort(listBazillion);
			Future<int[]> futureList = ex.submit(task);
			int[] sortedList = futureList.get();
		} catch (Exception e) {
		} finally {
			// Cierra todos los Threads
			ex.shutdown();
		}

		long t2 = System.nanoTime();
		System.out.println("Tiempo: " + (t2 - t1));
	}
}
