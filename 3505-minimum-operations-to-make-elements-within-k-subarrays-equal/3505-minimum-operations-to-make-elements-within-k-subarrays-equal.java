import java.util.*;

class Solution {

    TreeMap<Integer, Integer> low = new TreeMap<>();
    TreeMap<Integer, Integer> high = new TreeMap<>();

    int lowSize = 0;
    int highSize = 0;

    long lowSum = 0;
    long highSum = 0;

    void add(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    void remove(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);

        if (count == 1) {
            map.remove(val);
        } else {
            map.put(val, count - 1);
        }
    }

    void addNum(int num) {

        if (low.isEmpty() || num <= low.lastKey()) {
            add(low, num);
            lowSize++;
            lowSum += num;
        } else {
            add(high, num);
            highSize++;
            highSum += num;
        }

        balance();
    }

    void removeNum(int num) {

        if (low.containsKey(num)) {
            remove(low, num);
            lowSize--;
            lowSum -= num;
        } else {
            remove(high, num);
            highSize--;
            highSum -= num;
        }

        balance();
    }

    void balance() {

        int target = (lowSize + highSize + 1) / 2;

        while (lowSize > target) {

            int val = low.lastKey();

            remove(low, val);
            lowSize--;
            lowSum -= val;

            add(high, val);
            highSize++;
            highSum += val;
        }

        while (lowSize < target) {

            int val = high.firstKey();

            remove(high, val);
            highSize--;
            highSum -= val;

            add(low, val);
            lowSize++;
            lowSum += val;
        }
    }

    long getCost() {

        int median = low.lastKey();

        return (long) median * lowSize - lowSum
             + highSum - (long) median * highSize;
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        long[] cost = new long[n - x + 1];

        // Sliding Window

        for (int i = 0; i < n; i++) {

            addNum(nums[i]);

            if (i >= x) {
                removeNum(nums[i - x]);
            }

            if (i >= x - 1) {

                int start = i - x + 1;

                cost[start] = getCost();
            }
        }

        // Dynamic Programming

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= k; j++) {

                // Skip current element

                dp[i][j] = dp[i - 1][j];

                // Select a window of size x

                if (i >= x && dp[i - x][j - 1] != INF) {

                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - x][j - 1] + cost[i - x]
                    );
                }
            }
        }

        return dp[n][k];
    }
}