package json;

public class Car {
    @JsonField(name = "brand")
    private final String manufacturer;

    @JsonField(name = "model_name")
    private final String model;

    private final int year;

    public Car(String manufacturer, String model, int year) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
    }
}
