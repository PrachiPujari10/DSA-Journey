import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int radius = 0;

        for (int house : houses) {
            int idx = Arrays.binarySearch(heaters, house);

            if (idx < 0) {
                idx = -(idx + 1);
            }

            int leftDist = (idx - 1 >= 0) ? house - heaters[idx - 1] : Integer.MAX_VALUE;
            int rightDist = (idx < heaters.length) ? heaters[idx] - house : Integer.MAX_VALUE;

            int nearest = Math.min(leftDist, rightDist);
            radius = Math.max(radius, nearest);
        }

        return radius;
    }
}