import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


class MetodosOrdenamiento{

	static long tInicio, tFin;
	static class Burbuja{
       
       public static void ordenacionBurbuja1(long []numeros) {
			
    	   tInicio = System.nanoTime();
			for(int i=1; i<=numeros.length-1; i++) {
				
				for(int j=0; j<=numeros.length-i-1; j++) {
					
					if(numeros[j]>numeros[j+1]) {
						long aux = numeros[j];
						numeros[j] = numeros[j+1];
						numeros[j+1] = aux;
					}
				}
			}
			tFin = System.nanoTime();
			System.out.println("Tiempo de ejecucion en ordenamiento por burbuja: " + (tFin-tInicio));
		}
		
        public static void ordenacionBurbuja2(long []numeros) {
        	tInicio = System.nanoTime();
            for(int i=1; i<numeros.length; i++) {
				
				for(int j=0; j<numeros.length-i; j++) {
					
					if(numeros[j]>numeros[j+1]) {
						long aux = numeros[j];
						numeros[j] = numeros[j+1];
						numeros[j+1] = aux;
					}
				}
			}
            tFin = System.nanoTime();
			System.out.println("Tiempo de ejecucion en ordenamiento por burbuja: " + (tFin-tInicio));
		}
        
        public static void ordenacionBurbuja3(long []numeros) {
           tInicio = System.nanoTime();
           int i=1;
     	   do {
     		   
     		   for(int j=0; j<numeros.length-i; j++) {
 					
 					if(numeros[j]>numeros[j+1]) {
 						long aux = numeros[j];
 						numeros[j] = numeros[j+1];
 						numeros[j+1] = aux;
 					}
 				}
     		   
     		   i=1+i;
     	   }while(i<numeros.length);
     	    tFin = System.nanoTime();
			System.out.println("Tiempo de ejecucion en ordenamiento por burbuja: " + (tFin-tInicio));
        }
        
        public static void mostrar(long[] array) {
        	System.out.println(Arrays.toString(array));
        }
        
	}// class Burbuja

}//class MetodosOrdenamiento


public class PruebaMetodosOrdenamiento {
	
    public static long[] aleatorio(int cantidad, int limite) {
		
		long []array = new long[cantidad];
		
		for(int i=0; i<cantidad; i++) {
			array[i] = (long)(Math.random()*limite);
		}
		
		return array;
	}
    
    public static long[] ingresar() {
		
		Scanner entrada = new Scanner(System.in);
		
		while(true) {
			System.out.println("Introduce cantidad de elementos: ");
			int cantidad = entrada.nextInt();
			System.out.println("Introduce limite: ");
			int limite = entrada.nextInt();
			
			if(cantidad>0 && limite>0) {
				return aleatorio(cantidad, limite+1);
			}else {
				System.out.println("Error en entrada de datos, intenta de nuevo");
			}
		}
	}

}
