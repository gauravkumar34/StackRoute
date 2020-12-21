//! extra word

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class LinkedListImpl {

    public static LinkedList readFromFile(String fileName) throws FileNotFoundException {
        LinkedList<Word> words = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = null;

            while ((line = br.readLine()) != null) {
                line = line.toLowerCase().replaceAll("[,':;.?]", "");
                String[] wrd = line.split(" ");
                for (String w : wrd) {
                    Word word = new Word();
                    word.setWord(w);
                    // if (!isUpdateOccurance(word)) {
                    word.setNoOfOccurance(1);
                    words.add(word);
                    // }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;

    }

    public static boolean isUpdateOccurance(Word word) {
        // if(word.equals
        return true;
    }

    public static void showWordList() throws FileNotFoundException {
        LinkedList<Word> allWord = readFromFile("data/daffodils.txt");

        for (Word w : allWord) {

            System.out.println(w);

        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        LinkedList rr = readFromFile("data/daffodils.txt");
        showWordList();
    }
}
