package aled.ejercicios.tema2.cuentas;

public class Suma {

	public static void main(String[] args) {
		int resultado = suma(5);
		System.out.println(resultado);
	}
	
	// Suma todos los enteros del 1 al n
	public static int suma(int n) {
		if (n == 1) {
			return 1;
		}
		return n + suma(n-1);
	}
}
