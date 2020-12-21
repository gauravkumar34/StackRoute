public class ICE extends Engine {

    String engineType;
    String enginePowerSource;
    int noCylinder;
    int displacement;
    String compRatio;
    int maxPower;
    int maxRPM;
    int maxTorque;
    int weight;

    public ICE(String modelNo) {
        super(modelNo);
        engineType = "Internal Combustion Engine";
        switch (modelNo) {
            case "C1500":
                maxPower = 69;
                maxRPM = 6500;
                maxTorque = 122;
                weight = 93;
                enginePowerSource = "CNG";
                noCylinder = 4;
                displacement = 1498;
                compRatio = "10.5:1";
                break;
            case "C1000":
                maxPower = 43;
                maxRPM = 6000;
                maxTorque = 78;
                weight = 75;
                enginePowerSource = "CNG";
                noCylinder = 3;
                displacement = 988;
                compRatio = "11.0:1";
                break;
            case "D2400":
                maxPower = 136;
                maxRPM = 7000;
                maxTorque = 233;
                weight = 152;
                enginePowerSource = "Diesel";
                noCylinder = 4;
                displacement = 2384;
                compRatio = "11.2:1";
                break;
            case "D1800":
                maxPower = 103;
                maxRPM = 6300;
                maxTorque = 170;
                weight = 141;
                enginePowerSource = "Diesel";
                noCylinder = 4;
                displacement = 1796;
                compRatio = "10.5:1";
                break;
            case "D1300":
                maxPower = 67;
                maxRPM = 6000;
                maxTorque = 200;
                weight = 140;
                enginePowerSource = "Diesel";
                noCylinder = 4;
                displacement = 1248;
                compRatio = "17.6:1";
                break;
            case "P2400":
                maxPower = 138;
                maxRPM = 6900;
                maxTorque = 340;
                weight = 140;
                enginePowerSource = "Petrol";
                noCylinder = 6;
                displacement = 2396;
                compRatio = "10.5:1";
                break;
            case "P2000":
                maxPower = 118;
                maxRPM = 6500;
                maxTorque = 220;
                weight = 93;
                enginePowerSource = "Petrol";
                noCylinder = 4;
                displacement = 1992;
                compRatio = "12.0:1";
                break;
            case "P1500":
                maxPower = 88;
                maxRPM = 6500;
                maxTorque = 155;
                weight = 75;
                enginePowerSource = "Petrol";
                noCylinder = 4;
                displacement = 1498;
                compRatio = "10.3:1";
                break;
            case "P1000":
                maxPower = 50;
                maxRPM = 6000;
                maxTorque = 90;
                weight = 75;
                enginePowerSource = "Petrol";
                noCylinder = 3;
                displacement = 996;
                compRatio = "11.0:1";
                break;
            default:
                System.out.println("\n****** INVALID Model Number ******");
                System.exit(0);
                break;
        }

    }

    public void showSpecs() {

        System.out.println("\nEngine Type\t    :  " + engineType);
        System.out.println("Engine Power Source :  " + enginePowerSource);
        System.out.println("Engine Model Number :  " + modelNo + "\n");

        System.out.println("Key Specification  ");
        System.out.println("1. Max Power : " + maxPower + " kW (158 HP)");
        System.out.println("2. Max RPM : " + maxRPM);
        System.out.println("3. Max Torque : " + maxTorque + " Nm");
        System.out.println("4. Weight : " + weight + " Kgs");
        System.out.println("5. No of Cylinder : " + noCylinder);
        System.out.println("6. Displacement : " + displacement + " cc");
        System.out.println("7. Composition Ratio : " + compRatio);
    }

}
