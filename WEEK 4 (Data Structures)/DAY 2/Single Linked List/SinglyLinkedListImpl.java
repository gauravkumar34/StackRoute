public class SinglyLinkedListImpl {
    public static void main(String[] args) {
        SinglyLinkedList s1 = new SinglyLinkedList();

        s1.insertAtBeginning(35);
        s1.insertAtBeginning(36);
        s1.insertAtBeginning(37);
        System.out.println("\nInsertion At the Beginning  : ");
        s1.traverse();

        s1.insertAtMiddle(39, 1);
        s1.insertAtMiddle(40, 2);
        s1.insertAtMiddle(41, 3);

        System.out.println("\nInsertion At the Middle : ");
        s1.traverse();

        s1.insertAtEnd(42);
        s1.insertAtEnd(43);
        s1.insertAtEnd(44);
        System.out.println("\nInsertion At the End : ");
        s1.traverse();
        s1.delete(43);
        System.out.println("\nDelete at data : ");
        s1.traverse();

    }
}
