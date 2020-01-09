package data;

public class Connection {
    public String depTime;
    public String arrTime;
    public String changes;
    public String duration;
    public String firstClassPrice;
    public String secondClassPrice;

    public Connection(String depTime, String arrTime, String changes, String duration, String firstClassPrice, String secondClassPrice){
        this.depTime = depTime;
        this.arrTime = arrTime;
        this.changes = changes;
        this.duration = duration;
        this.firstClassPrice = firstClassPrice;
        this.secondClassPrice = secondClassPrice;
    }
}
