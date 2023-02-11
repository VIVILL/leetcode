import java.util.Arrays;

public class MajorityElement {


    // https://leetcode.cn/problems/majority-element/solution/duo-shu-yuan-su-tong-gui-yu-jin-fa-by-st-y2le/
    public static int majorityElement(int[] nums) {
        int win = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == win) {
                count++;
            } else if (count == 0) {
                win = nums[i];
                count = 1;
            } else {
                count--;
            }
        }
        return win;

    }

    //https://leetcode.cn/problems/majority-element/solution/3chong-fang-fa-by-gfu-2/
    // 排序思路
    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        // https://leetcode.cn/problems/majority-element/solution/duo-shu-yuan-su-tong-gui-yu-jin-fa-by-st-y2le/
        // 因为多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 你的测试用例，⌊9/2⌋=4，
        // 3的个数是4不满足大于4，1的个数是3也不满足大于4，剩余元素也是如此。没有一个元素的个数满足这个条件。
        // 结果 1
        //int[] nums = {3,3,3,3,2,2,1,1,1};
        System.out.println("majorityElement result  = " +  majorityElement(nums));
        System.out.println("majorityElement1 result  = " +  majorityElement1(nums));

    }
}
