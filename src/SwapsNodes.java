
public class SwapsNodes {

	public static void main(String[] args) {
		// Input: head = [1,2,3,4,5], k = 2
		// Node head = Node.buildLinkedList(new int[]{1, 2, 3, 4, 5});
		Node head = Node.buildLinkedList(new int[] { 7, 9, 6, 6, 7, 8, 3, 0, 9, 5 });

		SwapsNodes solution = new SwapsNodes();
		Node result = solution.swapNodes(head, 5);
		Node.printLinkedList(result);
	}

	public Node swapNodes(Node head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		Node kthNodeFromStart = head;
		Node slow = head;
		Node fast = head;

		int i = 1;

		while (i < k && kthNodeFromStart != null) {
			kthNodeFromStart = kthNodeFromStart.next;
			i++;
		}
		fast = kthNodeFromStart;

		while (fast != null && fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		

		//swap the nodes - swap the values
		int temp = slow.data;
		slow.data = kthNodeFromStart.data;
		kthNodeFromStart.data = temp;
	
		
		return head;
	}
}
