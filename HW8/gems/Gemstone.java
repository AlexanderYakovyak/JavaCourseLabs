package gems;


public class Gemstone implements Comparable<Gemstone>{
    public double weight;
    public int rarity;
    public int price;
    public double transparency;

    public Gemstone(double weight, int rarity, int price, double transparency) {
        this.weight = weight;
        this.rarity = rarity;
        this.price = price;
        this.transparency = transparency;
    }

    @Override
    public int compareTo(Gemstone other) {
        int compareRarity = ((Gemstone) other).rarity;

        return this.rarity - compareRarity;
    }

    @Override
    public String toString() {
        return "Gemstone{" +
                "weight=" + weight +
                ", rarity=" + rarity +
                ", price=" + price +
                ", transparency=" + transparency +
                '}';
    }
}
