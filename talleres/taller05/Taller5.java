
/**
 * Write a description of class tallert5 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Taller5
{
  public static void main(String[] args){
      for (int n = 10000000; n < 100000000; n = n + 10000000){ 
        long ti = System.currentTimeMillis();
        suma(new int[n]);
        long tf = System.currentTimeMillis();
        System.out.println(tf-ti);
      }
  }
  public static void medirsort(int[] a){
      long ti = System.currentTimeMillis();
      insertionSort(a);
      long tf = System.currentTimeMillis();
      System.out.println(tf);
      System.out.println(ti);
      System.out.println(tf-ti);
    }
    public static int[] insertionSort(int[] a){
      for(int i = 1; i < a.length; i++) //El verde
      {
          for(int j = i; j > 0; j--) // El rojo
        {
              bailesito(a, j, j-1);
        }
      }
      return a;
  }
    private static void bailesito(int[] a, int primero, int segundo){
        if (a[primero] < a[segundo])
          seIntercambian(a, primero, segundo);
  }
  private static void seIntercambian(int[] a, int primero, int segundo){
      int temp = a[primero];
      a[primero] = a[segundo];
      a[segundo] = temp;
  }
  public static int suma(int[] a){
     long ti = System.currentTimeMillis();
     int acum = 0;  // c1 
     for (int i = 0; i < a.length; i++) // c2 + c3n
        acum = acum + a[i]; // c4n
     long tf = System.currentTimeMillis();
      System.out.println(tf);
      System.out.println(ti);
      System.out.println(tf-ti);
      return acum; // c5
   }               // T(n) = c1 + c2 + c5 + (c3 + c4)n
  public static void mul (int num){
      for(int i=0; i<=10; i++)
      System.out.println(i+"*"+num+"="+i*num);
    }
    public static int sumaRec(int[] array, int pos){
     long t= System.currentTimeMillis();
        int tam= pos;
     int res;

     if(tam>=array.length) {
         long ti= System.currentTimeMillis();
         System.out.print(t-ti);
         return 0;
    }
     long ti= System.currentTimeMillis();
     return res = array[tam]+ sumaRec(array, tam+1);
  }
  public static void medirsumrec(int[] a){
      long ti = System.currentTimeMillis();
      sumaRec(a,0);
      long tf = System.currentTimeMillis();
      System.out.println(tf);
      System.out.println(ti);
      System.out.println(tf-ti);
    }
}
