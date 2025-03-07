package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        var service = new SomeService();

        // Итерируем все методы класса
        for (Method method : SomeService.class.getDeclaredMethods()) {

            // Проверяем, есть ли у метода аннотация @Inspect
            if (method.isAnnotationPresent(Inspect.class)) {

                try {
                    // Выполняем метод с аннотацией Inspect
                    method.invoke(service);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Method " + method.getName() + "returns a value of type " + method.getReturnType());
            }
        }
        // END
    }
}
