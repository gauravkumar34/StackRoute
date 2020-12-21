import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class CountEachWord {
    void countWords(String fileName, Map<String, Integer> words) throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));
        while (file.hasNext()) {
            String word = file.next();
            word = word.toLowerCase();
            if (word.length() == 0)
                break;
            int l = word.length() - 1;
            char c = word.charAt(l);
            if (c == ',' || c == '.' || c == ':' || c == '-' || c == ';') {
                word = word.substring(0, l);
            }
            Integer count = words.get(word);
            if (count != null)
                count++;
            else
                count = 1;
            words.put(word, count);

        }
        file.close();
    }

}
