public class Voter {
    String name;
    String voterId;
    int age;

    Voter() {

    }

    public Voter(String name, String voterId, int age) {
        this.name = name;
        this.voterId = voterId;
        this.age = age;
    }

    public void validateAge(int age) throws AgeException {
        if (age < 18)
            // *throw an exceptions -> tell the entry that age is greater than 18;
            throw new AgeException("\nInvalid Age");

        else
            System.out.println("\nValid Age");
    }

}
