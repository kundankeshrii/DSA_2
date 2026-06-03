class Solution {

    private int calc(int[] start1, int[] duration1,
                     int[] start2, int[] duration2) {

        int earliestEnd = Integer.MAX_VALUE;
        // Earliest finish time among first category rides
        for (int i = 0; i < start1.length; i++) {
            earliestEnd = Math.min(earliestEnd, start1[i] + duration1[i]);
        }

        int ans = Integer.MAX_VALUE;

        // Try every ride in second category
        for (int i = 0; i < start2.length; i++) {
            int finishTime = Math.max(start2[i], earliestEnd) + duration2[i];
            ans = Math.min(ans, finishTime);
        }

        return ans;
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        return Math.min(
            calc(landStartTime, landDuration,
                 waterStartTime, waterDuration),

            calc(waterStartTime, waterDuration,
                 landStartTime, landDuration)
        );
    }
}