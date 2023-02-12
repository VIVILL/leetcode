package StackQueueAndRecursion;

/**
 * 设计实现双端队列。
 *
 * 实现 MyCircularDeque 类:
 *
 * MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
 * boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
 * boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
 * boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
 * int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
 * int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
 * boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
 * boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/design-circular-deque
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
// https://leetcode.cn/problems/design-circular-deque/comments/735933
public class MyCircularDeque {
    private final int[] elements;
    private int size = 0, head = 0, tail;

    public MyCircularDeque(int k) {
        elements = new int[k];
        tail = k - 1;
    }
    public boolean insertFront(int value) {
        if (isFull()) return false;
        elements[head = head == 0 ? elements.length - 1 : head - 1] = value;// 头指针左移
        size++;
        return true;
    }
    public boolean  insertLast(int value) {
        if (isFull()) return false;
        elements[tail = tail == elements.length - 1 ? 0 : tail + 1] = value;// 尾指针右移
        size++;
        return true;
    }
    public boolean deleteFront() {
        if (isEmpty()) return false;
        head = head == elements.length - 1 ? 0 : head + 1;// 头指针右移
        size--;
        return true;
    }
    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = tail == 0 ? elements.length - 1 : tail - 1;// 尾指针左移
        size--;
        return true;
    }
    public int getFront() {
        if (isEmpty()) return -1;
        return elements[head];
    }
    public int getRear() {
        if (isEmpty()) return -1;
        return elements[tail];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == elements.length;
    }
}
