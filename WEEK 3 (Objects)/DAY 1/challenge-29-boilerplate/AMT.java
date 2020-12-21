public class AMT extends Transmission {
    String engineType;
    int forwardGear;
    double GearRatio1st;
    double GearRatio2st;
    double GearRatio3st;
    double GearRatio4st;
    double GearRatio5st;

    public AMT(String modelNo) {
        super(modelNo);
        engineType = "AMT";
        switch (modelNo) {
            case "AMTP4":
                forwardGear = 4;
                GearRatio1st = 2.540;
                GearRatio2st = 1.920;
                GearRatio3st = 1.510;
                GearRatio4st = 1.000;
                break;
            case "AMTD5":
                forwardGear = 5;
                GearRatio1st = 2.950;
                GearRatio2st = 1.940;
                GearRatio3st = 1.340;
                GearRatio4st = 1.000;
                GearRatio5st = 0.630;
                break;
            default:
                System.out.println("Please Enter a valid Model Number.");
                System.exit(0);
                break;
        }

    }

    public void showSpecs() {
        System.out.println("\nTransmission Type      :  " + engineType);
        System.out.println("Transmission Model Number:  " + modelNo);
        System.out.println("Key Specification  ");
        System.out.println("1. Forward Gears  : " + forwardGear);
        System.out.println("2. 1st Gear Ratio : " + GearRatio1st);
        System.out.println("3. 2nd Gear Ratio : " + GearRatio2st);
        System.out.println("4. 3rd Gear Ratio : " + GearRatio3st);
        System.out.println("5. 4th Gear Ratio : " + GearRatio4st);
        System.out.println("6. 5th Gear Ratio : " + GearRatio5st);
    }

}
