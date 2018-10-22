package com.codergray.lintcode.list;


public class LinkedListCycleI {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
//		node6.next=node7;
		
		System.out.println(LinkedListCycleI.hasCycle(node1));
		
		
	}

	public static boolean hasCycle(ListNode head) {
		
		if(head==null || head.next==null || head.next.next==null)
			return false;
		
		ListNode node1 = head.next;
		ListNode node2 = head.next.next;
		while(null!=node2 && null!=node2.next){
			node1 = node1.next;
			node2 = node2.next.next;
			if(node1==node2)
				return true;
		}
		
		return false;
	}
}