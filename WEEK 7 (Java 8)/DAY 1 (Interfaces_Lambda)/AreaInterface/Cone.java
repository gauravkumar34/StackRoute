public class Cone implements Area {

    @Override
    public void area(double r, double h) {
        // πr(r+h2+r2)
        double areaCone = pi * r * (r + Math.pow(r, 2) + Math.pow(h, 2));
        System.out.println(areaCone);

    }

    public void display() {
        System.out.println("Area of Cone  ");
    }

}
