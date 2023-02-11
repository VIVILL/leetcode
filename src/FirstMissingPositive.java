import java.util.Arrays;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
public class FirstMissingPositive {
    // https://leetcode.cn/problems/first-missing-positive/solution/tianyu-by-deanwinchester-7njg/
    public static int firstMissingPositive1(int[] nums) {
        Arrays.sort(nums);
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > k) {
                return k;
            }
            if (num == k) {
                ++k;
            }
        }
        return k;
    }

    // https://leetcode.cn/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/
    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(nums, nums[i] - 1, i);
            }
        }

        // [1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void main(String[] args) {
        // -1 0  5 7
        int[] nums = {-1,0,5,7};
        // 結果為1
        System.out.println("firstMissingPositive result  = " +  firstMissingPositive(nums));
        System.out.println("result  = " +  firstMissingPositive1(nums));
    }
}
