package flowers;

public class Lilly extends Flower {

    String tribe;
    String family;

    @Override
    public String toString() {
        return "Lilly{" +
                "tribe='" + tribe + '\'' +
                ", family='" + family + '\'' +
                ", color='" + color + '\'' +
                ", stem_length=" + stem_length +
                ", freshness=" + freshness +
                '}';
    }


    public String getTribe() {
        return tribe;
    }

    public String getFamily() {
        return family;
    }

    public Lilly(String color, int stem_length, int freshness, int price, String tribe, String family) {
        super(color, stem_length, freshness, price);
        this.tribe = tribe;
        this.family = family;
    }
}
