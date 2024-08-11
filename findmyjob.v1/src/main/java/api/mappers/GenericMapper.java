package api.mappers;

import api.exceptions.HttpInternalServerErrorException;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Component
public class GenericMapper {

    /**
     * Maps all fields from an instance to another instance, but this instances must to be
     * the same kind of class.
     * */
    public <T> T map(T source, T destination, Class<T> clazz) {

        if(source == null || destination == null)
            throw new HttpInternalServerErrorException("Parsing error.");

        List<Field> fields = Arrays.asList(clazz.getDeclaredFields());

        fields.forEach(field -> {
            try {
                field.setAccessible(true);
                Object value = field.get(source);
                field.set(destination, value);
            } catch (IllegalAccessException e) {
                throw new HttpInternalServerErrorException(e.getMessage());
            }
        });

        return destination;
    }
}