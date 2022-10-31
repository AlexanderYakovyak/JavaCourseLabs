import connections.ConnectionManager;

public class Task1 {
    public static void main(String[] args){
        String[] user_input = new String[]{"Input message 1", "Input message 2","Input message 3"};
        ConnectionManager object = new ConnectionManager(user_input);

        while(ConnectionManager.has_connection()){
            System.out.println(ConnectionManager.get_connection());
        }
    }
}
