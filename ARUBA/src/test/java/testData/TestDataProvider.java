package testData;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static helpers.DateTimeHelper.getDate;

public class TestDataProvider {

    @DataProvider(name = "searchAvailableConnection", parallel = true)
    public Object[][] searchAvailableConnectionData() throws Exception {
        return new Object[][] {
                {"Zürich HB", "Hamburg Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"},
                {"Zürich HB", "Kassel Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"},
                {"Zürich HB", "Mainz Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"}};
    }
//    public static Iterator<Object[]> allDataForSearchAvailableConnection() {
//        List<Object[]> data = new ArrayList<>();
        /**
         Data for France:
         */
//        data.add(new Object[]{"Genève","Paris Gare de Lyon", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Genève","Marseille-Saint-Charles", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Genève","Avignon TGV", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Genève","Lyon-Part-Dieu", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Genève","Aix-en-Provence TGV", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Genève","Bourg-en-Bresse", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Paris Gare de Lyon","Genève", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Marseille-Saint-Charles","Genève", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Avignon TGV","Genève", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Lyon-Part-Dieu","Genève", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Aix-en-Provence TGV","Genève", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bourg-en-Bresse","Genève", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern","Paris Gare de Lyon", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Paris Gare de Lyon","Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern","Dijon Ville", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Dijon Ville","Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB","Paris Gare de Lyon", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB","Mulhouse Ville", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB","Dijon Ville", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
////        data.add(new Object[]{"Basel SBB","Lyon-Part-Dieu", getDate("dd.MM.yyyy","+7days"), "02:00"}); TODO: Button to CFD not displayed
//        data.add(new Object[]{"Basel SBB","Avignon TGV", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB","Aix-en-Provence TGV", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB","Marseille-Saint-Charles", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Paris Gare de Lyon","Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Mulhouse Ville","Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Dijon Ville","Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
////        data.add(new Object[]{"Lyon-Part-Dieu","Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00"}); TODO: Button to CFD not displayed
//        data.add(new Object[]{"Avignon TGV","Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Aix-en-Provence TGV","Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Marseille-Saint-Charles","Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB","Paris Gare de Lyon", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB","Dijon Ville", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB","Belfort-Montbéliard TGV", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB","Mulhouse Ville", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Paris Gare de Lyon","Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Dijon Ville","Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Belfort-Montbéliard TGV","Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Mulhouse Ville","Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Lausanne","Paris Gare de Lyon", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Paris Gare de Lyon","Lausanne", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
        /**
         Data for Germany:
         */
//        data.add(new Object[]{"Basel SBB", "Freiburg (Breisgau) Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB", "Frankfurt (Main) Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB", "Mannheim Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB", "Karlsruhe Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB", "Ringsheim", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB", "Dortmund Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB", "Frankfurt Flughafen", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB", "Stuttgart Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB", "Heidelberg Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB", "Berlin Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB", "Baden-Baden", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB", "Hamburg Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB", "Kassel Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB", "Mainz Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB", "Offenburg", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB", "Hannover Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB", "Düsseldorf Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB", "Leipzig Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Basel SBB", "Köln Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Freiburg (Breisgau) Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Frankfurt (Main) Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Mannheim Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Karlsruhe Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Ringsheim", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Köln Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Dortmund Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Frankfurt Flughafen", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Stuttgart Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Heidelberg Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Berlin Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Baden-Baden", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Hamburg Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Kassel Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Mainz Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Offenburg", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Hannover Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Düsseldorf Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Leipzig Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Köln Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "München Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich HB", "Stuttgart Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern", "Freiburg (Breisgau) Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern", "Frankfurt (Main) Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern", "Mannheim Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern", "Karlsruhe Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern", "Ringsheim", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern", "Köln Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern", "Dortmund Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern", "Frankfurt Flughafen", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern", "Stuttgart Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern", "Heidelberg Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern", "Berlin Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern", "Baden-Baden", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern", "Hamburg Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern", "Kassel Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern", "Mainz Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern", "Offenburg", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern", "Hannover Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern", "Düsseldorf Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern", "Leipzig Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bern", "Köln Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Chur", "Freiburg (Breisgau) Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Chur", "Karlsruhe Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Chur", "Mannheim Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Chur", "Mainz Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Chur", "Köln Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Chur", "Dortmund Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Chur", "Bremen Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Interlaken Ost", "Freiburg (Breisgau) Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Interlaken Ost", "Karlsruhe Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Interlaken Ost", "Mannheim Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Interlaken Ost", "Frankfurt (Main) Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Interlaken Ost", "Berlin Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Interlaken West", "Freiburg (Breisgau) Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Interlaken West", "Karlsruhe Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Interlaken West", "Mannheim Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Interlaken West", "Frankfurt (Main) Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Interlaken West", "Berlin Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Schaffhausen", "Stuttgart Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"St. Gallen", "München Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Winterthur", "München Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Zürich Flughafen", "München Hbf", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Freiburg (Breisgau) Hbf", "Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Frankfurt (Main) Hbf", "Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Mannheim Hbf", "Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Karlsruhe Hbf", "Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Ringsheim", "Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Köln Hbf", "Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Dortmund Hbf", "Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Frankfurt Flughafen", "Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Stuttgart Hbf", "Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Heidelberg Hbf", "Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Berlin Hbf", "Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Baden-Baden", "Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Hamburg Hbf", "Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Kassel Hbf", "Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Mainz Hbf", "Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Offenburg", "Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Hannover Hbf", "Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Düsseldorf Hbf", "Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Leipzig Hbf", "Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Köln Hbf", "Basel SBB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Freiburg (Breisgau) Hbf", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Frankfurt (Main) Hbf", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Mannheim Hbf", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Karlsruhe Hbf", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Ringsheim", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Köln Hbf", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Dortmund Hbf", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Frankfurt Flughafen", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Stuttgart Hbf", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Heidelberg Hbf", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Berlin Hbf", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Baden-Baden", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Hamburg Hbf", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Kassel Hbf", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Mainz Hbf", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Offenburg", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Hannover Hbf", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Düsseldorf Hbf", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Leipzig Hbf", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Köln Hbf", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"München Hbf", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Stuttgart Hbf", "Zürich HB", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Freiburg (Breisgau) Hbf", "Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Frankfurt (Main) Hbf", "Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Mannheim Hbf", "Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Karlsruhe Hbf", "Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Ringsheim", "Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Köln Hbf", "Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Dortmund Hbf", "Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Frankfurt Flughafen", "Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Stuttgart Hbf", "Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Heidelberg Hbf", "Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Berlin Hbf", "Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Baden-Baden", "Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Hamburg Hbf", "Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Kassel Hbf", "Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Mainz Hbf", "Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Offenburg", "Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Hannover Hbf", "Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Düsseldorf Hbf", "Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Leipzig Hbf", "Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Köln Hbf", "Bern", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Freiburg (Breisgau) Hbf", "Chur", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Karlsruhe Hbf", "Chur", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Mannheim Hbf", "Chur", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Mainz Hbf", "Chur", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Köln Hbf", "Chur", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Dortmund Hbf", "Chur", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Bremen Hbf", "Chur", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Freiburg (Breisgau) Hbf", "Interlaken Ost", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Karlsruhe Hbf", "Interlaken Ost", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Mannheim Hbf", "Interlaken Ost", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Frankfurt (Main) Hbf", "Interlaken Ost", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Berlin Hbf", "Interlaken Ost", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Freiburg (Breisgau) Hbf", "Interlaken West", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Karlsruhe Hbf", "Interlaken West", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Mannheim Hbf", "Interlaken West", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Frankfurt (Main) Hbf", "Interlaken West", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Berlin Hbf", "Interlaken West", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"Stuttgart Hbf", "Schaffhausen", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"München Hbf", "St. Gallen", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"München Hbf", "Winterthur", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        data.add(new Object[]{"München Hbf", "Zürich Flughafen", getDate("dd.MM.yyyy","+7days"), "02:00", "Arrival"});
//        return data.iterator();
//    }
    @DataProvider(name = "searchWDI")
    public static Iterator<Object[]> searchWDI() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"Genève", "Paris Gare de Lyon", getDate("dd.MM.yyyy","+Month"), "15:00", "Departure"});
        return data.iterator();
    }


    @DataProvider(name = "searchByArrival")
    public static Iterator<Object[]> searchByArrival() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"Bern", "Ringsheim", getDate("dd.MM.yyyy","+Month"), "02:00", "Arrival"});
        return data.iterator();
    }

    @DataProvider(name = "searchByDeparture")
    public static Iterator<Object[]> searchByDeparture() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"Bern", "Ringsheim", getDate("dd.MM.yyyy","+Month"), "15:00", "Departure"});
        return data.iterator();
    }

    @DataProvider(name = "scrollToPrevDayConnections")
    public static Iterator<Object[]> scrollToPrevDayConnections() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"Bern", "Ringsheim", getDate("dd.MM.yyyy","+7days"), "15:00", "Departure"});
        return data.iterator();
    }

    @DataProvider(name = "scrollToNextDayConnections")
    public static Iterator<Object[]> scrollToNextDayConnections() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"Bern", "Ringsheim", getDate("dd.MM.yyyy","+9days"), "15:00", "Departure"});
        return data.iterator();
    }

    @DataProvider(name = "checkNoOfferAvailableCardWithEarlier")
    public static Iterator<Object[]> checkNoOfferAvailableCardWithEarlier() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"Bern", "Offenburg", getDate("dd.MM.yyyy","+Month"), "00:02", "Departure"});
        return data.iterator();
    }

    @DataProvider(name = "checkNoOfferAvailableCardWithLater")
    public static Iterator<Object[]> checkNoOfferAvailableCardWithLater() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"Bern", "Offenburg", getDate("dd.MM.yyyy","+Month"), "21:00", "Departure"});
        return data.iterator();
    }

    @DataProvider(name = "checkProductInformation")
    public static Iterator<Object[]> digitalDataTest() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"Basel SBB", "Düsseldorf Hbf", getDate("dd.MM.yyyy","+Month"), "02:00", "Arrival"});
        return data.iterator();
    }

    @DataProvider(name = "checkTranslations")
    public static Iterator<Object[]> checkTranslations() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"Bern", "Ringsheim", getDate("dd.MM.yyyy","+Month"), "02:00", "Departure"});
        return data.iterator();
    }

    @DataProvider(name = "jumpInWDIGeneration")
    public static Iterator<Object[]> jumpInWDIGeneration() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"8507000", "Bern", "8768600", "Paris-Gare-de-Lyon"});
        data.add(new Object[]{"8507000", "Bern", "8771304", "Dijon Ville"});
        data.add(new Object[]{"8771304", "Dijon Ville", "8507000", "Bern"});
        data.add(new Object[]{"8500010", "Basel SBB", "8768600", "Paris-Gare-de-Lyon"});
        data.add(new Object[]{"8500010", "Basel SBB", "8718206", "Mulhouse Ville"});
        data.add(new Object[]{"8500010", "Basel SBB", "8771304", "Dijon Ville"});
        data.add(new Object[]{"8500010", "Basel SBB", "8731896", "Avignon TGV"});
        data.add(new Object[]{"8500010", "Basel SBB", "8775100", "Marseille-Saint-Charles"});
        data.add(new Object[]{"8768600", "Paris-Gare-de-Lyon", "8500010", "Basel SBB"});
        data.add(new Object[]{"8718206", "Mulhouse Ville", "8500010", "Basel SBB"});
        data.add(new Object[]{"8771304", "Dijon Ville", "8500010", "Basel SBB"});
        data.add(new Object[]{"8731896", "Avignon TGV", "8500010", "Basel SBB"});
        data.add(new Object[]{"8775100", "Marseille-Saint-Charles", "8500010", "Basel SBB"});
        data.add(new Object[]{"8501120", "Lausanne", "8768600", "Paris-Gare-de-Lyon"});
        data.add(new Object[]{"8768600", "Paris-Gare-de-Lyon", "8501120", "Lausanne"});
        return data.iterator();
    }

    @DataProvider(name = "spicificGenerationLink")
    public static Iterator<Object[]> spicificGenerationLink() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"8501008", "Genève", "8768600", "Paris-Gare-de-Lyon"});
//        data.add(new Object[]{"8503000", "Zürich HB", "8029034", "Stuttgart Hbf"});
//        data.add(new Object[]{"8506302", "St. Gallen", "8020347", "München Hbf"});

        return data.iterator();
    }

}