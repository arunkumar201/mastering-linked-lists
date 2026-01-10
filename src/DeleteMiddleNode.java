
public class DeleteMiddleNode {
	
	public static void main(String[] args) {
		// Input: head = [1,3,4,7,1,2,6]
		Node head = new Node(1, null);
		head.next = new Node(3, null);
		head.next.next = new Node(4, null);
		head.next.next.next = new Node(7, null);
		head.next.next.next.next = new Node(1, null);
		head.next.next.next.next.next = new Node(2, null);
		head.next.next.next.next.next.next = new Node(6, null);

		DeleteMiddleNode solution = new DeleteMiddleNode();
		Node result = solution.deleteMiddle(head);
		Node.printLinkedList(result);
	}
	
	public Node deleteMiddle(Node head) {
		if (head == null || head.next == null) {
			return null;
		}

		Node slow = head;
		Node fast = head;
		Node prev = null;


		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		prev.next = slow.next;
		
        return head;
    }
}
