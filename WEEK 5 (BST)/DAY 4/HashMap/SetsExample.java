import java.util.HashSet;

public class SetsExample {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(10);
        set.add(11);
        set.add(13);
        set.add(10);
        // check -> hashvalue hashCode
        System.out.println(set);

    }
}
