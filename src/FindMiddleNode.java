import java.lang.classfile.components.ClassPrinter.ListNode;

public class FindMiddleNode {
	

	public static void main(String[] args) {
		
		// Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
		Node head = new Node(1, null);
		head.next = new Node(2, null);
		head.next.next = new Node(3, null);
		head.next.next.next = new Node(4, null);
		head.next.next.next.next = new Node(5, null);

		FindMiddleNode finder = new FindMiddleNode();
		Node middle = finder.findMiddle(head);
		System.out.println("Middle node value: " + middle.data); // Should print 3

	}
	
	
	public Node findMiddle(Node head) {
		if (head == null || head.next == null)
			return head;

		//Approach -1 find the length of the list and then traverse to middle
		//Approach -2 use tortoise and hare technique or slow and fast pointers or flyod's cycle detection
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// this will point to the middle node
		return slow;
	}
	
	// Palindrome linked list check
	public boolean isPalindrome(Node head) {

		// step-1 Find middle
		Node middleNode = findMiddle(head);

		// step-2 Reverse second half starting from middleNode
		Node secondHalf = reverseList(middleNode);

		// step-3 Compare first half with reversed second half
		Node curr = head;
		Node secondCurr = secondHalf;

		while (secondCurr != null) {
			if (curr.data != secondCurr.data) {
				return false;
			}
			curr = curr.next;
			secondCurr = secondCurr.next;
		}

		return true;
	}
	
	// Helper method to reverse a linked list 
	private Node reverseList(Node head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		Node curr = head;
		Node prev = null;
		Node nextNode = null;

		while (curr != null) {
			nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextNode;
		}
		return prev;
	}

	// Merge sort on linked list
	public Node mergeTwoLists(Node list1, Node list2) {

		Node dummyNode = new Node(-1, null);

		Node curr = dummyNode;

		Node l1 = list1;
		Node l2 = list2;

		while (l1 != null && l2 != null) {
			if (l1.data <= l2.data) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		// attach rest of the nodes if any list remains
		if (l1 != null) {
			curr.next = l1;
		} else if (l2 != null) {
			curr.next = l2;
		}

		return dummyNode.next;
	}
	
}
