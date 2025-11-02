package aled.ejercicios.tema3.tareas;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LanzadorTareas {

	public static void main(String[] args) {
		try {
			// Creo el servicio de ejecución de Threads
			int cores = Runtime.getRuntime().availableProcessors();
			ExecutorService executor = Executors.newFixedThreadPool(cores);
			// Crear tareas
			Callable<Integer> tarea1 = new MCD(500000000, 150005);
			// Envía las tareas al servicio de ejecución
			Future<Integer> resultadoFuturo = executor.submit(tarea1);
			// Este código NO SE BLOQUEA hasta que termine la tarea
			System.out.println("Hago cosas");
			// Esperar a que termine las tareas
			// Este código se BLOQUEA hasta que termine la tarea
			int resultado = resultadoFuturo.get();
			System.out.println(resultado);
			
			
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
		}

	}
}
