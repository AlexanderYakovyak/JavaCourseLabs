package connections;
public class ConnectionManager {

    static String message = "Your connection manager";
    static Connection[] connections;
    static int current_connection = 0;

    public ConnectionManager(String[] user_messages) {
        System.out.println(message);

        int number_of_messages = user_messages.length;

        connections = new Connection[number_of_messages];

        for(int i=0; i<number_of_messages; ++i){
            connections[i] = new Connection(user_messages[i]);
        }
    }

    public static String get_connection(){
        if(ConnectionManager.has_connection()){
            String resp = connections[current_connection].response();
            current_connection+=1;
            return resp;
        }
        return "No connections available";
    }

    public static boolean has_connection() {
        return (ConnectionManager.current_connection<ConnectionManager.connections.length);
    }

    public static void main(String[] args){
        System.out.println("Accessing connections in response to your messages");

    }

    static class Connection{
        String message_response;

        Connection(String message){
            this.message_response = message + ". Responded";
        }

        String response(){
            return this.message_response;
        }

    }
}
