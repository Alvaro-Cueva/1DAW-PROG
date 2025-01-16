package com.gsd.daw.prog;

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
	
	
	/*
	 * Comprueba que la longitud de argumentos sea incorrecta, en este caso una longitud inferior.
	 */
	@Test
	@DisplayName("Args tiene una longitud inferior")
	public void argsInferior() {
		String []args = {"192.192.192.123"};
		assertFalse(App.isLongitudArgumentos(args));
	}
	
	
	/*
	 * Comprueba que la longitud de argumentos sea incorrecta,, en este caso una longitud superior. 
	 */
	@Test
	@DisplayName("Args tiene una longitud superior")
	public void argsSuperior() {
		String []args = {"192.192.192.192.192","23","23"};	
		assertFalse(App.isLongitudArgumentos(args));
	}
	
	
	/*
	 * Comprueba que la longitud de argumentos sea correcta.
	 */
	@Test
	@DisplayName("Args tiene una longitud correcta")
	public void argsCorrecto() {
		String []args = {"192.192.192.192","23"};	
		assertTrue(App.isLongitudArgumentos(args));

	}
	
	
	/*
	 * Comprueba que el formato de la ip es incorrecto, en este caso por formato inferior.
	 */
	
	@Test
	@DisplayName("Formato ip inferior")
	public void formatoIpIncorrecto() {
		String ip = "192.192.192192";	
		assertFalse(App.isLongitudIpValida(ip));
	}
	
	
	/*
	 * Comprueba que el formato de la ip es incorrecto, en este caso por formato superior.
	 */
	@Test
	@DisplayName("Formato ip superior")
	public void formatoIpSuperior() {
		String ip = "192.192.192.192.192";	
		assertFalse(App.isLongitudIpValida(ip));
	}
	
	
	/*
	 * Comprueba que el formato de la ip no puede acabar en punto.
	 */
	@Test
	@DisplayName("Formato ip acabado en punto")
	public void formatoIpAcabadoEnPunto() {
		String ip = "192.192.192.192.";	
		assertFalse(App.isLongitudIpValida(ip));
	}
	
	
	/*
	 * Comprueba que el formato de la ip siendo correcta.
	 */
	@Test
	@DisplayName("Formato ip correcta")
	public void formatoIpCorrecta() {
		String ip = "192.192.192.192";	
		assertTrue(App.isLongitudIpValida(ip));
	}
	
	
	/*
	 * Comprueba el formato de la mascara siendo una máscara superior.
	 */
	@Test
	@DisplayName("Formato mascara superior")
	public void formatoMascaraSuperior() {
		String mascara = "2233";	
		assertFalse(App.isMascaraDentroDeValoresValidos(mascara));
	}
	
	
	/*
	 * Comprueba el formato de la mascara siendo un máscara inferior.
	 */
	@Test
	@DisplayName("Formato mascara inferior")
	public void formatoMascaraIpInferior() {
		String mascara = "-20";	
		assertFalse(App.isMascaraDentroDeValoresValidos(mascara));
	}
	
	
	/*
	 * Comprueba si el formato de la mascara es un int válido. 
	 */
	@Test
	@DisplayName("Formato mascara int invalido")
	public void formatoMascaraIntInvalido() {
		String mascara = "l20";	
		assertFalse(App.isMascaraDentroDeValoresValidos(mascara));
	}
	
	
	/*
	 * Comprueba el formato de la mascara de forma correcta.
	 */
	@Test
	@DisplayName("Formato mascara correcta")
	public void mascaraCorrecta() {
		String mascara = "23";	
		assertTrue(App.isMascaraDentroDeValoresValidos(mascara));
	}
	
	
	/*
	 * Comprueba la ip reservada(0.0.0.0).
	 */
	@Test
	@DisplayName("Comprobar si la ip es reservada 0.0.0.0")
	public void isIpReservada1() {
		String ip = "0.0.0.0";	
		assertFalse(App.esIpReservada(ip));
	}
	
	
	/*
	 * Comprueba la ip reservada(255.255.255.255).
	 */
	@Test
	@DisplayName("Comprobar si la ip es reservada 255.255.255.255")
	public void isIpReservada2() {
		String ip = "255.255.255.255";	
		assertFalse(App.esIpReservada(ip));
	}
	
	
	/*
	 * Comprobar si es un int valido en la ip reservada.
	 */
	@Test
	@DisplayName("Comprobar si la ip es reservada 255.255.255.255")
	public void isIpReservada3() {
		String ip = "1500.255.255.255";	
		assertFalse(App.esIpReservada(ip));
	}
	
	/*
	 * Comprobar si una ip correcta es reservada.
	 */
	@Test
	@DisplayName("Comprobar si la ip 192.0.0.0 es reservada")
	public void isIpReservada4() {
		// La ip son int validos. 
		String ip = "192.0.0.0";	
		assertTrue(App.esIpReservada(ip));
	}
	
	
	/*
	 * Comprobar un Ip con argumentos invalidos.
	 */
	@Test
	@DisplayName("Ip mal dentro de valores validos")
	public void isIpValidaMal() {
		String ip = "240.255.255.255.120";	
		assertFalse(App.isIpDentroDeValoresValidos(ip));
	}
	
	
	/*
	 * Comprobar una Ip con una parte superior.
	 */
	@Test
	@DisplayName("Ip siendo mayor")
	public void isIpValidaMayor() {
		String ip = "260.255.255.255";	
		assertFalse(App.isIpDentroDeValoresValidos(ip));
	}
	
	
	/*
	 * Comprobar una Ip con una parte inferior.
	 */
	@Test
	@DisplayName("Ip siendo menor")
	public void isIpValidaMenor() {
		String ip = "12.255.-255.255";	
		assertFalse(App.isIpDentroDeValoresValidos(ip));
	}
	
	
	/*
	 * Comprobar si la Ip son int válidos.
	 */
	@Test
	@DisplayName("Ip con letra")
	public void isIpValidaLetra() {
		String ip = "l92.255.255.255";	
		assertFalse(App.isIpDentroDeValoresValidos(ip));
	}
	
	
	/*
	 * Comprueba que la ip es correcta.
	 */
	@Test
	@DisplayName("Ip siendo correcta")
	public void isIpValidaCorrecta() {
		String ip = "192.255.255.255";	
		assertTrue(App.isIpDentroDeValoresValidos(ip));
	}
	
	
	/*
	 * Comprueba la clase de la Ip con una Ip incorrecta.
	 */
	@Test
	@DisplayName("Determinar clase con ip incorrecta")
	public void determinarClaseIpIncorrecta() {
		String ip = "270.255.255.255";	
		assertEquals("ERROR:Clase Inválida",App.determinarClase(ip));
	}
	
	
	/*
	 * Comprueba una ip de clase A.
	 */
	@Test
	@DisplayName("Determinar clase con ip correcta A")
	public void determinarClaseIpCorrectaA() {
		String ip = "120.255.255.255";	
		assertEquals("A",App.determinarClase(ip));
	}
	
	
	/*
	 * Comprueba una ip de clase B.
	 */
	@Test
	@DisplayName("Determinar clase con ip correcta B")
	public void determinarClaseIpCorrectaB() {
		String ip = "170.255.255.255";	
		assertEquals("B",App.determinarClase(ip));
	}
	
	
	/*
	 * Comprueba una ip de clase C.
	 */
	@Test
	@DisplayName("Determinar clase con ip correcta C")
	public void determinarClaseIpCorrecta() {
		String ip = "192.255.255.255";	
		assertEquals("C",App.determinarClase(ip));
	}
	
	
	/*
	 * Comprueba una ip de Otra clase.
	 */
	@Test
	@DisplayName("Determinar clase con ip correcta Otra")
	public void determinarClaseIpCorrectaOtra() {
		String ip = "240.255.255.255";	
		assertEquals("Otra",App.determinarClase(ip));
	}
	
	
	/*
	 * Comprueba si hay subnetting en una ip incorrecta.
	 */
	@Test
	@DisplayName("Determinar si hay subnetting con ip incorrecta")
	public void determinarSiHaySubnettingIpIncorrecta() {
		String ip = "1500.255.255.255";	
		String mascara ="12";
		assertFalse(App.isSubnetting(ip, mascara));
	}
	
	
	/*
	 * Comprueba si hay subnetting con clase de tipo A(false).
	 */
	@Test
	@DisplayName("Determinar si hay subnetting A")
	public void determinarSiHaySubnettingA() {
		String ip = "120.255.255.255";	
		String mascara ="8";
		assertFalse(App.isSubnetting(ip, mascara));
	}
	
	
	/*
	 * Comprueba si hay subnetting con clase de tipo A(true)
	 */
	@Test
	@DisplayName("Determinar si hay subnetting A")
	public void determinarSiHaySubnettingACorrecto() {
		String ip = "120.255.255.255";	
		String mascara ="12";
		assertTrue(App.isSubnetting(ip, mascara));
	}
	
	
	/*
	 * Comprueba si hay subnetting con clase B(true). 
	 */
	@Test
	@DisplayName("Determinar si hay subnetting B")
	public void determinarSiHaySubnettingB() {
		String ip = "140.255.255.255";	
		String mascara ="12";
		assertTrue(App.isSubnetting(ip, mascara));
	}
	
	
	/*
	 * Comprueba si hay subnetting con clase B(false). 
	 */
	@Test
	@DisplayName("Determinar si hay subnetting B")
	public void determinarSiHaySubnettingBCorrecto() {
		String ip = "140.255.255.255";	
		String mascara ="16";
		assertFalse(App.isSubnetting(ip, mascara));
	}
	
	
	/*
	 * Comprueba si hay subnetting con clase C(false).
	 */
	@Test
	@DisplayName("Determinar si hay subnetting C")
	public void determinarSiHaySubnettingC() {
		String ip = "200.255.255.255";	
		String mascara ="24";
		assertFalse(App.isSubnetting(ip, mascara));
	}
	
	
	/*
	 * Comprueba si hay subnetting con clase C(true).
	 */
	@Test
	@DisplayName("Determinar si hay subnetting C")
	public void determinarSiHaySubnettingCCorrecto() {
		String ip = "200.255.255.255";	
		String mascara ="12";
		assertTrue(App.isSubnetting(ip, mascara));
	}
	
	
	/*
	 * Comprueba si hay subnetting con clase Otra.
	 */
	@Test
	@DisplayName("Determinar si hay subnetting en Default")
	public void determinarSiHaySubnettingDefault() {
		String ip = "240.255.255.255";	
		String mascara ="12";
		assertTrue(App.isSubnetting(ip, mascara));
	}
	
	
	/*
	 * Comprueba si imprime dandole un Ip incorrecta.
	 */
	@Test
	@DisplayName("Determinar si hay subnetting en Default")
	public void imprimirIpIncorrecta() {
		String ip = "270.255.255.255";	
		String mascara ="12";
		assertFalse(App.imprimirIp(ip, mascara));
	}
	
	
	/*
	 * Comprueba si imprime dandole un Ip correcta.
	 */
	@Test
	@DisplayName("Determinar si hay subnetting en Default")
	public void imprimirIpCorrecta() {
		String ip = "240.255.255.255";	
		String mascara ="12";
		assertTrue(App.imprimirIp(ip, mascara));
	}
	
	
	/*
	 * Comprueba si imprime dandole un mascara incorrecta.
	 */
	@Test
	@DisplayName("Determinar si hay subnetting en Default")
	public void imprimirMacaraIncorrecta() {
		String ip = "240.255.255.255";	
		String mascara ="72";
		assertFalse(App.imprimirIp(ip, mascara));
	}
	
	
	/*
	 * Comprobar main con una ip correcta.
	 */
	@Test
	@DisplayName("Probar la primera línea")
	public void mainCorrecto() {
		String [] a={"199.192.192.192","12"};
		App.main(a);
	}
	
	
	/*
	 * Comprueba si imprime si hay subnetting.
	 */
	@Test
	@DisplayName("Determinar si hay subnetting en Default")
	public void imprimirSiHaySubnetting() {
		String ip = "172.255.255.255";	
		String mascara ="16";
		assertTrue(App.imprimirIp(ip, mascara));
	}
	
	
	/*
	 * Comprueba si imprime dandole un Ip incorrecta.
	 */
	@Test
	@DisplayName("Determinar si no hay subnetting en Default")
	public void imprimirSiNoHaySubnetting() {
		String ip = "70.255.255.255";	
		String mascara ="8";
		assertTrue(App.imprimirIp(ip, mascara));
	}
	
	
	/*
	 * Comprobar main con una ip reservada.
	 */
	@Test
	@DisplayName("Main con Ip reservada 0.0.0.0")
	public void mainIpReservada() {
		String [] a={"0.0.0.0","12"};
		App.main(a);
	}
	
	
	/*
	 * Comprobar main con más argumentos en args.
	 */
	@Test
	@DisplayName("Crear un main con la longitud de los argumentos superior")
	public void mainArgumetnosSuperior() {
		String [] a={"0.0.0.0","12","12"};
		App.main(a);
	}
	
	
	/*
	 * Comprueba main con una ip incorrecta ya que la primera parte de la ip es un numero superior a los valores perimitidos.
	 */
	@Test
	@DisplayName("Probar la primera línea")
	public void mainIpIncorrecta() {
		String [] a={"1552.192.192.192","12"};
		App.main(a);
	}
	
	
	/*
	 * Este test solo esta para alcanzar el 100% de cobertura.
	 */
	@Test
	@DisplayName("Probar la primera línea")
	public void primeraLinea() {
		new App();
		new UnApi();
		}
	
	
}