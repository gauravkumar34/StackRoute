import java.util.Date;

public class Person {
    private int age;
    private String name;
    private String addr;
    private Date date;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
Person()
{
    
}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Person(int age, String name, String addr, Date date) {
        this.age = age;
        this.name = name;
        this.addr = addr;
        this.date = date;
    }

}
