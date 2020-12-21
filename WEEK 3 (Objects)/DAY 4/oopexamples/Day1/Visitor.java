public class Visitor {
    static int counter;

    public void visitorCounter()
    {
        System.out.println("Welcome User.....");
        counter = counter+1;
        System.out.println("You are visitor number "+counter);
    }
}
