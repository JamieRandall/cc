package ru.gov.rkn.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Converter
public class DateTimeConverter implements AttributeConverter<LocalDateTime, String> {

    @Override
    public String convertToDatabaseColumn(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd:MM:yyyy");
        return localDateTime.format(formatter);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String s) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd:MM:yyyy");

        return LocalDateTime.parse(s, formatter);
    }
}
