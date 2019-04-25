package entregable2;


public class Nodo {
	private Integer info;
	private Nodo dere;
	private Nodo  izqui;


	
	public Nodo(Integer info) {
		this.info = info;
		this.dere = null;
		this.izqui = null;
	}
	
	public boolean tieneDere() {
		if(this.dere!=null){
			return true;
		}
		else return false;
	}
	public boolean tieneIzqui() {
		if(this.izqui!=null){
			return true;
		}
		else return false;
	}
	
	public Nodo getDere() {
		return dere;
	}
	public Nodo getIzqui() {
		return izqui;
	}

	public void setDere(Nodo dere) {
		this.dere = dere;
	}
	public void setIzqui(Nodo izqui) {
		this.izqui = izqui;
	}

	public Integer getInfo() {
		return info;
	}

	public void setInfo(Integer info) {
		this.info = info;
	}
}
