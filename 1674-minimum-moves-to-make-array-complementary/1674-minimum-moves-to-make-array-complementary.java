class Solution {

    public int minMoves(int[] nums, int limit) {

        int n = nums.length;

        // difference array
        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {

            int a = Math.min(nums[i], nums[n - 1 - i]);
            int b = Math.max(nums[i], nums[n - 1 - i]);

            /*
                Initially assume:
                every sum needs 2 moves

                Then optimize ranges.
            */

            // range [2 , 2*limit] += 2
            diff[2] += 2;
            diff[2 * limit + 1] -= 2;

            // range [a+1 , b+limit] -= 1
            diff[a + 1] -= 1;
            diff[b + limit + 1] += 1;

            // exact sum (a+b) -= 1
            diff[a + b] -= 1;
            diff[a + b + 1] += 1;
        }

        int ans = Integer.MAX_VALUE;

        int current = 0;

        // all possible target sums
        for (int sum = 2; sum <= 2 * limit; sum++) {

            current += diff[sum];

            ans = Math.min(ans, current);
        }

        return ans;
    }
}