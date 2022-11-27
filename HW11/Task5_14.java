import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task5_14 {
    public static void getNumberByInitials(String filename, String surname, String initials){
        FileReader fr = null;
        boolean res = false;
        try {
            fr = new FileReader(filename);
            Scanner fsc = new Scanner(fr);

            while(fsc.hasNext()){
                String current_str = fsc.nextLine();
                String[] words = current_str.split("\\s+");

                if(words[0].equals(surname) && words[1].equals(initials)){
                    System.out.printf("We've found data about this person: %s %s \n", surname, initials);
                    System.out.printf("His phone number is: %s \n", words[2]);
                    res = true;
                    break;
                }
            }

            fr.close();

            if(res==false){
                System.out.println("No information on this person in a given file");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args){
        //Testing function with robust data
        System.out.println("Person1: ");
        getNumberByInitials("workers.txt", "Surname1", "N.P.1");

        System.out.println("\nPerson2: ");
        //Testing function with wrong data
        getNumberByInitials("workers.txt", "Surname10", "N.P.10");

    }
}
