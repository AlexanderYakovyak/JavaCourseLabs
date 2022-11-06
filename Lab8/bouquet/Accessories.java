package bouquet;

public class Accessories {

    String type;
    int price;

    public Accessories(String type, int price){
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Accessories{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
