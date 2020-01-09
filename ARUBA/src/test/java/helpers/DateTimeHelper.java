package helpers;


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by ivanchik on 30.06.2016.
 */
public class DateTimeHelper {
    public static final String FORMAT_PATTERN = "dd.MM.yyyy";
    public static final String FORMAT_PATTERN_DD_MM = "dd.MM";
    public static final String FORMAT_PATTERN_FOR_DB = "yyyy-MM-dd";

    private static DateTimeFormatter getFormatPattern() {
        return DateTimeFormat.forPattern(FORMAT_PATTERN);
    }

    public static DateTime toJodaTime(String stringDate) {
        return getFormatPattern().parseDateTime(stringDate);
    }

    public static String currentDatePlusNDays(int days) {
        return new DateTime().plusDays(days).toString(FORMAT_PATTERN);
    }

    public static String currentDatePlusNDaysFormatddMM(int days) {
        return new DateTime().plusDays(days).toString(FORMAT_PATTERN_DD_MM);
    }

    public static String currentDatePlusNDaysFormatForDB(int days) {
        return new DateTime().plusDays(days).toString(FORMAT_PATTERN_FOR_DB);
    }

    public static String currentDatePlusNDaysNotWeekend(int days) {
        if (new DateTime().plusDays(days).getDayOfWeek() > 5) {
            days = days + 2;
        }
        return new DateTime().plusDays(days).toString(DateTimeHelper.FORMAT_PATTERN);
    }

    public static String currentDateMinusNYears(int years) {
        return new DateTime().minusYears(years).toString(FORMAT_PATTERN);
    }

    public static String currentDatePlusWeekAndDayOfTheWeek(int weeks, int days) {
        return new DateTime().plusWeeks(weeks).withDayOfWeek(days).toString(FORMAT_PATTERN);
    }

    public static String currentDatePlusNYears(int years) {
        return new DateTime().plusYears(years).toString(FORMAT_PATTERN);
    }

    public static String getDateOnly(DateTime dateTime) {
        return dateTime.toString(FORMAT_PATTERN);
    }

    public static String getTimeOnly(DateTime dateTime) {
        return dateTime.toString("HH:mm");
    }

    public static String getHours(String pattern, int hours) {
        return DateTimeFormat.forPattern(pattern).parseDateTime(hours + "").toString("HH:mm");
    }

    /**
     *
     * @param date
     * @param years
     * @param days
     * @return
     */
    public static String dateMinusNYearsPlusNDays(String date,int years, int days) {
        return toJodaTime(date).minusYears(years).minusDays(days).toString(FORMAT_PATTERN);
    }

    /**
     *
     * @param date
     * @param years
     * @param days
     * @return
     */
    public static String dateMinusNYearsMinusNDays( String date,  int years,  int days) {
        return toJodaTime(date).minusYears(years).plusDays(days).toString(FORMAT_PATTERN);
    }

    /**
     *
     * @param date
     * @param years
     * @return
     */
    public static String dateMinusNYears( String date,  int years) {
        return toJodaTime(date).minusYears(years).toString(FORMAT_PATTERN);
    }

    public static String getDayOfWeekAfterNDays(int dayOfWeek, int days){
        return new DateTime().plusDays(days).withDayOfWeek(dayOfWeek).toString(FORMAT_PATTERN);
    }

        /**
     *  Return specific date in format dd.MM.yyyy
     *  @param period, with cases 'nextMonth', 'nextDay'
     */
    public static String getDate(String pattern, String period) {
        Date currentDate;
//        dd.MM.yyyy
//        YYYY-MM-dd
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Calendar c = Calendar.getInstance();
        switch (period) {
            case ("+1day"):
                c.add(Calendar.DAY_OF_MONTH, 1);
                break;
            case ("+5days"):
                c.add(Calendar.DAY_OF_MONTH, 5);
                break;
            case ("+7days"):
                c.add(Calendar.DAY_OF_MONTH, 7);
                break;
            case ("+9days"):
                c.add(Calendar.DAY_OF_MONTH, 9);
                break;
            case ("+10days"):
                c.add(Calendar.DAY_OF_MONTH, 10);
                break;
            case ("+14days"):
                c.add(Calendar.DAY_OF_MONTH, 14);
                break;
            case ("+Month"):
                c.add(Calendar.MONTH, 1);
                break;
            case ("-Month"):
                c.add(Calendar.MONTH, -1);
                break;
            case ("-Week"):
                c.add(Calendar.DAY_OF_MONTH, -7);
                break;
            case ("yesterday"):
                c.add(Calendar.DAY_OF_MONTH, -1);
                break;
            default:
                Calendar.getInstance();
        }
        currentDate = c.getTime();
        return dateFormat.format(currentDate);
    }

}
