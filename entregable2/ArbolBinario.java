package entregable2;

import java.util.LinkedList;

public class ArbolBinario {
	private Nodo root;

	public ArbolBinario() {
		this.root = null;
	}

	public int obtenerRoot() {
		return this.root.getInfo();
	}

	public LinkedList<Nodo> getfrontera() {
		return buscarfrontera(root);
	}

	private LinkedList<Nodo> buscarfrontera(Nodo root) {
		LinkedList<Nodo> sal = new LinkedList<Nodo>();
		if ((!root.tieneDere()) && (!root.tieneIzqui())) {
			sal.add(root);
		} else {
			if (root.tieneDere()) {
				sal.addAll(buscarfrontera(root.getDere()));
			}
			if (root.tieneIzqui()) {
				sal.addAll(buscarfrontera(root.getIzqui()));
			}

		}
		return sal;

	}

	public void agregar(int v) {
		Nodo nuevo = new Nodo(v);
		insert(this.root, nuevo);
	}

	private void insert(Nodo root, Nodo nue) {
		if (root != null) {
			
			if (nue.getInfo() < root.getInfo()) {
				if (root.tieneIzqui()) {
					insert(root.getIzqui(), nue);
				} else {
					root.setIzqui(nue);
				}
			} else{
				
				if (root.tieneDere()) {
					insert(root.getDere(), nue);
				} else {
					root.setDere(nue);
				}
			}

		} else{
			this.root=nue;
		}

	}

}
