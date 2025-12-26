
public class AddTwoNumbers_lc {
	
	public static void main(String[] args) {
		// Input: l1 = [2,4,3], l2 = [5,6,9,9,9,9]
		// Output: [7,0,3,0,0,0,1]
		Node l1 = new Node(2, null);
		l1.next = new Node(4, null);
		l1.next.next = new Node(3, null);

		Node l2 = new Node(5, null);
		l2.next = new Node(6, null);
		l2.next.next = new Node(9, null);
		l2.next.next.next = new Node(9, null);
		l2.next.next.next.next = new Node(9, null);
		l2.next.next.next.next.next = new Node(9, null);

		AddTwoNumbers_lc addTwoNumbers_lc = new AddTwoNumbers_lc();
		Node result = addTwoNumbers_lc.addTwoNumbers(l1, l2);
		Node.printLinkedList(result);
		

	}
	
	public Node addTwoNumbers(Node l1, Node l2) {

		Node dummyHead = new Node(-1, null);
		Node current = dummyHead;
		int carry = 0;

		while (l1 != null || l2 != null) {
			int sum = 0;

			if (l1 != null) {
				sum += l1.data;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.data;
				l2 = l2.next;
			}
			sum += carry;
			carry = sum / 10;
			int digit = sum % 10;
			current.next = new Node(digit, null);
			current = current.next;
		}

		if (carry > 0) {
			current.next=new Node(carry, null);
		}
		return dummyHead.next;
		
        
    }
}
