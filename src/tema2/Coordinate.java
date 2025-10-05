package tema2;

import java.util.Objects;

public class Coordinate {

	private int x;
	private int y;
	
	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		return ( (this.x == other.x) && (this.y == other.y) );
	}
	
	
}
