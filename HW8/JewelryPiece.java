import gems.Gemstone;

import java.util.Arrays;

public class JewelryPiece {
    public Gemstone[] gemstones;
    public int craft_price;
    int overall_price;
    double weight;

    public JewelryPiece(Gemstone[] gemstones, int craft_price) {
        this.gemstones = gemstones;
        this.craft_price = craft_price;
    }

    @Override
    public String toString() {
        return "JewelryPiece{" +
                "gemstones=" + Arrays.toString(gemstones) +
                ", craft_price=" + craft_price +
                '}';
    }

    public double setWeight() {
        double weight = 0;
        for(Gemstone gem: gemstones){
            weight+=gem.weight;
        }
        this.weight = weight;
        return this.weight;
    }

    public int setPrice(){
        int price = 0;
        for(Gemstone gem: gemstones){
            price+=gem.price;
        }
        price += this.craft_price;
        this.overall_price = price;
        return this.overall_price;
    }
}
