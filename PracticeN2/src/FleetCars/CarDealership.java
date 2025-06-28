package FleetCars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Optional;

public class CarDealership {
    private String name;
    private List<Car> cars;

    public CarDealership(String name){
        this.name=name;
        this.cars=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public boolean addCar(Car newCar){
        boolean alreadyExists=this.cars.stream()
                .anyMatch(car-> car.getVin().equals(newCar.getVin()));
        if (alreadyExists){
            System.out.println("Машина с VIN "+ newCar.getVin()+" уже существует в салоне.");
            return false;
        }
        else{
            this.cars.add(newCar);
            System.out.println("Машина "+newCar.getManufacturer()+" "+newCar.getModel()+" добавлена.");
            return true;
        }
    }

    public List<Car> findCarsByManufacturer(String manufacturer){
        return this.cars.stream()
                .filter(car->car.getManufacturer().equalsIgnoreCase(manufacturer))
                .collect(Collectors.toList());
    }

    public double getAveragePriceByType(CarType type){
        return this.cars.stream()
                .filter(car -> car.getType()==type)
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0.0);
    }

    public List<Car> getSortedByYear(){
        return this.cars.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public Map<CarType, Long> getCountByType(){
        return this.cars.stream()
                .collect(Collectors.groupingBy(
                        Car::getType,
                        Collectors.counting()
                ));
    }

    public Optional<Car> getMostRecentCar(){
        return this.cars.stream().min(Car::compareTo);
    }

    public Optional<Car> getOldestCar(){
        return this.cars.stream().max(Car::compareTo);
    }



}
