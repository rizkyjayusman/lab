package tech.noar.commons.annotations.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Exclude {
    Exclusion exclusion() default Exclusion.NONE;

    Expression expression() default @Expression(booleanField = "", expectedValue = "");

    public static @interface Expression {
        String booleanField();

        String expectedValue();
    }

    public enum Exclusion {
        NONE, VALUE_IS_NULL, STRING_IS_BLANK;
    }
}
