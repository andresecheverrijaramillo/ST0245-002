/**
 *
 * @author Isabella Quintero, Sofia Vega
 * This class contains the methods that solve points 1.1 and 1.2 of laboratory 
 * practice 1
 */
import java.util.*;
public class Laboratory1 {
    
    /**
     * This method calculates the longest common sequence between two strings
     * @param string1 First string
     * @param string2 Second string
     * @return length of the largest common sequence between cadena
     */
    public static int lcsDNA(String string1, String string2){
        return lcsDNAAux(string1,string2,string1.length(),string2.length());
    }
    /**
     * This method is an auxiliar for lcsDNA
     * @param string1 first characters string
     * @param string2 second characters string
     * @param m length of cadena1
     * @param n length of cadena 2
     * @return length of the largest common sequence between two strings
     */
    private static int lcsDNAAux(String string1, String string2, int m, int n) {
        if(m<1||n<1){
            return 0;
        }
        if(string1.charAt(m-1)==string2.charAt(n-1)){
            return 1 + lcsDNAAux(string1.substring(0,m-1),string2.substring(0,n-1),m-1,n-1);
        }
        return Math.max(lcsDNAAux(string1,string2.substring(0,n-1),m,n-1), lcsDNAAux(string1.substring(0,m-1),string2,m-1,n));
    }
    public static void maxTime (){
      
      System.out.print("Array 1:");
      Scanner sc= new Scanner(System.in);
      
      String uno= sc.nextLine();
      System.out.print("Array 2:");
      String dos= sc.nextLine();
      long ti = System.currentTimeMillis();
      int arr = lcsDNAAux(uno,dos,uno.length(),dos.length());
      System.out.println("El tamaño del substring igual es de "+ arr);
      long tf = System.currentTimeMillis();
      System.out.println("Tiempo transcurrido:"+ (tf - ti));
     }
    /**
     * This method calculates how many ways there are for organizing rectangles
     * of 1x2 in a rectangle of 2xn
     * @param n side n of the rectangle 2xn
     * @return number of ways that rectangles of 1x2 can be organized 
     * in a rectangle of 2xn
     */
    public static int ways(int n){
        if(n<=2) return n;
        return ways(n-1) + ways(n-2);
    }

}
