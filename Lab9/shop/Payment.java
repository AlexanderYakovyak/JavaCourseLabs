package shop;

public class Payment{
    class Warehouse{
        
        public void get(Item item){
            System.out.println("Get shop.Item: " + item);
        }
        
        public void find(Item item){
            System.out.println("Find shop.Item: " + item);
        }
        
        public void sell(Item item){
            System.out.println("Sell shop.Item: " + item);
        }
    }
    
    private Warehouse stock;
    private Client client;
    float sum_money;
    
    public Payment(Client client){
        this.client = client;
        this.stock = new Payment.Warehouse();
        this.sum_money = 0;
    }
    
    void setClient(Client c){
        this.client = c;
    }
    
    Client getClient(){
        return client;
    }
    
    public Item order(EnumProducts prod, String name, float price){
        Item item = this.client.order(prod, name, price);

        this.stock.find(item);
        this.stock.sell(item);
        
        this.sum_money += price;
        
        return item;
    }
    
    public static void main(String[] args){
        Client cl = new Client("Name", "Surname", 1000.0);
        Payment p = new Payment(cl);

        Item item1 = p.order(EnumProducts.MEAT, "Pork", 100);
        Item item2 = p.order(EnumProducts.MILK, "Almond", 20);
        Item item3 = p.order(EnumProducts.MEAT, "Japanese Wagyu", 3000);
        

        System.out.println("shop.Payment: " + p.sum_money);
    }
}
