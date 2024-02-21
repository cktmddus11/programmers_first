import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8};
        int target = 10;
        List<List<Integer>> subsets = findSubsets(nums, target);
        subsets.forEach(System.out::println);
    }

    public static List<List<Integer>> findSubsets(int[] nums, int target) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private static void backtrack(int[] nums, int target, int index, List<Integer> current, List<List<Integer>> subsets) {
        System.out.format("nums : %d, target : %d, index : %d", Arrays.toString(nums), target, index);
        if (target == 0) {
            subsets.add(new ArrayList<>(current));
            return;
        }

        if (index >= nums.length || target < 0) {
            return;
        }

        backtrack(nums, target, index + 1, current, subsets);

        List<Integer> newSubset = new ArrayList<>(current);
        newSubset.add(nums[index]);
        backtrack(nums, target - nums[index], index + 1, newSubset, subsets);
    }
}
