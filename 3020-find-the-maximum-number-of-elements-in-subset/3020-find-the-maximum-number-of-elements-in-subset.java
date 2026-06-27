 
class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int ans = 1;
        if (count.containsKey(1)) {
            int ones = count.get(1);
            ans = (ones % 2 == 0) ? ones - 1 : ones;
        }

        for (int num : count.keySet()) {
            if (num == 1) continue;

            int currentLength = 0;
            long x = num; 

            while (count.containsKey((int) x) && count.get((int) x) >= 2) {
                currentLength += 2;
                x = x * x; 
                
                if (x > 1_000_000_000) {
                    break;
                }
            }

            if (x <= 1_000_000_000 && count.containsKey((int) x)) {
                currentLength += 1;
            } else {
                currentLength -= 1;
            }

            ans = Math.max(ans, currentLength);
        }

        return ans;
    }
}