class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            char[] arr = Integer.toString(i).toCharArray();
            int count = 0;
            for (char c : arr) {
                int num = c - '0';
                if ((num != 0) && (i % num) == 0) count++;
            }
            if (count == arr.length) list.add(i);
        }
        return list;
    }
}