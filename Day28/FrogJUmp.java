import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }

        map.get(0).add(0);

        for (int stone : stones) {
            for (int jump : map.get(stone)) {

                for (int step = jump - 1; step <= jump + 1; step++) {

                    if (step > 0 && map.containsKey(stone + step)) {
                        map.get(stone + step).add(step);
                    }
                }
            }
        }

        return !map.get(stones[stones.length - 1]).isEmpty();
    }
}