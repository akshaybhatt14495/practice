package leetcode;

import java.awt.*;

class ListNode1 {
     int val;
     ListNode1 next;
     ListNode1() {}
     ListNode1(int val) { this.val = val; }
     ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
}

public class LinkedListSum {
    public static ListNode1 addTwoNumbers(ListNode1 l1, ListNode1 l2) {
        ListNode1 sol = new ListNode1();
        ListNode1 pointer = sol;
        ListNode1 prevPointer = null;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            pointer.val = sum %10;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            prevPointer = pointer;
            pointer.next = new ListNode1();;
            pointer = pointer.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            pointer.val = sum %10;
            carry = sum / 10;
            prevPointer = pointer;
            pointer.next = new ListNode1();;
            pointer = pointer.next;
            l2 = l2.next;
        }


        while (l1 != null) {
            int sum = l1.val + carry;
            pointer.val = sum %10;
            carry = sum / 10;
            prevPointer = pointer;
            pointer.next = new ListNode1();;
            pointer = pointer.next;
            l1 = l1.next;
        }
        if (carry > 0 ) {
            prevPointer.next.val = carry;
        } else {
            prevPointer.next = null;
        }
        return sol;
    }

    public static void main(String[] args) {
        /*
        9,9,9,9,9,9,9]
         */
        ListNode1 l1 = new ListNode1(9, new ListNode1(9, new ListNode1(9, new ListNode1(9))));
        ListNode1 l2 = new ListNode1(9, new ListNode1(9, new ListNode1(9, new ListNode1(9, new ListNode1(9, new ListNode1(9, new ListNode1(9)))))));
        ListNode1 l3 = addTwoNumbers(l1,l2);
        while (l3 != null ) {
            System.out.println(l3.val);
            l3 = l3.next;
        }

    }
}
