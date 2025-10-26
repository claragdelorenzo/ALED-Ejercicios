package aled.ejercicios.tema2.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pruebas {

	public static void main(String[] args) {
		// Mi implementación de LinkedList
		Node primero = new Node(7);
		Node segundo = new Node(3);
		Node tercero = new Node(10);
		MiLinkedList lista = new MiLinkedList(primero);
		lista.addNode(segundo);
		lista.addNode(tercero);
		
		// Implementacions de List de Java
		List<Integer> arrayList = new ArrayList<Integer>(100);
		List<Integer> linkedList = new LinkedList<Integer>();
	}
}
