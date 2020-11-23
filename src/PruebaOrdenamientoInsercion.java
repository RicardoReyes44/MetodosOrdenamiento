import java.util.Arrays;

interface Delay{

	public static void wait(int mili) {
		try {
			Thread.sleep(mili);
		}catch(Exception e){
			Thread.currentThread().interrupt();
		}
	}

}

class Ordenador {
	public void ordenadorInsercion(int []numeros) {
		int aux;
		
		for(int i=1; i<numeros.length; i++) {
			aux = numeros[i];
			
			
			
			for(int j=i-1; j>=0 && numeros[j]>aux; j--) {
				
				numeros[j+1] = numeros[j];
				numeros[j] = aux;
				
			}// segundo for
		}// primero for
	}
}// metodo ordenarInsercion


public class PruebaOrdenamientoInsercion {

	public static void main(String[] args) {

		int[]numeros = {5, 7, 11, 4, 12, 23, 3, 4, 2, 1, 45, 13};

		System.out.println("Numeros desordenados: " + Arrays.toString(numeros));

		Ordenador o = new Ordenador();
		o.ordenadorInsercion(numeros);

		System.out.println("Numeros ordenados: " + Arrays.toString(numeros));
		
	}

}
