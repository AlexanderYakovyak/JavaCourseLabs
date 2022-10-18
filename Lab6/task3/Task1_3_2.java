package task3;

public class Task1_3_2 extends Task1_3 {

    public static void main(String[] args){
        Task1_3_2 successor = new Task1_3_2();

        System.out.println(successor.field1);
        System.out.println(successor.field2);
        System.out.println("Can't access field3, because it's protected");
        System.out.println(successor.field4+"\n");

        successor.method1();
        successor.method2();
        System.out.println("Can't call method3, because it's protected");
        successor.method4();

    }
}
