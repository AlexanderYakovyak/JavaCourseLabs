package shop;

public class Client {

    String name;
    String surname;
    double balance;

    public Client(){

    };

    public Client(String name, String surname, double balance){
        this.name = name;
        this.surname = surname;
        this.balance = balance;
    }

    public Item order(EnumProducts product, String name, float price){
        if(this.balance < price){
            System.out.println("\nshop.Client doesn't have enough funds on his balance\n");
            return new Item();
        } else if (product == EnumProducts.MEAT) {
            Meat meat = new Meat(price, name, "fresh");
            this.balance-=price;
            return meat;
        } else if (product == EnumProducts.MILK) {
            Milk milk = new Milk(price, name, 30);
            this.balance-=price;
            return milk;
        }
        return new Item();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
