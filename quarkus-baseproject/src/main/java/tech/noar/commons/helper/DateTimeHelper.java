package tech.noar.commons.helper;

import org.jboss.logging.Logger;
import tech.noar.commons.constants.DateTimeConstants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public final class DateTimeHelper {

    private static final Logger log = Logger.getLogger(DateTimeHelper.class);

    private DateTimeHelper() {
    }

    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static Date parseToDate(String dateString, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(dateString);
        } catch (ParseException e) {
            log.infof("Exception on DateTimeUtility.parse() - {} :: {}", e.getMessage(), e.getStackTrace());
            return null;
        }
    }

    public static String format(Instant time, String pattern) {
        return DateTimeFormatter
                .ofPattern(pattern)
                .withZone(ZoneId.systemDefault())
                .format(time);
    }

    public static Instant parseToInstant(String timeString, String pattern) {
        return ZonedDateTime.from(
                DateTimeFormatter
                        .ofPattern(pattern)
                        .withZone(ZoneId.systemDefault())
                        .parse(timeString)
        ).toInstant();
    }

    public static String format(LocalDateTime dateTime, String pattern) {
        return DateTimeFormatter
                .ofPattern(pattern)
                .withZone(ZoneId.systemDefault())
                .format(dateTime);
    }

    public static LocalDateTime instanceDateTime(int year, int month, int day, LocalTime localTime) {
        return LocalDateTime.of(LocalDate.of(year, month, day),localTime);
    }

    public static String getMonthName(Integer val) {
        return DateTimeConstants.MONTH_NAME_LIST.get(val - 1);
    }

    public static LocalDateTime atStartOfDay(Date date) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        return localDateTime.with(LocalTime.MIN);
    }

    public static LocalDateTime atEndOfDay(Date date) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        return localDateTime.with(LocalTime.MAX);
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date addDate(int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }

}
