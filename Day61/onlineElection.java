import java.util.*;

class TopVotedCandidate {
    int[] times;
    int[] leaders;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        leaders = new int[persons.length];
        Map<Integer, Integer> count = new HashMap<>();
        
        int leader = -1;
        int maxVotes = 0;

        for (int i = 0; i < persons.length; i++) {
            int p = persons[i];
            count.put(p, count.getOrDefault(p, 0) + 1);

            if (count.get(p) >= maxVotes) {
                leader = p;
                maxVotes = count.get(p);
            }

            leaders[i] = leader;
        }
    }

    public int q(int t) {
        int left = 0, right = times.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (times[mid] <= t) left = mid + 1;
            else right = mid - 1;
        }

        return leaders[right];
    }
}