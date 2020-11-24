import java.util.Arrays;

class OrdenamientoPorSeleccion{

	public void ordenamientoSeleccion(int []numeros) {
		for(int i=0; i<numeros.length-1; i++) {
			
			for(int j=i+1; j<numeros.length; j++) {
				
				if(numeros[i]>numeros[j]) {
					int minimo = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = minimo;	
				}
			}
		}
	}
}


public class Prueba {

	public static void main(String[] args) {

		int []numeros = {6, 1, 10, 2, 8, 4, 6, 9};
		
		OrdenamientoPorSeleccion ops = new OrdenamientoPorSeleccion();
		
		System.out.println("Numeros sin ordenador: " + Arrays.toString(numeros));
		ops.ordenamientoSeleccion(numeros);
		System.out.println("Numeros ordenados: " + Arrays.toString(numeros));
		
		
	}

}
