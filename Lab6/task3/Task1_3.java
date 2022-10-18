package task3;
public class Task1_3 {

    int field1;
    public int field2;
    private int field3;
    protected int field4;

    void method1(){
        System.out.println("Simple method1");
    }

    public void method2(){
        System.out.println("Public method2");
    }

    private void method3(){
        System.out.println("Private method3");
    }

    protected void method4(){
        System.out.println("Protected method4");
    }

    public static void main(String[] args){
        Task1_3 object = new Task1_3();
        object.field3 = 1;
        object.method3();
    }

}
