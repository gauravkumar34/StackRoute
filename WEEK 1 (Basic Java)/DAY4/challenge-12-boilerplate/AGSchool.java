import java.util.Scanner;

public class AGSchool {
    /**
     * this function print the passed and not passed of all student in each subject
     * 
     * @param rollNumberOrMarks
     * @param studentsName
     */
    public static void passedStudent(int[][] rollNumberOrMarks, String[] studentsName) {
        for (int i = 0; i < rollNumberOrMarks.length; i++) {

            // System.out.println("Students who needs to mandatorily repeat the
            // examination");
            boolean flag = false;
            for (int j = 0; j < rollNumberOrMarks.length; j++) {

                if (rollNumberOrMarks[i][j] > 34) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Passed In All Subject :- " + studentsName[i]);
            } else {
                System.out.println("Not Passed In All Subject :- " + studentsName[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Students:  ");
        int noOfStudent = sc.nextInt();
        int n = noOfStudent;

        String[] subjects = { "Math", "Science", "English", "Languages", "Social Science" };
        String[] studentsName = new String[n]; // names of student stored in array taking from user
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the Name of Roll Number " + (i + 1) + " : ");
            studentsName[i] = sc.next();
        }

        int[][] rollNumberOrMarks = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("Enter the Marks of Roll Number " + (i + 1) + "  " + subjects[j]);
                rollNumberOrMarks[i][j] = sc.nextInt();
            }
        }

        /**
         * Printing the input Value
         */
        System.out.println("Name\t  Math\tScience\tEnglish\tLanguage  Social Science");
        for (int i = 0; i < n; i++) {
            System.out.print(studentsName[i]);
            for (int j = 0; j < 5; j++) {
                System.out.print("\t    " + rollNumberOrMarks[i][j]);
            }

            System.out.println("\n");

        }
        passedStudent(rollNumberOrMarks, studentsName);
    }
}
