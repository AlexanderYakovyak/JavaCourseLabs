package gems;

public class Sapphire extends Gemstone{
    String color;
    String place_of_origin;


    public Sapphire(double weight, int rarity, int price, double transparency, String color, String place_of_origin) {
        super(weight, rarity, price, transparency);
        this.color = color;
        this.place_of_origin = place_of_origin;
    }

    @Override
    public String toString() {
        return "Sapphire{" +
                "color='" + color + '\'' +
                ", place_of_origin='" + place_of_origin + '\'' +
                ", weight=" + weight +
                ", rarity=" + rarity +
                ", price=" + price +
                ", transparency=" + transparency +
                '}';
    }
}
