package jaxb;


import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    private static final ThreadLocal<DateTimeFormatter> dateFormat
            = new ThreadLocal<DateTimeFormatter>() {

        @Override
        protected DateTimeFormatter initialValue() {
            return DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        }
    };

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v, dateFormat.get());
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        return dateFormat.get().format(localDate);
    }

}