import java.lang.reflect.Array;
import java.util.Arrays;

class PruebaQuickSort{
	public int[] quickSort(int[] array, int izq, int der){
		int pivote = array[izq];
		int i = izq, j=der;
		int aux;
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


public class Prueba {

	public static void main(String[] args) {

		int []numeros = {6, 1, 10, 2, 8, 4, 6, 9};
		
		PruebaQuickSort pqs = new PruebaQuickSort();
		
		System.out.println("Numeros sin ordenador: " + Arrays.toString(numeros));
		System.out.println("Numeros ordenados: " + Arrays.toString(pqs.quickSort(numeros, 0, numeros.length-1)));
		
		
	}

}
