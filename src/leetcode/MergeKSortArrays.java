package leetcode;

import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class MergeKSortArrays {
    public static void main(String[] args) {
        //[1,4,5],[1,3,4],[2,6]
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));

        System.out.println(mergeKLists(new ListNode[]{null, null}));
    }
    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }
        ListNode[] result ;
        while (true) {

            int j=0;
            int resultSize;
            int loopCount;
            if ( lists.length %2 != 0) {
                //one is remaining
                resultSize = lists.length/2 +1;
                result = new ListNode[resultSize];
                result[resultSize-1] = lists[resultSize-1];
                loopCount =  result.length -1;

            } else {
                result = new ListNode[lists.length/2];
                loopCount =  result.length;
            }
            for (j=0; j < loopCount; j++) {
                result[j] = merge2Lists(lists[j], lists[ result.length + j]);
            }

            lists = result;
            if (result.length == 1) {
                return result[0];
            }
            result = null;
        }
    }

    public static ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode p = result;
        ListNode prev = p;
        if (l1 == null && l2 == null) {
            return null;
        }
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.val = l2.val;
                l2 = l2.next;
            } else {
                p.val = l1.val;
                l1 = l1.next;
            }

            p.next = new ListNode();
            prev = p;
            p = p.next;
        }

        while (l1 != null) {
            p.val = l1.val;
            l1 = l1.next;
            p.next = new ListNode();
            prev = p;
            p = p.next;
        }
        while (l2 != null) {
            p.val = l2.val;
            l2 = l2.next;
            p.next = new ListNode();
            prev = p;
            p = p.next;
        }

        prev.next = null;
        return result;
    }
}
