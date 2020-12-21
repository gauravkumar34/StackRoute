public class ScoreCard {
    Student[] studList;

    public void displayScoreCard(Student[] studList) {
        System.out.println("            <<<<<<<<<<<<<<<<<<<<<<<< SCORE CARD >>>>>>>>>>>>>>>>>>>>>>>>>>          ");
        System.out.format("\n%s\t%4s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%10s\t%10s\n", "Roll Number", "Name", "Math",
                "Science", "English", "Language ", "Social Science", "Total Marks", "Average Marks", "Grade");
        for (Student s : studList) {
            System.out.format("%d\t%13s\t%13.1f\t%13.1f\t%13.1f\t%13.1f\t%13.1f\t%13.1f\t%13.1f\t%6s\n",
                    s.studentRollNo, s.studentName, s.mathMarks, s.sciMarks, s.engMarks, s.langMarks, s.socialMarks,
                    s.totalMarks, s.avgMarks, s.gradeMarks);

        }

    }
}
