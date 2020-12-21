import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BInaryTreeImpl {
    static BinaryTree readFromFile(String fileName) throws FileNotFoundException {
        String line = null;
        BinaryTree bt = new BinaryTree();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                String str[] = line.split(", ");
                Student stud = new Student();
                stud.setStudentName(str[0]);
                stud.setMarks(Integer.parseInt(str[1]));
                bt.insert(bt.root, stud);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bt;
    }

    static void showTree(BinaryTree bt) {
        bt.traversal(bt.root, Direction.PREORDER);
    }

    public static void main(String[] args) {
        BinaryTree bt = null;
        try {
            bt = readFromFile("studentMarks.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        showTree(bt);
    }
}
