package StackQueueAndRecursion;

public class CircularDequeTest {
    public static void main(String[] args) {
/*
*
* 输入
["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
输出
[null, true, true, true, false, 2, true, true, true, 4]
输入这里的参数代表了对应了函数和相应的参数
输出代表函数调用返回的结果
* */
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        System.out.println("insertLast  = " + circularDeque.insertLast(1));// 返回 true
        System.out.println("insertLast  = " + circularDeque.insertLast(2));// 返回 true
        System.out.println("insertFront  = " + circularDeque.insertFront(3));// 返回 true
        System.out.println("insertFront  = " + circularDeque.insertFront(4));// 已经满了，返回 false
        System.out.println("getRear  = " +  circularDeque.getRear());// 返回 2
        System.out.println("isFull  = " +   circularDeque.isFull());// 返回 true
        System.out.println("deleteLast  = " +   circularDeque.deleteLast());// 返回 true
        System.out.println("insertFront  = " +   circularDeque.insertFront(4));// 返回 true
        System.out.println("getFront  = " +   circularDeque.getFront());// 返回 4

    }
}
