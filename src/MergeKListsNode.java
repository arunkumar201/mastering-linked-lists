import java.util.PriorityQueue;

public class MergeKListsNode {
	
	public static void main(String[] args) {
		// Input: lists = [[1,4,5],[1,3,4],[2,6]]
		// Expected output: [1,1,2,3,4,4,5,6]
		
		Node n1 = new Node(1, new Node(4, new Node(5, null)));
		Node n2 = new Node(1, new Node(3, new Node(4, null)));
		Node n3 = new Node(2, new Node(6, null));
		
		Node[] lists = {n1, n2, n3};

		MergeKListsNode solution = new MergeKListsNode();
		Node result = solution.mergeKLists(lists);
		System.out.println("Merged list: ");
		Node.printLinkedList(result);

	}
	
	// Time Complexity: O(N log k) where N is total number of nodes and k is number
	// of lists
	// Space Complexity: O(k) for the priority queue
	// where k is the number of linked lists and N is the total number of nodes
	public Node mergeKLists(Node[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		//MIN_HEAP  - in java PriorityQueue is a min heap by default but here we need to specify comparator for Node objects to compare their data values
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
		
		for (Node list : lists) {
			if (list != null) {
				pq.add(list);
			}
		}
		
		Node dummy = new Node(-1, null);
		Node current = dummy;

		while (!pq.isEmpty()) {
			Node minNode = pq.poll();
			current.next = minNode;
			current = current.next;
			// as we are adding the first node from each list into the priority queue, 
			// we need to make sure we should add the next node if curr minNode has next
			// this ensures we continue merging nodes from the same list in order
			if (minNode.next != null) {
				pq.add(minNode.next);
			}
		}
		
		return dummy.next;
	}
}
