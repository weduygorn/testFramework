package data;

public enum Stations {
    ROME(8308409, "Rome Termini"),
    VENICE_SL(8302593, "Venice Santa Lucia"),
    VERONA_PN(8302430, "Verona Porta Nuova"),
    MILAN(8301700, "Milan Main Station"),
    ZURICH_HB(8503000, "Zürich Hb"),
    NICE_VILLE(8775605, "Nice Ville"),
    REGGIO_DC(8311781, "Reggio Di Calabria Main Station"),
    RAVENNA(8313827, "Ravenna"),
    LASPEZIA_CENTRALE(8306000, "La Spezia Centrale"),
    CANNES(8775762, "Cannes"),
    BOLOGNA(8305043, "Bologna Main Station"),
    DRESDEN(8006050, "Dresden Hbf"),
    NAPLES(8309218, "Naples Main Station"),
    HAMBURG(8001071, "Hamburg Hbf"),
    BERLIN(8065969, "Berlin Central Station"),
    FIRENZE(8306421, "Firenze Santa Maria Novella"),
    COLOGNE(8015458, "Cologne Centrale"),
    WIEN_CENTRAL(8108000, "Vienna Central Station"),
    MARSEILLE(8775100, "Marseille St. Charles"),
    PARIS_NORD(8727100, "Paris Nord"),
    BRUSSELS_SOUTH(8814001, "Brussels South"),
    MUNICH(8020347, "Munich Hbf");


    public final int id;
    public final String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    Stations(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
