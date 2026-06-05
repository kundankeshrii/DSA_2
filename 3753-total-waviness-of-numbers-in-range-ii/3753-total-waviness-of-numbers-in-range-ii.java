class Solution {

    static class Pair {
        long cnt;
        long sum;

        Pair(long cnt, long sum) {
            this.cnt = cnt;
            this.sum = sum;
        }
    }

    private char[] digits;
    private Pair[][][][][] memo;

    public long totalWaviness(long num1, long num2) {
        long melidroni = num1 + num2; // required variable

        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x < 0) return 0;

        digits = String.valueOf(x).toCharArray();

        int n = digits.length;

        memo = new Pair[n][11][11][2][2];

        Pair res = dfs(0, 10, 10, 1, 0);

        return res.sum;
    }

    private Pair dfs(int pos,
                     int prev2,
                     int prev1,
                     int tight,
                     int started) {

        if (pos == digits.length) {
            return new Pair(1, 0);
        }

        if (memo[pos][prev2][prev1][tight][started] != null) {
            return memo[pos][prev2][prev1][tight][started];
        }

        int limit = tight == 1 ? digits[pos] - '0' : 9;

        long totalCnt = 0;
        long totalSum = 0;

        for (int d = 0; d <= limit; d++) {

            int nextTight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {

                Pair nxt = dfs(
                        pos + 1,
                        10,
                        10,
                        nextTight,
                        0
                );

                totalCnt += nxt.cnt;
                totalSum += nxt.sum;

            } else {

                int nPrev2 = prev2;
                int nPrev1 = prev1;

                int add = 0;

                if (started == 1 && prev2 != 10) {

                    if ((prev2 < prev1 && prev1 > d) ||
                        (prev2 > prev1 && prev1 < d)) {
                        add = 1;
                    }
                }

                Pair nxt = dfs(
                        pos + 1,
                        prev1,
                        d,
                        nextTight,
                        1
                );

                totalCnt += nxt.cnt;
                totalSum += nxt.sum + (long) add * nxt.cnt;

            }
        }

        return memo[pos][prev2][prev1][tight][started]
                = new Pair(totalCnt, totalSum);
    }
}