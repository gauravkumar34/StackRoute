import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BinarySearchTreeImpl {
    static BinarySearchTree readFromFile(String fileName) throws FileNotFoundException {
        String line = null;
        BinarySearchTree bst = new BinarySearchTree();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                String str[] = line.split(", ");
                Student stud = new Student();// new Student(str[0],Integer.parseInt(str[1]));
                stud.setStudentName(str[0]);
                stud.setMarks(Integer.parseInt(str[1]));
                bst.insert(bst.root, stud);

            }
        } catch (IOException e) {

            e.printStackTrace();
        }
        return bst;
    }

    static void showTree(BinarySearchTree bt) {
        bt.traversal(bt.root, Direction.POSTORDER);
    }

    public static void main(String[] args) {
        BinarySearchTree bt = null;
        try {
            bt = readFromFile("studentMarks.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        showTree(bt);

        System.out.println("The student is found : " + (bt.search(bt.root, 89)).student.getStudentName());
    }
}
