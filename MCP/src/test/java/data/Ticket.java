package data;

public class Ticket {

    public String ticketTitle;
    public String travelZone;
    public String reservationTitle;
    public String reservationInfo;
    public String reservedTravellersTitle;
    public String textWarning;

    public String getTicketTitle() {
        return ticketTitle;
    }

    public void setTicketTitle(String ticketTitle) {
        this.ticketTitle = ticketTitle;
    }

    public String getTravelZone() {
        return travelZone;
    }

    public void setTravelZone(String travelZone) {
        this.travelZone = travelZone;
    }

    public String getReservationTitle() {
        return reservationTitle;
    }

    public void setReservationTitle(String reservationTitle) {
        this.reservationTitle = reservationTitle;
    }

    public String getReservationInfo() {
        return reservationInfo;
    }

    public void setReservationInfo(String reservationInfo) {
        this.reservationInfo = reservationInfo;
    }

    public String getReservedTravellersTitle() {
        return reservedTravellersTitle;
    }

    public void setReservedTravellersTitle(String reservedTravellersTitle) {
        this.reservedTravellersTitle = reservedTravellersTitle;
    }

    public String getTextWarning() {
        return textWarning;
    }

    public void setTextWarning(String textWarning) {
        this.textWarning = textWarning;
    }

    public Ticket(String ticketTitle, String travelZone, String reservationTitle, String reservationInfo, String reservedTravellersTitle, String textWarning) {
        this.ticketTitle = ticketTitle;
        this.travelZone = travelZone;
        this.reservationTitle = reservationTitle;
        this.reservationInfo = reservationInfo;
        this.reservedTravellersTitle = reservedTravellersTitle;
        this.textWarning = textWarning;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketTitle='" + ticketTitle + '\'' +
                ", travelZone='" + travelZone + '\'' +
                ", reservationTitle='" + reservationTitle + '\'' +
                ", reservationInfo='" + reservationInfo + '\'' +
                ", reservedTravellersTitle='" + reservedTravellersTitle + '\'' +
                ", textWarning='" + textWarning + '\'' +
                '}';
    }
}
