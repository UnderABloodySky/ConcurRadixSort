package radixSort;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestConcurRadixSort {
	private ConcurRadixSort concurPrueba;
	private List<Integer> listaAOrdenar;
//	private List<Integer> listaCeroOrdenada;
	private List<Integer> listaUnoOrdenada;
	private List<Integer> listaConListasCeroUno;
	@Before
	public void setup() {
	concurPrueba=new ConcurRadixSort(2, 2);	
	listaAOrdenar = new ArrayList<Integer>();
//	listaCeroOrdenada= new ArrayList<Integer>();
	listaUnoOrdenada= new ArrayList<Integer>();
	listaConListasCeroUno= new ArrayList<Integer>();
	}
//	@Test
//	public void testSplit() {
//		listaAOrdenar.add(6);
//		listaAOrdenar.add(7);
//		listaAOrdenar.add(4);
//		listaAOrdenar.add(3);
////		listaCeroOrdenada.add(6);
////		listaCeroOrdenada.add(4);
//		listaUnoOrdenada.add(6);
//		listaUnoOrdenada.add(4);
//		listaUnoOrdenada.add(7);
//		listaUnoOrdenada.add(3);
//				
//		listaConListasCeroUno=concurPrueba.split(listaAOrdenar, 0);
//		
//		assertEquals(listaUnoOrdenada ,listaConListasCeroUno);
//	}
//
//	@Test
//	public void testRaidUsandoSplit() {
//		listaAOrdenar.add(6);
//		listaAOrdenar.add(7);
//		listaAOrdenar.add(4);
//		listaAOrdenar.add(3);
//		
//		listaUnoOrdenada.add(3);
//		listaUnoOrdenada.add(4);
//		listaUnoOrdenada.add(6);
//		listaUnoOrdenada.add(7);
//		
//		
//		assertEquals(listaUnoOrdenada,concurPrueba.radixSort(listaAOrdenar));
//	}
	
	@Test
	public void testConcur() {
		listaAOrdenar.add(6);
		listaAOrdenar.add(7);
		listaAOrdenar.add(4);
		listaAOrdenar.add(3);
//		listaCeroOrdenada.add(6);
//		listaCeroOrdenada.add(4);
		listaUnoOrdenada.add(3);
		listaUnoOrdenada.add(4);
		listaUnoOrdenada.add(6);
		listaUnoOrdenada.add(7);
//		listaConListasCeroUno= 
		assertEquals(listaUnoOrdenada,concurPrueba.radixSort(listaAOrdenar));
	}
}
