class Solution {
    private static final int MOD = 1_000_000_007;

    class SegmentTree {
        long[] sum;
        long[] sumSq;
        long[] lazy;
        int n;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sumSq = new long[4 * n];
            lazy = new long[4 * n];
        }

        void update(int node, int start, int end, int l, int r) {
            if (l > end || r < start) {
                return;
            }

            if (l <= start && end <= r) {
                apply(node, start, end);
                return;
            }

            push(node, start, end);

            int mid = start + (end - start) / 2;

            update(node * 2, start, mid, l, r);
            update(node * 2 + 1, mid + 1, end, l, r);

            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
            sumSq[node] = (sumSq[node * 2] + sumSq[node * 2 + 1]) % MOD;
        }

        void apply(int node, int start, int end) {
            long oldSum = sum[node];
            long len = end - start + 1L;

            sumSq[node] = (sumSq[node] + 2L * oldSum + len) % MOD;
            sum[node] = (oldSum + len) % MOD;
            lazy[node]++;
        }

        void push(int node, int start, int end) {
            if (lazy[node] == 0 || start == end) {
                return;
            }

            int mid = start + (end - start) / 2;

            applyMultiple(node * 2, start, mid, lazy[node]);
            applyMultiple(node * 2 + 1, mid + 1, end, lazy[node]);

            lazy[node] = 0;
        }

        void applyMultiple(int node, int start, int end, long delta) {
            long oldSum = sum[node];
            long len = end - start + 1L;

            sumSq[node] = (sumSq[node]
                    + 2L * delta % MOD * oldSum
                    + delta % MOD * delta % MOD * len) % MOD;

            sum[node] = (oldSum + delta % MOD * len) % MOD;
            lazy[node] += delta;
        }

        long getSquaredSum() {
            return sumSq[1];
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;

        int[] last = new int[100001];
        SegmentTree tree = new SegmentTree(n);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = last[nums[i]];

            // Update all subarrays ending at i
            // that gain a new distinct element.
            tree.update(1, 0, n - 1, prev, i);

            ans = (ans + tree.getSquaredSum()) % MOD;

            // Store i + 1 so that 0 means unseen.
            last[nums[i]] = i + 1;
        }

        return (int) ans;
    }
}