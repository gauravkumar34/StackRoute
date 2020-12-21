
public class ScientificOperation {
    double a;

    public ScientificOperation(double a) {
        this.a = a;

    }

    public void ceil(double a) throws CalException {
        if (a > 0) {
            System.out.println("The Ceil of " + a + " is : " + Math.ceil(a));
        } else {
            throw new CalException("\nEntered number is 0 or negative");
        }
    }

    public void floor(double a) throws CalException {
        if (a > 0) {
            System.out.println("The Floor of " + a + " is : " + Math.floor(a));
        } else {
            throw new CalException("\nEntered number is 0 or negative");
        }
    }

    public void squareRoot(double a) throws CalException {
        if (a > 0) {
            System.out.println("The Square Root of " + a + " is : " + Math.sqrt(a));
        } else {
            throw new CalException("\nEntered number is 0 or negative");
        }
    }

}