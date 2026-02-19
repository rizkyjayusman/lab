package tech.noar.commons.helper;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class StringHelper {

    private static final Pattern PATTERN_MOBILE_PHONE_NUMBER = Pattern.compile("^(\\+62|62|0)8[1-9][0-9]{7,10}$");

    private StringHelper() {
    }

    public static String generateSlug(String... strs) {
        if (ArrayUtils.isEmpty(strs)) {
            return "";
        }

        final String pattern = "[^a-zA-Z0-9]";

        final String joined = String.join("-", strs);
        String slug = joined.replaceAll(pattern, " ");
        slug = slug.replaceAll(" ", "-");
        do {
            slug = slug.replace("--", "-");
        } while (slug.contains("--"));

        return slug.toLowerCase();
    }

    public static boolean isValidLength(String value, int minLength, int maxLength) {

        boolean isBlank = StringUtils.isBlank(value);

        if (minLength > 0 && isBlank) {
            return false;
        }

        if (!isBlank && value.length() < minLength) {
            return false;
        }

        if (!isBlank && value.length() > maxLength) {
            return false;
        }

        return true;
    }

    public static boolean isValidMobilePhoneNumber(String phoneNumber) {
        if (StringUtils.isBlank(phoneNumber)) {
            return false;
        }

        return PATTERN_MOBILE_PHONE_NUMBER.matcher(phoneNumber).matches();
    }

    public static String normalizePhoneNumber(String phoneNumber) {
        if (StringUtils.isBlank(phoneNumber)) {
            return phoneNumber;
        }

        if (StringUtils.startsWith(phoneNumber, "0")) {
            return phoneNumber.replaceFirst("0", "62");
        }

        if (StringUtils.startsWith(phoneNumber, "+62")) {
            return phoneNumber.substring("+".length());
        }

        return phoneNumber;
    }

}
