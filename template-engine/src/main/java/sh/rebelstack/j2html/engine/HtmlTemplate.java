package sh.rebelstack.j2html.engine;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface HtmlTemplate {
    String value() default "";

    ComponentScope scope() default ComponentScope.PROTOTYPE;

    String description() default "";
}
