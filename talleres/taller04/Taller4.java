import java.util.*;
/**
 * Write a description of class Taller4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Taller4
{
    public static int maximo(int[] nums,int start){ // {-1, -2, -3}
    if (start > nums.length || start<1){
        System.out.println("hi");
        return 0; //Qué procede!!!!!!!!!!!!!!8===D
    }
    else
        return Math.max(maximo(nums,start-1), nums[start-1]);
 }
 
public static int[] generador(int n){
    int[] arr= new int[n];
    for(int i=0; i<n; i++){
     for(int j=0; j<n; j++){
        arr[i]=j;
        }
    }
    return arr;
    }
  public static void maxTime (){
      
      System.out.print("Cantidad de números:");
      Scanner sc= new Scanner(System.in);
      
      int i= sc.nextInt();
      long ti = System.currentTimeMillis();
      int start= generador(i).length-1;
      long tf = System.currentTimeMillis();
      System.out.println(ti);
      System.out.println(tf);
      System.out.println("Tiempo transcurrido:"+ (tf - ti));
}
 
  public static boolean groupSum(int start, int[] nums, int target) {
     if (start == nums.length) // c1
      return target == 0;     // T(n) = c1 + c2
     else
      return groupSum(start+1, nums, target) // T(n) = c3 + 2*T(n-1)
      || groupSum(start+1,nums,target-nums[start]);// T(n) = c1*2^(n-1) + c3*(2^n - 1)
 }
 
 public static void maxSum(int target){
      
      System.out.print("Cantidad de números:");
      Scanner sc= new Scanner(System.in);
      
      int i= sc.nextInt();
      double ti = System.currentTimeMillis();
      int start= generador(i).length-1;
      groupSum(start,generador(i), target);
      double tf = System.currentTimeMillis();
      System.out.println("Tiempo transcurrido:"+ (tf - ti));
}
}
