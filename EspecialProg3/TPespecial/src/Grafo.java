import java.util.ArrayList;

public class Grafo {
	private ArrayList<Aeropuerto> aeropuertos = new ArrayList<Aeropuerto>();
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private ArrayList<ArrayList<Ruta>> posiblesCaminos = new ArrayList<ArrayList<Ruta>>();

	public Grafo() {
		aeropuertos = new ArrayList<Aeropuerto>();
	}

	public ArrayList<String> mostrarAeropuertos() {
		ArrayList<String> mostrar = new ArrayList<String>();
		for (Aeropuerto a : aeropuertos) {
			mostrar.add(a.getNombre());
		}
		return mostrar;
	}

	public  ArrayList<String> mostrarReservas() {
		ArrayList<String> mostrar = new ArrayList<String>();
		for (Reserva a : reservas) {
			mostrar.add(a.getAerolinea() + " : " + a.getReservados() + " de " + a.getOrigen().getNombre() + " a "
					+ a.getDestino().getNombre());
		}
		return mostrar;

	}

	public void addAeropuerto(Aeropuerto a) {
		aeropuertos.add(a);
	}

	public void addReserva(Reserva r) {
		reservas.add(r);
	}

	public ArrayList<Reserva> getReservas() {
		return this.reservas;
	}

	public Aeropuerto getAeropuerto(String nombre) {
		for (Aeropuerto a : aeropuertos) {
			if (a.getNombre().equals(nombre)) {
				return a;
			}
		}
		Aeropuerto ae = new Aeropuerto("Pepe", "pepito", "peputo");
		return ae;
	}

	public Reserva getReserva(String aerolinea, Aeropuerto origen, Aeropuerto destino) {
		for (int i = 0; i < reservas.size(); i++) {
			Reserva r = reservas.get(i);
			if ((r.getAerolinea() == aerolinea) && (r.getOrigen() == origen) && (r.getDestino() == destino)) {
				return r;
			}

		}
		return null;

	}

	public Ruta existeDirecto(Aeropuerto origen, Aeropuerto destino) {

		if (origen.hasVecino(destino) != null) {
			return origen.hasVecino(destino);

		} else
			return null;

	}

	public int existeAerolinea(Ruta ruta, String aerolinea) {
		return ruta.existeAerolinea(aerolinea);

	}

	public ArrayList<String> serivicio1(Aeropuerto o, Aeropuerto d, String aerolinea) {
		ArrayList<String> mostrar = new ArrayList<String>();
		Ruta ruta = existeDirecto(o, d);
		String dato;
		if (ruta != null) {
			float kilometros = ruta.getKm();
			int asientosDisponibles = existeAerolinea(ruta, aerolinea);
			if (asientosDisponibles > 0)

				dato = "Existe vuelo directo entre " + o.getNombre() + " y " + d.getNombre() + " de " + kilometros
						+ " kilometros, con " + asientosDisponibles + " asientos disponibles";
			else if (asientosDisponibles == 0)
				dato = "No hay asientos disponibles en dicha aerolinea para este vuelo directo";
			else
				dato = "No existe dicha aerolinea en este vuelo directo";

		} else
			dato = "No existe vuelo directo";
		mostrar.add(dato);
		return mostrar;
	}

// siguiente funcion busca todos los vuelos entre dos aeropuertos sin utilizar una aerolinea determinada	


	
	
	
	
	public ArrayList<ArrayList<String>> dfs(Aeropuerto origen, Aeropuerto destino, String aerolinea) {
		ArrayList<ArrayList<String>> mostrar = new ArrayList<ArrayList<String>>();
		ArrayList<Ruta> rutaDisponible = new ArrayList<Ruta>();
		// int kilometros = 0;
		for (Aeropuerto a : aeropuertos) {
			a.setColor("blanco");
		}
		origen.setColor("amarillo");
		dfsVisit(origen, destino, rutaDisponible, aerolinea);
		mostrar = imprimirCaminos(origen, destino, aerolinea);
		return mostrar;

	}

