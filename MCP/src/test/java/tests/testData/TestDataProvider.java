package tests.testData;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "Wien_LinzHbf")
    public Object[][] Wien_LinzHbf() {
        return new Object[][]{
                {"Wien", "Linz Hbf"},
        };
    }

    @DataProvider(name = "HamburgHbf_Wien")
    public Object[][] HamburgHbf_Wien() {
        return new Object[][]{
                {"Hamburg Hbf", "Wien"},
        };
    }

    @DataProvider(name = "ParisGareDeLyon_NiceVille")
    public Object[][] ParisGareDeLyon_NiceVille() {
        return new Object[][]{
                {"Paris Gare De Lyon", "Nice Ville"},
        };
    }

    @DataProvider(name = "ParisGareDeLyon_LyonPartDieu")
    public Object[][] ParisGareDeLyon_LyonPartDieu() {
        return new Object[][]{
                {"Paris Gare De Lyon", "Lyon Part Dieu"},
        };
    }

    @DataProvider(name = "RomaTermini_MilanoCentrale")
    public Object[][] RomaTermini_MilanoCentrale() {
        return new Object[][]{
                {"Rome Termini", "Milan Main Station"},
        };
    }

    @DataProvider(name = "BerlinHbf_HannoverHbf")
    public Object[][] BerlinHbf_HannoverHbf() {
        return new Object[][]{
                {"Berlin Central Station", "Hannover Hbf"},
        };
    }

    @DataProvider(name = "FrankfurtMainHbf_MilanoCentrale")
    private Object[][] FrankfurtMainHbf_MilanoCentrale() {
        return new Object[][]{
                {"Frankfurt Main Station", "Milan Main Station"},
        };
    }

    @DataProvider(name = "HannoverHbf_NapoliCentrale")
    private Object[][] HannoverHbf_NapoliCentrale() {
        return new Object[][]{
                {"Hannover Hbf", "Naples Main Station"},
        };
    }

    @DataProvider(name = "ParisNord_BruxellesMidi")
    private Object[][] ParisNord_BruxellesMidi() {
        return new Object[][]{
                {"Paris Nord", "Bruxelles Midi"},
        };
    }

    @DataProvider(name = "LondonStPancras_ParisNord")
    private Object[][] LondonStPancras_ParisNord() {
        return new Object[][]{
                {"London St. Pancras", "Paris Nord"},
        };
    }

    @DataProvider(name = "GrazHbf_KlagenfurtHbf")
    private Object[][] GrazHbf_KlagenfurtHbf() {
        return new Object[][]{
                {"Graz Hbf", "Klagenfurt Hbf"},
        };
    }

    @DataProvider(name = "BaselSbb_Bern")
    private Object[][] BaselSbb_Bern() {
        return new Object[][]{
                {"Basel Sbb", "Bern"},
        };
    }

    @DataProvider(name = "MunchenHbf_Vannes")
    private Object[][] MunchenHbf_Vannes() {
        return new Object[][]{
                {"Munich Hbf", "Vannes"},
        };
    }

    @DataProvider(name = "Bern_ZurichHb")
    public Object[][] Bern_ZurichHb() {
        return new Object[][]{
                {"Bern", "Zürich Hb"},
        };
    }

    @DataProvider(name = "Winterthur_St. Gallen")
    public Object[][] Winterthur_StGalen() {
        return new Object[][]{
                {"Winterthur", "St. Gallen"},
        };
    }

    @DataProvider(name = "StGallenCH_Lausanne")
    public Object[][] StGallenCH_Lausanne() {
        return new Object[][]{
                {"St. Gallen", "Lausanne"},
        };
    }

    @DataProvider(name = "Marseille St. Charles_Milano Centrale")
    public Object[][] Marseille_Milano() {
        return new Object[][]{
                {"Marseille St. Charles", "Milan Main Station"},
        };
    }
}