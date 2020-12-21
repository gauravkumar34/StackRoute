import java.util.Scanner;

public class AGSchool {
    /**
     * this function genretating the grade of each student
     * 
     * @param totalMarksOfStudents
     * @param noOfStudent
     * @return
     */
    public static String[] gradingSystem(int[] totalMarksOfStudents, int noOfStudent) {
        int[] avgMarks = avgMarksofStudent(totalMarksOfStudents);
        String[] gradeMarks = new String[5];
        for (int i = 0; i < avgMarks.length; i++) {

            if (avgMarks[i] >= 90) {
                gradeMarks[i] = "A";
            } else if (avgMarks[i] >= 80 && avgMarks[i] < 90) {
                gradeMarks[i] = "B";
            } else if (avgMarks[i] >= 70 && avgMarks[i] < 80) {
                gradeMarks[i] = "C";
            } else if (avgMarks[i] >= 60 && avgMarks[i] < 70) {
                gradeMarks[i] = "D";
            } else if (avgMarks[i] >= 50 && avgMarks[i] < 60) {
                gradeMarks[i] = "E";
            } else {
                gradeMarks[i] = "F";
            }
        }
        return gradeMarks;

    }

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

    /**
     * This function generating the score card of the Students
     */

    public static void scoreCard(String[] studentsName, String[] subjects, int[][] rollNumberOrMarks,
            int[] totalMarksOfStudents, int noOfStudent, String[] gradeMarks) {
        int rollNum = 1;
        System.out.println("<----       SCORE CARD      ---->");
        System.out.println();
        for (int i = 0; i < noOfStudent; i++) {
            System.out.println("<----       Roll no : " + (rollNum++) + "       ---->");
            System.out.println();
            System.out.println("Name : " + studentsName[i]);
            System.out.println("Roll No : " + (i + 1));
            System.out.println("Subjects ");
            for (int j = 0; j < 5; j++) {
                System.out.println("  " + subjects[j] + " : " + rollNumberOrMarks[i][j]);
            }
            System.out.println("Total Marks : " + totalMarksOfStudents[i]);
            System.out.println("Grade : " + gradeMarks[i]);
            System.out.println();

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
        String[] gradeMarks = gradingSystem(totalMarksOfStudents, noOfStudent);
        System.out.println("<------------------------------------------------------------------>");
        System.out.println("\tName\t Grade\t Total Marks\t Average Marks");
        for (int i = 0; i < noOfStudent; i++) {
            System.out.println("\t" + studentsName[i] + "\t\t" + gradeMarks[i] + "\t" + totalMarksOfStudents[i] + "\t"
                    + avgMarks[i]);
        }
        System.out.println("<------------------------------------------------------------------>");
        scoreCard(studentsName, subjects, rollNumberOrMarks, totalMarksOfStudents, noOfStudent, gradeMarks);
    }
}
