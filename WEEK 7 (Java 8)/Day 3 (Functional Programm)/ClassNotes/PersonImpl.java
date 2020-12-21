import java.util.ArrayList;
// import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class PersonImpl {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Leena", 26));
        personList.add(new Person("Liena", 336));
        personList.add(new Person("Lena", 46));
        personList.add(new Person("Leea", 56));
        personList.add(new Person("Leen", 66));

        // List<Person> pList = Arrays.asList(new Person("leena", 25), new
        // Person("Linean", 36), new Person("Lena", 46),
        // new Person("Leea", 56), new Person("Leen", 66));
        // Collections.sort(personList, object);

        Comparator<Person> comp = new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getAge() > o2.getAge())
                    return 1;
                else if (o1.getAge() < o2.getAge())
                    return -1;
                else
                    return 0;
            }

        };
        Collections.sort(personList, comp);

        System.out.println(personList + "\n");

        Collections.sort(personList, new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getAge() > o2.getAge())
                    return 1;
                else if (o1.getAge() < o2.getAge())
                    return -1;
                else
                    return 0;
            }
        });
        System.out.println(personList + "\n");

        Collections.sort(personList, (o1, o2) -> {
            if (o1.getAge() > o2.getAge())
                return 1;
            else if (o1.getAge() < o2.getAge())
                return -1;
            else
                return 0;
        });
        System.out.println(personList + "\n");
        Consumer<Person> c = new Consumer<Person>() { // consuee an object and what ever you want to do, any

            @Override
            public void accept(Person t) {
                System.out.println(t);

            }

        };
        System.out.println("anoynmous");
        personList.forEach(c);
        System.out.println("Lambda");
        personList.forEach(i -> System.out.println(i));
        System.out.println("Method Ref");
        personList.forEach(System.out::println);

    }
}
