public class Task1_4 {

    String username;
    float xp;

    Task1_4(String username, float xp){
        this.username = username;
        this.xp = xp;
    }

    public static void main(String[] args) {
        Task1_4 object = new Task1_4("samurai", 151.512f);
        System.out.println("The nickname of this user: " + object.username);

    }

}
