import java.lang.classfile.components.ClassPrinter.ListNode;
import java.util.HashSet;

public class LinkedListCycle {
	

	public static void main(String[] args) {
		// Input: head = [3,2,0,-4], pos = 1
		// Create linked list: 3 -> 2 -> 0 -> -4 -> 2 (cycle)
		Node n1 = new Node(3, null);
		Node n2 = new Node(2, null);
		Node n3 = new Node(0, null);
		Node n4 = new Node(-4, null);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n2; // create cycle

		System.out.println("Using the HashSet Approach");
		
		LinkedListCycle solution = new LinkedListCycle();
		System.out.println("Has cycle: " + solution.hasCycle_HashSet(n1));

		System.out.println("Using Floyd's Cycle Detection Algorithm");
		System.out.println("Has cycle: " + solution.hasCycle_Floyd(n1));
	}


	public boolean hasCycle_HashSet(Node head) {
		
		if (head == null || head.next == null) {
			return false;
		}
			boolean hasCycle = false;
			HashSet<Node> visited = new HashSet<>();

			Node current = head;
			while (current != null) {
				if (visited.contains(current)) {
					hasCycle = true;
					break;
				}
				visited.add(current);
				current = current.next;
			}
        return hasCycle;
    }
	
	public boolean hasCycle_Floyd(Node head) {
		if (head == null || head.next == null) {
			return false;
		}
		Node slow = head;
		Node fast = head;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
}
