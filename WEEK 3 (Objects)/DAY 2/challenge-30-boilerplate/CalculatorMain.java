import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        String yn; // * for continue "yes" or "no"

        do {
            System.out.println("\nEnter the operation you wish to perform : ");
            System.out.println("1. Mathematical Calculation");
            System.out.println("2. Scientific Calculation");
            System.out.println("3. Exit");
            n = sc.nextInt();

            switch (n) {

                case 1:
                    System.out.println("\nSelect an arithmetic operation : ");
                    System.out.println("1. Add ");
                    System.out.println("2. Subtract ");
                    System.out.println("3. Multiply ");
                    System.out.println("4. Divide ");
                    System.out.println("5. Modulo ");
                    System.out.println("6. Back to Main Menu ");
                    int ao = sc.nextInt(); // * user input for arithematic operation
                    System.out.println("Enter the 1st Number ");
                    double a = sc.nextDouble();

                    System.out.println("Enter the 2nd Number ");
                    double b = sc.nextDouble();
                    Arithmeticoperation ac = new Arithmeticoperation(a, b);
                    switch (ao) {
                        case 1:
                            try {
                                ac.add(a, b);
                            } catch (CalException e) {

                            }
                            break;
                        case 2:
                            try {
                                ac.sub(a, b);
                            } catch (CalException e) {

                            }
                            break;
                        case 3:
                            try {
                                ac.multiply(a, b);
                            } catch (CalException e) {

                            }
                            break;
                        case 4:
                            try {
                                ac.divide(a, b);
                            } catch (CalException e) {

                            }
                            break;
                        case 5:
                            try {
                                ac.module(a, b);
                            } catch (CalException e) {

                            }
                            break;
                        case 6:
                            System.out.print("Back to main menu ");
                            break;
                        default:
                            System.out.println("Please Enter a Valid Options :");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("\nSelect a scientific operation :");
                    System.out.println("1. Ceil ");
                    System.out.println("2. Floor ");
                    System.out.println("3. Square Root ");
                    System.out.println("4. Power Of ");
                    System.out.println("5. Back to Main Menu ");
                    int cs = sc.nextInt(); // * user input for scientific operation
                    System.out.println("Enter the Number ");
                    double c = sc.nextDouble();
                    ScientificOperation so = new ScientificOperation(c);

                    switch (cs) {
                        case 1:
                            try {
                                so.ceil(c);
                                ;
                            } catch (CalException e) {

                            }
                            break;
                        case 2:
                            try {
                                so.floor(c);
                            } catch (CalException e) {

                            }
                            break;
                        case 3:
                            try {
                                so.squareRoot(c);
                            } catch (CalException e) {

                            }
                            break;
                        case 4:
                            System.out.println("Enter Number to the power of ");
                            double d = sc.nextDouble();
                            Arithmeticoperation acc = new Arithmeticoperation(c, d);
                            try {
                                acc.powerOf(c, d);
                            } catch (CalException e) {

                            }
                            break;
                        case 5:
                            System.out.println("hai back main menu");
                            break;
                        default:
                            System.out.println("Please Enter a Valid Options :");
                            break;
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Please Enter a Valid Options :");
                    break;

            }
            System.out.println("\nDo you want to Continue ?\nPlease type  y or n ");
            yn = sc.next();
        } while (n != 3 && yn.equalsIgnoreCase("y"));

    }
}
