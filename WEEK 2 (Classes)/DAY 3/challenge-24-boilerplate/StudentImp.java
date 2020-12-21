public class StudentImp {

    public static void main(String[] args) {
        Student[] studList = Student.acceptStudentDetails();
        Student stud = new Student();
        stud.displayStudentDetails(studList); // ! Task 1
        stud.displayClearedExamStudent(studList); // ! Task 1
        stud.displayNotClearedExamStudent(studList); // ! Task 2

        ScoreCard score = new ScoreCard(); // ! Task 3 && Task 4
        score.displayScoreCard(studList); // !Task 4
    }
}
