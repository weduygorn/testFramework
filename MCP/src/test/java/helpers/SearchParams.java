package helpers;

import data.Passenger;

import java.util.Arrays;

public class SearchParams {

    String stationFrom;

    String stationTo;

    String outwardDate;

    String inwardDate;

    boolean roundTrip;

    String searchMode;

    String[] passengerBirthDates;
    Passenger[] passengers;
    Passenger passenger;

    String[] reductionCards;

    String outwardTime;

    String inwardTime;


    public SearchParams() {
    }

    public String getStationFrom() {
        return stationFrom;
    }

    public String getStationTo() {
        return stationTo;
    }

    public String getOutwardDate() {
        return outwardDate;
    }

    public String getInwardDate() {
        return inwardDate;
    }

    public boolean isRoundTrip() {
        return roundTrip;
    }

    public String[] getPassengerBirthDates() {
        return passengerBirthDates;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public String getOutwardTime() {
        return outwardTime;
    }

    public String getInwardTime() {
        return inwardTime;
    }

    public String getSearchMode() {
        return searchMode;
    }

    public SearchParams withStationFrom(String stationFrom) {
        this.stationFrom = stationFrom;
        return this;
    }

    public SearchParams withStationTo(String stationTo) {
        this.stationTo = stationTo;
        return this;
    }

    public SearchParams withDateOutward(String outwardDate) {
        this.outwardDate = outwardDate;
        return this;
    }

    public SearchParams withDateInward(String inwardDate) {
        this.inwardDate = inwardDate;
        return this;
    }

    public SearchParams withRoundTrip(boolean roundTrip) {
        this.roundTrip = roundTrip;
        return this;
    }

    public SearchParams withOutwardTime(String outwardTime) {
        this.outwardTime = outwardTime;
        return this;
    }

    public SearchParams withInwardTime(String inBoundTimeTo) {
        this.inwardTime = inBoundTimeTo;
        return this;
    }

    public SearchParams withPassengerBirthDates(String[] passengerBirthDates) {
        this.passengerBirthDates = passengerBirthDates;
        return this;
    }

    public SearchParams withPassenger(Passenger passenger) {
        this.passenger = passenger;
        return this;
    }

    public SearchParams withPassengers(Passenger[] passengers) {
        this.passengers = passengers;
        return this;
    }

    public SearchParams withSearchMode(String searchMode) {
        this.searchMode = searchMode;
        return this;
    }

    public SearchParams withReductionCards(String[] reductionCards) {
        this.reductionCards = reductionCards;
        return this;
    }


    @Override
    public String toString() {
        return "SearchParams{" +
                "stationFrom='" + stationFrom + '\'' +
                ", stationTo='" + stationTo + '\'' +
                ", roundTrip=" + roundTrip +
                ", outwardDate='" + outwardDate + '\'' +
                ", inwardDate='" + inwardDate + '\'' +
                ", outwardTime='" + outwardTime + '\'' +
                ", inwardTime='" + inwardTime + '\'' +
                ", searchMode='" + searchMode + '\'' +
                ", passengerBirthDates=" + Arrays.toString(passengerBirthDates) +
                ", reductionCards=" + Arrays.toString(reductionCards) +
                '}';
    }


}
