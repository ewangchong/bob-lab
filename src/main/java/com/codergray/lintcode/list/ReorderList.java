package com.codergray.lintcode.list;

public class ReorderList {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		reorderList(n1);

	}

	public static void reorderList(ListNode head) {

		if (head != null && head.next != null) {
			ListNode fast = head;
			ListNode slow = head;

			// use fast and slow pointer to get two lists
			while (fast != null && fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}

			ListNode second = slow.next;
			slow.next = null;

			// reverse second list

			ListNode pre = second;
			ListNode curr = second.next;

			while (curr != null) {
				ListNode temp = curr.next;
				curr.next = pre;
				pre = curr;
				curr = temp;
			}

			// set head node's next
			second.next = null;

			second = pre;

			ListNode p1 = head;
			ListNode p2 = second;

			// merge two lists here
			while (p2 != null) {
				ListNode temp1 = p1.next;
				ListNode temp2 = p2.next;

				p1.next = p2;
				p2.next = temp1;

				p1 = temp1;
				p2 = temp2;
			}

		}
	}

}
