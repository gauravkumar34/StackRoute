import java.util.Comparator;

public class NameComp implements Comparator<Word> {

    @Override
    public int compare(Word o1, Word o2) {

        if (o1.getWord().compareTo(o2.getWord()) < 0)
            return -1;
        else
            return 1;
    }

}
