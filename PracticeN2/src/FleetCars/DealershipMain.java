package FleetCars;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;

public class DealershipMain {

    private static CarDealership dealership;
    private static Scanner scanner;

    public static void main(String[] args) {
        // 1. Инициализация
        dealership = new CarDealership("Best Motors");
        scanner = new Scanner(System.in);
        populateInitialCars(); // Заполняем салон несколькими машинами для старта

        // 2. Запуск главного цикла меню
        runMenu();

        // 3. Завершение работы
        scanner.close();
        System.out.println("Программа завершена.");
    }

    /**
     * Метод для начального заполнения автосалона.
     */
    private static void populateInitialCars() {
        System.out.println("Загрузка начального каталога автомобилей...");
        dealership.addCar(new Car("T1", "Model S", "Tesla", 2022, 40000, 75000.0, CarType.ELECTRIC));
        dealership.addCar(new Car("T2", "Camry", "Toyota", 2021, 30000, 35000.0, CarType.SEDAN));
        dealership.addCar(new Car("B1", "M5", "BMW", 2019, 60000, 65000.0, CarType.SEDAN));
        dealership.addCar(new Car("T3", "Model X", "Tesla", 2023, 10000, 95000.0, CarType.SUV));
        System.out.println("Загрузка завершена.\n");
    }

    /**
     * Основной цикл, который показывает меню и обрабатывает выбор пользователя.
     */
    private static void runMenu() {
        while (true) {
            printMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    showAllCars();
                    break;
                case 2:
                    addNewCar();
                    break;
                case 3:
                    findCarsByManufacturer();
                    break;
                case 4:
                    calculateAveragePriceByType();
                    break;
                case 5:
                    showStatistics();
                    break;
                case 0:
                    return; // Выход из метода runMenu и, соответственно, из цикла
                default:
                    System.out.println("ОШИБКА: Неверный пункт меню. Пожалуйста, выберите от 0 до 5.");
            }
        }
    }

    /**
     * Печатает в консоль пункты меню.
     */
    private static void printMenu() {
        System.out.println("\n--- Меню автосалона \"" + dealership.getName() + "\" ---");
        System.out.println("1. Показать все машины (сортировка по году)");
        System.out.println("2. Добавить новую машину");
        System.out.println("3. Найти машины по производителю");
        System.out.println("4. Рассчитать среднюю цену по типу кузова");
        System.out.println("5. Показать общую статистику");
        System.out.println("0. Выход");
        System.out.print("Ваш выбор: ");
    }

    /**
     * Получает ввод пользователя и обрабатывает возможные ошибки.
     */
    private static int getUserChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // "Съедаем" оставшийся символ новой строки
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Очищаем буфер от неверного ввода (например, букв)
            return -1; // Возвращаем невалидное значение, чтобы switch ушёл в default
        }
    }

    //  Методы, реализующие пункты меню

    private static void showAllCars() {
        System.out.println("\n--- Все машины в наличии (от новых к старым) ---");
        List<Car> allCars = dealership.getSortedByYear();
        if (allCars.isEmpty()) {
            System.out.println("В автосалоне пока нет машин.");
        } else {
            allCars.forEach(System.out::println);
        }
    }

    private static void findCarsByManufacturer() {
        System.out.print("Введите производителя для поиска: ");
        String manufacturer = scanner.nextLine();
        List<Car> foundCars = dealership.findCarsByManufacturer(manufacturer);

        System.out.println("\n--- Результаты поиска по производителю \"" + manufacturer + "\" ---");
        if (foundCars.isEmpty()) {
            System.out.println("Машины данного производителя не найдены.");
        } else {
            foundCars.forEach(System.out::println);
        }
    }

    private static void calculateAveragePriceByType() {
        System.out.println("Доступные типы кузова:");
        for (CarType type : CarType.values()) {
            System.out.print(type + " ");
        }
        System.out.print("\nВведите тип кузова: ");
        String typeInput = scanner.nextLine().toUpperCase();

        try {
            CarType selectedType = CarType.valueOf(typeInput);
            double avgPrice = dealership.getAveragePriceByType(selectedType);
            if (avgPrice > 0) {
                System.out.printf("Средняя цена для типа %s: %,.2f $\n", selectedType, avgPrice);
            } else {
                System.out.println("Машины с типом " + selectedType + " не найдены, среднюю цену рассчитать невозможно.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("ОШИБКА: Введен неверный тип кузова.");
        }
    }

    private static void showStatistics() {
        System.out.println("\n--- Общая статистика автосалона ---");
        Map<CarType, Long> counts = dealership.getCountByType();
        System.out.println("Количество машин по типам: " + counts);

        dealership.getMostRecentCar().ifPresent(car -> System.out.println("Самая новая машина: " + car));
        dealership.getOldestCar().ifPresent(car -> System.out.println("Самая старая машина: " + car));
    }

    private static void addNewCar() {
        try {
            System.out.println("\n--- Добавление новой машины ---");
            System.out.print("VIN: ");
            String vin = scanner.nextLine();
            System.out.print("Производитель: ");
            String manufacturer = scanner.nextLine();
            System.out.print("Модель: ");
            String model = scanner.nextLine();
            System.out.print("Год выпуска: ");
            int year = scanner.nextInt();
            System.out.print("Пробег: ");
            int mileage = scanner.nextInt();
            System.out.print("Цена: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // "Съедаем" Enter

            System.out.println("Доступные типы кузова:");
            for (CarType type : CarType.values()) {
                System.out.print(type + " ");
            }
            System.out.print("\nВведите тип кузова: ");
            String typeInput = scanner.nextLine().toUpperCase();
            CarType type = CarType.valueOf(typeInput);

            Car newCar = new Car(vin, model, manufacturer, year, mileage, price, type);
            dealership.addCar(newCar);

        } catch (InputMismatchException e) {
            System.out.println("ОШИБКА ВВОДА. Пожалуйста, вводите числа для года, пробега и цены.");
            scanner.nextLine(); // Очищаем буфер сканера после ошибки
        } catch (IllegalArgumentException e) {
            System.out.println("ОШИБКА: Введен неверный тип кузова.");
        }
    }
}