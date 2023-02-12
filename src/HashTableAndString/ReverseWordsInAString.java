package HashTableAndString;

import java.util.Arrays;
import java.util.Collections;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 * 示例 1：
 *
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 *
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * 链接：https://leetcode.cn/problems/reverse-words-in-a-string
 */
public class ReverseWordsInAString {

    // https://leetcode.cn/problems/reverse-words-in-a-string/comments/123146

    // 6ms 版本
    /*
分三步:
先翻转整个数组
再翻转单个单词
清除多余空格
    * */
    public String reverseWords(String s) {
        if (s == null) return null;
        char[] s_arr = s.toCharArray();
        int n = s_arr.length;
        // 翻转这个数组
        reverse(s_arr, 0, n - 1);
        System.out.println(new String(s_arr));
        // 翻转每个单词
        word_reverse(s_arr, n);
        System.out.println(new String(s_arr));
        // 去除多余空格
        return clean_space(s_arr, n);
    }

    private void reverse(char[] s_arr, int i, int j) {
        while (i < j) {
            char t = s_arr[i];
            s_arr[i++] = s_arr[j];
            s_arr[j--] = t;
        }
    }

    private void word_reverse(char[] s_arr, int n) {
        int i = 0;
        int j = 0;
        while (j < n) {
            // 找到第一个首字母
            while (i < n && s_arr[i] == ' ') i++;
            j = i;
            // 末位置
            while (j < n && s_arr[j] != ' ') j++;
            reverse(s_arr, i, j - 1);
            i = j;
        }
    }

    private String clean_space(char[] s_arr, int n) {
        int i = 0;
        int j = 0;
        while (j < n) {
            while (j < n && s_arr[j] == ' ') j++;
            while (j < n && s_arr[j] != ' ') s_arr[i++] = s_arr[j++];
            while (j < n && s_arr[j] == ' ') j++;
            if (j < n) s_arr[i++] = ' ';
        }
        return new String(s_arr).substring(0, i);
    }



    //2ms 版本
    public String reverseWords1(String s) {
        char[] ch = s.toCharArray();
        reverse1(ch, 0, ch.length - 1);
        int k = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                continue;
            }
            int tempidx = i;
            while (i < ch.length && ch[i] != ' ') {
                i++;
            }
            for (int j = tempidx; j < i; j++) {
                if (j == tempidx) {
                    reverse1(ch, j, i - 1);
                }
                ch[k] = ch[j];
                k++;
                if (j == i - 1) {
                    if (k < ch.length) {
                        ch[k++] = ' ';
                    }
                }
            }

        }
        if (k == 0) {
            return "";
        } else {
            return new String(ch, 0, (k == ch.length) && (ch[k - 1] != ' ') ? k : k - 1);
        }
    }
    private void reverse1(char[] c, int left, int right) {
        while (left < right) {
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }
    }

    // 使用 split和reverse api 的版本
    public String reverseWords2(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
