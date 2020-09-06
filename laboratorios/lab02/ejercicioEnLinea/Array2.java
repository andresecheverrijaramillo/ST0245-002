import java.util.Arrays;
public class Array2 {
   public int countEvens(int[] nums) {
        int count = 0;//        C
        for (int n : nums) {//  n
            if (n % 2 == 0) {// n
                count++;    //  n
            }
        }
        return count;       //C
        //Complejidad O(n)
    }

   public int[] post4(int[] nums) {
        int count4=0;//c_1
        int[] nums2;//c_2
       for (int i=0; i<nums.length;i++){//c_3*n
           if(nums[i]==4){//c_4*n
               count4++;//c_5*n
            }
        }
       if(count4>0){//c_6
       if(nums.length==count4){//c_7
           int []nums3 = new int[1];//c_8
           return nums3;//c_9
        }
       for (int i=0; i<nums.length;i++){//c_10*n
           if(nums[i]==4){//c_11*n
               count4--;//c_12*n
            }
           if(count4==0&&i++<nums.length){//c_13*n
                int tamañonuevo=nums.length-i;//c_14*n
                nums2 = Arrays.copyOfRange(nums, i, nums.length);//c_15*n
                return nums2;//c_16*n
            }
          }
        }
        return nums;//c_17
       //O(n)
    }

   public boolean only14(int[] nums) {
     boolean g=true;
     for(int i=0; i<nums.length;i++){//c*n
        if (nums[i]!=1){//c*n
             g=false;//c*n
            }
         if (nums[i]!=4){//c*n
             g=false;//c*n
            }
         if (nums[i]==1){//c*n
             g=true;//c*n
            }
         if (nums[i]==4){//c*n
             g=true;//c*n
            }
            if (g==false)//c*n
            return false;//c*n
        }
     return g;//c
     //O(n)
    }

   public String[] fizzArray2(int n) {
        String[] array=new String[n];//c
        for(int i=0; i<n; i++){//c*n
            array[i]=String.valueOf(i);//c*n
        }
        return array;//c
        //O(c)
    }

     public boolean has12(int[] nums) {
      boolean uno=false;//c
      boolean dos=false;//c
      for(int i=0; i<nums.length;i++){//c*n
      if(nums[i]==1)//c*n
      uno=true;//c*n
  
      if(nums[i]==2&&uno==true)//c*n
      dos=true;//c*n
     }
     if(uno==true&&dos==true){//c
     return true;//c
     }
      return false;//c
     //O(c)
   } 
}


