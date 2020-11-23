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
	
	static class Insercion {
		public static void ordenadorInsercion(long []numeros) {
			long aux;
			
			tInicio = System.nanoTime();
			for(int i=1; i<numeros.length; i++) {
				aux = numeros[i];
				
				
				
				for(int j=i-1; j>=0 && numeros[j]>aux; j--) {
					
					numeros[j+1] = numeros[j];
					numeros[j] = aux;
					
				}// segundo for
			}// primero for
			tFin = System.nanoTime();
			System.out.println("Tiempo de ejecucion en ordenamiento por burbuja: " + (tFin-tInicio));
		}
	}

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
    
    public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		long array[];
		boolean candado = true;

		while(true) {
			try {
				array = ingresar();
				break;
			}catch(InputMismatchException error){
				System.out.println("Error " + error + " en la entrada de datos");
			}
			System.out.println();
		}

        while(candado) {
        	
        	System.out.println("------------MENU-------------");
        	System.out.println("1.- Crear nuevo array");
        	System.out.println("2.- Metodo 1 de ordenamiento");
        	System.out.println("3.- Metodo 2 de ordenamiento");
        	System.out.println("4.- Metodo 3 de ordenamiento");
        	System.out.println("5.- Metodo de insercion");
        	System.out.println("6.- Salir");
        	System.out.print("Introduce una opcion: ");
			
        	
        	try {
        		int opcion = entrada.nextInt();
            	
    			switch(opcion) {
    			
    			case 1:
    				array = ingresar();
    				break;

    			case 2:
    				MetodosOrdenamiento.Burbuja.ordenacionBurbuja1(array);
    				MetodosOrdenamiento.Burbuja.mostrar(array);
    				break;

    			case 3:
    				MetodosOrdenamiento.Burbuja.ordenacionBurbuja2(array);
    				MetodosOrdenamiento.Burbuja.mostrar(array);
    				break;

    			case 4:
    				MetodosOrdenamiento.Burbuja.ordenacionBurbuja3(array);
    				MetodosOrdenamiento.Burbuja.mostrar(array);
    				break;
    			
    			case 5:
    				MetodosOrdenamiento.Insercion.ordenadorInsercion(array);
    				MetodosOrdenamiento.Burbuja.mostrar(array);
    				break;

    			case 6:
    				candado = false;
    				System.out.println("--------------Programa terminado-----------");
    				break;

    			default:
    				System.out.println("Opcion inexistente, por favor prueba de nuevo");
    				break;
    			}
        	}catch(InputMismatchException error){
        		System.out.println("Error <" + error + "> en la entrada de datos");
        	    entrada.nextLine();
        	}
			System.out.println();
		}
	}

}
