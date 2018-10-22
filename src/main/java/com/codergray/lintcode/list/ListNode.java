package com.codergray.lintcode.list;

public class ListNode {
	int val;
	ListNode next;
	public ListNode(int x) {
		val = x;
		next = null;
	}
	public void print() {
		ListNode head = this;
		System.out.print(head.val);
		while(true){
			head=head.next;
			if(head!=null)
				System.out.print("->"+head.val);
			else
				break;
		}
	}
}