/*
 * Node class represents a single element of a Singly Linked List
 * Each node contains:
 * 1. data  -> value stored
 * 2. next  -> reference to the next node
 */
public class Node {

	int data; // Data stored in the node
	Node next; // Reference to the next node

	// Constructor to create a node
	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	public static void main(String[] args) {

		// ---- Creating initial linked list: 1 -> 2 -> 3 -> 4 -> 5 ----
		Node head = new Node(1, null);
		head.next = new Node(2, null);
		head.next.next = new Node(3, null);
		head.next.next.next = new Node(4, null);
		head.next.next.next.next = new Node(5, null);

		System.out.println("Initial Linked List:");
		printLinkedList(head);
		System.out.println("-------");

		// Insert at front
		head = insertNodeAtFront(head, 0);
		System.out.println("After Inserting at Front:");
		printLinkedList(head);
		System.out.println("-------");

		// Insert at end
		head = insertNodeAtEnd(head, 6);
		System.out.println("After Inserting at End:");
		printLinkedList(head);
		System.out.println("-------");

		// Insert at position
		head = insertNodeAtPosition(head, 7, 4);
		System.out.println("After Inserting at Position 4:");
		printLinkedList(head);
		System.out.println("-------");

		// Delete at front
		head = deleteNodeAtFront(head);
		System.out.println("After Deleting at Front:");
		printLinkedList(head);
		System.out.println("-------");

		// Delete at end
		head = deleteNodeAtEnd(head);
		System.out.println("After Deleting at End:");
		printLinkedList(head);
		System.out.println("-------");
	}

	/*
	 * Prints the linked list starting from head
	 * Time Complexity: O(n)
	 */
	public static void printLinkedList(Node head) {
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("null");
	}

	/*
	 * Inserts a node at the beginning of the list
	 * New node becomes the new head
	 */
	public static Node insertNodeAtFront(Node head, int data) {
		// Create new node pointing to current head
		Node newNode = new Node(data, head);

		// New node becomes head
		return newNode;
	}

	/*
	 * Inserts a node at the end of the list
	 */
	public static Node insertNodeAtEnd(Node head, int data) {

		// If list is empty, new node is the head
		if (head == null) {
			return new Node(data, null);
		}

		Node temp = head;

		// Traverse till the last node
		while (temp.next != null) {
			temp = temp.next;
		}

		// Attach new node at the end
		temp.next = new Node(data, null);
		return head;
	}

	/*
	 * Inserts a node at a specific position (0-based index)
	 * Example:
	 * position = 0 -> insert at front
	 */
	public static Node insertNodeAtPosition(Node head, int data, int position) {

		// Invalid position
		if (position < 0) {
			throw new IllegalArgumentException("Position cannot be negative");
		}

		// Insert at front
		if (position == 0) {
			return insertNodeAtFront(head, data);
		}

		// If list is empty and position > 0
		if (head == null) {
			throw new IllegalArgumentException("Position out of bounds");
		}

		Node temp = head;

		// Move to node just before the desired position
		for (int i = 0; i < position - 1; i++) {
			if (temp.next == null) {
				throw new IllegalArgumentException("Position out of bounds");
			}
			temp = temp.next;
		}

		// Insert new node
		Node newNode = new Node(data, temp.next);
		temp.next = newNode;

		return head;
	}

	/*
	 * Deletes the first node of the list
	 */
	public static Node deleteNodeAtFront(Node head) {

		// If list is empty, nothing to delete
		if (head == null) {
			return null;
		}

		// Second node becomes new head
		return head.next;
	}

	/*
	 * Deletes the last node of the list
	 */
	public static Node deleteNodeAtEnd(Node head) {

		// Empty list
		if (head == null) {
			return null;
		}

		// Single-node list
		if (head.next == null) {
			return null;
		}

		Node temp = head;

		// Traverse to the second-last node
		while (temp.next.next != null) {
			temp = temp.next;
		}

		// Remove last node
		temp.next = null;

		return head;
	}
}
