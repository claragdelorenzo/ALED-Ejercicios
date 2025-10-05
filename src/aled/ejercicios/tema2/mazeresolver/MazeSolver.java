package aled.ejercicios.tema2.mazeresolver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MazeSolver {

	private String[] maze;
	private char wall;
	private Coordinate start;
	private Coordinate end;
	private List<Coordinate> path;
	// Lista de coordenadas visitadas
	private Set<Coordinate> visited;
	
	public MazeSolver(String[] maze, char wall, Coordinate start, Coordinate end) {
		super();
		this.maze = maze;
		this.wall = wall;
		this.start = start;
		this.end = end;
		this.path = new ArrayList<Coordinate>();
		this.visited = new HashSet<Coordinate>();
	}
	
	// Método recursivo
	private boolean walk(Coordinate current) {
		// Código general
		path.add(current);
		
		// CASOS BASE:
		// Estoy fuera?
		if (current.getX() >= maze[0].length() // La X se sale por la derecha
			|| current.getX() < 0			   // La X se sale por la izquierda
			|| current.getY()  >= maze.length  // La Y se sale por abajo
			|| current.getY() < 0) {		   // La Y se sale por arriba
			path.remove(current);
			return false;
		}
		// Estoy en un muro?
		if (maze[current.getY()].charAt(current.getX()) == wall ) {
			path.remove(current);
			return false;
		}
		// Estoy en la salida?
		if (current.equals(end)) {
			return true;
		}
		// He estado antes?
		if (visited.contains(current)) {
			path.remove(current);
			return false;
		}
		
		// Paso recursivo: up, right, down left
		Coordinate up = new Coordinate(current.getX(), current.getY() - 1);
		Coordinate right = new Coordinate(current.getX() + 1, current.getY());
		Coordinate down = new Coordinate(current.getX(), current.getY() + 1);
		Coordinate left = new Coordinate(current.getX() - 1, current.getY());
		Coordinate toVisit[] = new Coordinate[4];
		toVisit[0] = up;
		toVisit[1] = right;
		toVisit[2] = down;
		toVisit[3] = left;
		for (Coordinate next : toVisit) {
			this.visited.add(current);
			if (this.walk(next)) {
				return true;
			}
			
		}
		return false;
	}
	
	// Método fachada
	public List<Coordinate> solve() {
		this.walk(start);
		return path;
	}
	
	public static void main(String[] args) throws IOException{
		Path filePath = Paths.get(args[0]);
		List<String> mazeList = Files.readAllLines(filePath);
		String maze[] = mazeList.toArray(new String[0]);
		// Encontramos camino de inicio y fin
		Coordinate start = null, end = null;
		for (int i = 0; i < maze.length ; i++) {
			String string = maze[i];
			int startX = string.indexOf("E");
			int endX = string.indexOf("S");
			if (startX != -1) {
				start = new Coordinate(startX, i);
			}
			if (endX != -1) {
				end = new Coordinate(endX, i);
			}
		}
		// Creamos el resolvedor de laberintos
		MazeSolver solver = new MazeSolver(maze, '#', start, end);
		// Lo ejecutamos
		System.out.println(solver.solve());
	}
}
