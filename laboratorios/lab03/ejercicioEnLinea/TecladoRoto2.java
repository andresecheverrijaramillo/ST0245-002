import java.util.*;
public class TecladoRoto2{
    //Punto 2.1
    public static void teclado(String a){
        LinkedList<Character>texto = new LinkedList<>();
        int j=0;
        boolean inc=false;
        boolean fin=true;
        for (int i=0; i<a.length(); i++){
        if(a.charAt(i)=='['){
            inc=true;
            fin=false;
            j=0;
        }
        if(fin){
            texto.add(a.charAt(i));
        }if(a.charAt(i)==']'){
            inc=false;
            fin=true;
        }
        if(inc){
            texto.add(j++,a.charAt(i));
        }
        }
        while(texto.contains('[') || texto.contains(']')){
            texto.removeFirstOccurrence('[');
            texto.removeFirstOccurrence(']');
        }
        System.out.println(texto);
       }
 }           