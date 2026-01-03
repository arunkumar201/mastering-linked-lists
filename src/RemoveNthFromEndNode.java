
public class RemoveNthFromEndNode {
	

	public static void main(String[] args) {
		// Input: head = [1,2,3,4,5], n = 2
		// Output: [1,2,3,5]
		Node head = new Node(1, null);
		head.next = new Node(2, null);
		head.next.next = new Node(3, null);
		head.next.next.next = new Node(4, null);
		head.next.next.next.next = new Node(5, null);

		System.out.println("Original list:");
		Node.printLinkedList(head);

		RemoveNthFromEndNode solution = new RemoveNthFromEndNode();
		Node result = solution.removeNthFromEnd_usingLen(head, 2);
		System.out.println("After removing 2nd node from end:");
		Node.printLinkedList(result);




		System.out.println("----");
		Node result2 = solution.removeNthFromEnd(head, 2);
		System.out.println("After removing 2nd node from end (two-pointer):");
		Node.printLinkedList(result2);

	}
	
	public int getLinkedListSize(Node head) {
		int count = 0;
		Node curr = head;

		while (curr != null) {
			curr = curr.next;
			count++;
		}
		return count;
	}
	
	public Node removeNthFromEnd_usingLen(Node head, int n) {
		int size = getLinkedListSize(head);
		int target = size - n - 1;

		if (target == 0) {
			head = head.next;
			return head;
		}

		Node curr = head;

		while (target != 1 && curr != null) {
			curr = curr.next;
			target--;
		}

		if (curr.next != null && curr.next.next != null) {
			curr.next = curr.next.next;
		} else {
			curr.next = null;
		}
		return head;
	}
	public Node removeNthFromEnd(Node head, int n) {
		Node slow = head;
		Node fast = head;

		if (head==null ||  head.next==null) {
			return head.next;
		}

		//move the fast pointer to n steps
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
// if fast is null, we must remove head
		if (fast == null) {
			return head.next;
		}
		// move both until fast.next is null 
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		System.out.println("--------"+slow.data);
		if (slow.next != null && slow.next.next != null) {
			slow.next = slow.next.next;
		} else {
			slow.next = null;
		}

		return head;

	}
}
