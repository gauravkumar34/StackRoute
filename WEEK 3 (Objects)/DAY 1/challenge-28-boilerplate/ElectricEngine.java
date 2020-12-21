
public class ElectricEngine extends Engine {

    String currentType;
    int voltage;
    int maxPower;
    int maxRPM;
    int maxTorque;
    int weight;

    public ElectricEngine(String modelNo) {
        super(modelNo);

        maxPower = 88;
        maxRPM = 15000;
        maxTorque = 220;
        weight = 45;
        this.currentType = "AC";
        this.voltage = 360;

    }

    public void showSpecs() {

        System.out.println("Engine Type\t    :  " + "Electrical Engine");
        System.out.println("Engine Power Source : " + " Electric Battery");
        System.out.println("Engine Model Number :  " + modelNo + "\n");

        System.out.println("Key Specification  ");
        System.out.println("1. Max Power : " + maxPower);
        System.out.println("2. Max RPM : " + maxRPM);
        System.out.println("3. Max Torque : " + maxTorque);
        System.out.println("4. Weight : " + weight);
        System.out.println("5. Current Type : " + currentType);
        System.out.println("6. Voltage : " + voltage);

    }

}
