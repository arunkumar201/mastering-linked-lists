import java.util.Stack;

public class ReorderListNode {
	
	public static void main(String[] args) {
		// Input: head = [1,2,3,4]

		Node head = new Node(1, null);
		head.next = new Node(2, null);
		head.next.next = new Node(3, null);
		head.next.next.next = new Node(4, null);

		ReorderListNode solution = new ReorderListNode();
		// solution.reorderList(head);
		// Node.printLinkedList(head);

		solution.reorderListUsingStack(head);
		Node.printLinkedList(head);

	}
	
	public Node reverseList(Node head) {
		Node currNode=head;
		Node prevNode=null;
		Node nextNode = null;
		
		while (currNode != null) {
			nextNode = currNode.next;

			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;

		}

		return prevNode;
		
	}
	
	public void reorderList(Node head) {
		if (head == null || head.next == null) {
			return;
		}

		//find the middle node
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Node secondHalf = slow.next;
		slow.next = null;

		Node reverseHead = reverseList(secondHalf);
		Node firstHalf = head;

		while (firstHalf != null && reverseHead != null) {
			Node temp1 = firstHalf.next;
			Node temp2 = reverseHead.next;

			//reorder the nodes
			firstHalf.next = reverseHead;
			reverseHead.next = temp1;

			//move to next nodes
			firstHalf = temp1;
			reverseHead = temp2;
		}

	}
	
	//using stack
	public void reorderListUsingStack(Node head) {
		int nodeCounts = 0;

		Stack<Node> stack = new Stack<>();

		Node curr = head;

		while (curr != null) {
			stack.push(curr);
			curr = curr.next;
		}
		nodeCounts = stack.size();
		
		Node firstHalfNode = head;


		int count=0;
		while (count < (nodeCounts / 2)) {
			Node temp1 = firstHalfNode.next;
			Node secondHalfNode = stack.pop();

			firstHalfNode.next = secondHalfNode;
			secondHalfNode.next = temp1;

			firstHalfNode = temp1;

			count++;
		}

		firstHalfNode.next = null;
		
	}
}
