import java.util.Scanner;

public class TransmissionMains {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Enter the Model Number : ");

        String modelNo = sc.next().toUpperCase();
        if (modelNo.equals("MP4") || modelNo.equals("MP5") || modelNo.equals("MP6") || modelNo.equals("MD5")
                || modelNo.equals("MD6")) {
            Manual mn = new Manual(modelNo);
            mn.showSpecs();
        } else if (modelNo.equals("AMTP4") || modelNo.equals("AMTD5")) {
            AMT amt = new AMT(modelNo);
            amt.showSpecs();
        } else if (modelNo.equals("CVT6") || modelNo.equals("DCT8")) {
            CvtDvt cd = new CvtDvt(modelNo);
            cd.showSpecs();
        } else {
            System.out.println("InValid Model Number");
        }
    }
}
