public class Cylinder implements Area {

    @Override
    public void area(double r, double h) {
        // 2πrh+2πr2
        double areaCylinder = 2 * pi * r * h + 2 * pi * Math.pow(r, 2);
        System.out.println(areaCylinder);

    }

    public void display() {
        System.out.println("Area of Cylinder  ");
    }

}
