package com.jy;

public class Main {

	public static void main(String[] args) {
		// 构造链表
		ListNode listNode3 = new ListNode(3, null);
		ListNode listNode2 = new ListNode(2, listNode3);
		ListNode listNode1 = new ListNode(1, listNode2);
		// 头结点
		ListNode headNode = listNode1;

		System.out.print("删除前的链表:");
		for (ListNode node = headNode; node != null; node = node.mNext) {
			System.out.print(node.mValue + "->");
		}

		System.out.println();

		// 删除节点
		System.out.println("删除的节点：" + listNode2.mValue);
		deleteNode(headNode, listNode2);
		
		System.out.print("删除后的链表:");
		for (ListNode node = headNode; node != null; node = node.mNext) {
			System.out.print(node.mValue + "->");
		}
	}

	private static void deleteNode(ListNode headNode, ListNode toBeDeletedNode) {
		// 鲁棒性检查
		if (headNode == null || toBeDeletedNode == null)
			return;

		if (toBeDeletedNode.mNext != null) { // 不是尾节点
			// 先获取待删节点的下一个节点
			ListNode temp = toBeDeletedNode.mNext;
			// 再将待删节点的值赋给待删节点
			toBeDeletedNode.mValue = toBeDeletedNode.mNext.mValue;
			toBeDeletedNode.mNext = toBeDeletedNode.mNext.mNext;
			// 然后删除待删节点的下一个节点
			temp = null;
		} else if (headNode == toBeDeletedNode) { // 是尾节点，且链表只有1个节点
			headNode = null;
			toBeDeletedNode = null;
		} else { // 是尾节点，且链表有多个节点
			// 从头节点开始往后顺序查找
			ListNode preNode = headNode;
			while (preNode.mNext != toBeDeletedNode)
				preNode = preNode.mNext;
			preNode.mNext = null;
			toBeDeletedNode = null;
		}
	}

}
