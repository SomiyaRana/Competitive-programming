class Solution:
    def findThePrefixCommonArray(self, A, B):
        n = len(A)
        C = [0] * n
        seen_in_A = set()
        seen_in_B = set()
        common_count = 0

        for i in range(n):
            # Add current elements from A and B to their respective seen sets
            seen_in_A.add(A[i])
            seen_in_B.add(B[i])

            # Check how many elements are common between the two sets up to this index
            if A[i] in seen_in_B:
                common_count += 1
            if B[i] in seen_in_A and B[i] != A[i]:  # Avoid double-counting when A[i] == B[i]
                common_count += 1

            # Update the prefix common array
            C[i] = common_count

        return C