	public ArrayList<ArrayList<String>> imprimirCaminos(Aeropuerto o, Aeropuerto d, String aerolinea) {
		ArrayList<ArrayList<String>> mostrar = new ArrayList<ArrayList<String>>();
		ArrayList<String> agregar = new ArrayList<String>();
		int contador = -1;
		double kilometros = 0;

		for (ArrayList<Ruta> ar : posiblesCaminos) {

			agregar.add(o.getNombre() + " - ");
			for (Ruta r : ar) {
				agregar.add(r.getOrigen().getNombre() + " - " + r.getDestino().getNombre()
						+ "   -  Aerolineas disponibles:  ");
				contador++;
				kilometros += r.getKm();
				for (String ae : r.disponibleSinAerolinea(aerolinea)) {
					agregar.add(" - " + ae);
				}
				

			}

			agregar.add("El vuelo es de "+contador+" estalas y de "+kilometros+" kilometros");
			contador = 0;
			kilometros = 0;

			mostrar.add((ArrayList<String>) agregar.clone());
			agregar.clear();
		}
		return mostrar;
	}

	public void dfsVisit(Aeropuerto origen, Aeropuerto destino, ArrayList<Ruta> rutaDisponible, String aerolinea) {

		if (destino.equals(origen)) {
			posiblesCaminos.add((ArrayList<Ruta>) rutaDisponible.clone());
		} else {

			for (Ruta ru : origen.getVecinos()) {
				if (ru.getDestino().getColor() == "blanco") {
					if (ru.haySinAerolinea(aerolinea)) {
						rutaDisponible.add(ru);
						ru.getDestino().setColor("amarillo");
						dfsVisit(ru.getDestino(), destino, rutaDisponible, aerolinea);
						ru.getDestino().setColor("blanco");
						rutaDisponible.remove(ru);
					}
				}
			}

		}

	}


	public ArrayList<ArrayList<String>> servicio3(String paisO, String paisD) {
		ArrayList<ArrayList<String>> mostrar = new ArrayList<ArrayList<String>>();
		ArrayList<String> agregar = new ArrayList<String>();

		ArrayList<Aeropuerto> aeropuertosO = new ArrayList<Aeropuerto>();
		ArrayList<Aeropuerto> aeropuertosD = new ArrayList<Aeropuerto>();
		ArrayList<Ruta> rutaDisponible = new ArrayList<Ruta>();
		for (Aeropuerto a : aeropuertos) {
			if (a.getPais().equals(paisO))
				aeropuertosO.add(a);
			else if (a.getPais().equals(paisD))
				aeropuertosD.add(a);

		}
		for (Aeropuerto a : aeropuertosO) {
			for (Aeropuerto b : aeropuertosD) {
				Ruta ruta = existeDirecto(a, b);
				if ((ruta != null) && (!ruta.asientosDisponibles().isEmpty())) {

					rutaDisponible.add(ruta);
				}
			}
		}
		if (rutaDisponible.isEmpty()) {
			agregar.add("No existen vuelos directos entre " + paisO + " y " + paisD);
			mostrar.add((ArrayList<String>) agregar.clone());
			
		} else
			mostrar = mostrarVuelos(rutaDisponible);
		return mostrar;
	}

	public ArrayList<ArrayList<String>> mostrarVuelos(ArrayList<Ruta> rutas) {
		ArrayList<ArrayList<String>> mostrar = new ArrayList<ArrayList<String>>();
		ArrayList<String> agregar = new ArrayList<String>();

		for (Ruta r : rutas) {
			agregar.add("Vuelo disponible encontrado");
			agregar.add("Desde " + r.getOrigen().getNombre() + " hacia " + r.getDestino().getNombre());
			agregar.add("Los kilometros a recorrer son: " + r.getKm());
			agregar.add("Las aerolineas disponibles para este vuelo son:");
			for (String aerolineas : r.asientosDisponibles()) {
				agregar.add(aerolineas);
			}
			mostrar.add((ArrayList<String>) agregar.clone());
			agregar.clear();

		}
		return mostrar;
	}

}
