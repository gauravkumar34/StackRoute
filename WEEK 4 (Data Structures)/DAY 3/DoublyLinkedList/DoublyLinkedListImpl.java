import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DoublyLinkedListImpl {

    public static DoublyLinkedList readFromFile(String fileName) {
        String line = null;
        DoublyLinkedList dl = new DoublyLinkedList();
        // Closable, AutoClosable
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                String nos[] = line.split(",");
                for (int i = 0; i < nos.length; i++) {
                    dl.insertAtEnd(Integer.parseInt(nos[i]));
                }

            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dl;
    }

    public static void main(String[] args) {
        DoublyLinkedList numberList = readFromFile("numbers.txt");
        numberList.insertBegin(508111);
        numberList.forwardTraversal();
        System.out.println();
        numberList.reverseTraversal();
        // numberList.delete(100);
        // numberList.delete(88);
        System.out.println();
        numberList.reverseTraversal();
        System.out.println();
        System.out.println(numberList.getSize());

    }
}
