package model;

import javax.swing.text.DateFormatter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateConverter {
    private static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern ("dd.MM.yyyy");

    public void setDateFormat(String format) {
        dateFormat = DateTimeFormatter.ofPattern (format);
    }

    public static String convertDateToString(LocalDate date) {
        return dateFormat.format(date);
    }

    public static LocalDate convertStringToDate(String date) {
        return LocalDate.parse(date, dateFormat);
    }
}
