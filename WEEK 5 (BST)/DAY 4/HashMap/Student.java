/**
 * Student
 */
public class Student {
    // implements Comparable<Student> {

    int rollNo;
    String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", rollNo=" + rollNo + "]\n";
    }

    // @Override
    // public int compareTo(Student sobj) {
    // if (rollNo > sobj.getRollNo())
    // return 1;
    // else if (rollNo < sobj.getRollNo())
    // return -1;
    // else
    // return 0;
    // }

}