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
	
    static class Radix{
		
    	public static void orden(long[]numeros) {
    	  tInicio = System.nanoTime();
  	      if(numeros.length == 0)
  	          return;
  	          int[][] np = new int[numeros.length][2];
  	          int[] q = new int[0x100];
  	          int i,j,k,l,f = 0;
  	          for(k=0;k<4;k++) {
  	             for(i=0;i<(np.length-1);i++)
  	             np[i][1] = i+1;
  	             np[i][1] = -1;
  	             for(i=0;i<q.length;i++)
  	             q[i] = -1;
  	             for(f=i=0;i<numeros.length;i++) {
  	                j = (int)((0xFF<<(k<<3))&numeros[i])>>(k<<3);
  	                if(q[j] == -1)
  	                l = q[j] = f;
  	             else {
  	                l = q[j];
  	                while(np[l][1] != -1)
  	                l = np[l][1];
  	                np[l][1] = f;
  	                l = np[l][1];
  	             }
  	             f = np[f][1];
  	             np[l][0] = (int)numeros[i];
  	             np[l][1] = -1;
  	          }
  	          for(l=q[i=j=0];i<0x100;i++)
  	          for(l=q[i];l!=-1;l=np[l][1])
  	        	  numeros[j++] = np[l][0];
  	       }//for
  	       tFin = System.nanoTime();
		   System.out.println("Tiempo de ejecucion en ordenamiento: " + (tFin-tInicio));
  	}//metodo
		
	}
    
    static class Intercalacion{
    	
    	public static long[] intercalacion(long numeros[], long numeros2[]) {
    		
    		long arrayOrdenado[] = new long[numeros.length+numeros2.length];
    		
        	int i=0, j=0, k=0;
        	
        	while(i<numeros.length && j<numeros2.length) {
        		if(numeros[i]<numeros2[j]) {
        			arrayOrdenado[k] = numeros[i];
        			i++;
        		}else {
        			arrayOrdenado[k] = numeros2[j];
        			j++;
        		}
        		k++;
        	}
        	
        	while(i<numeros.length) {
        		arrayOrdenado[k] = numeros[i];
    			i++;
    			k++;
        	}
        	
            while(j<numeros2.length) {
            	arrayOrdenado[k] = numeros2[j];
    			j++;
    			k++;
        	}
        	
        	return arrayOrdenado;
    		
    	}
    	
    }
    
    static class OrdenamientoMezclaDirecta{
    	
    	public static long[] ordenamientoMezcla(long arreglo[]) {
    		int i,j,k;
    		
    		if(arreglo.length>1) {
    			int numElementosIzq = arreglo.length/2;
    			int numElementosDer=arreglo.length-numElementosIzq;
    			
    			long arregloIzquierdo[] = new long[numElementosIzq];
    			long arregloDerecho[] = new long[numElementosDer];
    			
    			for(i=0; i<numElementosIzq; i++) {
    				arregloIzquierdo[i] = arreglo[i];
    			}
    			
    			for(i=numElementosIzq; i<numElementosIzq+numElementosDer; i++) {
    				arregloDerecho[i-numElementosIzq]=arreglo[i];
    			}
    			
    			//Ahora se aplica la recursividad
    			arregloIzquierdo = ordenamientoMezcla(arregloIzquierdo);
    			arregloDerecho = ordenamientoMezcla(arregloDerecho);
    			i=j=k=0;
    			/*
    			 * i= posicion en el arreglo original
    			 * j= posicion en el arreglo izquierdo
    			 * k= posicion en el arreglo derecho
    			 * 
    			*/
    			
    			while(arregloIzquierdo.length!=j && arregloDerecho.length!=k) {
    				if(arregloIzquierdo[j]<arregloDerecho[k]) {
    					arreglo[i] = arregloIzquierdo[j];
    					i++;
    					j++;
    				}else {
    					arreglo[i] = arregloDerecho[k];
    					i++;
    					k++;
    				}
    			}
    			
    			//Arreglo izquierdo
    			while(arregloIzquierdo.length!=j) {
    				arreglo[i] = arregloIzquierdo[j];
    				i++;
    				j++;
    			}
    			
    			while(arregloDerecho.length!=k) {
    				arreglo[i] = arregloDerecho[k];
    				i++;
    				k++;
    			}
    			
    		}// if
    		
    		return arreglo;
    	}
    	
    }
    
    static class MezclaNatural{
    	
    	public static void mezclaDirecta2(long arreglo[]) {
    		int i,j,k;
    		
    		if(arreglo.length>1) {
    			int numElementosIzq = arreglo.length/2;
    			int numElementosDer=arreglo.length-numElementosIzq;
    			
    			long arregloIzquierdo[] = new long[numElementosIzq];
    			long arregloDerecho[] = new long[numElementosDer];
    			
    			for(i=0; i<numElementosIzq; i++) {
    				arregloIzquierdo[i] = arreglo[i];
    			}
    			
    			for(i=numElementosIzq; i<numElementosIzq+numElementosDer; i++) {
    				arregloDerecho[i-numElementosIzq]=arreglo[i];
    			}
    			
    			//Ahora se aplica la recursividad
    			mezclaDirecta2(arregloIzquierdo);
    			mezclaDirecta2(arregloDerecho);
    			i=j=k=0;
    			/*
    			 * i= posicion en el arreglo original
    			 * j= posicion en el arreglo izquierdo
    			 * k= posicion en el arreglo derecho
    			 * 
    			*/
    			
    			while(arregloIzquierdo.length!=j && arregloDerecho.length!=k) {
    				if(arregloIzquierdo[j]<arregloDerecho[k]) {
    					arreglo[i] = arregloIzquierdo[j];
    					i++;
    					j++;
    				}else {
    					arreglo[i] = arregloDerecho[k];
    					i++;
    					k++;
    				}
    			}
    			
    			//Arreglo izquierdo
    			while(arregloIzquierdo.length!=j) {
    				arreglo[i] = arregloIzquierdo[j];
    				i++;
    				j++;
    			}
    			
    			while(arregloDerecho.length!=k) {
    				arreglo[i] = arregloDerecho[k];
    				i++;
    				k++;
    			}
    		    }//if
    			
    		}
    		
    		public static void mezclaNatural(long numeros[]) {

    	        int izquierda = 0;
    	        int izq = 0;
    	        int derecha = numeros.length-1;
    	        int der = derecha;
    	        boolean ordenado = false;
    	        do {
    	        	
    	        	izquierda = 0;
    	        	ordenado = true;
    	        	
    	        	while(izquierda<derecha) {
    	        		izq = izquierda;
    	        		while(izq<derecha && numeros[izq]<=numeros[izq+1]) {
    	        			izq++;
    	        		}
    	        		der = izq+1;
    	        		while(der==derecha-1 || der<derecha && numeros[der]<=numeros[der+1]) {	
    	        		}
    	        		
    	        		if(der<=derecha) {
    	        			mezclaDirecta2(numeros);
    	        			
    	        			ordenado = false;
    	        		}
    	        		izquierda = izq;
    	        	}
    	        	
    	        }while(!ordenado);
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
        	System.out.println("9.- Metodo radix");
        	System.out.println("10.- Metodo de intercalacion");
        	System.out.println("11.- Metodo de mezcla directa");
        	System.out.println("12.- Metodo de mezcla natural");
        	System.out.println("13.- Salir");
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
    				MetodosOrdenamiento.Radix.orden(array2);
    				MetodosOrdenamiento.mostrar(array2);
    				break;
    			
    			case 10:
    				
    				long array3[];
    				long array4[];
    				
    				System.out.println("\nVamos a crear un nuevo array para ordenar con respecto al anterior");

    				while(true) {
    					try {
    						array3 = ingresar();
    						break;
    					}catch(InputMismatchException error){
    						System.out.println("Error " + error + " en la entrada de datos");
    					}
    					System.out.println();
    				}
    				
    				MetodosOrdenamiento.QuickSort.ejecutar(array3);
    				System.out.println("Primer Array: " + Arrays.toString(array2));
    				MetodosOrdenamiento.QuickSort.ejecutar(array2);
    				System.out.println("Segund Array: " + Arrays.toString(array3));
    				System.out.println();

    				array4 = MetodosOrdenamiento.Intercalacion.intercalacion(array2, array3);
    				MetodosOrdenamiento.mostrar(array4);
    				break;
    			
    			case 11:
    				MetodosOrdenamiento.OrdenamientoMezclaDirecta.ordenamientoMezcla(array2);
                    MetodosOrdenamiento.mostrar(array2);
                    break;

    			case 12:
    				MetodosOrdenamiento.MezclaNatural.mezclaNatural(array2);
    				MetodosOrdenamiento.mostrar(array2);
    				break;

    			case 13:
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
