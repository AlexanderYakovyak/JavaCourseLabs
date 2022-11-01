package printing;

public class Printer implements PrintingDevice{
    String type;
    String model;
    String manufacturer;
    int price;

    public Printer(String type, String model, String manufacturer, int price) {
        this.type = type;
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    @Override
    public void print() {
        System.out.printf("Your document has been printed by %s %s", this.model, this.type);
    }

    @Override
    public String toString() {
        return "Printer{" +
                "type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }

}
