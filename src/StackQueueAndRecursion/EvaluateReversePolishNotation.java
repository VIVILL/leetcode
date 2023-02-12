package StackQueueAndRecursion;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 *
 * 请你计算该表达式。返回一个表示表达式值的整数。
 *
 * 注意：
 *
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 * 链接：https://leetcode.cn/problems/evaluate-reverse-polish-notation
 *
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        //输入 ["2","1","+","3","*"]  输出 9
        // 计算过程 2+1 = 3  3 * 3 = 9
        String[] s = {"2","1","+","3","*"} ;
        System.out.println("evalRPN  = " + evalRPN(s));
    }
    // 分析
    //https://leetcode.cn/problems/evaluate-reverse-polish-notation/solution/xiang-jie-ni-bo-lan-biao-da-shi-fu-ben-t-sfl6/
/*
* 逆波兰表达式，也叫做后缀表达式。

我们平时见到的运算表达式是中缀表达式，即 "操作数① 运算符② 操作数③" 的顺序，运算符在两个操作数中间。
但是后缀表达式是 "操作数① 操作数③ 运算符②" 的顺序，运算符在两个操作数之后。

各种表达式没有本质区别，他们其实是同一个语法树，只是遍历方式不同而得到的不同式子；是一个事物的一体多面，只不过是从不同角度观察罢了。

中缀表达式是其对应的语法树的中序遍历；
后缀表达式是其对应的语法树的后序遍历；
前缀表达式是其对应的语法树的前序遍历；

* 求值方法
对逆波兰表达式求值的过程是：

如果遇到数字就进栈；
如果遇到操作符，就从栈顶弹出两个数字分别为 num2（栈顶）、num1（栈中的第二个元素）；计算 num1 运算 num2

作者：fuxuemingzhu
链接：https://leetcode.cn/problems/evaluate-reverse-polish-notation/solution/xiang-jie-ni-bo-lan-biao-da-shi-fu-ben-t-sfl6/
* */

    //java 版本代码 https://leetcode.cn/problems/evaluate-reverse-polish-notation/solution/by-carlsun-2-a0vh/
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList();
        for (String s : tokens) {
            if ("+".equals(s)) {
                stack.push(stack.pop() + stack.pop());      // 注意 - 和/ 需要特殊处理
            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }

}
