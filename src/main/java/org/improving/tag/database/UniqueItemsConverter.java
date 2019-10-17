package org.improving.tag.database;
import org.improving.tag.items.UniqueItems;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;


@Converter(autoApply = true)
public class UniqueItemsConverter implements AttributeConverter<UniqueItems, String> {


    @Override
    public String convertToDatabaseColumn(UniqueItems items) {
        return items.getName();
    }

    @Override
    public UniqueItems convertToEntityAttribute(String s) {
        return (Arrays
                .stream(UniqueItems.values())
                .filter(item -> item.getName().equals(s))
                .findFirst().orElse(null));
    }
}
