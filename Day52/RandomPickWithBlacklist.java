import java.util.*;

class Solution {
    private Map<Integer, Integer> map;
    private Random rand;
    private int size;

    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        rand = new Random();
        size = n - blacklist.length;

        Set<Integer> black = new HashSet<>();
        for (int b : blacklist) {
            black.add(b);
        }

        int last = n - 1;

        for (int b : blacklist) {
            if (b < size) {
                while (black.contains(last)) {
                    last--;
                }
                map.put(b, last);
                last--;
            }
        }
    }

    public int pick() {
        int r = rand.nextInt(size);
        if (map.containsKey(r)) {
            return map.get(r);
        }
        return r;
    }
}