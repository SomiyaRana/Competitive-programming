class Solution {
    public String triangleType(int[] arr) {
        int a = arr[0], b = arr[1], c = arr[2];

        // Check for triangle validity
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "none";
        }

        // Determine type of triangle
        if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || b == c || a == c) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}
