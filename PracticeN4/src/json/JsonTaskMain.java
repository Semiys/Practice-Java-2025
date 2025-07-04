package json;

public class JsonTaskMain {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 2021);

        try {
            String json = JsonSerializer.serialize(car);
            System.out.println("Объект Car сериализован в JSON:");
            System.out.println(json);
            // Ожидаемый вывод: {"brand":"Toyota", "model_name":"Camry"}
        } catch (IllegalAccessException e) {
            System.err.println("Ошибка доступа при сериализации: " + e.getMessage());
        }
    }
}
