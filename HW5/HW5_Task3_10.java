public class HW5_Task3_10 {

    String name;
    String surname;

    HW5_Task3_10(String name){
        this.name = name;
        System.out.println("Call of constructor here 1");
    }

    HW5_Task3_10(String name, String surname){
        this(name);
        this.surname = surname;
        System.out.println("Call of constructor here 2");
    }

    public static void main(String args[]){
        HW5_Task3_10 example = new HW5_Task3_10("John");
        HW5_Task3_10 example2 = new HW5_Task3_10("Jack", "Musk");

    }
}
