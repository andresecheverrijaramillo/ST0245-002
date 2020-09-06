/** 
* Laboratorio 2 de Estructuras de Datos 1
 * 
 * @author Mauricio Toro 
 * @version 1
 */

import java.util.*;

public class Laboratorio2
{

    // Sorts an array using Insertion Sort
    public static void InsertionSort(int[] A) {
        for(int i=0; i<A.length; i++){
            for(int j=i; j>0; j--){
                if (A[j]<A[j-1]){
                    int temp=A[j];
                    A[j]=A[j-1];
                    A[j-1]=temp;
                }
            }
        }
    } 

    // Sorts an array using Merge Sort
    public static void mergeSort(int [ ] a) {
        int[] tmp = new int[a.length];
        mergeSort(a, tmp,  0,  a.length - 1);
    }

    // Sorts an array using Merge Sort
    private static void mergeSort(int [ ] a, int [ ] tmp, int left, int right) {
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(a, tmp, left, mid);
            mergeSort(a, tmp, mid+1, right);
            merge(a, tmp, left, mid+1, right);
        }
    }

    // Merges two sorted arrays
    //In mergeSort (line 38) mid is right & right is rightEnd
    private static void merge(int[ ] a, int[ ] tmp, int left, int right, int rightEnd ) {
        int cond=rightEnd-left+1;
        int aux=left;
        while (left<=(right-1) && right<=rightEnd){
            if(a[left]<=a[right]) tmp[left++]=a[left++];
            else tmp[left++]=a[right++];
        }
        while (left<=(right-1)) tmp[aux++]=a[left++];
        while (right<=rightEnd) tmp[aux++]=a[right++];
        for (int i=0; i<cond; i++, rightEnd--) a[rightEnd]=tmp[rightEnd];
    }

    public static void main(String[] args) {
        int[] A = {1,5,3,2,6};
        int[] B = {1,5,3,2};
        int[] C = {1,5,2,6};
        int[][] Arrays = {A,B,C};
        for (int[] X : Arrays)
        {
            Laboratorio2.mergeSort(X);
            Laboratorio2.InsertionSort(X);
        }
    }
    
     public static void tiempoinsert(int[] a){
      long ti = System.currentTimeMillis();
      InsertionSort(a);
      long tf = System.currentTimeMillis();
      System.out.println(tf);
      System.out.println(ti);
      System.out.println(tf-ti);
    }
    
    public static void tiempomerge(int[] a){
      long ti = System.currentTimeMillis();
      mergeSort(a);
      long tf = System.currentTimeMillis();
      System.out.println(tf);
      System.out.println(ti);
      System.out.println(tf-ti);
    }
    public static void tiempomergehelper(int a){
        int []nums = new int[a];
        for(int i=0; i<a;i++){
            nums[i]=a-i;
        }
        tiempomerge(nums);
    }
    public static void tiempoinserthelper(int a){
        int []nums = new int[a];
        for(int i=0; i<a;i++){
            nums[i]= a-i;
        }
        tiempoinsert(nums);
    }
}