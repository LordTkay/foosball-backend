package de.tkay.foosball.converter;


import jakarta.persistence.AttributeConverter;
import org.apache.commons.lang3.StringUtils;


/**
 * A converter for Entity-Attributes of a database entity. It converts empty strings to null, when writing to the
 * database.
 */
public class EmptyStringConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String string) {
        return StringUtils.defaultIfEmpty(string, null);
    }

    @Override
    public String convertToEntityAttribute(String databaseValue) {
        return databaseValue;
    }
}
