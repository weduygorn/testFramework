package data;

import static helpers.DateTimeHelper.currentDatePlusNDaysNotWeekend;

public enum DBlink {

    ROME_MILAN_OW("/request/C=1&PA[1]=30&PC[1]=0&OB=8300263$8300046$YYYYMMDDOUT0600$YYYYMMDDOUT0855$FRO+9600", currentDatePlusNDaysNotWeekend(14), null),
    VIENNA_SIENA_OW("/request/C=2&PT[1]=E&PC[1]=0&OB=8103000$8300093$YYYYMMDDOUT0625$YYYYMMDDOUT1353$RJ+131^8300093$8300151$YYYYMMDDOUT1438$YYYYMMDDOUT1639$FA+9425^8300151$8300175$YYYYMMDDOUT1710$YYYYMMDDOUT1838$R+3135", currentDatePlusNDaysNotWeekend(45), null),
    ROME_MILAN_RT("/request/C=2&PT[1]=E&PC[1]=0&OB=8300263$8300046$YYYYMMDDOUT1400$YYYYMMDDOUT1655$FR+9634&IB=8300046$8300263$YYYYMMDDIN1200$YYYYMMDDIN1503$FR+9631", currentDatePlusNDaysNotWeekend(14), currentDatePlusNDaysNotWeekend(21));

    public String link;
    public String outwardDate;
    public String inwardDate;

    public String getLink() {
        return link;
    }

    public String getOutwardDate() {
        return outwardDate;
    }

    public String getInwardDate() {
        return inwardDate;
    }

    DBlink(String link, String outwardDate, String inwardDate) {
        this.link = link;
        this.outwardDate = outwardDate;
        this.inwardDate = inwardDate;

    }


    protected String RomeMilanOWLink = "/request/C=1&PA[1]=30&PC[1]=0&OB=8300263$8300046$YYYYMMDD0600$YYYYMMDD0855$FRO+9600";
    protected String RomeMilanRTLink = "/request/C=2&PA[1]=30&PC[1]=0&PT[1]=E&OB=8300263$8300046$YYYYMMDDOUT0600$YYYYMMDDOUT0855$ES+9600&IB=8300046$8300263$YYYYMMDDIN0615$YYYYMMDDIN0955$ES+9503";
    protected String MunichRoma = "/request/C=2&PT[1]=E&PC[1]=0&OB=8000261$8300217$YYYYMMDDOUT0934$YYYYMMDDOUT1620$EC+85^8300217$8300263$YYYYMMDDOUT1635$YYYYMMDDOUT1828$ES+9641";
    //    protected String MunichRoma="/request/C=2&PT[1]=E&PC[1]=0&OB=8000261$8300217$YYYYMMDDOUT0851$YYYYMMDDOUT1620$EC+85^8300217$8300263$YYYYMMDDOUT1635$YYYYMMDDOUT1828$FR+9641";
    protected String MunichVerona = "/request/C=2&PA[1]=30&PC[1]=0&PT[1]=E&OB=8000261$8300120$YYYYMMDD1334$YYYYMMDD1858$EC+89";
    protected String BaselSbbBernOWLink = "/request/C=2&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&OB=8500010$8507000$YYYYMMDD1131$YYYYMMDD1224$IC+1069";
    protected String GrazKlagenfurtOWLink = "/request/C=2&PT[1]=E&PC[1]=0&OB=8181512$8197056$YYYYMMDD1230$YYYYMMDD1430$Bus+957";
    protected String GrazKlagenfurtRTLink = "/request/C=2&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&OB=8181512$8197056$YYYYMMDDOUT1230$YYYYMMDDOUT1430$Bus+957&IB=8197056$8181512$YYYYMMDDIN1345$YYYYMMDDIN1545$Bus+956";
    protected String BaselSbbBernRTLink = "/request/C=2&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&OB=8500010$8500218$YYYYMMDDOUT1004$YYYYMMDDOUT1028$IR+2319^8500218$8507000$YYYYMMDDOUT1036$YYYYMMDDOUT1121$IR+2364&IB=8507000$8500218$YYYYMMDDIN1238$YYYYMMDDIN1324$IR+2371^8500218$8500010$YYYYMMDDIN1330$YYYYMMDDIN1355$IR+2320";
    protected String ParisNordBruxellesMidiOWLink = "/request/C=2&PT[1]=E&PC[1]=0&OB=8700014$8800004$YYYYMMDD1146$YYYYMMDD1317$THA+9437";
    protected String ParisNordBruxellesMidiRTLink = "/request/C=2&PT[1]=E&PC[1]=0&OB=8700014$8800004$YYYYMMDDOUT1146$YYYYMMDDOUT1317$THA+9437&IB=8800004$8700014$YYYYMMDDIN1237$YYYYMMDDIN1359$THA+9336";
    protected String LondonParisNordOWlink = "/request/C=2&PT[1]=E&PC[1]=0&OB=7004428$8798014$201906201531$201906201847$EST+9036";
    protected String LondonParisNordRTLink = "/request/C=2&PT[1]=E&PC[1]=0&OB=7004428$8798014$201904071631$201904071947$EST+9040&IB=8798014$7004428$201904171303$201904171439$EST+9031";
    protected String ParisNiceOWLink = "/request/C=2&PT[1]=E&PC[1]=0&OB=8700012$8700171$201906251602$201906252208$TGV+6169";
    protected String ParisNiceRTLink = "/request/C=2&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&OB=8700012$8700171$201906301602$201906302211$TGV+6169&IB=8700171$8700012$201907101550$201907102223$TGV+6162";
    protected String WienLinzOW = "/request/C=2&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&OB=8103000$8100013$201904080930$201904081044$RJX+162";
    protected String FeldkirchVillachOW = "/request/C=2&PT[1]=E&PC[1]=0&OB=8100197$8100147$201904182245$201904190605$EN+40465";
    protected String HamburgWienOW = "/request/C=2&PT[1]=E&PC[1]=0&OB=8002549$8103000$201904272029$201904280827$NJ+491";
    protected String BernLausanneOWLink = "/request/C=2&PT[1]=E&PC[1]=0&OB=8507000$8501120$YYYYMMDD0934$YYYYMMDD1040$IC+710";
    protected String ZurichLuganoRTLink = "/request/C=2&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&OB=8503000$8505300$YYYYMMDDOUT0732$YYYYMMDDOUT0948$IC+861&IB=8505300$8503000$YYYYMMDDIN0811$YYYYMMDDIN1028$IC+866";

    @Override
    public String toString() {
        return "DBlink{" +
                "link='" + link + '\'' +
                '}';
    }
}
