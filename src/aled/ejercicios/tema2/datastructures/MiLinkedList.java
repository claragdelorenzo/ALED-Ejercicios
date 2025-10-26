package aled.ejercicios.tema2.datastructures;

public class MiLinkedList {

	private Node primero;
	private Node ultimo;
	
	public MiLinkedList(Node primero) {
		this.primero = primero;
		this.ultimo = primero;
	}

	public Node getPrimero() {
		return primero;
	}
	
	public void addNode(Node nuevo) {
		this.ultimo.setNext(nuevo);
		this.ultimo = nuevo;
	}

	public void setPrimero(Node primero) {
		this.primero = primero;
	}
	
	public void insertar(Node despuesDe, Node aInsertar) {
		aInsertar.setNext(despuesDe.getNext());
		despuesDe.setNext(aInsertar);
	}	
}
