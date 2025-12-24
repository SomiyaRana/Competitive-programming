class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length(), len2 = s2.length();

        int index = 0;      // index in s2
        int count2 = 0;     // how many times s2 is matched

        // record[index] = { iteration number in s1, count2 at that time }
        int[][] record = new int[len2][2];
        for (int i = 0; i < len2; i++) {
            record[i][0] = -1;
        }

        int i = 0;
        while (i < n1) {
            i++;

            for (int j = 0; j < len1; j++) {
                if (s1.charAt(j) == s2.charAt(index)) {
                    index++;
                    if (index == len2) {
                        index = 0;
                        count2++;
                    }
                }
            }

            // cycle detected
            if (record[index][0] != -1) {
                int prevI = record[index][0];
                int prevCount = record[index][1];

                int cycleLen = i - prevI;
                int cycleCount = count2 - prevCount;

                int remaining = n1 - i;
                int cycles = remaining / cycleLen;

                count2 += cycles * cycleCount;
                i += cycles * cycleLen;
            } else {
                record[index][0] = i;
                record[index][1] = count2;
            }
        }

        return count2 / n2;
    }
}
