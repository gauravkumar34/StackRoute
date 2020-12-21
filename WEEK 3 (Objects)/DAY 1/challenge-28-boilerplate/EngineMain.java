import java.util.Scanner;

public class EngineMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the Model Number : ");
        String modelNo = sc.next().toUpperCase();

        switch (modelNo) {
            case "88":
                ElectricEngine ee = new ElectricEngine(modelNo);
                ee.showSpecs();
                break;
            default:
                ICE ce = new ICE(modelNo);
                ce.showSpecs();
                break;
        }

    }
}
