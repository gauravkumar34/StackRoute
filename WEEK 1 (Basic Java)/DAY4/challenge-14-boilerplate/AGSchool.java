import java.util.Scanner;

// import javax.swing.plaf.synth.SynthOptionPaneUI;

public class AGSchool {

    /**
     * this function calculate the average marks of the students
     * 
     * @param totalMarksOfStudents
     * @return
     */
    public static int[] avgMarksofStudent(int[] totalMarksOfStudents) {
        int n = totalMarksOfStudents.length;
        int[] avgMarks = new int[n];
        for (int i = 0; i < totalMarksOfStudents.length; i++) {
            int avgMark = 0;
            avgMark += totalMarksOfStudents[i] / 5;
            avgMarks[i] = avgMark;
        }
        return avgMarks;

    }

    public static void printHistogram(int[] avgMarks, int noOfStudent) {

        System.out.println("<---------------GRADING GRAPH--------------->");
        for (int i = 0; i < avgMarks.length; i++) {
            avgMarks[i] = avgMarks[i] / 10;

        }

        for (int i = 10; i > 0; i--) {
            int t = i * 10;
            System.out.print(t);

            for (int j = 0; j < noOfStudent; j++) {
                if (avgMarks[j] >= i) {
                    System.out.print("\t*");

                } else {
                    System.out.print("\t ");

                }
            }
            System.out.println("\n");

        }
        for (int i = 0; i < noOfStudent; i++) {
            System.out.print("\t" + (i + 1));
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
        int[] totalMarksOfStudents = new int[n];
        int totalMarks;
        // int totalMathsMarks = 0;
        // int totalScienceMarks = 0;
        for (int i = 0; i < n; i++) {
            totalMarks = 0;
            for (int j = 0; j < 5; j++) {
                System.out.println("Enter the Marks of Roll Number " + (i + 1) + "  " + subjects[j]);
                rollNumberOrMarks[i][j] = sc.nextInt();
                // totalMathsMarks += rollNumberOrMarks[i][1];
                // totalScienceMarks += rollNumberOrMarks[i][2];
                totalMarks += rollNumberOrMarks[i][j];
            }
            totalMarksOfStudents[i] = totalMarks;
        }

        /**
         * Printing the input Value
         */
        System.out.println("Name\t  Math\tScience\tEnglish\tLanguage  Social Science\ttotal Marks");
        for (int i = 0; i < n; i++) {
            System.out.print(studentsName[i]);
            for (int j = 0; j < 5; j++) {
                System.out.print("\t    " + rollNumberOrMarks[i][j]);
            }
            System.out.print("\t              " + totalMarksOfStudents[i]);
            System.out.println("\n");

        }
        int[] avgMarks = avgMarksofStudent(totalMarksOfStudents);
        printHistogram(avgMarks, noOfStudent);
    }
}
