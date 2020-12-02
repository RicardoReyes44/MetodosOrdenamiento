import java.util.Arrays;


class OrdenamientoMezclaDirecta{
	
	public void mezclaDirecta2(int arreglo[]) {
		int i,j,k;
		
		if(arreglo.length>1) {
			int numElementosIzq = arreglo.length/2;
			int numElementosDer=arreglo.length-numElementosIzq;
			
			int arregloIzquierdo[] = new int[numElementosIzq];
			int arregloDerecho[] = new int[numElementosDer];
			
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
		
		public void mezclaNatural(int numeros[]) {

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


public class Prueba {

	public static void main(String[] args) {

		OrdenamientoMezclaDirecta mn = new OrdenamientoMezclaDirecta();
		
		int numeros[] = {60, 30, 20, 10, 100, 80, 90, 40, 70, 50};
		System.out.println("Array desordenado: " + Arrays.toString(numeros));
		mn.mezclaNatural(numeros);
		System.out.println("Array ordenado: " + Arrays.toString(numeros));
		
		
	}

}
