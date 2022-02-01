package annotation;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.*;

/**
 * Class implements dependency injection
 * @author Valentina Filonova
 */
@Configuration(packages = {"validation", "sorting"})
public class Injector {
    /**
     * Function for getting all classes from configuration packages
     * @return List classes from packages
     */
    private static List<Class<?>> getAllClassesFromPackages() {
        String rootPath = "src/main/java/";
        String[] packages = Injector.class.getAnnotation(Configuration.class).packages();
        List<Class<?>> classes = new ArrayList<>();
        for (String packagenames : packages) {
            File[] filesInDir = (new File(rootPath + packagenames.replace('.', '/'))).listFiles();
            if (filesInDir != null) {
                for (File file : filesInDir) {
                    String filePath = file.getPath();
                    if (filePath.length() > 5 && filePath.substring(filePath.length() - 5).equals(".java")) {
                        try {
                            classes.add(Class.forName(filePath.substring(rootPath.length(), filePath.length() - 5).replace('\\', '.')));
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return classes;
    }

    /**
     * Function for getting fields with annotation AutoInjectable
     * @param object - class where we should find fields for injection
     * @return List of these fields
     */
    public static List<Field> getFieldsToInject(Object object) {
        Field[] injectedObjectFields = object.getClass().getDeclaredFields();
        List<Field> fieldsToInject = new ArrayList<>();
        for (Field field : injectedObjectFields) {
            Annotation[] fieldAnnotation = field.getAnnotations();
            if (fieldAnnotation.length > 0)
                for (Annotation annotation : fieldAnnotation) {
                    if (AutoInjectable.class.isAssignableFrom(annotation.annotationType()))
                        fieldsToInject.add(field);
                }
        }
        return fieldsToInject;
    }

    /**
     *
     * @param object - class where we should find fields for injection
     * @return class with injected fields
     * @throws DependencyInjectionException
     * @throws IllegalAccessException
     */
    public static <T> T inject(T object) throws DependencyInjectionException, IllegalAccessException {
        List<Class<?>> classes = getAllClassesFromPackages();
        List<Field> fields = getFieldsToInject(object);
        for (Field field : fields) {
            field.setAccessible(true);
            if (!List.class.isAssignableFrom(field.getType())) {
                int count = 0;
                Class<?> tempClass = null;
                Class<?> fieldClass = field.getType();
                for (Class<?> clazz : classes) {
                    if (fieldClass.isAssignableFrom(clazz)) {
                        tempClass = clazz;
                        count++;
                    }
                }
                if (count < 1)
                    throw new DependencyInjectionException("Class for injecting not found");
                else if (count > 1)
                    throw new DependencyInjectionException("More one class for injecting");
                else
                    try {
                        field.set(object, tempClass.getDeclaredConstructor().newInstance());
                    } catch (IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
            } else {
                Class<?> fieldGenericClass = (Class<?>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
                Class<?> fieldCollectionType = field.get(object).getClass();
                Collection<Object> temp = null;
                try {
                    assert fieldCollectionType != null;
                    temp = (Collection<Object>) fieldCollectionType.getDeclaredConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
                assert temp != null;
                for (Class<?> clazz : classes) {
                    if (fieldGenericClass.isAssignableFrom(clazz) && (!clazz.getName().toString().equals(fieldGenericClass.getTypeName().toString()))) {
                        try {
                            temp.add(clazz.getDeclaredConstructor().newInstance());
                        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (temp.size() < 1)
                    throw new DependencyInjectionException("Class for injecting not found");
                try {
                    field.set(object, temp);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return object;
    }
}
