package entregable;

import java.util.Iterator;

public class Iterador implements Iterator<Integer>{
private Nodo nodo;
	
	public Iterador(Nodo nodo) {
		this.nodo = nodo;
	}
	public boolean hasNext() {
		return this.nodo != null;
	}
	public Integer next() {
		Integer info = this.nodo.getInfo();
		this.nodo = this.nodo.getNext();
		return info;
	}
	public Integer get(){
		return this.nodo.getInfo();
	}
	
}
