
import java.util.Scanner;
import java.util.Random;

public class CustomerAnalyzer {

    public Customer[] acceptCustomerDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Numbers of Student : ");
        int n = sc.nextInt();

        Customer custList[] = new Customer[n];

        for (int i = 0; i < n; i++) {
            Customer cust = new Customer();
            cust.setId(generatedId());
            System.out.println("First Name : ");
            cust.setFname(sc.next());
            System.out.println("Last Name : ");
            cust.setLname(sc.next());
            System.out.println("Date of Birth : ");
            cust.setDob(sc.next());
            System.out.println("Phone Number : ");
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
        System.out.format("\n%s %10s %10s %10s %30s %15s\n", "id", "fName", "lName", "Address", "DateofBith",
                "Phone Number");
        for (Customer s : custList) {
            System.out.format("\n%s %10s %10s %15s %20s %15s\n", s.getId(), s.getFname(), s.getLname(),
                    s.getAddress().getHouseNo() + " " + s.getAddress().getStreetName() + " "
                            + s.getAddress().getVillage() + " " + s.getAddress().getPincode() + " "
                            + s.getAddress().getState(),
                    s.getDob(), s.getPhoneNumber());
        }
    }

    /**
     * display custoomer bye same village
     * 
     * @param custList
     */ // ! not completed
    public void displaySameVillage(Customer[] custList) {
        System.out.format("\n%s %10s %10s %10s %30s %15s\n", "id", "fName", "lName", "Address", "DateofBith",
                "Phone Number");
        for (int i = 0; i < custList.length; i++) {
            for (int j = 0; j < custList.length; i++) {
                if (custList[i].getAddress().getVillage().equals(custList[j].getAddress().getVillage())) {
                    System.out.format("\n%s %10s %10s %15s %20s %15s\n", custList[i].getId(), custList[i].getFname(),
                            custList[i].getLname(),
                            custList[i].getAddress().getHouseNo() + " " + custList[i].getAddress().getStreetName() + " "
                                    + custList[i].getAddress().getVillage() + " "
                                    + custList[i].getAddress().getPincode() + " " + custList[i].getAddress().getState(),
                            custList[i].getDob(), custList[i].getPhoneNumber());
                }
            }
        }
    }

}
