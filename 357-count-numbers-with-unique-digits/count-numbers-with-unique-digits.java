class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int count = 0;
        int limit = (int) Math.pow(10, n);
        for (int i = 0; i < limit; i++) {
            if (hasUniqueDigits(i)) count++;
        }
        return count;
    }
    private boolean hasUniqueDigits(int num) {
        boolean[] seen = new boolean[10];
        if (num == 0) return true;
        while (num > 0) {
            int digit = num % 10;
            if (seen[digit]) return false;
            seen[digit] = true;
            num /= 10;
        }
        return true;
    }
}
// public class Solution {
//     public int countNumbersWithUniqueDigits(int n) {
//         if (n == 0) return 1;
//         int result = 10;
//         int uniqueDigits = 9;
//         int availableNumbers = 9;
//         while (n-- > 1 && availableNumbers > 0) {
//             uniqueDigits *= availableNumbers;
//             result += uniqueDigits;
//             availableNumbers--;
//         }
//         return result;
//     }
// }