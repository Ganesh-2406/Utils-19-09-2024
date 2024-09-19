package in.edu.kristujayanti.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import in.edu.kristujayanti.enums.DateFormats;
import in.edu.kristujayanti.enums.TimeZoneEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class DateUtils {
    private static final Logger LOGGER = LogManager.getLogger(DateUtils.class);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm:ss.SSSZ");


    public static Long currentDateTimeInMillis() {
        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            return localDateTime.atZone(ZoneId.of(TimeZoneEnum.UTC.getZoneId())).toInstant().toEpochMilli();
        } catch (DateTimeParseException var2) {
            LOGGER.error("DateTimeParseException occurred while checking current date");
            throw new IllegalArgumentException("Date is invalid");
        }
    }

    public static Long currentDateInMillis() {
        try {
            LocalDate localDate = LocalDate.now();  // Gets the current date
            LocalDateTime startOfDay = localDate.atStartOfDay();  // Sets time to midnight (00:00:00)
            return startOfDay.atZone(ZoneId.of(TimeZoneEnum.UTC.getZoneId())).toInstant().toEpochMilli();
        } catch (DateTimeParseException var2) {
            LOGGER.error("DateParseException occurred while checking current date");
            throw new IllegalArgumentException("Date is invalid");
        }
    }

    public static ZonedDateTime labelToDateTime(String dateString) {
        DateTimeParser dateTimeParser = new DateTimeParser(DateFormats.DDMMYYYYHIPHENAVOIDED);
        return DateTimeParser.parseDate(dateString);
    }

    public static Long labelToDateTimeMillis(String dateString) {
        List<DateTimeFormatter> formatters = Arrays.asList(
                DateTimeFormatter.ofPattern("dd-MM-yyyy"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd"),
//                DateTimeFormatter.ofPattern("MM/dd/yyyy"),
                DateTimeFormatter.ofPattern("yyyy/MM/dd"),
                DateTimeFormatter.ISO_LOCAL_DATE,
                DateTimeFormatter.ofPattern("dd/MM/yyyy")
        );

        for (DateTimeFormatter formatter : formatters) {
            try {
                LocalDate localDate = LocalDate.parse(dateString, formatter);
                LocalDateTime dateTime = LocalDateTime.of(localDate, LocalTime.now());
                ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.of("UTC")); // Use IST
                return zonedDateTime.toInstant().toEpochMilli();
            } catch (DateTimeParseException e) {
                LOGGER.debug("Failed to parse '{}' with formatter '{}'", dateString, formatter);
            }
        }
        LOGGER.error("Unable to parse date string: {}", dateString);
        return null; // Return null if parsing fails for all formats
    }

    public static Long labelToStartDayDateTimeMillis(String dateString) {
        List<DateTimeFormatter> formatters = Arrays.asList(
                DateTimeFormatter.ofPattern("dd-MM-yyyy"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd"),
                DateTimeFormatter.ofPattern("MM/dd/yyyy"),
                DateTimeFormatter.ofPattern("yyyy/MM/dd"),
                DateTimeFormatter.ISO_LOCAL_DATE,
                DateTimeFormatter.ofPattern("dd/MM/yyyy")
        );

        for (DateTimeFormatter formatter : formatters) {
            try {
                LocalDate localDate = LocalDate.parse(dateString, formatter);
                // Set the time to midnight at the start of the specified date
                LocalDateTime dateTime = LocalDateTime.of(localDate, LocalTime.MIDNIGHT);
                ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.of("Asia/Kolkata")); // Use IST
                return zonedDateTime.toInstant().toEpochMilli();
            } catch (DateTimeParseException e) {
                LOGGER.debug("Failed to parse '{}' with formatter '{}'", dateString, formatter);
            }
        }
        LOGGER.error("Unable to parse date string: {}", dateString);
        return null; // Return null if parsing fails for all formats
    }


    public static Instant millisToInstant(Long dateInMillis) {
        return Instant.ofEpochMilli(dateInMillis);
    }

    public static long convertDateTimeToStartOfDayToMillis(long dateInMillis) {
        try {
            // Convert the milliseconds to Instant
            Instant instant = Instant.ofEpochMilli(dateInMillis);

            // Convert Instant to LocalDate in UTC
            LocalDate localDate = instant.atZone(ZoneOffset.UTC).toLocalDate();

            // Convert LocalDate to ZonedDateTime at the start of the day in UTC
            ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneOffset.UTC);

            // Convert ZonedDateTime to epoch milliseconds
            return zonedDateTime.toInstant().toEpochMilli();

        } catch (DateTimeException var2) {
            LOGGER.error("DateTimeException occurred while processing date in millis {} and exception is {} ", dateInMillis, var2);
            throw new IllegalArgumentException("Date " + dateInMillis + " is invalid");
        }
    }

    public static Long convertDateTimeStringToMillis(String dateAsString) {
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(dateAsString, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            return localDateTime.atZone(ZoneId.of(TimeZoneEnum.UTC.getZoneId())).toInstant().toEpochMilli();
        } catch (DateTimeParseException var2) {
            LOGGER.error("DateTimeParseException occurred while checking string date value {} is valid and exception is {} ", dateAsString, var2);
            throw new IllegalArgumentException("Date " + dateAsString + " is invalid");
        }
    }

    public static long getCurrentTimeInMillis() {
        ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneId.of(TimeZoneEnum.UTC.getZoneId()));
        return zonedDateTime.toInstant().toEpochMilli();
    }


    public static String convertMillisToDateString(Long millis) {
        if (millis == null) {
            throw new IllegalArgumentException("Milliseconds cannot be null.");
        }

        // Convert milliseconds to Instant
        Instant instant = Instant.ofEpochMilli(millis);

        // Convert Instant to ZonedDateTime in IST
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Asia/Kolkata"));

        // Format the ZonedDateTime to a date string using the specified pattern
        return DATE_FORMATTER.format(zonedDateTime);
    }

    public static String convertMillisToDateTimeString(Long millis) {
        if (millis == null) {
            throw new IllegalArgumentException("Milliseconds cannot be null.");
        }

        // Convert milliseconds to Instant
        Instant instant = Instant.ofEpochMilli(millis);

        // Convert Instant to ZonedDateTime in IST
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of(TimeZoneEnum.ASIA_KOLKATA.getZoneId()));

        // Format the ZonedDateTime to a date string using the specified pattern
        return DATE_TIME_FORMATTER.format(zonedDateTime);
    }

}
