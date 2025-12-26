public class ReverseLinkedList_lc {
	
	public static void main(String[] args) {
		// Input: head = [1,2,3,4,5]
		// Output: [5,4,3,2,1]
		Node head = new Node(1, null);
		head.next = new Node(2, null);
		head.next.next = new Node(3, null);
		head.next.next.next = new Node(4, null);
		head.next.next.next.next = new Node(5, null);


		ReverseLinkedList_lc reverseLinkedList_lc = new ReverseLinkedList_lc();
		System.out.println("before reverseList");
		Node.printLinkedList(head);
		System.out.println("---- reverseList ----");
		Node.printLinkedList(reverseLinkedList_lc.reverseList(head));
		System.out.println("-------");

	}
	
	public Node reverseList(Node head) {
		
		if (head == null || head.next == null) {
			return head;
		}

		Node curr = head;
		Node prevNode = null;
		Node nextNode = null;


		while (curr != null) {
			// store next node - to avoid loss of next node
			nextNode = curr.next;
			//as curr.next needs to become null (first node) or having pointer to previous node 
			curr.next = prevNode;
			//move prevNode to curr
			prevNode = curr;
			//move curr to nextNode
			curr = nextNode;
		}
		return prevNode;
    }
}
