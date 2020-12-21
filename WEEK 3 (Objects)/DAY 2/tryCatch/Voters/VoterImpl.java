public class VoterImpl {

    public static void main(String[] args) {
        int age = 21;
        Voter v = new Voter();
        try {
            v.validateAge(age);
        } catch (AgeException e) {

        }
        System.out.println("Control back main method.");
    }
}
