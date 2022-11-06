package flowers;

public class Flower implements Comparable<Flower>{
    String color;
    int stem_length;
    int freshness;
    int price;

    public Flower(String color, int stem_length, int freshness, int price){
        this.color = color;
        this.stem_length = stem_length;
        this.freshness = freshness;
        this.price = price;
    }

    public int compareTo(Flower other) {

        int compareFreshness = ((Flower) other).getFreshness();

        return this.freshness - compareFreshness;

    }

    public String getColor() {
        return color;
    }

    public int getStem_length() {
        return stem_length;
    }

    public int getFreshness() {
        return freshness;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "color='" + color + '\'' +
                ", stem_length=" + stem_length +
                ", freshness=" + freshness +
                '}';
    }

}
