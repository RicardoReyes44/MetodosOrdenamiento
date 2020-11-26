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
			System.out.println("Tiempo de ejecucion en ordenamiento: " + (tFin-tInicio));
		}
	}

	public static class OrdenamientoPorSeleccion{

		public static void ordenamientoSeleccion(long []numeros) {
			tInicio = System.nanoTime();
			for(int i=0; i<numeros.length-1; i++) {
				
				for(int j=i; j<numeros.length; j++) {
					
					if(numeros[i]>numeros[j]) {
						long minimo = numeros[i];
						numeros[i] = numeros[j];
						numeros[j] = minimo;	
					}
				}
			}
			tFin = System.nanoTime();
			System.out.println("Tiempo de ejecucion en ordenamiento: " + (tFin-tInicio));
		}
	}
	
	public static class QuickSort{

		public static long[] ejecutar(long[] array) {
			tInicio = System.nanoTime();
			
			long []ordenado = quickSort(array, 0, array.length-1);
			
			tFin = System.nanoTime();
			System.out.println("Tiempo de ejecucion en ordenamiento: " + (tFin-tInicio));
			
			return ordenado;
		}
		
		public static long[] quickSort(long[] array, int izq, int der){
			long pivote = array[izq];
			int i = izq, j=der;
			long aux;
			
			while(i<j) {
				while(array[i]<=pivote && i<j) i++;
				while(array[j]>pivote) j--;
				if(i<j) {
					aux = array[i];
					array[i] = array[j];
					array[j] = aux;
				}
			}
			array[izq] = array[j];
			array[j] = pivote;
			
			if(izq<j-1)
				quickSort(array, izq, j-1);
			if(j+1<der)
				quickSort(array, j+1, der);
			
			return array;
		}
	}
	
	static class ShellSort{
		
		public static void ordenar(long []numeros) {
			
			int intervalo = numeros.length/2;
			tInicio = System.nanoTime();
			
			while(intervalo>0) {
				for(int i=intervalo; i<numeros.length; i++) {
					int j=i-intervalo;
					while(j>=0) {
						int k=j+intervalo;
						if(numeros[j]<=numeros[k]) {
							j=-1;
						}else {
							long aux=numeros[j];
							numeros[j] = numeros[k];
							numeros[k] = aux;
							j-=intervalo;
							
						}
					}
				}
				intervalo = intervalo/2;
			}
			
			tFin = System.nanoTime();
			System.out.println("Tiempo de ejecucion en ordenamiento: " + (tFin-tInicio));
			
		}
		
	}
	
	public static void mostrar(long[] array) {
    	System.out.println("Array ordenado: " + Arrays.toString(array));
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
        	System.out.println("2.- Metodo burbuja 1 de ordenamiento");
        	System.out.println("3.- Metodo burbuja 2 de ordenamiento");
        	System.out.println("4.- Metodo burbuja 3 de ordenamiento");
        	System.out.println("5.- Metodo de insercion");
        	System.out.println("6.- Metodo de seleccion");
        	System.out.println("7.- Metodo quick");
        	System.out.println("8.- Metodo shell");
        	System.out.println("9.- Salir");
        	System.out.print("Introduce una opcion: ");
			
        	long []array2 = array.clone();
        	
        	try {
        		int opcion = entrada.nextInt();
            	
        		System.out.println("Array original: " + Arrays.toString(array2));
        		
    			switch(opcion) {
    			
    			case 1:
    				array = ingresar();
    				array2 = array.clone();
    				break;

    			case 2:
    				MetodosOrdenamiento.Burbuja.ordenacionBurbuja1(array2);
    				MetodosOrdenamiento.mostrar(array2);
    				break;

    			case 3:
    				MetodosOrdenamiento.Burbuja.ordenacionBurbuja2(array2);
    				MetodosOrdenamiento.mostrar(array2);
    				break;

    			case 4:
    				MetodosOrdenamiento.Burbuja.ordenacionBurbuja3(array2);
    				MetodosOrdenamiento.mostrar(array2);
    				break;
    			
    			case 5:
    				MetodosOrdenamiento.Insercion.ordenadorInsercion(array2);
    				MetodosOrdenamiento.mostrar(array2);
    				break;

    			case 6:
    				MetodosOrdenamiento.OrdenamientoPorSeleccion.ordenamientoSeleccion(array2);
    				MetodosOrdenamiento.mostrar(array2);
    				break;
    			
    			case 7:
    				long ordenado[] = MetodosOrdenamiento.QuickSort.ejecutar(array2);
    				MetodosOrdenamiento.mostrar(ordenado);
    				break;
    			
    			case 8:
    				MetodosOrdenamiento.ShellSort.ordenar(array2);
    				MetodosOrdenamiento.mostrar(array2);
    				break;
    			
    			case 9:
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
