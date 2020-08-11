 
/**
*
* La clase Taller3 tiene como objtivo dar solución a los puntos del taller 3
*
* @author Mauricio Toro, Andrés Páez
* @version 1
*/


public class Taller3 {

	/**
	*
	* El método torresDeHannoi es un auxiliar del proceso 
	* @param n numero de discos
	* 
	*/	
	
	public static void torresDeHannoi(int n) {
		torresDeHannoiAux(n, 1, 2, 3);
	}

	/**
	*
	* El método torresDeHannoi es un auxiliar del proceso 
	* @param n numero de discos
	* @param origen la torre número uno donde se posicionan todos los discos inicialmente
	* @param destino la torre donde deben posicionarse todos los discos terminado el proceso
	* @param intermedio torre auxiliar para que el cambio de torres se haga efectivo
	* 
	* debe devolver la secuencia de pasos en consola de esta manera:
	* System.out.println("Disk "+ n + " from "+ origen + " to "+ destino);
	*
	* @see <a href="http://www.uterra.com/juegos/torre_hanoi.php"> Simulación del funcionamiento</a>
	* @see <a href="https://es.wikipedia.org/wiki/Torres_de_Han%C3%B3i"> Un poco de historia </a>
	*/	
	
	private static void torresDeHannoiAux(int n, int origen, int intermedio, int destino) {
	if(n<=1)
	    {   
		System.out.println("Disk 1 from "+ origen + " to "+ destino);
	    }
	else {
	    torresDeHannoiAux(n-1, origen,destino,intermedio);
	    System.out.println("Disk "+ n + " from "+ origen + " to "+ destino);
	    torresDeHannoiAux(n-1, intermedio, origen, destino);
	}
    }
		

		
	/**
	*
	* El método permutation es un auxiliar del proceso 
	* @param str es la cadena a permutar
	*/
	public static void permutation(String str) {
		permutationAux("", str); 
	}
	
	/**
	*
	* El método permutationAux es el core del proceso, en el se busca conseguir
	* las posibles permutaciones que puede tener la cadena str 
	* @param str es la cadena a permutar
	* @param prefix cadena auxiliar donde se guarda la cadena de salida
	*
	* Las cadenas de salida tienes una longitud de lenght de la cadena s
	* Ej: para la cadena AB se tiene la salida: { ABC,ACB,BAC,BCA,CAB,CBA }
	* donde los caracteres no se repiten pero el orden tiene un papel importante.
	*
	*/
	private static void permutationAux(String prefix, String str) {
		if(prefix.length()>0) {
            System.out.printf(prefix + ", ");
            }if(str.length()==0) {
            System.out.printf("");
             }else{
            permutationAux(prefix + str.charAt(0), str.substring(1));
            if(str.length()>1) {
                for(int i = 1; str.length()>i; i++){
                    permutationAux(prefix + str.charAt(i), str.substring(i+1));
                }
            }
            }
	}
		
	
}
