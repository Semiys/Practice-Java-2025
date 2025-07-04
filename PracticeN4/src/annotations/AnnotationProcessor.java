package annotations;

import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void process(Class<?> clazz){

        if (clazz.isAnnotationPresent(DeprecatedEx.class)){
            DeprecatedEx annotation=clazz.getAnnotation(DeprecatedEx.class);
            String message=annotation.message();
            System.out.println("Внимание: класс '"+clazz.getSimpleName()+ "' устарел. Альтернатива: '"+ message +"'");

        }
        Method[] methods =clazz.getDeclaredMethods();
        for(Method method: methods){
            if(method.isAnnotationPresent(DeprecatedEx.class)){
                DeprecatedEx annotation=method.getAnnotation(DeprecatedEx.class);
                String message=annotation.message();
                System.out.println("Внимание: метод '" + method.getName() + "' устарел. Альтернатива: '" + message + "'");
            }
        }
    }
}
