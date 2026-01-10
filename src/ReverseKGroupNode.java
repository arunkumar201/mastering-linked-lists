import java.util.Stack;

public class ReverseKGroupNode {
	
	public static void main(String[] args) {
		// Input: head = [1,2,3,4,5], k = 2
		Node head = Node.buildLinkedList(new int[] { 1, 2, 3, 4, 5 });
		System.out.println("Original list:");
		Node.printLinkedList(head);
		// System.out.println("Reversed list:");
		// Node result = new ReverseKGroupNode().reverseKGroup_usingStack(head, 2);
		// Node.printLinkedList(result);
		System.out.println("Reversed list using reverseNode:");
		Node result2 = new ReverseKGroupNode().reverseKGroup(head, 2);
		Node.printLinkedList(result2);

	}

	public Node reverseNodeInGroup(Node head, int k) {

		Node current = head;
		Node prev = null;
		Node next = null;
		int count = 0;

		while (current != null && count < k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		return prev;
	}

	public Node reverseKGroup(Node head, int k) {

		//we will use similar approach as stack one 
		Node dummyNode = new Node(-1, null);
		Node prev = dummyNode;

		Node current = head;

		while (current != null) {
			Node temp = current;
			int count = 0;

			while (temp != null && count < k) {
				temp = temp.next;
				count++;
			}

			if (count < k) {
				prev.next = current;
				break;
			}
			// reverse exactly k nodes
			Node reversedHead = reverseNodeInGroup(current, k);

			prev.next = reversedHead;

			current.next = temp;

			prev = current;
			current = temp;
		}
		return dummyNode.next;
	}

	public Node reverseKGroup_usingStack(Node head, int k) {
		Stack<Node> stack = new Stack<>();
		Node current = head;

		Node dummyNode = new Node(-1, null);
		Node prev = dummyNode;

		while (current != null) {
			int count = 0;
			Node temp = current;
			
			//push the first k elements into the stack
			while (temp != null && count < k) {
				stack.push(temp);
				temp = temp.next;
				count++;
			}

			//we don't have k elements in the stack, so we don't need to reverse just 
			//connect the remaining nodes to prev node 
			if (count < k) {
				prev.next = current;
				break;
			}
			//if we found k elements in the stack, reverse them by popping from stack
			//connecting to prev Node 
			if (count == k) {
				// Reverse the group or pop k elements from stack
				while (count > 0) {
					prev.next = stack.pop();
					prev = prev.next;
					count--;
				}
			}
			prev.next = temp;
			current = temp;
		}
	
        return dummyNode.next;
    }
}
