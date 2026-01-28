class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;   // total gas balance
        int tank = 0;    // current tank
        int start = 0;   // candidate start index
        
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            
            // Cannot reach next station from current start
            if (tank < 0) {
                start = i + 1;  // choose next station as start
                tank = 0;       // reset tank
            }
        }
        
        return total >= 0 ? start : -1;
    }
}
