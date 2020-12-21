public class Arithmeticoperation {
    double a;
    double b;

    public Arithmeticoperation(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public void add(double a, double b) throws CalException {
        if (a > 0 && b > 0) {
            System.out.println("The Sum of " + a + " and " + b + " is : " + (a + b));
        } else {
            throw new CalException("\nEntered number is 0 or negative");
        }
    }

    public void sub(double a, double b) throws CalException {
        if (a > 0 && b > 0) {
            System.out.println("The Sub of " + a + " and " + b + " is : " + (a - b));
        } else {
            throw new CalException("\nEntered number is 0 or negative");
        }
    }

    public void multiply(double a, double b) throws CalException {
        if (a > 0 && b > 0) {
            System.out.println("The Multiply of " + a + " and " + b + " is : " + (a * b));
        } else {
            throw new CalException("\nEntered number is 0 or negative");
        }
    }

    public void divide(double a, double b) throws CalException {
        if (a > 0 && b > 0) {
            System.out.println("The Divide of " + a + " and " + b + " is : " + (a / b));
        } else {
            throw new CalException("\nEntered number is 0 or negative");
        }
    }

    public void module(double a, double b) throws CalException {
        if (a > 0 && b > 0) {
            System.out.println("The Module of " + a + " and " + b + " is : " + (a % b));
        } else {
            throw new CalException("\nEntered number is 0 or negative");
        }
    }

    public void powerOf(double a, double b) throws CalException {
        if (a > 0 && b > 0) {
            System.out.println("The Power of " + a + " to the power of " + b + " is : " + Math.pow(a, b));
        } else {
            throw new CalException("\nEntered number is 0 or negative");
        }
    }

}
