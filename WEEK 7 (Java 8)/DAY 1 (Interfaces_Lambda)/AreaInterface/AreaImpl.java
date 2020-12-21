public class AreaImpl {

    public static void main(String[] args) {
        Area conArea = new Cone();
        conArea.display();
        conArea.area(3, 2);
        Area cyArea = new Cylinder();
        cyArea.display();
        cyArea.area(3, 2);
    }
}
