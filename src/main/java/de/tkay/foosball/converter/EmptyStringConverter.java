package de.tkay.foosball.converter;



import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;

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
