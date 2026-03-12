import java.util.*;

class Solution {

    int[] original;
    Random rand;

    public Solution(int[] nums) {
        original = nums.clone();
        rand = new Random();
    }
    
    public int[] reset() {
        return original.clone();
    }
    
    public int[] shuffle() {
        int[] arr = original.clone();
        
        for (int i = 0; i < arr.length; i++) {
            int j = i + rand.nextInt(arr.length - i);
            
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
        return arr;
    }
}