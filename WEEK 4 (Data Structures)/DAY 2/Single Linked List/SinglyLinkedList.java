public class SinglyLinkedList {

    // Declare the startPointer
    Node startPtr = null;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (startPtr == null) {
            // starting node becomes the new node
            startPtr = newNode;
            startPtr.next = null;
        } else {
            newNode.next = startPtr;
            startPtr = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (startPtr == null) {
            // starting node becomes the new node
            startPtr = newNode;
            startPtr.next = null;
        } else {
            Node curr = startPtr;
            while (curr.next != null) {
                curr = curr.next;
            }
            // reach end of list and reassign pointers
            curr.next = newNode;
            newNode.next = null;
        }
    }

    public void insertAtMiddle(int data, int postion) {
        Node newNode = new Node(data);
        if (postion < 0 || postion > getSize()) {
            System.out.println("Invalid Postion");
        }
        if (postion == 0) {
            newNode.next = startPtr;
            startPtr = newNode;
        } else {
            Node curr = startPtr;
            Node prev = null;
            // counter to tack index
            int index = 0;
            while (index < postion) {
                prev = curr;
                curr = curr.next;
                index++;
            }
            newNode.next = curr;
            prev.next = newNode;
        }
    }

    public int getSize() {
        int len = 0;
        Node curr = startPtr;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        return len;
    }

    public void traverse() {
        Node curr = startPtr;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }

    }

    public void delete(int data) {
        Node curr = startPtr;
        Node temp = null;
        if (curr.data == data) {
            startPtr = curr.next;
            return;
        }
        while (curr != null && curr.data != data) {
            temp = curr;
            curr = curr.next;
        }

        if (curr == null)
            return;
        temp.next = curr.next;
    }
}
