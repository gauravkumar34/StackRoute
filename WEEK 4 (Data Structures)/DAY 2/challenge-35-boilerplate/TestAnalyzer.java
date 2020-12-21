import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestAnalyzer {

    /**
     * \ * this method are used to read the external file and adding word in the
     * list
     */

    public SingleLinkedList readFromFile(String fileName) {
        File file = new File(fileName);
        SingleLinkedList s1 = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = null;
            String[] words = null;
            s1 = new SingleLinkedList();

            while ((line = br.readLine()) != null) {
                line = line.toLowerCase().replaceAll("[,':;.?]", "");
                words = line.split(" ");

                for (String word : words) {
                    s1.addWord(word);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s1;
    }

    public void showWordList() {
        SingleLinkedList list = readFromFile("data/daffodils.txt");
        System.out.println("UnSorted  List\t:");
        list.showWord();
        list.sortAlpha();
        System.out.println("\n\nSorted  List\t:");
        list.showWord();

        list.revSortAlpha();
        System.out.println("\n\n Reverse Sorted  List\t:");
        list.showWord();

    }

}
