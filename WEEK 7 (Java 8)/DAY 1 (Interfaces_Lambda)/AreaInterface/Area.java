/**
 * Area
 */
public interface Area {
    double pi = 3.14;

    public void area(double r, double h);

    public default void display() {
        System.out.println("Area of...............");
    }
}