class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        // Minimum finish time if land ride is done first
        int minLandFinish = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            minLandFinish = Math.min(minLandFinish,
                    landStartTime[i] + landDuration[i]);
        }

        // Try water after land
        for (int j = 0; j < waterStartTime.length; j++) {

            int start = Math.max(minLandFinish, waterStartTime[j]);
            ans = Math.min(ans, start + waterDuration[j]);
        }

        // Minimum finish time if water ride is done first
        int minWaterFinish = Integer.MAX_VALUE;
        for (int j = 0; j < waterStartTime.length; j++) {
            minWaterFinish = Math.min(minWaterFinish,
                    waterStartTime[j] + waterDuration[j]);
        }

        // Try land after water
        for (int i = 0; i < landStartTime.length; i++) {

            int start = Math.max(minWaterFinish, landStartTime[i]);
            ans = Math.min(ans, start + landDuration[i]);
        }

        return ans;
    }
}