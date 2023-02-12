package HashTableAndString;

import java.util.Arrays;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-string
 输入：s = ["h","e","l","l","o"]
 输出：["o","l","l","e","h"]
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        // reverseString = [o, l, l, e, h]
        System.out.println("reverseString = " + Arrays.toString(reverseString(s)));
    }

    // https://leetcode.cn/problems/reverse-string/comments/618798
    public static char[] reverseString(char[] s) {
        int len = s.length,size = len;
        for(int i = 0;i < len/2;i++){
            size--;
            char tmp = s[i];
            s[i] = s[size];
            s[size] = tmp;
        }
        return s;
    }
}
