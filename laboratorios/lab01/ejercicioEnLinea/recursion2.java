
/**
 * Write a description of class enlinea here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class recursion2{

   public boolean groupNoAdj(int start, int[] nums, int target) {
   if(target==0)
     return true;
     if (start>nums.length-1)
        return false;
     if (groupNoAdj(start+2,nums,target-nums[start]))
            return true;
        return groupNoAdj(start+1,nums,target);
    }
    public boolean groupSum5(int start, int[] nums, int target) {
  if (target==0){
    return true;
  }
   if (start>nums.length-1)
     return false;
  int count=0;
  for(int i=0;i<nums.length;i++){
      if(nums[i]%5==0){
          target=target-nums[i];
          nums[i]=0;
          if(i<nums.length-1)
          if(nums[i+1]==1)
          nums[i+1]=0;
        }
    }
  for(int i=start;i<nums.length;i++){
      count=count+nums[i];
      if(count==target)
      return true;
    }
    return groupSum5(start+1,nums,target);
  }
  public boolean groupSumClump(int start, int[] nums, int target) {
      if (target==0){
    return true;
  }
  if (start>nums.length-1)
        return false;
  int targetaux=target;
  int saverep=0;
  int count=0;
  for(int i=0;i<nums.length;i++){
      if(i<nums.length-1)
      if(nums[i]==nums[i+1]){
          saverep=nums[i];
        }
      if(nums[i]==saverep){
          nums[i]=0;
          targetaux=targetaux-saverep;
        }
    }
  for(int i=start;i<nums.length;i++){
      count=count+nums[i];
      if(count==target)
      return true;
      if(i>0){
          if(count-nums[i-1]==target)
          return true;
        }
    }
  if(groupSumClump(start+1,nums,target))
  return true;
  if(groupSumClump(start+1,nums,targetaux))
  return true;
  else
  return false;
 }
 public boolean splitArray(int[] nums) {
  return helper(0, nums, 0, 0);
  }
  public boolean helper(int start, int[]nums, int sum, int sum1){
  if(start==nums.length)
  return sum==sum1;
  if(helper(start+1, nums, sum+nums[start], sum1))
  return true;
  else if(helper(start+1, nums, sum, sum1+nums[start]))
  return true;
  else return false;

 }
 public boolean split53(int[] nums) {
        return helper3(0, nums, 0, 0);
     }
 private boolean helper3(int index, int[] nums, int sum5s, int sum3n5) {
        for(int i=0;i<nums.length;i++){
             if(nums[i]%5==0){
                 sum5s=sum5s+nums[i];
                 nums[i]=0;
                }
             if(nums[i]%3==0){
                 sum3n5=sum3n5+nums[i];
                 nums[i]=0;
                }
        }
        if(index==nums.length)
        return sum5s==sum3n5;
        if(helper3(index+1, nums, sum5s+nums[index], sum3n5))
        return true;
        else if(helper3(index+1, nums, sum5s, sum3n5+nums[index]))
        return true;
        else return false;
   }
}


