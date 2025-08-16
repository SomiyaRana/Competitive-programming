import java.util.*;

public class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int low = 0, high = Math.min(tasks.length, workers.length), answer = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canAssign(mid, tasks, workers, pills, strength)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

    private boolean canAssign(int k, int[] tasks, int[] workers, int pills, int strength) {
        Deque<Integer> taskDeque = new ArrayDeque<>();
        for (int i = k - 1; i >= 0; i--) {
            taskDeque.addFirst(tasks[i]);
        }

        TreeMap<Integer, Integer> workerMap = new TreeMap<>();
        for (int i = workers.length - k; i < workers.length; i++) {
            workerMap.put(workers[i], workerMap.getOrDefault(workers[i], 0) + 1);
        }

        int pillsLeft = pills;

        while (!taskDeque.isEmpty()) {
            int task = taskDeque.pollLast();  // hardest remaining task

            // Try assigning without pill
            Integer worker = workerMap.ceilingKey(task);
            if (worker != null) {
                remove(workerMap, worker);
                continue;
            }

            // Try assigning with pill
            if (pillsLeft == 0) return false;

            worker = workerMap.ceilingKey(task - strength);
            if (worker != null) {
                remove(workerMap, worker);
                pillsLeft--;
            } else {
                return false;
            }
        }
        return true;
    }

    private void remove(TreeMap<Integer, Integer> map, int key) {
        if (map.get(key) == 1) {
            map.remove(key);
        } else {
            map.put(key, map.get(key) - 1);
        }
    }
}
