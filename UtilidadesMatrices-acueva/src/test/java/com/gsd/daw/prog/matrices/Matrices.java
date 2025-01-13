package com.gsd.daw.prog.matrices;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.gsd.daw.prog.App;

class Matrices {

	@Test
	@DisplayName("Matriz no valida")
	public void matrizNoValida() {
		int [][] a = {{1,2,3,4},{1,2,3}};
		Matriz.isMatrizValida(a);
		assertFalse(false);
	}
	@Test
	@DisplayName("Matriz valida")
	public void matrizValida() {
		int [][] a = {{1,2,3},{1,2,3}};
		Matriz.isMatrizValida(a);
		assertTrue(true);
	}
	
}
