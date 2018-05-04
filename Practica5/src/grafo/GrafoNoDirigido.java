package grafo;

import java.util.*;

import vertice.Vertice;

public class GrafoNoDirigido<T> extends Grafo<T> {

	public void addArco(Vertice<T> v1, Vertice<T> v2, double peso) {
		if ((vertices.containsKey(v1.getId())==false) || (vertices.containsKey(v2.getId())==false)){
			return;
		}
		
		Map<Integer,Integer> m1 = new TreeMap<>();
		Map<Integer,Integer> m2 = new TreeMap<>();
		m1.put(v1.getId(), v2.getId());
		m2.put(v2.getId(), v1.getId());
		if (this.existeArco(v1, v2)||this.existeArco(v2, v1)) {
			return;
		}
		
		arcos.put(m1, peso);
	}
	
	public double getPesoDe(Vertice<T> v1, Vertice<T> v2) {
		Map<Integer,Integer> m1 = new TreeMap<>();
		Map<Integer,Integer> m2 = new TreeMap<>();
		m1.put(v1.getId(), v2.getId());
		m2.put(v2.getId(), v1.getId());
		
		if (arcos.containsKey(m1)==true) {
			return arcos.get(m1);
		}
		else if (arcos.containsKey(m2)==true) {
			return arcos.get(m2);
		}
		return -1;
	}
	
	public List<Vertice<T>> getVecinosDe(Vertice<T> v){
		List<Vertice<T>> lista = new ArrayList<>();
		for(Vertice<T> ver: super.vertices.values()) {
			if(this.existeArco(v, ver)) {
				lista.add(ver);
			}else if(this.existeArco(ver, v)) {
				lista.add(ver);
			}
		}
		return lista;
	}
}
