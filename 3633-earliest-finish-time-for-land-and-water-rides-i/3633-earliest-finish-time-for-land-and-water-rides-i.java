class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        // Land ride first -> Water ride
        for (int i = 0; i < landStartTime.length; i++) {

            int landFinish = landStartTime[i] + landDuration[i];

            for (int j = 0; j < waterStartTime.length; j++) {

                int waterStart = Math.max(landFinish, waterStartTime[j]);
                int totalFinish = waterStart + waterDuration[j];

                ans = Math.min(ans, totalFinish);
            }
        }

        // Water ride first -> Land ride
        for (int j = 0; j < waterStartTime.length; j++) {

            int waterFinish = waterStartTime[j] + waterDuration[j];

            for (int i = 0; i < landStartTime.length; i++) {

                int landStart = Math.max(waterFinish, landStartTime[i]);
                int totalFinish = landStart + landDuration[i];

                ans = Math.min(ans, totalFinish);
            }
        }

        return ans;
    }
}