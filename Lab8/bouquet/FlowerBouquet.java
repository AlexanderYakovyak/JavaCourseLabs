package bouquet;
import flowers.*;

public class FlowerBouquet {
    int flowers_num;
    Flower[] flowers;

    int accessories_num;
    Accessories[] accessories;

    public FlowerBouquet(){
        this.flowers_num = 0;
        this.accessories_num = 0;

    }

    public FlowerBouquet(int flowers_num, Flower[] flowers,int accessories_num, Accessories[] accessories){
        this.flowers_num = flowers_num;
        this.accessories_num = accessories_num;

        this.flowers = new Flower[flowers_num];
        this.accessories = new Accessories[accessories_num];

        for(int i=0; i<flowers_num; ++i){
            this.flowers[i] = flowers[i];
        }

        for(int i=0; i<accessories_num; ++i){
            this.accessories[i] = accessories[i];
        }
    }

    public int get_price(){
        int bouquet_price = 0;

        for(Flower flower: this.flowers){
            bouquet_price+=flower.getPrice();
        }

        for(Accessories accessory: this.accessories){
            bouquet_price+=accessory.getPrice();
        }

        return bouquet_price;
    }


}
