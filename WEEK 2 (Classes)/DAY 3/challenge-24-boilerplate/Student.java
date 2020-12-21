
import java.util.Scanner;

public class Student {
    String studentName;
    int studentRollNo;
    double mathMarks;
    double sciMarks;
    double engMarks;
    double langMarks;
    double socialMarks;
    double totalMarks;
    double avgMarks;
    String gradeMarks;

    public Student() {

    }

    public Student(String studentName, int studentRollNo, double mathMarks, double sciMarks, double engMaeks,
            double langMarks, double socialMarks, double totalMarks, double avgMarks, String gradeMarks) { //
        this.studentName = studentName;
        this.studentRollNo = studentRollNo;
        this.mathMarks = mathMarks;
        this.sciMarks = sciMarks;
        this.engMarks = engMaeks;
        this.langMarks = langMarks;
        this.socialMarks = socialMarks;
        this.totalMarks = totalMarks;
        this.avgMarks = avgMarks;
        this.gradeMarks = gradeMarks;

    }

    public static Student[] acceptStudentDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Student : ");
        int noOfStudent = sc.nextInt();
        int n = noOfStudent;
        Student studList[] = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the " + (i + 1) + " Name : ");
            String name = sc.next();
            int rollNo = (i + 1);
            System.out.println("Math Marks : ");
            double mathMarks = sc.nextDouble();
            System.out.println("Science Marks : ");
            double sciMarks = sc.nextDouble();
            System.out.println("English Marks : ");
            double engMarks = sc.nextDouble();
            System.out.println("Language Marks : ");
            double langMarks = sc.nextDouble();
            System.out.println("Social Science Marks : ");
            double socialMarks = sc.nextDouble();

            double totalMarks = mathMarks + sciMarks + engMarks + langMarks + socialMarks;
            double avgMarks = (totalMarks / 5);
            /**
             * Grade of each Student with help of <avgMarks>
             */
            String gradeMarks; // ! Task 3
            if (avgMarks >= 90) {
                gradeMarks = "A";
            } else if (avgMarks >= 80 && avgMarks < 90) {
                gradeMarks = "B";
            } else if (avgMarks >= 70 && avgMarks < 80) {
                gradeMarks = "C";
            } else if (avgMarks >= 60 && avgMarks < 70) {
                gradeMarks = "D";
            } else if (avgMarks >= 50 && avgMarks < 60) {
                gradeMarks = "E";
            } else {
                gradeMarks = "F";
            }

            Student stud = new Student(name, rollNo, mathMarks, sciMarks, engMarks, langMarks, socialMarks, totalMarks,
                    avgMarks, gradeMarks);

            studList[i] = stud;

        }
        return studList;

    }
    // public void displayTopScorer(Student[] studList)
    // {
    // System.out.println(" Top-Scorer : ");
    // for(Student s : studList){
    // double topScorer = s.totalMarks;
    // if(topScorer > s.topScorer)

    // }

    // }

    /**
     * Display the all students Details
     * 
     * @param studList
     */
    public void displayStudentDetails(Student[] studList) {
        System.out.format("\n%s\t%4s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%10s\n", "Roll Number", "Name", "Math",
                "Science", "English", "Language ", "Social Science", "Total Marks", "Average Marks");
        for (Student s : studList) {

            System.out.format("%d\t%13s\t%13.1f\t%13.1f\t%13.1f\t%13.1f\t%13.1f\t%13.1f\t%13.1f\n", s.studentRollNo,
                    s.studentName, s.mathMarks, s.sciMarks, s.engMarks, s.langMarks, s.socialMarks, s.totalMarks,
                    s.avgMarks);

        }

    }

    /**
     * Display the student details who had cleared the exam ;
     * 
     * @param studList
     */
    public void displayClearedExamStudent(Student[] studList) {
        System.out.println("<--------- Student Who Had Cleared Examination ------------>");
        System.out.format("\n%s\t%4s\t%12s", "Roll Number", "Name", "Total Marks");
        for (Student s : studList) {
            if (s.mathMarks >= 35 && s.sciMarks >= 35 && s.engMarks >= 35 && s.langMarks >= 35 && s.socialMarks >= 35) {
                System.out.format("\n%d\t%13s\t%13s\n", s.studentRollNo, s.studentName, s.totalMarks);
            }
        }
    }

    /**
     * Display the student details who had not cleared the exam ;
     * 
     * @param studList
     */
    public void displayNotClearedExamStudent(Student[] studList) {
        System.out.println("<--------- Student Who Had Not Cleared Examination ------------>");
        System.out.format("\n%s\t%4s\t%12s", "Roll Number", "Name", "Total Marks");
        for (Student s : studList) {
            if (s.mathMarks < 35 && s.sciMarks < 35 && s.engMarks < 35 && s.langMarks < 35 && s.socialMarks < 35) {
                System.out.format("\n%d\t%13s\t%13s\n", s.studentRollNo, s.studentName, s.totalMarks);
            }
        }
    }

}
