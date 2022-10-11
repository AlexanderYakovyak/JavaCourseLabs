public class Task3_4 {

    Task3_4(){
        System.out.println("Some message");
    }

    Task3_4(String message){
        System.out.println("Some message "+ message);
    }

    public static void main(String[] args){
        Task3_4 example = new Task3_4("another message");
    }
}
