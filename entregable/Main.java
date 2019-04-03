package entregable;




public class Main {

	public static void main(String[] args) {
		Lista lista1 = new Lista();
		Lista lista2 =new Lista();
	
		lista1.addFront(1);
		lista1.addFront(5);
		lista1.addFront(16);
		lista1.addFront(3);
		lista1.addFront(10);
		
		lista2.addFront(16);
		lista2.addFront(15);
		lista2.addFront(1);
		lista2.addFront(31);
		lista2.addFront(10);
		
		
		
		imprimirLista(funcionConstruir(lista1,lista2));
		

	}

	
	private static Lista funcionConstruir(Lista a, Lista b) {
		Lista resultante=new Lista();
		Iterador iterador= a.iterator();
		
		
		while(iterador.hasNext()){
			Integer numero = iterador.next();
			if(!b.contiene(numero)){
				resultante.addFront(numero);
				
			}
		}
		return resultante;
		
	}


	private static void imprimirLista(Lista resultante) {
		Iterador iterador3= resultante.iterator();
		while(iterador3.hasNext()){
			Integer valor= iterador3.next();
			System.out.println(valor);
		}
		
	}
	

}
