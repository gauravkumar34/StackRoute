public class Address {
    private int houseNo;
    private String streetName;
    private String city;
    private int pincode;

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public Address(int houseNo, String streetName, String city, int pincode) {
        this.houseNo = houseNo;
        this.streetName = streetName;
        this.city = city;
        this.pincode = pincode;
    }

    
    
}
