import printing.LaserPrinter;
import printing.Printer;

public class Task7_14 {

    public static void main(String[] args){

        Printer device1 = new Printer("type1", "model1", "man1",250);
        LaserPrinter device2 = new LaserPrinter("type2", "model2", "man2",500, 100);

        System.out.println(device1);
        System.out.println(device2);
    }
}
