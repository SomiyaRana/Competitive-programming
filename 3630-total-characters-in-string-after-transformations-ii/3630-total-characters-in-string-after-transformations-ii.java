import java.util.*;

class Solution {
    private static final int MOD = (int)1e9 + 7;

    private int[][] matrixMultiplication(int[][] A, int[][] B) {
        int[][] res = new int[26][26];
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j) {
                for (int k = 0; k < 26; ++k) {
                    res[i][j] = (int)((res[i][j] + (1L * A[i][k] * B[k][j]) % MOD) % MOD);
                }
            }
        }
        return res;
    }

    private int[][] matrixExponentiation(int[][] transformationMatrix, int t) {
        int[][] res = new int[26][26];
        for (int i = 0; i < 26; ++i) {
            res[i][i] = 1;
        }

        while (t > 0) {
            if ((t & 1) == 1) {
                res = matrixMultiplication(transformationMatrix, res);
            }
            transformationMatrix = matrixMultiplication(transformationMatrix, transformationMatrix);
            t >>= 1;
        }
        return res;
    }

    public int lengthAfterTransformations(String s, int t, List<Integer> numsList) {
        // Convert List<Integer> to int[]
        int[] nums = numsList.stream().mapToInt(Integer::intValue).toArray();

        int[] initialFreq = new int[26];
        for (char c : s.toCharArray()) {
            initialFreq[c - 'a']++;
        }

        int[][] transformationMatrix = new int[26][26];
        for (int i = 0; i < 26; ++i) {
            for (int j = i + 1; j <= i + nums[i]; ++j) {
                transformationMatrix[j % 26][i]++;
            }
        }

        int[][] res = matrixExponentiation(transformationMatrix, t);
        int[] finalArray = new int[26];
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j) {
                finalArray[i] = (int)((finalArray[i] + (1L * res[i][j] * initialFreq[j]) % MOD) % MOD);
            }
        }

        int stringSize = 0;
        for (int i = 0; i < 26; ++i) {
            stringSize = (stringSize + finalArray[i]) % MOD;
        }
        return stringSize;
    }
}
