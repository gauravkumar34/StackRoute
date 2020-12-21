import java.util.ArrayList;
import java.util.Collections;

public class ListGeneric {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student(110, "Jane"));
        studentList.add(new Student(111, "AJane"));
        studentList.add(new Student(112, "VJane"));
        studentList.add(new Student(113, "EJane"));
        studentList.add(new Student(124, "CJane"));
        studentList.add(new Student(115, "FJane"));
        studentList.add(new Student(116, "TJane"));
        studentList.add(new Student(117, "lJane"));

        // iterating
        // for (Student s : studentList) {
        // System.out.println(s);

        // }
        // ListIterator<Student> itr = studentList.listIterator();

        // while (itr.hasNext()) {
        // System.out.println(itr.next());
        // }
        // System.out.println("<----REVERSE ORDER---->");
        // while (itr.hasPrevious()) {
        // System.out.println("" + itr.previous());
        // }

        // Iterator<Student> itrr = studentList1.descendingIterator();
        // itrr.next();

        Collections.sort(studentList, new NameComparator());
        System.out.println(studentList);

    }

    // hasPrevious() ->
    // hasNext() ->
}
