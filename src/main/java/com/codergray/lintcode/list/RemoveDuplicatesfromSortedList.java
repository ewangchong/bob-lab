package com.codergray.lintcode.list;


public class RemoveDuplicatesfromSortedList {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		n1.next = n2;
		ListNode n3 = new ListNode(2);
		n2.next = n3;

		ListNode x = deleteDuplicates(n1);
		x.print();
	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode pre = head;
		if (head == null || head.next == null)
			return head;
		ListNode curr = head.next;
		while (curr!= null) {
			if (pre.val == curr.val) {
				pre.next = curr.next;
			} else {
				pre = pre.next;
			}
			curr = curr.next;
		}

		return head;
	}

}
