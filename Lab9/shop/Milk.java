package shop;

public class Milk extends Item{
    
    int fat;
    
    Milk(){
        super();
        this.type = "liquid";
    }
    
    Milk(float price, String name, int fat){
        super(price, name, "liquid");
        this.fat = fat;
    }
    
    public int getFat(){
        return fat;
    }
    
    public void setFat(int fat){
        this.fat = fat;
    }
}
