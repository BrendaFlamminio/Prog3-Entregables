package entregable2;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		ArbolBinario arbol = new ArbolBinario();
		
		arbol.agregar(8);
		arbol.agregar(6);
		arbol.agregar(3);
		arbol.agregar(9);
		arbol.agregar(5);
		arbol.agregar(7);
		arbol.agregar(1);
		arbol.agregar(21);
		arbol.agregar(2);
		arbol.agregar(11);
		
		Iterator<Nodo> resultado = arbol.getfrontera().iterator();
		
		while (resultado.hasNext()) {
			System.out.println(resultado.next().getInfo());

		}

	}

}