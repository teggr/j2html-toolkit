package dev.rebelcraft.j2html.ext;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Apply to a <code>public static final String XXX = "";</code> static field so that the mapping is both documented and re-usable by other applications.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CssClassMapper {

    String field();

    String className();

}
