
import java.util.Scanner;

import java.util.Random;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.text.ParseException;

public class CustomerAnalyzer {

    public Customer[] acceptCustomerDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Numbers of Customers : ");
        int n = sc.nextInt();

        Customer custList[] = new Customer[n];

        for (int i = 0; i < n; i++) {
            Customer cust = new Customer();
            cust.setId(generatedId());
            System.out.println("Type :-  M for male\t F for female ");
            cust.setGender(sc.next());
            System.out.println("First Name : ");
            cust.setFname(sc.next());
            System.out.println("Last Name : ");
            cust.setLname(sc.next());
            System.out.println("Date of Birth (MM/DD/YYYY) : ");
            String dob = sc.next();
            if (validateJavaDate(dob)) {
                cust.setDob(dob);
            }
            LocalDate today = LocalDate.now();
            // ! int age = cust.setAge(calculateAge(dob, today));
            System.out.println("Phone Number (Only 10 Digits) : ");
            String phNumber = sc.next();

            /**
             * validation of phone no check
             */

            if (validatePhoneNumber(phNumber)) {
                cust.setPhoneNumber(phNumber);
            } else {
                cust.setPhoneNumber("InValid Phone Number ");
            }
            Address addr = new Address();
            System.out.println("House No : ");
            addr.setHouseNo(sc.nextInt());
            System.out.println("Street Name : ");
            addr.setStreetName(sc.next());
            System.out.println("Village : ");
            addr.setVillage(sc.next());
            System.out.println("Pin Code : ");
            addr.setPincode(sc.nextInt());
            System.out.println("State : ");
            addr.setState(sc.next());

            cust.setAddress(addr);

            SavingBankAccount sva = new SavingBankAccount();
            long accountNumber = (accountNumberGenerate());
            sva.setAccountNumber(accountNumber);
            System.out.println("Enter the amount to Deposit :  else type 0");
            double deposit = sc.nextDouble();
            System.out.println("Enter the amount to Withdraw :  else type 0");
            double withdraw = sc.nextDouble();
            sva.setTotalBalance(deposit - withdraw);

            cust.setSavingBankAccount(sva);

            custList[i] = cust;

        }
        return custList;
    }

    /**
     * validate phone number
     * 
     * @param phNumber
     * @return
     */
    public boolean validatePhoneNumber(String phNumber) {
        String phoneNumber = phNumber;

        String regex = "(0/91)?[7-9][0-9]{9}";

        return phoneNumber.matches(regex);
    }

    /**
     * generate random customer ID
     * 
     * @return
     */

    public int generatedId() {
        Random rand = new Random();
        int upperbound = 1000;
        int int_random = rand.nextInt(upperbound);
        return int_random;
    }

    /**
     * display details of customer.
     * 
     * @param custList
     */
    public void displayCustomerDetails(Customer[] custList) {
        System.out.format("\n%s %10s %10s %10s %30s %15s %15s %15s\n", "id", "fName", "lName", "Address", "DateofBith",
                "Phone Number", "Account Number", "Total Balance");
        for (Customer s : custList) {
            System.out.format("\n%s %10s %10s %15s %20s %15s %15d %15.2f\n", s.getId(), s.getFname(), s.getLname(),
                    s.getAddress().getHouseNo() + " " + s.getAddress().getStreetName() + " "
                            + s.getAddress().getVillage() + " " + s.getAddress().getPincode() + " "
                            + s.getAddress().getState(),
                    s.getDob(), s.getPhoneNumber(), s.getSavingBankAccount().getAccountNumber(),
                    s.getSavingBankAccount().getTotalBalance());
        }
    }

    /**
     * *this function validate the date format.
     */

    public boolean validateJavaDate(String strDate) {
        /* Check if date is 'null' */
        if (strDate.trim().equals("")) {
            return true;
        }
        /* Date is not 'null' */
        else {
            /*
             * Set preferred date format, For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.
             */
            SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
            sdfrmt.setLenient(false);
            /*
             * Create Date object parse the string into date
             */
            try {
                Date javaDate = sdfrmt.parse(strDate);
                // System.out.println(strDate + " is valid date format");
            }
            /* Date format is invalid */
            catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
                return false;
            }
            /* Return true if date format is valid */
            return true;
        }
    }

    /**
     * here we calculate the age from the date of birth
     * 
     * @return
     */

    public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    /**
     * *automatical account generated //! 16/11/2020
     * 
     * @return
     */
    public long accountNumberGenerate() {
        long upperbound = 100000000;
        long lowerbound = 536871066;
        return ((long) (Math.random() * (upperbound - lowerbound))) + lowerbound;
    }

}
