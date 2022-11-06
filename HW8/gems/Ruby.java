package gems;

public class Ruby extends Gemstone{
    String place_of_origin;

    public Ruby(double weight, int rarity, int price, double transparency, String place_of_origin) {
        super(weight, rarity, price, transparency);
        this.place_of_origin = place_of_origin;
    }

    @Override
    public String toString() {
        return "Ruby{" +
                "place_of_origin='" + place_of_origin + '\'' +
                ", weight=" + weight +
                ", rarity=" + rarity +
                ", price=" + price +
                ", transparency=" + transparency +
                '}';
    }

}
