public class Task3_2 {
    String field1 = "Initialized from the start";
    String field2;

    Task3_2(String field2){
        this.field2 = field2;
    }

    public static void main(String[] args){
        Task3_2 example = new Task3_2("Initialized via constructor");
        System.out.println(example.field1);
        System.out.println(example.field2);
    }
}
