class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        java.util.Arrays.sort(nums1);
        java.util.Arrays.sort(nums2);

        int i = 0, j = 0;
        int n1 = nums1.length, n2 = nums2.length;

        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();

        while (i < n1 && j < n2) {

            if (nums1[i] < nums2[j]) {
                i++;
            } 
            else if (nums1[i] > nums2[j]) {
                j++;
            } 
            else {
                // add only if not duplicate
                if (list.isEmpty() || list.get(list.size() - 1) != nums1[i]) {
                    list.add(nums1[i]);
                }

                int val = nums1[i];

                // skip duplicates in nums1
                while (i < n1 && nums1[i] == val) i++;

                // skip duplicates in nums2
                while (j < n2 && nums2[j] == val) j++;
            }
        }

        int[] ans = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            ans[k] = list.get(k);
        }

        return ans;
    }
}
