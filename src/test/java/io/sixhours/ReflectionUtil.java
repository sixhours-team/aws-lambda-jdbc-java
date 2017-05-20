package io.sixhours;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Test utility class.
 *
 * @author Igor Bolic
 */
public final class ReflectionUtil {

    private ReflectionUtil() {
        throw new AssertionError();
    }

    /**
     * Set final field of the object under test.
     *
     * @param object    The object under test.
     * @param fieldName Field name.
     * @param newValue  New field value.
     * @throws Exception When final field could not be set.
     */
    public static void setFinalField(Object object, String fieldName, Object newValue) throws Exception {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object, newValue);
    }

    /**
     * Set final static field.
     *
     * @param newValue  New field value.
     * @throws Exception When final field could not be set.
     */
    public static void setStaticFinalField(Field field, Object newValue) throws Exception {
        field.setAccessible(true);

        Field modifiers = Field.class.getDeclaredField("modifiers");
        modifiers.setAccessible(true);
        modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, newValue);
    }

    /**
     * Get final static field value.
     *
     * @param field Static final field
     * @return Field value
     * @throws Exception When final field value could not be accessed.
     */
    public static Object getStaticFinalField(Field field) throws Exception {
        field.setAccessible(true);

        return field.get(null);
    }
}
