package radixSort;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestConcurRadixSort {
	private ConcurRadixSort concurPrueba;
	private List<Integer> listaAOrdenar;
	private List<Integer> listaCeroOrdenada;
	private List<Integer> listaUnoOrdenada;
	private List<List<Integer>> listaConListasCeroUno;
	@Before
	public void setup() {
	concurPrueba=new ConcurRadixSort(0, 0);	
	listaAOrdenar = new ArrayList<Integer>();
	listaCeroOrdenada= new ArrayList<Integer>();
	listaUnoOrdenada= new ArrayList<Integer>();
	listaConListasCeroUno= new ArrayList<>();
	}
	@Test
	public void testSplit() {
		listaAOrdenar.add(6);
		listaAOrdenar.add(7);
		listaAOrdenar.add(4);
		listaAOrdenar.add(3);
		
//		listaCeroOrdenada.add(6);

//		listaCeroOrdenada.add(4);
		listaUnoOrdenada.add(6);
		listaUnoOrdenada.add(7);
//		listaUnoOrdenada.add(3);
		listaUnoOrdenada.add(4);
		
		
		listaConListasCeroUno=concurPrueba.split(listaAOrdenar, 2);
		

		assertEquals(listaUnoOrdenada ,listaConListasCeroUno.get(1));
	}

}
