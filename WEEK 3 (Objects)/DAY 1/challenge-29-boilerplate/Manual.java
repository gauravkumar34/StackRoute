
public class Manual extends Transmission {
    String engineType;
    int forwardGear;
    double GearRatio1st;
    double GearRatio2st;
    double GearRatio3st;
    double GearRatio4st;
    double GearRatio5st;
    double GearRatio6st;

    public Manual(String modelNo) {
        super(modelNo);
        engineType = "Manual Automatic";
        switch (modelNo) {
            case "MP4":
                forwardGear = 4;
                GearRatio1st = 2.540;
                GearRatio2st = 1.920;
                GearRatio3st = 1.540;
                GearRatio4st = 1.000;
                break;
            case "MP5":
                forwardGear = 5;
                GearRatio1st = 3.545;
                GearRatio2st = 1.904;
                GearRatio3st = 1.280;
                GearRatio4st = 0.914;
                GearRatio5st = 0.757;
                break;
            case "MP6":
                forwardGear = 6;
                GearRatio1st = 3.010;
                GearRatio2st = 2.070;
                GearRatio3st = 1.430;
                GearRatio4st = 1.000;
                GearRatio5st = 0.710;
                GearRatio6st = 0.570;
                break;
            case "MD5":
                forwardGear = 5;
                GearRatio1st = 3.545;
                GearRatio2st = 1.904;
                GearRatio3st = 1.233;
                GearRatio4st = 0.911;
                GearRatio5st = 0.725;
                break;
            case "MD6":
                forwardGear = 6;
                GearRatio1st = 3.640;
                GearRatio2st = 2.150;
                GearRatio3st = 1.360;
                GearRatio4st = 1.000;
                GearRatio5st = 0.750;
                GearRatio6st = 0.630;
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
        System.out.println("7. 6th Gear Ratio : " + GearRatio6st);
    }

}