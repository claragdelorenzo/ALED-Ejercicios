package aled.ejercicios.tema2.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Diccionarios {

	public static void main(String[] args) {
		Map<String, Map<String, Float>> asignaturas
			= new HashMap<String, Map<String, Float>>();
		
		Map<String, Float> notas = new HashMap<String, Float>();
		
		notas.put("Paek", 2.0F);
		
		asignaturas.put("ALED", notas);
		
		asignaturas.get("ALED").get("Paek");
		
		notas.put("Rodrigo", 9.7F);
		notas.put("Rodrigo", 3.3F);
		notas.put("Pelayo", 7.1F);
		notas.put("Diego" , 10.0F);
		notas.put("Miguel", 0.1F);
		// ¿Qué podemos hacer con un Map?
		Scanner sc = new Scanner(System.in);
		System.out.println("Escriba el nombre del estudiante:");
		String nombre = sc.nextLine();
		if (notas.containsKey(nombre)) {
			System.out.println("Su nota es: " + notas.get(nombre));
		}
		else {
			System.out.println("El estudiante no existe.");
		}
		
		
		
		
		
	}
}
