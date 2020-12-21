/**
 * Routes
 */
public class Routes {

    String from;
    String to;
    int distance;
    String travelTime;
    String airFare;

    public Routes() {
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.travelTime = travelTime;
        this.airFare = airFare;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public String getAirFare() {
        return airFare;
    }

    public void setAirFare(String airFare) {
        this.airFare = airFare;
    }

    @Override
    public String toString() {
        return "Routes [airFare=" + airFare + ", distance=" + distance + ", from=" + from + ", to=" + to
                + ", travelTime=" + travelTime + "]\n";
    }

}