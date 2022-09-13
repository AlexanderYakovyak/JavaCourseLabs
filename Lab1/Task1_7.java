public class Task1_7 {
    private String username;

    public static void main(String args[]){
        Task1_7 obj = new Task1_7();

        if(args.length<1){
            System.out.println("Incorrect number of arguments");
        } else {
            obj.username = args[0];
            System.out.println(obj.username);
        }
    }
}
