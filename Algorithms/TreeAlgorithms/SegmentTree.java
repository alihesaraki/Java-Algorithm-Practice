package Algorithms.TreeAlgorithms;

class SegmentTree {

    private final int[] tree;
    private final int size;

    public SegmentTree(int[] arr) {
        size = arr.length;
        int height = (int) Math.ceil(Math.log(size) / Math.log(2));
        int maxSize = 2 * (int) Math.pow(2, height) - 1;
        tree = new int[maxSize];
        buildTree(arr, 0, size - 1, 0);
    }

    private void buildTree(int[] arr, int start, int end, int node) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            buildTree(arr, start, mid, 2 * node + 1);
            buildTree(arr, mid + 1, end, 2 * node + 2);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public void update(int index, int value) {
        updateUtil(0, size - 1, index, value, 0);
    }

    private void updateUtil(int start, int end, int index, int value, int node) {
        if (start == end) {
            tree[node] = value;
        } else {
            int mid = (start + end) / 2;
            if (index <= mid) {
                updateUtil(start, mid, index, value, 2 * node + 1);
            } else {
                updateUtil(mid + 1, end, index, value, 2 * node + 2);
            }
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public int rangeQuery(int left, int right) {
        return rangeQueryUtil(0, size - 1, left, right, 0);
    }

    private int rangeQueryUtil(int start, int end, int left, int right, int node) {
        if (left > end || right < start) {
            return 0; // Neutral value for sum
        }
        if (left <= start && right >= end) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return rangeQueryUtil(start, mid, left, right, 2 * node + 1) +
                rangeQueryUtil(mid + 1, end, left, right, 2 * node + 2);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(arr);

        System.out.println("Sum of values in given range = " + segmentTree.rangeQuery(1, 3)); // Output: 15
        segmentTree.update(1, 10);
        System.out.println("Updated sum of values in given range = " + segmentTree.rangeQuery(1, 3)); // Output: 22
    }
}

