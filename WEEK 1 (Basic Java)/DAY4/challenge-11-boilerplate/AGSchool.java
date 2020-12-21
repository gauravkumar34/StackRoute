import java.util.Scanner;

public class AGSchool {

    public static int findTheHighestScorer(int[] totalMarksOfStudents) // top scorer
    {
        int maxMarks = 0;
        for (int i = 0; i < totalMarksOfStudents.length; i++) {
            if (totalMarksOfStudents[i] > 0) {
                maxMarks = totalMarksOfStudents[i];
            }
        }
        return maxMarks;
    }

    public static void displayHighestScorer(int[] totalMarksOfStudents, String[] studentsName) {
        System.out.println("<-------------Top Scorer--------------->");// top scorer
        int topScorerMarks = findTheHighestScorer(totalMarksOfStudents);
        for (int i = 0; i < totalMarksOfStudents.length; i++) {
            if (topScorerMarks == totalMarksOfStudents[i]) {
                System.out.println("Top Scorer Name -> " + studentsName[i] + "\tRoll Number : " + (i + 1));
            }
        }
    }

    public static void findAverageMarks(int[][] rollNumberOrMarks, int noOfStudent) {
        double[] AvgMarksofEachSubject = new double[5];
        String[] subjects = { "Math", "Science", "English", "Languages", "Social Science" };
        double totalMarksMaths = 0;
        double totalMarksScience = 0;
        double totalMarksEnglish = 0;
        double totalMarksLanguage = 0;
        double totalMarksSocialSci = 0;
        for (int i = 0; i < rollNumberOrMarks.length; i++) {

            totalMarksMaths += Integer.valueOf(rollNumberOrMarks[i][0]).floatValue()
                    / Integer.valueOf(noOfStudent).floatValue();
            totalMarksScience += Integer.valueOf(rollNumberOrMarks[i][1]).floatValue()
                    / Integer.valueOf(noOfStudent).floatValue();
            totalMarksEnglish += Integer.valueOf(rollNumberOrMarks[i][2]).floatValue()
                    / Integer.valueOf(noOfStudent).floatValue();
            totalMarksLanguage += Integer.valueOf(rollNumberOrMarks[i][3]).floatValue()
                    / Integer.valueOf(noOfStudent).floatValue();
            totalMarksSocialSci += Integer.valueOf(rollNumberOrMarks[i][4]).floatValue()
                    / Integer.valueOf(noOfStudent).floatValue();

        }

        // for(int i=0; i<5; i++)
        // {
        AvgMarksofEachSubject[0] = totalMarksMaths;
        AvgMarksofEachSubject[1] = totalMarksScience;
        AvgMarksofEachSubject[2] = totalMarksEnglish;
        AvgMarksofEachSubject[3] = totalMarksLanguage;
        AvgMarksofEachSubject[4] = totalMarksSocialSci;
        // }

        // System.out.println(totalMarksMaths + " " + totalMarksScience + " " +
        // totalMarksEnglish + " "
        // + totalMarksLanguage + " " + totalMarksSocialSci);

        for (int i = 0; i < AvgMarksofEachSubject.length; i++) {
            System.out.println("Average Marks of " + subjects[i] + " " + AvgMarksofEachSubject[i]);
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
        displayHighestScorer(totalMarksOfStudents, studentsName);
        System.out.println("<--------------------------------------->");

        findAverageMarks(rollNumberOrMarks, n);
        // System.out.println(totalMathsMarks + " " + totalScienceMarks);
    }
}
