package GreedAndDynamicPlanning;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/assign-cookies/
 * 455. 分发饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 *
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。
 * 如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，
 * 并输出这个最大数值。
 *
  
 示例 1:

 输入: g = [1,2,3], s = [1,1]
 输出: 1
 解释:
 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 所以你应该输出1。
 示例 2:

 输入: g = [1,2], s = [1,2,3]
 输出: 2
 解释:
 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 所以你应该输出2.


 */
public class AssignCookies {
    public static void main(String[] args) {
        System.out.println("findContentChildren = " + findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println("findContentChildren = " + findContentChildren(new int[]{1, 2}, new int[]{1, 2,3}));

    }

    // https://leetcode.cn/problems/assign-cookies/solution/fen-fa-bing-gan-by-leetcode-solution-50se/
    // 为了尽可能满足最多数量的孩子，从贪心的角度考虑，应该按照孩子的胃口从小到大的顺序依次满足每个孩子，
    // 且对于每个孩子，应该选择可以满足这个孩子的胃口且尺寸最小的饼干。
    // 排序 + 双指针 + 贪心
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int m = g.length, n = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < m && j < n; i++, j++) {
            while (j < n && g[i] > s[j]) {
                j++;
            }
            if (j < n) {
                count++;
            }
        }
        return count;
    }

}
