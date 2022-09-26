public class Task1_5 {

    String username;
    float xp;

    Task1_5(String username, float xp){
        this.username = username;
        this.xp = xp;
    }

    public static void main(String[] args) {
        Task1_5 object = new Task1_5("samurai", 151.512f);
        object.display();

    }

    public void display(){
        System.out.println("The nickname of this user: " + this.username);
    }
}
