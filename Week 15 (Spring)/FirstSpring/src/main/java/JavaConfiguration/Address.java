package JavaConfiguration;
public class Address {
    private int doorNo;
    private String streetName;
    private String location;
    private long pincode;
    public Address(int doorNo, String streetName, String location, long pincode) {
        this.doorNo = doorNo;
        this.streetName = streetName;
        this.location = location;
        this.pincode = pincode;
    }
    @Override
    public String toString() {
        return "Address{" +
                "doorNo=" + doorNo +
                ", streetName='" + streetName + '\'' +
                ", location='" + location + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}