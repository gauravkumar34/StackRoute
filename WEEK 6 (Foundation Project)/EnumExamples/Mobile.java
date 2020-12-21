/**
 * Mobile
 */
public enum Mobile {
    APPLE(10000), SAMSUNG(8000), LG(7000), REDMI(5000);

    private int basePrice;

    Mobile(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getBasePrice() {
        return basePrice;
    }

}

enum TeamTitles {
    HIPHOP("Hiphop"), WIN2WIN("Win2Win"), HAPPYFEET("Happy Feet"), LUCKYSTRIKE("Lucky Strike");

    String teamValue;

    private TeamTitles(String teamValue) {
        this.teamValue = teamValue;
    }

    public String getTeamValue() {
        return teamValue;
    }

    public void setTeamValue(String teamValue) {
        this.teamValue = teamValue;
    }

}