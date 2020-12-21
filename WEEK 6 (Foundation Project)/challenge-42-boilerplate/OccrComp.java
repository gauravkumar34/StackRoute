import java.util.Comparator;

public class OccrComp implements Comparator<Word> {

    @Override
    public int compare(Word o1, Word o2) {
        NameComp nc = new NameComp();
        if (o1.getNoOfOccurance() == o1.getNoOfOccurance())
            return nc.compare(o1, o2);
        if (o1.getNoOfOccurance() < o2.getNoOfOccurance())
            return -1;
        else
            return 1;
    }

}
