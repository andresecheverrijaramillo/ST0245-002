public class Array3 {

    public int maxSpan(int[] nums) {
        int max = 0;//C
        for (int i = 0; i < nums.length; i++) {//n*C

            int j = nums.length - 1;//n*C
            for (;; j--) {//n*n*C
                if (nums[j] == nums[i]) {//n*n*C
                    break;//n*n*C
                }
            }

            int span = j - i + 1;//n*C

            if (span > max) {//n*C
                max = span;//n*C
            }
        }
        return max;//C
        //Complejidad O(n*n)
    }

    public int[] fix45(int[] nums) {
      int j=0;//c1
      int mew[]= new int[nums.length];//c2
      for(int i=0;i<nums.length;i++){
         if(nums[i]==4){//c3p
           mew[i]=4;//c5p
           i++;//c6p
           mew[i]=5;//c7p
         }
       }
      for(int i=0;i<mew.length;i++){//c9n
      if(mew[i]==0){//c10n
      for(int k=j;k<nums.length;k++){//c11nm
        if(nums[k]!=4&&nums[k]!=5){//c12nm
          mew[i]=nums[k];//c13nm
          j=k;//c14mn
          break;//c15mn
          }
          }
        }
      }
      return mew;
       // O(nm)
  }

  public boolean canBalance(int[] nums) {
    int lSum = 0; //c1

    for (int i = 0; i < nums.length; i++) { //c2n
    lSum += nums[i]; //c3n
    int rSum = 0; //c4n
    for (int j = nums.length-1; j > i; j--) { //c5nm
      rSum += nums[j]; //c6nm
    }
    if (rSum == lSum) //c7n
      return true; //c8n
    }
    return false; //c9
    //O(nm)
    }

   public boolean linearIn(int[] outer, int[] inner) {
        int count=0; //c1
        for(int i=0;i<outer.length;i++){ //c2n
          if(count<inner.length) //c3n
            if(outer[i]==inner[count]){ //c4n
                count++; //c5n
            }
        }
        if(count==inner.length){ //c6
            return true; //c7
        }
        else { //c8
            return false; //c9
        }
        // T(n) es O(n)
     }

   public int[] seriesUp(int n) {
    int[] arr = new int[n*(n+1)/2];//c
    int p = 0;//c
    for(int i = 1; i <= n; i++)//c*n
    {
        for(int j = 1; j <= i; j++, p++)//c*n*m
            arr[p] = j;//c*n*m
    }
    return arr;//c
    //T(n) es O(nm)
   }
}
