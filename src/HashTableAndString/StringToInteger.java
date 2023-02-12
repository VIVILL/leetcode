package HashTableAndString;

/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * 输入：s = "42"
 * 输出：42
 * 输入：s = "   -42"
 * 输出：-42
 */
public class StringToInteger {
    public static void main(String[] args) {
        System.out.println("myAtoi = " +  myAtoi( "42"));
        System.out.println("myAtoi = " +  myAtoi( "   -42"));
    }
    // https://leetcode.cn/problems/string-to-integer-atoi/solution/jin-liang-bu-shi-yong-ku-han-shu-nai-xin-diao-shi-/
/*解题思路：
这个问题其实没有考察算法的知识，模拟的是日常开发中对于原始数据的处理（例如「参数校验」等场景），如果面试中遇到类似的问题，应先仔细阅读题目文字说明和示例，有疑惑的地方和需要和面试官确认，在编码的时候需要耐心和细心地调试。

其实很多时候，业务需求就是类似这样的问题，工作中如果遇到：

1、有现成的工具和类库需尽量使用，因为它们是性能更优，且经过更严格测试，是相对可靠的；
2、能抽取成工具类、工具方法的尽量抽取，以突出主干逻辑、方便以后代码复用；
3、不得不写得比较繁琐、冗长的时候，需要写清楚注释、体现逻辑层次，以便上线以后排查问题和后续维护。
* */

    // https://leetcode.cn/problems/string-to-integer-atoi/solution/jin-liang-bu-shi-yong-ku-han-shu-nai-xin-diao-shi-/1058128
    public static int myAtoi(String s) {
        int sign = 1, ans = 0, index = 0;
        char[] array = s.toCharArray();
        while (index < array.length && array[index] == ' ') {
            index ++;
        }
        if (index < array.length && (array[index] == '-' || array[index] == '+')) {
            sign = array[index++] == '-' ? -1 : 1;
        }
        while (index < array.length && array[index] <= '9' && array[index] >= '0') {
            int digit = array[index++] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit;
        }
        return ans * sign;
    }
}
