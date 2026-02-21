class Solution {
    public int missingNumber(int[] nums) {
       long n =nums.length;//[0,1,4,3]
       long sum =n*(n+1)/2;//3*(3+1)=12/2=6
       long arraySum =0;
       for(int ele:nums)
       {
        arraySum+=ele;
       }

       return(int) (sum-arraySum);
    }
    
}