class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(k, 1, n, new ArrayList<>(), ans);
        return ans; 
    }
    public static void findCombination(int k, int num, int target, ArrayList<Integer> list, List<List<Integer>> ans) {
        if (target == 0 && k == 0) ans.add(new ArrayList<>(list));
        for (int i = num; i < 10; i++) {
            if (i > target || k <= 0) break;
            list.add(i);
            findCombination(k - 1, i + 1, target - i, list, ans);
            list.remove(list.size() - 1);
        }
    }
}