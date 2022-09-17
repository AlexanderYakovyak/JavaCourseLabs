package Task1_9;

/** Represents a Task1_9 Lab1.
 * <strong>This is my HTML header</strong>
 * <p>Just playing around with paragraph</p>
 * @author Alexander Yakovyak
 * @version 1.0
 * @since 1.0
 */
public class Task1_9 {
    /**
     * The username input from command line
     */
    private String username;

    public static void main(String args[]){
        Task1_9 obj = new Task1_9();


        if(args.length<1){
            System.out.println("Incorrect number of arguments");
        } else {
            obj.username = args[0];
            System.out.println(obj.username);
        }
    }
}
