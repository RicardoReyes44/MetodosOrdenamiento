import java.util.Arrays;

class OrdenamientoMezclaDirecta{
	
	public int[] ordenamientoMezcla(int arreglo[]) {
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


public class Prueba {

	public static void main(String[] args) {

		OrdenamientoMezclaDirecta o1 = new OrdenamientoMezclaDirecta();
		
		int vector[] = {5, 10, 7, 4, 1, 8, 2, 3, 6, 9};
		
		System.out.println("Vector desordenado: " + Arrays.toString(vector));
		
		int vector2[] = o1.ordenamientoMezcla(vector);
        System.out.println("Vector ordenado: " + Arrays.toString(vector2));
		
	}

}
