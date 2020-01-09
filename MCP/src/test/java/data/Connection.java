package data;

import pages.blocks.search.ConnectionsBlock;
import ru.yandex.qatools.htmlelements.element.Button;

public class Connection {

    public String stations;
    public String time;
    public String duration;
    public String changes;
    public String product;
    public Double savingFares;
    public Double flexpreis;
    public Button toOfferSelection;

    public String getStations() {
        return stations;
    }

    public String getTime() {
        return time;
    }

    public String getDuration() {
        return duration;
    }

    public String getChanges() {
        return changes;
    }

    public String getProduct() {
        return product;
    }

    public Double getSavingFares() {
        return savingFares;
    }

    public Double getFlexpreis() {
        return flexpreis;
    }


    public Connection(ConnectionsBlock conn) {
        this.stations = conn.getStations();
        this.time = conn.getTime();
        this.duration = conn.getDuration();
        this.changes = conn.getChanges();
        this.product = conn.getProduct();
        this.savingFares = conn.getSavingFaresPrice();
        this.flexpreis = conn.getFlexPrice();
        this.toOfferSelection = conn.getToOfferSelection();
    }

    @Override
    public String toString() {
        return "ConnectionData{" +
                "stations='" + stations + '\'' +
                ", time='" + time + '\'' +
                ", duration='" + duration + '\'' +
                ", changes='" + changes + '\'' +
                ", product='" + product + '\'' +
                ", savingFares=" + savingFares +
                ", flexpreis=" + flexpreis +
                '}';
    }
}
