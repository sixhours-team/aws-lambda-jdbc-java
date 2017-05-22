package io.sixhours;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Reflection utility class.
 *
 * @author Igor Bolic
 */
public final class ReflectionUtil {

    private ReflectionUtil() {
        throw new AssertionError();
    }

    /**
     * Set final static field.
     *
     * @param newValue New field value.
     * @throws Exception When final field could not be set.
     */
    public static void setStaticFinalField(Field field, Object newValue) throws Exception {
        field.setAccessible(true);

        Field modifiers = Field.class.getDeclaredField("modifiers");
        modifiers.setAccessible(true);
        modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, newValue);
    }

}
