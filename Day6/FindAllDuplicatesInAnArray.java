class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        int n =nums.length;             
        for(int i = 0;i<n;i++)
        {
            int index = Math.abs(nums[i])-1;
            if(nums[index]<0)
            {
                result.add(index+1);
            }
            else
            {
                nums[index]=-nums[index];
            }
        }
        return result;
    }
} 
