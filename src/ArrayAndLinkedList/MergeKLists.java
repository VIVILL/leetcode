package ArrayAndLinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.cn/problems/merge-k-sorted-lists/comments/64343
public class MergeKLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            pq.add(list);
        }

        while (!pq.isEmpty()) {
            ListNode nextNode = pq.poll();
            curr.next = nextNode;
            curr = curr.next;
            if (nextNode.next != null) {
                pq.add(nextNode.next);
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        // 输入 [[1,listNode2],[1,listNode3],[2,ArrayAndLinkedList.ListNode(6)]]  输出 [1,1,2,6]
        ListNode listNode3 = new ListNode(2,new ListNode(6));
        ListNode listNode2 = new ListNode(1,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        ListNode[] listNodes = {listNode1, listNode2,listNode3};
        // 打断点可查看生成的数据 dummyHead.next
        mergeKLists(listNodes);
    }
}

