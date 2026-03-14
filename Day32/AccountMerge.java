import java.util.*;

class Solution {

    int[] parent;

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py)
            parent[py] = px;
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();
        parent = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;

        Map<String, Integer> emailMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> acc = accounts.get(i);

            for (int j = 1; j < acc.size(); j++) {
                String email = acc.get(j);

                if (!emailMap.containsKey(email))
                    emailMap.put(email, i);
                else
                    union(i, emailMap.get(email));
            }
        }

        Map<Integer, TreeSet<String>> map = new HashMap<>();

        for (String email : emailMap.keySet()) {
            int parentAcc = find(emailMap.get(email));
            map.putIfAbsent(parentAcc, new TreeSet<>());
            map.get(parentAcc).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (int acc : map.keySet()) {
            List<String> list = new ArrayList<>();
            list.add(accounts.get(acc).get(0));
            list.addAll(map.get(acc));
            result.add(list);
        }

        return result;
    }
}