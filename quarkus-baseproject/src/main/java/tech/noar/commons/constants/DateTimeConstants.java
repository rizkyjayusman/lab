package tech.noar.commons.constants;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class DateTimeConstants {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String TIME_FORMAT = "HH:mm:ss";
    public static final String DATE_TIME_FORMAT = DATE_FORMAT + " " + TIME_FORMAT;
    public static final String DATE_TIME_ISO_WITH_MILLISECOND = String.format("%sT%s.SSSZ", DATE_FORMAT, TIME_FORMAT);

    public static final DateTimeFormatter FORMATTER_DATE = DateTimeFormatter.ofPattern(DATE_FORMAT);
    public static final DateTimeFormatter FORMATTER_TIME = DateTimeFormatter.ofPattern(TIME_FORMAT);
    public static final DateTimeFormatter FORMATTER_DATE_TIME = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

    public static final TimeZone DEFAULT_TIMEZONE = TimeZone.getTimeZone(ZoneOffset.ofHours(7));
    public static final Calendar NOW = Calendar.getInstance(DEFAULT_TIMEZONE);

    public static final List<String> MONTH_NAME_LIST = Arrays.asList("Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli",
            "Agustus", "September", "Oktober", "November", "Desember");

    public static final String PATTERN_DATETIME_WITHOUT_DELIMITERS = "yyyyMMddHHmmss";
    public static final String PATTERN_FILE_TIME = PATTERN_DATETIME_WITHOUT_DELIMITERS + "-SSSSSS";
    public static final String PATTERN_DATE_TIME_YEARS_MONTH_DAY = "yyyyMMdd";

    public static final String PATTERN_ISO_WITH_MILLISECOND = "yyyy-MM-dd'T'HH:mm:ss.SSSX";

    private DateTimeConstants() {
    }

}
