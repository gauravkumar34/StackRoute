/**
 * ticketDetails
 */
public class TicketDetails {
    private String scheduleNo;
    private String routeNo;
    private int ticketFromStopId;
    private int ticketFromStopSeqNo;
    private int ticketTillStopId;
    private int ticketTillStopSeqNo;
    private String ticketDate;
    private String ticketTime;
    private int totalTicketAmount;
    private double travelledKM;

    public TicketDetails() {
        this.scheduleNo = scheduleNo;
        this.routeNo = routeNo;
        this.ticketFromStopId = ticketFromStopId;
        this.ticketFromStopSeqNo = ticketFromStopSeqNo;
        this.ticketTillStopId = ticketTillStopId;
        this.ticketTillStopSeqNo = ticketTillStopSeqNo;
        this.ticketDate = ticketDate;
        this.ticketTime = ticketTime;
        this.totalTicketAmount = totalTicketAmount;
        this.travelledKM = travelledKM;
    }

    public String getScheduleNo() {
        return scheduleNo;
    }

    public void setScheduleNo(String scheduleNo) {
        this.scheduleNo = scheduleNo;
    }

    public String getRouteNo() {
        return routeNo;
    }

    public void setRouteNo(String routeNo) {
        this.routeNo = routeNo;
    }

    public int getTicketFromStopId() {
        return ticketFromStopId;
    }

    public void setTicketFromStopId(int ticketFromStopId) {
        this.ticketFromStopId = ticketFromStopId;
    }

    public int getTicketFromStopSeqNo() {
        return ticketFromStopSeqNo;
    }

    public void setTicketFromStopSeqNo(int ticketFromStopSeqNo) {
        this.ticketFromStopSeqNo = ticketFromStopSeqNo;
    }

    public int getTicketTillStopId() {
        return ticketTillStopId;
    }

    public void setTicketTillStopId(int ticketTillStopId) {
        this.ticketTillStopId = ticketTillStopId;
    }

    public int getTicketTillStopSeqNo() {
        return ticketTillStopSeqNo;
    }

    public void setTicketTillStopSeqNo(int ticketTillStopSeqNo) {
        this.ticketTillStopSeqNo = ticketTillStopSeqNo;
    }

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getTicketTime() {
        return ticketTime;
    }

    public void setTicketTime(String ticketTime) {
        this.ticketTime = ticketTime;
    }

    public int getTotalTicketAmount() {
        return totalTicketAmount;
    }

    public void setTotalTicketAmount(int totalTicketAmount) {
        this.totalTicketAmount = totalTicketAmount;
    }

    public double getTravelledKM() {
        return travelledKM;
    }

    public void setTravelledKM(double travelledKM) {
        this.travelledKM = travelledKM;
    }

    @Override
    public String toString() {
        return "ticketDetails [routeNo=" + routeNo + ", scheduleNo=" + scheduleNo + ", ticketDate=" + ticketDate
                + ", ticketFromStopId=" + ticketFromStopId + ", ticketFromStopSeqNo=" + ticketFromStopSeqNo
                + ", ticketTillStopId=" + ticketTillStopId + ", ticketTillStopSeqNo=" + ticketTillStopSeqNo
                + ", ticketTime=" + ticketTime + ", totalTicketAmount=" + totalTicketAmount + ", travelledKM="
                + travelledKM + "]\n";
    }

}