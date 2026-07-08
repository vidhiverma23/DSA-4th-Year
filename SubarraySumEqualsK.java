import java.util.HashMap;

class Solution {

    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSumHistory = new HashMap<>();

        int currentPrefixSum = 0;
        int totalSubarraysFound = 0;

        prefixSumHistory.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            currentPrefixSum += nums[i];

            int targetHistory = currentPrefixSum - k;

            if (prefixSumHistory.containsKey(targetHistory)) {
                totalSubarraysFound += prefixSumHistory.get(targetHistory);
            }

            prefixSumHistory.put(currentPrefixSum,
                    prefixSumHistory.getOrDefault(currentPrefixSum, 0) + 1);
        }

        return totalSubarraysFound;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] nums = {1, 1, 1};
        int k = 2;

        System.out.println(obj.subarraySum(nums, k));
    }
}