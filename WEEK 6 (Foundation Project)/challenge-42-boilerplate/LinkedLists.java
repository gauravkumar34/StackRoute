import java.util.*;
import java.util.LinkedList;

public class LinkedLists {

    static LinkedList<Word> words = new LinkedList<>();

    public static LinkedList<Word> insert(Word word) {
        words.add(word);
        return words;
    }

    public void display() {
        ListIterator<Word> li = words.listIterator();
        while (li.hasNext()) {
            System.out.println(li.next());
        }
    }

    public void sortAlphabetically() {
        Collections.sort(words, new NameComp());
    }

    public void displayRev() {
        ListIterator<Word> li = words.listIterator();
        while (li.hasNext()) {
            li.hasNext();
        }
        while (li.hasPrevious()) {
            System.out.println(li.previous());
        }
    }

    public void sortByOccr() {
        Collections.sort(words, new OccrComp());
    }

}
