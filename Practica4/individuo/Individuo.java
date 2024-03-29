package individuo;

import java.util.List;

import funcion.Funcion;
import nodos.INodo;
import terminal.Terminal;

/**
 * Clase Individuo
 * 
 * @author Juan Velasco y Miguel Angel Sanchez
 *
 */
public class Individuo implements IIndividuo {

	private INodo expresion;
	private double fitness;

	/**
	 * Obtiene la expresion de un individuo
	 * 
	 * @return INodo Expresion del individuo
	 */
	@Override
	public INodo getExpresion() {
		return expresion;
	}

	/**
	 * Fija la expresion del individuo
	 * 
	 * @param expresion
	 *            Expresion del indivudio
	 */
	@Override
	public void setExpresion(INodo expresion) {
		this.expresion = expresion;

	}

	/**
	 * Obtiene el fitness del individuo
	 * 
	 * @return fitness del individuo
	 */
	@Override
	public double getFitness() {
		return fitness;
	}

	/**
	 * Fija el fitness del individuo
	 * 
	 * @param fitness
	 *            Fitness del individuo
	 */
	@Override
	public void setFitness(double fitness) {
		this.fitness = fitness;

	}

	/**
	 * Crea un nodo aleatorio a partir de una profundidad y una serie de terminales
	 * y funciones
	 * 
	 * @param profundidad
	 *            Profundiad de la expresion
	 * @param terminales
	 *            Terminales
	 * @param funciones
	 *            Funciones
	 * @return Nueva expresion
	 */
	public INodo crearNodoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones) {
		int ran;
		INodo nnodo;
		int hijos;
		if (profundidad == 0) {
			ran = (int) Math.floor(Math.random() * terminales.size());
			return terminales.get(ran);
		}
		ran = (int) Math.floor(Math.random() * funciones.size());
		nnodo = funciones.get(ran).copy();
		hijos = ((Funcion) nnodo).getNumArg();
		for (int i = 0; i < hijos; i++) {
			nnodo.incluirDescendiente(crearNodoAleatorio(profundidad - 1, terminales, funciones));
		}
		return nnodo;
	}

	/**
	 * Crea un individuo aleatorio con la informacion dada
	 * 
	 * @param profundidad
	 *            Profundidad del individuo
	 * @param terminales
	 *            Lista de terminales del individuo
	 * @param funciones
	 *            Lista de funciones del individuo
	 */
	@Override
	public void crearIndividuoAleatorio(int profundidad, List<Terminal> terminales, List<Funcion> funciones) {
		this.expresion = crearNodoAleatorio(profundidad, terminales, funciones);
		this.etiquetaNodos();
	}

	/**
	 * Calcula la expresion del individuo
	 * 
	 * @return expresion del individuo
	 */
	@Override
	public double calcularExpresion() {
		return expresion.calcular();
	}

	/**
	 * Otra funcion que calcula la expresion del individuo pero con parametro
	 * 
	 * @return expresion del individuo
	 */
	public double calcularExpresion(double x) {
		return expresion.calcular(x);
	}

	/**
	 * Obtiene el numero de nodos del individuo
	 */
	@Override
	public int getNumeroNodos() {
		return 0;
	}

	/**
	 * Imprime la informacion del individuo
	 */
	@Override
	public void writeIndividuo() {
		System.out.println("Expresion: " + expresion.toString());
	}

	/**
	 * Etiqueta los nodos del individuo
	 */
	@Override
	public void etiquetaNodos() {
		expresion.etiquetar(0);
	}

	/**
	 * Calcula el numero total de nodos del individuo
	 */
	@Override
	public int totalNodos() {
		return expresion.numNodos();

	}

	/**
	 * toString de individuo return Individuo
	 */
	public String toString() {
		return "Individuo: " + expresion + " Fitness: " + fitness;
	}

}
