package annotation;

import java.lang.annotation.*;

/**
 * Annotation for class fields for which dependency injection will need to be implemented
 * @author Valentina Filonova
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AutoInjectable {

}