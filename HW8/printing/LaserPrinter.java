package printing;

public class LaserPrinter extends Printer{

    int printing_speed;

    public LaserPrinter(String type, String model, String manufacturer, int price, int printing_speed) {
        super(type, model, manufacturer, price);
        this.printing_speed = printing_speed;
    }

    @Override
    public void print() {
        super.print();
        System.out.printf("The speed of the process = %d", printing_speed);
    }

    @Override
    public String toString() {
        return "LaserPrinter{" +
                "printing_speed=" + printing_speed +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                '}';
    }

}
