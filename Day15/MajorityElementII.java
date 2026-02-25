import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer c1 = null, c2 = null;
        int count1 = 0, count2 = 0;

        
        for (int n : nums) {
            if (c1 != null && n == c1) {
                count1++;
            } 
            else if (c2 != null && n == c2) {
                count2++;
            } 
            else if (count1 == 0) {
                c1 = n;
                count1 = 1;
            } 
            else if (count2 == 0) {
                c2 = n;
                count2 = 1;
            } 
            else {
                count1--;
                count2--;
            }
        }

        
        count1 = 0;
        count2 = 0;

        for (int n : nums) {
            if (c1 != null && n == c1) count1++;
            else if (c2 != null && n == c2) count2++;
        }

        List<Integer> res = new ArrayList<>();

        if (count1 > nums.length / 3) res.add(c1);
        if (count2 > nums.length / 3) res.add(c2);

        return res;
    }
}