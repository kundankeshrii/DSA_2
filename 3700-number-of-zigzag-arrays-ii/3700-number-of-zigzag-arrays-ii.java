import java.util.*;

class Solution {

    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(long n, int l, int r) {

        int m = r - l + 1;
        int size = 2 * m;

        if (n == 1) {
            return m;
        }

        long[][] trans = new long[size][size];

        // State:
        // 0..m-1     -> U[x]
        // m..2m-1    -> D[x]

        for (int x = 0; x < m; x++) {

            // U[x] -> D[y] where y < x
            for (int y = 0; y < x; y++) {
                trans[m + y][x] = 1;
            }

            // D[x] -> U[y] where y > x
            for (int y = x + 1; y < m; y++) {
                trans[y][m + x] = 1;
            }
        }

        long[][] power = matrixPow(trans, n - 1);

        long[][] init = new long[size][1];

        for (int x = 0; x < m; x++) {
            init[x][0] = 1;
            init[m + x][0] = 1;
        }

        long[][] result = multiply(power, init);

        long ans = 0;

        for (int i = 0; i < size; i++) {
            ans = (ans + result[i][0]) % MOD;
        }

        return (int) ans;
    }

    private long[][] matrixPow(long[][] base, long exp) {

        int n = base.length;

        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {

            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }

            base = multiply(base, base);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {

        int r = A.length;
        int c = B[0].length;
        int mid = B.length;

        long[][] ans = new long[r][c];

        for (int i = 0; i < r; i++) {

            for (int k = 0; k < mid; k++) {

                if (A[i][k] == 0) continue;

                for (int j = 0; j < c; j++) {

                    ans[i][j] =
                        (ans[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }

        return ans;
    }
}