

public class Test {
    public static void main(String[] args) {
        Sum sum = new Sum();
//        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {-1,0,1};
//        int[] nums = {-1,-1,0,1,1};
//        int[] nums = {0,0,0};
//        int[] nums = {0,1,1};
//        int[] nums = {-2,0,0,2,2};
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println("result  = " + sum.threeSum(nums));

// 输入 [[1,listNode2],[1,listNode3],[2,ListNode(6)]]  输出 [1,1,2,6]
        MergeKLists mergeKLists = new MergeKLists();
        ListNode listNode3 = new ListNode(2,new ListNode(6));
        ListNode listNode2 = new ListNode(1,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        ListNode[] listNodes = {listNode1, listNode2,listNode3};
        // 打断点可查看生成的数据 dummyHead.next
        mergeKLists.mergeKLists(listNodes);
    }




}
