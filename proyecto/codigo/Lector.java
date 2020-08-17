
/**
 * @author (Santiago Gonzalez, Mariana Vargas)
 * Lector de archivos
 */
import java.io.*;
import java.util.*;
public class Lector {
    public static void main (String args[]) throws FileNotFoundException{
        List <String> datos=new ArrayList<String>();
        Scanner s=new Scanner(System.in);
        String n=s.nextLine();
        File archivo=new File(n);
        while (s.hasNextLine()){
            String texto=s.nextLine();
            datos.add(texto);
        }
    }
}