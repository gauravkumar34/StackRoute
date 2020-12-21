import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SingleLLWordImpl {
    static SingleLinkedListWord readFile(String fileName) {
        File file = new File(fileName);
        SingleLinkedListWord s1 = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = null;
            String[] words = null;
            s1 = new SingleLinkedListWord();

            while ((line = br.readLine()) != null) {
                line = line.toLowerCase().replaceAll("[,':;.?]", "");
                words = line.split(" ");

                for (String word : words) {
                    s1.addWordNode(word);
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return s1;

    }

    public static void main(String[] args) {
        SingleLinkedListWord list = readFile("daffodils.txt");
        list.traversal();
    }
}
