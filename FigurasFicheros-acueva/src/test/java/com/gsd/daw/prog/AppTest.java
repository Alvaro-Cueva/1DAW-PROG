package com.gsd.daw.prog;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;

import com.gsd.daw.prog.api.UnApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class AppTest {
//	@Test
//	@DisplayName("Test de Cobertura1")
//	public void testDeCobertura1() {
//		// este test no hace nada, simplemente da un 100% de cobertura en los reportes.
//		new App();
//		new UnApi();
//		assertTrue(true);
//	}
//	@Test
//	@DisplayName("Test de Cobertura2")
//	public void testDeCobertura2() {
//		
//	}
	
//	@Test
//	@DisplayName("Test con archivo figuras correcto")
//	public void testAgrumentos1() {
//	String[] args = {"FicherosTesting/figuras.txt","FicherosTesting/resultado.svg"};
//	App.main(args);
//		assertTrue(true);
//	}
// 
//	@Test
//	@DisplayName("Test con archivo figuras vacio")
//	public void testAgrumentos2() {
//		String[] args = {"FicherosTesting/figuras2.txt","FicherosTesting/resultado.svg"};
//		App.main(args);
//		assertTrue(true);
//	}
// 
//	@Test
//	@DisplayName("Test con archivo contiene una linea vacia")
//	public void testAgrumentos3() {
//		String[] args = {"FicherosTesting/figuras3.txt","FicherosTesting/resultado.svg"};
//		App.main(args);
//		assertTrue(true);
//	}
// 
//	@Test
//	@DisplayName("Test con archivo que pide un stroke pero no lo tiene")
//	public void testAgrumentos4() {
//		String[] args = {"FicherosTesting/figuras4.txt","FicherosTesting/resultado.svg"};
//		App.main(args);
//		assertTrue(true);
//	}
 
	@Test
	@DisplayName("Test con un circulo sin el radio")
	public void testAgrumentos5() {
		String[] args = {"FicherosTesting/figuras5.txt","FicherosTesting/resultadoSinRadio.svg"};
		App.main(args);
		assertTrue(true);
	}
	
	//Falla al hacer svg constructor por que elipse y las demas son null,
	// mirar el api de la practica anterior para ver que pasa
	//
	//Vale lo de arriba lo he borrado, ahora hechar un ojo a lo de abajo
	//
	// en este caso hay mas de un circulo, en la linea 66 escribir fichero,
	// remplaza el circulo anterior por el nuevo.
	
//	@Test
//	@DisplayName("Test con solo circulos")
//	public void testAgrumentos6() {
//		String[] args = {"FicherosTesting/figuras6.txt","FicherosTesting/resultado.svg"};
//		App.main(args);
//		assertTrue(true);
//	}
}
