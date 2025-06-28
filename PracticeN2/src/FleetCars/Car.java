package FleetCars;

import java.util.Objects;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Map;


public class Car implements Comparable<Car> {
    String vin;
    String model;
    String manufacturer;
    int year;
    int mileage;
    double price;
    private CarType type;


    public Car(String vin, String model, String manufacturer, int year, int mileage, double price, CarType type) {
        this.vin = vin;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.type=type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(vin, car.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vin);
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin='" + vin + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", price=" + price +
                '}';
    }
    public int getMileage() {
        return mileage;
    }

    public double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public CarType getType() {
        return type;
    }

    public String getVin() {
        return vin;
    }

    public static void main(String args[]){
        Set<Car> carSet=new HashSet<>();
        Car car1=new Car("VIN123", "Model S","Tesla", 2022,40000, 75000.0,CarType.ELECTRIC);
        Car car2=new Car("VIN233", "Camry","Toyota", 2021,30000, 35000.0,CarType.SEDAN);
        Car car3=new Car("VIN777", "M3 (E46)","BMW", 2000,15000, 155000.0,CarType.COUPE);
        Car car4=new Car("VIN777", "M3","BMW", 2017,45000, 76000.0,CarType.SEDAN);

        carSet.add(car1);
        carSet.add(car2);
        carSet.add(car3);
        carSet.add(car4);

        System.out.println("Количество машин: "+ carSet.size());

        for(Car car: carSet){
            System.out.println(car);
        }

        List<Car> sortCar=new ArrayList<>();
        sortCar.add(car1);
        sortCar.add(car2);
        sortCar.add(car3);
        sortCar.add(car4);
        Collections.sort(sortCar);
        System.out.println("\n");
        for (Car car:sortCar){
            System.out.println(car);
        }

        List<Car> topCars=sortCar.stream()
                .filter(car-> car.getMileage() <50000)
                .sorted(Comparator.comparingDouble(Car::getPrice).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("\nТоп 3");
        topCars.forEach(System.out::println);

        double averageMileage=sortCar.stream()
                .mapToInt(Car::getMileage)
                .average()
                .orElse(0.0);
        System.out.println("Средний пробег: "+ averageMileage + " км");

        Map<String, List<Car>> carsByManufacturer=sortCar.stream()
                .collect(Collectors.groupingBy(Car::getManufacturer));

        System.out.println("\n Группировка по производителю");
        carsByManufacturer.forEach((manufacturer, carList)->{
            System.out.println("\n Производитель: "+ manufacturer);

            carList.forEach(car->{
                System.out.println(" ->"+car.getModel() + " ("+car.getYear()+")");
            });
        });




    }

    @Override
    public int compareTo(Car otherCar){
        if (this.year > otherCar.year){
            return -1;
        }
        else if (this.year < otherCar.year){
            return 1;
        }
        else {
            return 0;
        }
    }


}
