package SortAndBinarySearch;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * 链接：https://leetcode.cn/problems/sqrtx
 输入：x = 4
 输出：2
 输入：x = 8
 输出：2
 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 */
public class Sqrt {

    public static void main(String[] args) {
        System.out.println("mySqrt 4 = " + mySqrt(4));
        System.out.println("mySqrt 8 = " + mySqrt(8));
        System.out.println("mySqrt 9 = " + mySqrt(9));

        System.out.println("mySqrt1 4 = " + mySqrt1(4));
        System.out.println("mySqrt1 8 = " + mySqrt1(8));
        System.out.println("mySqrt1 9 = " + mySqrt1(9));
    }


    /*
    * 思路分析
从题目的要求和示例我们可以看出，这其实是一个查找整数的问题，并且这个整数是有范围的。

如果这个整数的平方 恰好等于 输入整数，那么我们就找到了这个整数；
如果这个整数的平方 严格大于 输入整数，那么这个整数肯定不是我们要找的那个数；
如果这个整数的平方 严格小于 输入整数，那么这个整数 可能 是我们要找的那个数（重点理解这句话）。
因此我们可以使用「二分查找」来查找这个整数，不断缩小范围去猜。

猜的数平方以后大了就往小了猜；
猜的数平方以后恰恰好等于输入的数就找到了；
猜的数平方以后小了，可能猜的数就是，也可能不是。
    * */
    // https://leetcode.cn/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/
    // 二分法
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int left = 1;
        int right = x / 2;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else if (mid == x / mid) {
                // 由于本题特殊性，如果 mid == x / mid 就找到了答案，其它问题不一定可以这样
                return mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    // https://leetcode.cn/problems/sqrtx/solution/niu-dun-die-dai-fa-by-loafer/
    // 牛顿迭代法
    static int s;
    public static int mySqrt1(int x) {
        s=x;
        if(x==0) return 0;
        return ((int)(sqrt(x)));
    }

    public static double sqrt(double x){
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrt(res);
        }
    }


}
