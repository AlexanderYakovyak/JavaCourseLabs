import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args){
        LinkedList<String> arr = new LinkedList<String>();

        String filename = "text.txt";
        FileReader fr = null;

        try {
            fr = new FileReader(filename);
            Scanner sc = new Scanner(fr);

            while(sc.hasNext()){
                String currentString = sc.nextLine();
                arr.add(currentString);
            }

            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(int i=arr.size()-1; i>=0; --i){
            System.out.println(arr.get(i));
        }

    }
}
