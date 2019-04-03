package entregable;


public class Lista {
	private Nodo first;
	private int size;

	public Lista() {
		this.first = null;
		this.size = 0;
	}

	public void addFront(Integer info) {
		Nodo nuevoNodo = new Nodo(info, this.first);
		this.first = nuevoNodo;
		this.size++;
	}

	public Object get(int index) {
		int contador = 0; 

		Nodo temporal = this.first;
		while (contador < index) {
			contador++;
			temporal = temporal.getNext();
		}

		return temporal.getInfo();
	}

	public int count() {
		int contador = 0;

		Nodo temporal = this.first;
		while (temporal != null) {
			contador++;
			temporal = temporal.getNext();
		}

		return contador;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return this.first == null;
		
	}

	public Iterador iterator() {
		
		return new Iterador(this.first);
	}
	
	public boolean contiene(Integer n){
		Nodo nodo = this.first;
		for(int i=0; i<this.size; i++) {
			if (nodo.getInfo()==n) {
				return true;
			}
			else {
				nodo = nodo.getNext();
			}
		}
		return false;
	}
	
	public void addOrdenado(Integer n){
		if(first==null){
			addFront(n);
		}
		else {
			if(first.getInfo()>n){
				addFront(n);
			}
			else{
				Nodo tmp=first;
				while((tmp.getNext()!=null)&&(tmp.getNext().getInfo()<n)){
					tmp=tmp.getNext();
				}
					Nodo insertar=new Nodo(n);
					insertar.setNext(tmp.getNext());
					tmp.setNext(insertar);
				
			}
		}
		
	}
}



