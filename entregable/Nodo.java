package entregable;



public class Nodo {

	private Integer info;
	private Nodo next;

	public Nodo() {
		this(null,null);
	}
	
	public Nodo(int info) {
		this(info,null);
	}
	
	public Nodo(Integer info, Nodo next) {
		this.info = info;
		this.next = next;
	}
	
	public Nodo getNext() {
		return next;
	}

	public void setNext(Nodo next) {
		this.next = next;
	}

	public Integer getInfo() {
		return info;
	}

	public void setInfo(Integer info) {
		this.info = info;
	}
}

