package helpers;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by osinskyi on 3/28/2017.
 */
public class DateTimeHelper {
    public static final String FORMAT_PATTERN = "yyyyMMdd";
    public static final String FORMAT_PATTERN_PAX = "ddMMyyyy";
    public static final String FORMAT_PATTERN_GUI = "EEE, dd.MM.yyy";
    public static final String FORMAT_PATTERN_TRIP_SEARCH = "dd.MM.yyyy";

    private static DateTimeFormatter getFormatPattern() {
        return DateTimeFormat.forPattern(FORMAT_PATTERN);
    }

    public static DateTime toJodaTime(String stringDate) {
        return getFormatPattern().parseDateTime(stringDate);
    }

    public static String currentDatePlusNDays(int days) {
        return new DateTime().plusDays(days).toString(FORMAT_PATTERN);
    }

    public static String currentDatePlusNDaysGUI(int days) {
        return new DateTime().plusDays(days).toString(FORMAT_PATTERN_GUI);
    }

    public static String currentDatePlusNDaysTipSearchNotWeekend(int days) {
        if (new DateTime().plusDays(days).getDayOfWeek() > 5) {
            days = days + 2;
        }
        return new DateTime().plusDays(days).toString(FORMAT_PATTERN_TRIP_SEARCH);
    }

    public static String currentDatePlusNDaysNotWeekend(int days) {
        if (new DateTime().plusDays(days).getDayOfWeek() > 5) {
            days = days + 2;
        }
        return new DateTime().plusDays(days).toString(DateTimeHelper.FORMAT_PATTERN);
    }

    public static String currentDatePlusNDaysNotWeekendGUI(int days) {
        if (new DateTime().plusDays(days).getDayOfWeek() > 5) {
            days = days + 2;
        }
        return new DateTime().plusDays(days).toString(DateTimeHelper.FORMAT_PATTERN_GUI);
    }

    public static String currentDatePlusNDaysWeekend(int days) {
        if (new DateTime().plusDays(days).getDayOfWeek() == 1) {
            days = days + 5;
        }
        if (new DateTime().plusDays(days).getDayOfWeek() == 2) {
            days = days + 4;
        }
        if (new DateTime().plusDays(days).getDayOfWeek() == 3) {
            days = days + 3;
        }
        if (new DateTime().plusDays(days).getDayOfWeek() == 4) {
            days = days + 2;
        }
        if (new DateTime().plusDays(days).getDayOfWeek() == 5) {
            days = days + 1;
        }
        return new DateTime().plusDays(days).toString(DateTimeHelper.FORMAT_PATTERN);
    }

    public static String currentDatePlusNDaysWeekendGUI(int days) {
        if (new DateTime().plusDays(days).getDayOfWeek() == 1) {
            days = days + 5;
        }
        if (new DateTime().plusDays(days).getDayOfWeek() == 2) {
            days = days + 4;
        }
        if (new DateTime().plusDays(days).getDayOfWeek() == 3) {
            days = days + 3;
        }
        if (new DateTime().plusDays(days).getDayOfWeek() == 4) {
            days = days + 2;
        }
        if (new DateTime().plusDays(days).getDayOfWeek() == 5) {
            days = days + 1;
        }
        return new DateTime().plusDays(days).toString(DateTimeHelper.FORMAT_PATTERN_GUI);
    }


    public static String currentDateMinusNYears(int years) {
        return new DateTime().minusYears(years).toString(FORMAT_PATTERN_PAX);
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


}
