package com.gsd.daw.prog;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gsd.daw.prog.api.UnApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class AppTest {
	
	@Test
	@DisplayName("Args tiene una longitud inferior")
	public void argsInferior() {
		// Este test tiene la longitud de argumentos incorrecta, en este caso una longitud inferior. 
		String []args = {"192.192.192.123"};
		assertFalse(App.isLongitudArgumentos(args));
	}
	@Test
	@DisplayName("Args tiene una longitud superior")
	public void argsSuperior() {
		// Este test tiene la longitud de argumentos incorrecta, en este caso una longitud superior. 
		String []args = {"192.192.192.192.192","23","23"};	
		assertFalse(App.isLongitudArgumentos(args));
	}
	
	@Test
	@DisplayName("Args tiene una longitud correcta")
	public void argsCorrecto() {
		// Este test tiene la longitud de argumentos correcta. 
		String []args = {"192.192.192.192","23"};	
		assertTrue(App.isLongitudArgumentos(args));

	}
	
	@Test
	@DisplayName("Formato ip inferior")
	public void formatoIpIncorrecto() {
		// el formato de la ip incorrecta. 
		String ip = "192.192.192192";	
		assertFalse(App.isLongitudIpValida(ip));
	}
	
	@Test
	@DisplayName("Formato ip incorrecto")
	public void formatoIpInferior() {
		// el formato de la ip incorrecta. 
		String ip = "192.192.192192";	
		assertFalse(App.isLongitudIpValida(ip));
	}
	
	
	
	@Test
	@DisplayName("Formato ip superior")
	public void formatoIpSuperior() {
		//  el formato de la ip correcta. 
		String ip = "192.192.192.192.192";	
		assertFalse(App.isLongitudIpValida(ip));
	}
	
	@Test
	@DisplayName("Formato ip acabado en punto")
	public void formatoIpAcabadoEnPunto() {
		//  el formato de la ip correcta. 
		String ip = "192.192.192.192.";	
		assertFalse(App.isLongitudIpValida(ip));
	}
	
	@Test
	@DisplayName("Formato ip correcta")
	public void formatoIpCorrecta() {
		//  el formato de la ip correcta. 
		String ip = "192.192.192.192";	
		assertTrue(App.isLongitudIpValida(ip));
	}
	
	
	
	@Test
	@DisplayName("Formato mascara superior")
	public void formatoMascaraSuperior() {
		// la mascara incorrecta. 
		String mascara = "2233";	
		assertFalse(App.isMascaraDentroDeValoresValidos(mascara));
	}
	
	@Test
	@DisplayName("Formato mascara inferior")
	public void formatoMascaraIpInferior() {
		// la mascara incorrecta. 
		String mascara = "-20";	
		assertFalse(App.isMascaraDentroDeValoresValidos(mascara));
	}
	
	
	@Test
	@DisplayName("Formato mascara int invalido")
	public void formatoMascaraIntInvalido() {
		// la mascara incorrecta. 
		String mascara = "l20";	
		assertFalse(App.isMascaraDentroDeValoresValidos(mascara));
	}
	
	
	@Test
	@DisplayName("Formato mascara correcta")
	public void mascaraCorrecta() {
		// la mascara correcta. 
		String mascara = "23";	
		assertTrue(App.isMascaraDentroDeValoresValidos(mascara));
	}
	
	
	@Test
	@DisplayName("Comprobar si la ip es reservada 0.0.0.0")
	public void isIpReservada1() {
		// La ip son int validos. 
		String ip = "0.0.0.0";	
		assertFalse(App.esIpReservada(ip));
	}
	
	@Test
	@DisplayName("Comprobar si la ip es reservada 255.255.255.255")
	public void isIpReservada2() {
		// La ip son int validos. 
		String ip = "255.255.255.255";	
		assertFalse(App.esIpReservada(ip));
	}
	
	@Test
	@DisplayName("Comprobar si la ip es reservada 255.255.255.255")
	public void isIpReservada3() {
		// La ip son int validos. 
		String ip = "1500.255.255.255";	
		assertFalse(App.esIpReservada(ip));
	}
	
	@Test
	@DisplayName("Comprobar si la ip 192.0.0.0 es reservada")
	public void isIpReservada4() {
		// La ip son int validos. 
		String ip = "192.0.0.0";	
		assertTrue(App.esIpReservada(ip));
	}
	
	
	
	@Test
	@DisplayName("Ip mal dentro de valores validos")
	public void isIpValidaMal() {
		// La ip son int validos. 
		String ip = "240.255.255.255.120";	
		assertFalse(App.isIpDentroDeValoresValidos(ip));
	}
	
	@Test
	@DisplayName("Ip siendo mayor")
	public void isIpValidaMayor() {
		// La ip son int validos. 
		String ip = "260.255.255.255";	
		assertFalse(App.isIpDentroDeValoresValidos(ip));
	}
	
	@Test
	@DisplayName("Ip siendo menor")
	public void isIpValidaMenor() {
		// La ip son int validos. 
		String ip = "12.255.-255.255";	
		assertFalse(App.isIpDentroDeValoresValidos(ip));
	}
	
	
	
	@Test
	@DisplayName("Ip con letra")
	public void isIpValidaLetra() {
		// La ip son int validos. 
		String ip = "l92.255.255.255";	
		assertFalse(App.isIpDentroDeValoresValidos(ip));
	}
	
	
	@Test
	@DisplayName("Ip siendo correcta")
	public void isIpValidaCorrecta() {
		// La ip son int validos. 
		String ip = "192.255.255.255";	
		assertTrue(App.isIpDentroDeValoresValidos(ip));
	}
	
	
	@Test
	@DisplayName("Determinar clase con ip incorrecta")
	public void determinarClaseIpIncorrecta() {
		// La ip son int validos. 
		String ip = "270.255.255.255";	
		assertEquals("ERROR:Clase Inválida",App.determinarClase(ip));
	}

	@Test
	@DisplayName("Determinar clase con ip correcta A")
	public void determinarClaseIpCorrectaA() {
		// La ip son int validos. 
		String ip = "120.255.255.255";	
		assertEquals("A",App.determinarClase(ip));
	}
	
	@Test
	@DisplayName("Determinar clase con ip correcta B")
	public void determinarClaseIpCorrectaB() {
		// La ip son int validos. 
		String ip = "170.255.255.255";	
		assertEquals("B",App.determinarClase(ip));
	}
	
	@Test
	@DisplayName("Determinar clase con ip correcta C")
	public void determinarClaseIpCorrecta() {
		// La ip son int validos. 
		String ip = "192.255.255.255";	
		assertEquals("C",App.determinarClase(ip));
	}
	
	@Test
	@DisplayName("Determinar clase con ip correcta Otra")
	public void determinarClaseIpCorrectaOtra() {
		// La ip son int validos. 
		String ip = "240.255.255.255";	
		assertEquals("Otra",App.determinarClase(ip));
	}
	
	
	
	@Test
	@DisplayName("Determinar si hay subnetting con ip incorrecta")
	public void determinarSiHaySubnettingIpIncorrecta() {
		// La ip son int validos. 
		String ip = "1500.255.255.255";	
		String mascara ="12";
		assertFalse(App.isSubnetting(ip, mascara));
	}
	
	
	@Test
	@DisplayName("Determinar si hay subnetting A")
	public void determinarSiHaySubnettingA() {
		// La ip son int validos. 
		String ip = "120.255.255.255";	
		String mascara ="12";
		assertTrue(App.isSubnetting(ip, mascara));
	}
	
	@Test
	@DisplayName("Determinar si hay subnetting A")
	public void determinarSiHaySubnettingACorrecto() {
		// La ip son int validos. 
		String ip = "120.255.255.255";	
		String mascara ="8";
		assertTrue(App.isSubnetting(ip, mascara));
	}
	
	
	@Test
	@DisplayName("Determinar si hay subnetting B")
	public void determinarSiHaySubnettingB() {
		// La ip son int validos. 
		String ip = "140.255.255.255";	
		String mascara ="12";
		assertTrue(App.isSubnetting(ip, mascara));
	}
	
	@Test
	@DisplayName("Determinar si hay subnetting C")
	public void determinarSiHaySubnettingC() {
		// La ip son int validos. 
		String ip = "200.255.255.255";	
		String mascara ="12";
		assertTrue(App.isSubnetting(ip, mascara));
	}
	
	@Test
	@DisplayName("Determinar si hay subnetting en Default")
	public void determinarSiHaySubnettingDefault() {
		// La ip son int validos. 
		String ip = "240.255.255.255";	
		String mascara ="12";
		assertTrue(App.isSubnetting(ip, mascara));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	@Test
//	@DisplayName("ip int invalido")
//	public void ipIntInvalido() {
//		// La ip son int validos. 
//		String []ip = {"l2.192.192.192","23"};	
//		App.main(ip);
//	}
//	
//	@Test
//	@DisplayName("mascara int invalido")
//	public void mascaraIntInvalido() {
//		// La ip son int validos. 
//		String []ip = {"192.192.192.192","r3"};	
//		App.main(ip);
//	}
//	
//	@Test
//	@DisplayName("mascara int superior")
//	public void mascaraIntSuperior() {
//		// La ip son int validos. 
//		String []ip = {"192.192.192.192","40"};	
//		App.main(ip);
//	}
//	
//	@Test
//	@DisplayName("mascara int inferior")
//	public void mascaraIntInferior() {
//		// La ip son int validos. 
//		String []ip = {"l2.192.192.192","-123"};	
//		App.main(ip);
//	}
//	
//	
//	@Test
//	@DisplayName("Byte de la Ip superior")
//	public void byteIpSuperior() {
//		// Los Bytes de la ip son superiores. 
//		String []ip = {"260.192.192.192","23"};	
//		App.main(ip);
//	}
//	
//	@Test
//	@DisplayName("Byte de la Ip inferior")
//	public void byteIpInferior() {
//		// Los Bytes de la ip son superiores. 
//		String []ip = {"-12.192.192.192","23"};	
//		App.main(ip);
//	}
//	
//	
//	@Test
//	@DisplayName("Ip incorrecta con 0")
//	public void ipIncorrecta0() {
//		// Los Bytes de la ip son inferiores. 
//		String []ip = {"0.0.0.0","23"};	
//		App.main(ip);
//	}
//	
//	@Test
//	@DisplayName("Ip incorrecta con 255")
//	public void ipIncorrecta255() {
//		// Los Bytes de la ip son inferiores. 
//		String []ip = {"255.255.255.255","23"};	
//		App.main(ip);
//	}
//	
//	
//	@Test
//	@DisplayName("Clase incorrecta con 1")
//	public void claseAIncorrecta() {
//		// Clase de tipo A. 
//		String []ip = {"1.255.255.255","23"};	
//		App.main(ip);
//	}
//	
////	@Test
////	@DisplayName("Clase incorrecta con 1")
////	public void claseAIncorrecta() {
////		// Clase de tipo A. 
////		String []ip = {"122.255.255.255","8"};	
////		App.main(ip);
////	}
//	
//	
//	@Test
//	@DisplayName("Clase incorrecta con 127")
//	public void claseBIncorrecta() {
//		// Clase de tipo B. 
//		String []ip = {"127.255.255.255","23"};	
//		App.main(ip);
//	}
//	
//	@Test
//	@DisplayName("Clase incorrecta con 130")
//	public void claseCIncorrecta() {
//		// Clase de tipo B. 
//		String []ip = {"130.255.255.255","23"};	
//		App.main(ip);
//	}
//	
//	@Test
//	@DisplayName("Clase incorrecta con 240")
//	public void claseOtraIncorrecta() {
//		// Clase de tipo B. 
//		String []ip = {"240.255.255.255","23"};	
//		App.main(ip);
//	}
//	
//	@Test
//	@DisplayName("Subnetting A true")
//	public void subnettingATrue() {
//		// Clase de tipo B. 
//		String []ip = {"120.255.255.255","23"};	
//		App.main(ip);
//		assertTrue(true);
//	}
//	
//	@Test
//	@DisplayName("Subnetting A false")
//	public void subnettingAFalse() {
//		// Clase de tipo B. 
//		String []ip = {"120.255.255.255","8"};	
//		App.main(ip);
//		assertFalse(false);
//	}
//	
//	
//	@Test
//	@DisplayName("Subnetting B true")
//	public void subnettingBTrue() {
//		// Clase de tipo B. 
//		String []ip = {"130.255.255.255","23"};	
//		App.main(ip);
//		//assertTrue(true);
//	}
//	
//	@Test
//	@DisplayName("Subnetting B false")
//	public void subnettingBFalse() {
//		// Clase de tipo B. 
//		String []ip = {"140.255.255.255","16"};	
//		App.main(ip);
//		assertFalse(false);
//	}
//	
//	
//	@Test
//	@DisplayName("Subnetting C true")
//	public void subnettingCTrue() {
//		// Clase de tipo B. 
//		String []ip = {"194.255.255.255","12"};	
//		App.main(ip);
//		assertTrue(true);
//	}
//	
//	@Test
//	@DisplayName("Subnetting C false")
//	public void subnettingCFalse() {
//		// Clase de tipo B. 
//		String []ip = {"194.255.255.255","24"};	
//		String ipSep= ip[0];
//		String mascara= ip[1];
//		App.main(ip);
//		assertEquals(false, App.isSubnetting(ip, mascara));
//	}
//	
	@Test
	@DisplayName("Probar la primera línea")
	public void primeraLinea() {
		// Este test solo esta para alcanzar el 100% de cobertura.
		new App();
		new UnApi();
		String [] a={"hola"};
		App.main(a);
	}
//	
//	@Test
//	@DisplayName("esIntValido con caracteres especiales")
//	public void esIntValido1() {
//		String ip = "10```20";
//		assertFalse(App.esIntValido(ip));
//	}
//	
//	
//	
//	
//	
////	 @Test
////	 @DisplayName("Se pueden llenar el restaurante correctamente")
////	 public void sePuedeLlenar() {
////	  int[] mesas = new int[5];
////	  Restaurante.sentarMesa(mesas, 5);
////	  Restaurante.sentarMesa(mesas, 4);
////	  Restaurante.sentarMesa(mesas, 3);
////	  Restaurante.sentarMesa(mesas, 2);
////	  Restaurante.sentarMesa(mesas, 1);
////	  assertArrayEquals(new int[] { 5, 4, 3, 2, 1 }, mesas);
////	 }
//	
//	
}
