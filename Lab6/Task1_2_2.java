import task2.Task1_2;

public class Task1_2_2 {

    protected static void demonstation(){
        Task1_2 object = new Task1_2();
        System.out.println("Took field from package class in protected method "+object.getName());
    }

    public static void main(String[] args){
        demonstation();
    }
}
