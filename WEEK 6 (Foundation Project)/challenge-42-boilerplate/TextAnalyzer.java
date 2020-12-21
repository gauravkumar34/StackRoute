import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class TextAnalyzer {
    public static LinkedLists insert() throws FileNotFoundException {
        LinkedLists ll = new LinkedLists();
        CountEachWord cew = new CountEachWord();
        Map<String, Integer> words = new HashMap<String, Integer>();
        cew.countWords(".\\data\\daffodils.txt", words);
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            String str = entry.getKey();
            int count = entry.getValue();
            Word word = new Word();
            word.setWord(str);
            word.setNoOfOccurance(count);
            LinkedLists.insert(word);
        }
        return ll;

    }

    public static void main(String[] args) throws FileNotFoundException {
        insert();
        LinkedLists ll = new LinkedLists();
        ll.display();
        ll.sortAlphabetically();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<Sorted List>>>>>>>>>>>>>>>>>>>>>>>");
        ll.display();
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<Reverse List>>>>>>>>>>>>>>>>>>>>>>");
        // ll.displayRev(); //! errror
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<Sorted by Occurrance>>>>>>>>>>>>>>");
        ll.display();
    }
}
