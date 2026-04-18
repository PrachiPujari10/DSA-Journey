import java.util.*;

class MajorityChecker {

    class Node {
        int val, count;
        Node(int v, int c) {
            val = v;
            count = c;
        }
    }

    Node[] seg;
    Map<Integer, List<Integer>> map;
    int n;

    public MajorityChecker(int[] arr) {
        n = arr.length;
        seg = new Node[4 * n];
        build(arr, 0, 0, n - 1);

        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    }

    private void build(int[] arr, int idx, int l, int r) {
        if (l == r) {
            seg[idx] = new Node(arr[l], 1);
            return;
        }

        int mid = (l + r) / 2;
        build(arr, 2 * idx + 1, l, mid);
        build(arr, 2 * idx + 2, mid + 1, r);

        seg[idx] = merge(seg[2 * idx + 1], seg[2 * idx + 2]);
    }

    private Node merge(Node a, Node b) {
        if (a.val == b.val) return new Node(a.val, a.count + b.count);
        if (a.count > b.count) return new Node(a.val, a.count - b.count);
        return new Node(b.val, b.count - a.count);
    }

    public int query(int left, int right, int threshold) {
        Node candidate = queryTree(0, 0, n - 1, left, right);
        int val = candidate.val;

        if (!map.containsKey(val)) return -1;

        List<Integer> list = map.get(val);
        int l = lowerBound(list, left);
        int r = upperBound(list, right);

        if (r - l >= threshold) return val;
        return -1;
    }

    private Node queryTree(int idx, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) return new Node(0, 0);
        if (ql <= l && r <= qr) return seg[idx];

        int mid = (l + r) / 2;
        Node leftNode = queryTree(2 * idx + 1, l, mid, ql, qr);
        Node rightNode = queryTree(2 * idx + 2, mid + 1, r, ql, qr);

        return merge(leftNode, rightNode);
    }

    private int lowerBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private int upperBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}