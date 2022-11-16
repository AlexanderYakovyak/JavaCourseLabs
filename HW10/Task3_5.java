import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task3_5 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Input the file path: ");

        String file_path = sc.nextLine();

        File file = new File(file_path);
        Scanner file_sc = null;

        try {
            file_sc = new Scanner(file);
            int max_length = 0;
            String longest_string = "";

            while (file_sc.hasNextLine()){
                String line = file_sc.nextLine();
                if (line.length()>max_length){
                    max_length = line.length();
                    longest_string = line;
                }
            }

            System.out.println("The longest line in a tet file: ");
            System.out.println(longest_string);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
