import java.sql.Date;

/**
 * Customer
 */
public class Customer {

    private int id;
    private String gender;
    private String fname;
    private String lname;
    private Address address;
    private String dob;
    private int age;
    private String phoneNumber;
    private SavingBankAccount savingBankAccount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String string) {
        this.gender = string;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SavingBankAccount getSavingBankAccount() {
        return savingBankAccount;
    }

    public void setSavingBankAccount(SavingBankAccount SavingBankAccount) {
        this.savingBankAccount = SavingBankAccount;
    }

}