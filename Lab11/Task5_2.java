import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Task5_2 {

    public static void solve_task(String filename){
        FileReader fl = null;
        try {
            fl = new FileReader(filename);
            Scanner fsc = new Scanner(fl);

            long max_line_length = 0;
            int empty_lines_num = 0;

            while(fsc.hasNext()){
                String current_line = fsc.nextLine();

                if(current_line.length()>max_line_length){
                    max_line_length=current_line.length();
                }

                if(current_line.equals("")){
                    empty_lines_num+=1;
                }
            }


            System.out.println("Number of empty lines "+ empty_lines_num);
            System.out.println("The maximal length of a line "+max_line_length);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args){
        String filename = "text.txt";

        solve_task(filename);

    }
}
