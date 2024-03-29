import java.time.LocalDate;
/**
 * Main que prueba todos los metodos de cine
 * @author Miguel Angel Sanchez y Juan Velasco
 *
 */
public class PruebaCine {
	public static void main(String[] args) {
		Pelicula p1,p2;
		Sesion s1,s2,s3,s4,s5;
		LocalDate d1,d2,d3,d4;
		Sala sa1,sa2,sa3;
		Cine cine;
		String nombre, direccion;
		
		/**
		 * Creamos el cine, las peliculas, las salas y las sesiones
		 */
		
		d1 = LocalDate.of(1991,3,31);
		d2 = LocalDate.of(1992,4,16);
		d3 = LocalDate.of(2000,4,16);
		d4 = LocalDate.of(2002,4,16);
		System.out.println("Probamos a crear el cine, sesiones y peliculas (Dado que no hay toString, si no hay excepciones funcionara todo)\n");
		cine = new Cine ("Cinesa","Mendez Alvaro");
		System.out.println("Metemos salas en el cine\n");
		sa1= cine.crearSala(1,200);
		sa2= cine.crearSala(2,190);
		sa3= cine.crearSala(3,180);
		System.out.println("" + sa1 + "\n" + sa2 + "\n" + sa3 + "\n");
		System.out.println("Metemos peliculas en el cine\n");
		p1 = cine.crearPelicula("Titanic","James Cameron",1997,"Un barco que se hunde",Genero.COMEDIA);
		p2 = cine.crearPelicula("Wolololo","Pedro Balodis",2017,"El dia que una persona fue a clase de Pedro Balodis y no volvio a ser la misma",Genero.TERROR);
		System.out.println("" + p1 + "\n" +  p2  + "\n");
		System.out.println("Metemos sesiones en el cine\n");
		s1 = cine.crearSesion(d1,p1,sa1);
		s2 = cine.crearSesion(d2,p1,sa2);		
		s3 = cine.crearSesion(d3,p2,sa3);		
		s4 = cine.crearSesion(d4,p2,sa3);
		System.out.println("" + s1 + "\n"+ s2 + "\n" + s3 + "\n" + s4 + "\n");
		s5 = new Sesion (d1,p1,200);
		/**
		 * Probamos los getters
		 */
		System.out.println("Probamos los getters: ");
		nombre = cine.getNombre();
		direccion = cine.getDireccion();
		System.out.println("Nombre del cine: " + nombre + "\nDireccion: " + direccion);
		
		System.out.println("\nProbamos la funcion getSala: ");
		System.out.println("Esta es la informacion de la sala: \n" + cine.getSala(1));
		
		System.out.println("\nProbamos la funcion getPelicula: ");
		System.out.println("Esta es la informacion de la pelicula: \n" + cine.getPelicula("Titanic"));
		/**
		 * Vendemos entradas
		 */
		System.out.println("\nProbamos a vender 12 entradas sin descuento: ");
		System.out.println(cine.venderEntrada(12, s2, 15, 0));
		
		System.out.println("\nProbamos a vender 15 entradas con descuento: ");
		System.out.println(cine.venderEntrada(15, s1, 15, 30));
		
		System.out.println("\nProbamos a vender mas entradas de las que hay disponibles: ");
		System.out.println(cine.venderEntrada(205, s1, 15, 0));
		
		System.out.println("\nProbamos a vender butacas para una sesion que no esta anadida al cine ");
		System.out.println(cine.venderEntrada(23, s5, 15, 0));
		
		/**
		 * Imprimimos la cartelera y las sesiones
		 */
		System.out.println("\nObtenemos la cartelera: ");
		System.out.println(cine.getCartelera());
		
		System.out.println("Obtenemos las sesiones: ");
		System.out.println(cine.getSesiones());
		
		/**
		 * Probamos la recaudacion del cine
		 */
		
		System.out.println("\nLa recaudacion del cine es: ");
		System.out.println(cine.getRecaudacion());
		
		/**
		 * Eliminamos una pelicula y una sala
		 */
		
		System.out.println("\nBorramos la sala 3 del cine: ");
		System.out.println(cine.removeSala(3));
		System.out.println("Intentamos volver a borrar la misma sala para ver que falla: ");
		System.out.println(cine.removeSala(3));
		
		
		System.out.println("\nBorramos la pelicula Titanic del cine: ");
		System.out.println(cine.removePelicula("Titanic"));
		System.out.println("Borramos la pelicula Titanic del cine sabiendo que no hay peliculas con ese nombre: ");
		System.out.println(cine.removePelicula("Titanic"));
		
		
		
		
	}
}
