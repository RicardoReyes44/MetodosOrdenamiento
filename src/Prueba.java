import java.lang.reflect.Array;
import java.util.Arrays;

class PruebaShellSort{
	
	public void ordenar(int []numeros) {
		
		int intervalo = numeros.length/2;
		
		while(intervalo>0) {
			for(int i=intervalo; i<numeros.length; i++) {
				int j=i-intervalo;
				while(j>=0) {
					int k=j+intervalo;
					if(numeros[j]<=numeros[k]) {
						j=-1;
					}else {
						int aux=numeros[j];
						numeros[j] = numeros[k];
						numeros[k] = aux;
						j-=intervalo;
						
					}
				}
			}
			intervalo = intervalo/2;
		}
	}
	
}


public class Prueba {

	public static void main(String[] args) {

		int []numeros = {6, 1, 10, 2, 8, 4, 6, 9};
		
		PruebaShellSort pss = new PruebaShellSort();
		
		System.out.println("Numeros sin ordenador: " + Arrays.toString(numeros));
		pss.ordenar(numeros);
		System.out.println("Numeros ordenados: " + Arrays.toString(numeros));
		
	}

}
