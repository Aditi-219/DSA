class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isDivisible(i)) result.add(i);
        }
        return result;
    }
    public boolean isDivisible(int num) {
        int temp = num;
        while (temp > 0) {
            int rem = temp % 10;
            if (rem == 0 || num % rem != 0) return false;
            temp /= 10;
        }
        return true;
    }
}