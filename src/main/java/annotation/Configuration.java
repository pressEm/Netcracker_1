package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/**
 * Store package names where you will need to look for classes that will be embedded in fields
 * marked with the AutoInjectable annotation
 * @author Valentina Filonova
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Configuration {
    /**
     * Store package names where you will need to look for classes that will be embedded in fields
     *  * marked with the AutoInjectable annotation
     * @return string array of classes names
     */
    String[] packages() default {};
}