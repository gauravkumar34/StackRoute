
public class DoublyLinkedList {
    public Node head;

    public void insertBegin(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.previous = null;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        Node temp = null;
        if (head == null) {
            head = newNode;
            head.previous = null;
        } else {
            temp = head;
            // goto the end of the list
            while (temp.next != null) {
                temp = temp.next;
            }

            // reached end of the list
            temp.next = newNode;
            newNode.previous = temp;
            newNode.next = null;
        }
    }

    public void forwardTraversal() {
        Node current = head;
        if (current == null)
            return;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public void reverseTraversal() {
        Node current = head;
        if (current == null)
            return;
        while (current.next != null) {
            current = current.next;
        }
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.previous;
        }
    }

    public void delete(int data) {
        Node curr = head;
        Node temp = null;
        if (curr == null)
            return;
        if (curr.data == data) {
            curr = curr.next;
            return;
        }
        while (curr != null && curr.data != data) {
            temp = curr;
            curr = curr.next;
        }
        if (curr.next != null) {
            curr.next.previous = curr.previous;
        }
        if (curr.previous != null) {
            curr.previous.next = curr.next;
        }
        return;
    }

    public void insertAtMiddle(int data, int postion) {
        Node newNode = new Node(data);
        if (postion < 0 || postion > getSize())
            System.out.println("Invalid Postion");
        if (postion == 0) {
            newNode.next = head;
            head.previous = null;
            head = newNode;
        } else {
            Node curr = head;

            int index = 0;

            while (index < postion - 1) {
                curr = curr.next;

                index++;
            }
            newNode.previous = curr;
            newNode.next = curr.next;
            curr.next = newNode;
            newNode.next.previous = newNode;

        }

    }

    public int getSize() {
        int len = 0;
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        return len;
    }

}
