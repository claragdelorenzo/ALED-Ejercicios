package tema2;

import java.util.ArrayList;
import java.util.List;

public class Persona {

	private String nombre;
	private List<Persona> hijos;
	
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
		this.hijos = new ArrayList<Persona>();
	}

	public String getNombre() {
		return nombre;
	}

	public List<Persona> getHijos() {
		return hijos;
	}

	public void addHijo(Persona p) {
		//Hay que comprobar que no se añade el mismo hijo
		if(!hijos.contains(p))
		hijos.add(p);
	}

	public String descendientes() {
		
		//Caso base en un if
		if(hijos.isEmpty())
			return this.nombre;
		
		//Paso recursivo
		String lista = this.nombre + ":"; 
		for(Persona p : hijos) { 
		lista += " " + p.descendientes();
		}
		
		return lista;
	}

	public static void main(String[] args) {
		Persona ro = new Persona("Rodrigo");
		Persona no = new Persona("Nora");
		ro.addHijo(no);
		Persona afro = new Persona("Afrodita");
		ro.addHijo(afro);
		Persona lu = new Persona("Luis");
		no.addHijo(lu);
		Persona ra = new Persona("Ramona");
		no.addHijo(ra);
		Persona perseo = new Persona("Perseo");
		afro.addHijo(perseo);
		System.out.println(ro.descendientes());
		
		
		
		
	}

}
