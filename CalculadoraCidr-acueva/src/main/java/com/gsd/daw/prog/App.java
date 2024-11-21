package com.gsd.daw.prog;

import com.gsd.daw.prog.api.UnApi;

public class App {

	public static void main(String[] args) {
		// Verificar si args es null y asignar un array vacío
        if (args == null) {
            args = new String[0]; // Inicializar args como un array vacío
        }
		
		if(args.length!=2) {		
			System.err.println("ERROR: Argumentos inválidos,,,(<ip> <bits de máscara>) ");
			return;
		}
		
		String ip = args[0];
		String mascara = args[1];
		
			
		if(!ip.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
			System.err.println("ERROR: Ip incorrecta. \nFormato correcto-(X.X.X.X) ");
			return;
		}
		
		if(!mascara.matches("\\d{1,2}")) {
			System.err.println("ERROR: Mascara incorrecta. \nLa máscara debe estar entre 0 y 32 ambos incluidos, sin caractéres especiales. ");
			return;
		}
		
		String[] partesIp = ip.split("\\.");
        if (partesIp.length != 4) {
            System.err.println("ERROR: Ip incorrecta. \nFormato correcto-(X.X.X.X)");
            return;
            }
            
        for (int i = 0; i < partesIp.length; i++) {
            if (!esIntValido(partesIp[i])) {
                 System.err.println("ERROR en la parte " + (i + 1) + "\nLa ip debe ser un número entero");
                 return;
                }
                int num = Integer.parseInt(partesIp[i]);
                if (num < 0 || num > 255) { 
                    System.err.println("ERROR, la parte " + (i + 1) + " de la IP debe estar entre 0 y 255");
                    return;
                }
        }
			
        if (!esIpValida(partesIp)) { 
            System.err.println("ERROR, la IP no es válida (0.0.0.0 o 255.255.255.255)");
            return;
        }
	
		if (!esIntValido(mascara)) { 
			System.err.println("ERROR, la máscara debe ser un número entero");
			return;
		}
		
		int mascValida = Integer.parseInt(mascara); 
		if (mascValida<0 || mascValida>32) { 
			System.err.println("ERROR, la máscara debe estar entre 0 y 32 ambos incluidos");
			return;
		}
	    
		String claseIp = determinarClase(partesIp);
        boolean isSubnetting = false;

        switch (claseIp) {
            case "A":
                isSubnetting = mascValida != 8;
                break;
            case "B":
                isSubnetting = mascValida != 16; 
                break;
            case "C":
                isSubnetting = mascValida != 24;
                break;
            default:
                isSubnetting = true;
        }
        
		System.out.println(ip + "/" + mascara);
		System.out.println(determinarClase(partesIp));
		System.out.println(isSubnetting ? "Subnetting:True" : "Subnetting:False");
	}
	
	private static boolean esIntValido( String candidato ) {
		   try {
		          Integer.parseInt( candidato );
		       } catch ( Exception e ) {
		          return false;
		       }
		       return true;
		}
	
    private static boolean esIpValida(String[] partes) {
        String ip = String.join(".", partes);
        return !ip.equals("0.0.0.0") && !ip.equals("255.255.255.255");
    }
    
    private static String determinarClase(String[] partes) {
        int primeraParte = Integer.parseInt(partes[0]);
        if (primeraParte >= 1 && primeraParte <= 126) {
            return "A";
        } else if (primeraParte >= 128 && primeraParte <= 191) {
            return "B";
        } else if (primeraParte >= 192 && primeraParte <= 223) {
            return "C";
        } else {
            return "Otra";
        } 
    }   
}

