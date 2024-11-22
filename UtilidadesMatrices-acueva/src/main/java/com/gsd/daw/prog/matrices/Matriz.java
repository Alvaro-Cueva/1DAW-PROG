package com.gsd.daw.prog.matrices;

public class Matriz {
	/**
	 * Suma dos matrices devolviendo una nueva matriz con el resultado de la suma. Las matrices deben tener la misma dimensión (filasXcolumnas), si no es así el método devuelve null.
	 * @param a la primera matriz a sumar, debe ser una matriz válida
	 * @param b la segunda matriz a sumar, debe ser una matriz válida
	 * @return una matriz nueva que es la suma de las dos o null si alguna de las matrices no es válida.
	 */
	public static int[][] crearSuma(int [][] a, int [][] b){
		if(!isMatrizValida(a) || !isMatrizValida(b)) {
			return null;
		}
		int [][] suma = new int[a.length][a[0].length];
		for(int i =0;i<a.length;i++) {
			for(int j=0; j<a[i].length;j++) {
				suma[i][j] = a[i][j] + b[i][j];
			}
		}
		return suma;
	}
	/**
	 * Suma la matriz b EN la matriz a, alterando la matriz a. Las matrices deben tener la misma dimensión (filasXcolumnas), si no es así el método retorna inmediatamente sin alterar ninguna de las matrices.
	 * @param a la primera matriz a sumar, debe ser una matriz válida
	 * @param b la segunda matriz a sumar, debe ser una matriz válida
	 */
	public static void sumar(int[][] a, int [][] b) {
		if(!isMatrizValida(a) || !isMatrizValida(b)) {
			return;
		}
		if(a.length != b.length || a[0].length != b[0].length) {
			return;
		}
		for(int i =0;i<a.length;i++) {
			for(int j=0; j<a[i].length;j++) {
				a[i][j] += b[i][j];
			}
		}
	}
	/**
	 * Devuelve un string con la matriz, con los números separados por espacios.
	 * @param m la matriz, debe ser una matriz válida
	 * @return String que representa la matriz o null si la matriz no es válida.
	 */
	public static String toString(int[][] m) {
	    if (!isMatrizValida(m)) {
	        return null; 
	    }
	    String result = ""; 
	    for (int i = 0; i < m.length; i++) {
	        for (int j = 0; j < m[i].length; j++) {
	            result += m[i][j]; 
	            if (j < m[i].length - 1) {
	                result += " "; 
	            }
	        }
	        if (i < m.length - 1) {
	            result += "\n"; 
	        }
	    }
	    return result;
	}
	/**
	 * Devuelve una matriz que es la traspuesta de la matriz recibida.
	 * @param m la matriz, debe ser una matriz válida
	 * @return la traspuesta de la matriz actual o null si la matriz no es válida.
	 */
	public static int[][] crearTraspuesta(int[][] m) {
        if (!isMatrizValida(m)) {
            return null; 
        }
        int[][] traspuesta = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                traspuesta[j][i] = m[i][j];
            }
        }
        return traspuesta;
    }
	/**
	 * Incrementa (o decrementa si el incremento es negativo) los valores de la matriz dada. Si la matriz no es válida el método retorna inmediatamente sin alterar nada de la matriz.
	 * @param m la matriz, debe ser una matriz válida
	 * @param incremento el incremento/decremento a aplicar
	 */
	public static void incrementar(int [][] m, int incremento) {
		if (!isMatrizValida(m)) {
	          return; 
	    }
		for (int i = 0; i < m.length; i++) {
	          for (int j = 0; j < m[i].length; j++) {
	              m[i][j] += incremento; 
	          } 
		}
	}
	/**
	 * Devuelve una matriz nueva que es el resultado de incrementar los valores de la matriz actual según un incremento dado. Si la matriz no es válida el método retorna inmediatamente sin alterar nada de la matriz.
	 * @param m la matriz, debe ser una matriz válida
	 * @param incremento el incremento/decremento a aplicar
	 * @return devuelve una matriz con el resultado de aplicar el incremento/decremento a los valores de la matriz actual o null si la matriz no es valida.
	 */
	public static int[][] crearIncrementada(int[][] m, int incremento) {
        if (!isMatrizValida(m)) {
            return null; 
        }
        int[][] incrementada = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                incrementada[i][j] = m[i][j] + incremento; 
            }
        }return incrementada;
	}
	/**
	 * Obtiene el valor del elemento mas grande de la matriz
	 * @param m la matriz, debe ser una matriz válida
	 * @return el valor del elemento mas grande de la matriz o Integer.MIN_VALUE si la matriz no es valida.
	 */
	public static int getMaximoElemento(int [][] m) {
		if(!isMatrizValida(m)) {
			return Integer.MIN_VALUE;
		}
		int maxElemento=m[0][0];
		for(int i=0; i<m.length;i++) {
			for(int j=0;j<m.length;j++) {
				if(m[i][j] > maxElemento) {
					maxElemento =m[i][j];
				}
			}
		}
		return maxElemento;
	}
	/**
	 * Obtiene la posición del elemento mas grande de la matriz
	 * @param m la matriz, debe ser una matriz válida
	 * @return la posicion (fila,columna) del elemento mas grande de la matriz o null si la matriz no es valida.
	 */
	public static int[] getPosicionMaximoElemento(int [][] m) {
		if(!isMatrizValida(m)) {
			return null;
		}
		int maxFila =0;
		int maxColumna =0;
		int maxElemento =m[0][0];
		
		for(int i=0; i<m.length;i++) {
			for(int j=0;j<m.length;j++) {
				if(m[i][j] > maxElemento) {
					maxElemento =m[i][j];
					maxFila=i;
					maxColumna=j;
				}
			}
		}
		int [] posicion = new int[2];
		posicion[0] = maxFila;
		posicion[1] = maxColumna;
		return posicion; 
	}
	/**
	 * Comprueba la validez de una matriz. Una matriz válida es aquella que no es null, ninguna de sus filas es null, tiene al menos una fila y al menos una columna y el número de columnas es siempre el mismo.
	 * @param m la matriz a ser validada
	 * @return true si la matriz es válida, false si no lo es
	 */
	public static boolean isMatrizValida(int[][] m) {
	    if (m == null) {
	        return false;
	    }

	    if (m.length < 1) {
	        return false;
	    }

	    if (m[0] == null || m[0].length < 1) {
	        return false;
	    }

	    int numColumnas = m[0].length;

	    for (int i = 0; i < m.length; i++) {
	        if (m[i] == null || m[i].length != numColumnas) {
	            return false;
	        }
	    }
	    return true;
	}
}
