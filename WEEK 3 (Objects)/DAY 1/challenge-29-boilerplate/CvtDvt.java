public class CvtDvt extends Transmission {
    String engineType;
    int forwardGear;
    double GearRatio1st;
    double GearRatio2st;
    double GearRatio3st;
    double GearRatio4st;
    double GearRatio5st;
    double GearRatio6st;
    double GearRatio7st;
    double GearRatio8st;

    public CvtDvt(String modelNo) {
        super(modelNo);
        switch (modelNo) {
            case "CVT6":
                engineType = "Automatic - CVT";
                forwardGear = 6;
                GearRatio1st = 2.631;
                GearRatio2st = 1.440;
                GearRatio3st = 1.440;
                GearRatio4st = 1.165;
                GearRatio5st = 0.902;
                break;
            case "DCT8":
                engineType = "Automatic - DCT";
                forwardGear = 8;
                GearRatio1st = 4.714;
                GearRatio2st = 3.143;
                GearRatio3st = 2.106;
                GearRatio4st = 1.667;
                GearRatio5st = 1.258;
                GearRatio6st = 1.000;
                GearRatio7st = 0.839;
                GearRatio8st = 0.667;
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
        System.out.println("8. 7th Gear Ratio : " + GearRatio7st);
        System.out.println("9. 8th Gear Ratio : " + GearRatio8st);
    }

}
