import java.util.Comparator;

/**
 * DirectFlight
 */
public class DirectFlightSort implements Comparator<Routes> {

    @Override
    public int compare(Routes o1, Routes o2) {

        return (o1.getTo().compareTo(o2.getTo()));
    }

}