import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Task5_3 {
    public static void solve_task_a(String filename){
        FileReader fl = null;
        try {
            fl = new FileReader(filename);
            Scanner fsc = new Scanner(fl);

            while(fsc.hasNext()){
                System.out.println(fsc.nextLine());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void solve_task_b(String filename){
        FileReader fl = null;
        try {
            fl = new FileReader(filename);
            Scanner fsc = new Scanner(fl);

            while(fsc.hasNext()){
                String line = fsc.nextLine();
                if(line.length()>60) {
                    System.out.println(line);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void solve_task_c1(String filename, char symbol){
        FileReader fl = null;
        try {
            fl = new FileReader(filename);
            Scanner fsc = new Scanner(fl);

            int res = 0;

            while(fsc.hasNext()){
                String line = fsc.nextLine();
                line = line.strip();
                if(!line.equals("") && Character.toLowerCase(line.charAt(0))==symbol) {
                    res+=1;
                }
            }

            System.out.printf("The number of lines that begin with {%c} = %d ", symbol, res);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void solve_task_c2(String filename, char symbol){
        FileReader fl = null;
        try {
            fl = new FileReader(filename);
            Scanner fsc = new Scanner(fl);

            int res = 0;

            while(fsc.hasNext()){
                String line = fsc.nextLine();
                line = line.strip();

                if(!line.equals("") && Character.toLowerCase(line.charAt(line.length()-1))==symbol) {
                    res+=1;
                }
            }

            System.out.printf("The number of lines that end with {%c} = %d ", symbol, res);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void solve_task_c3(String filename){
        FileReader fl = null;
        try {
            fl = new FileReader(filename);
            Scanner fsc = new Scanner(fl);

            int res = 0;

            while(fsc.hasNext()){
                String line = fsc.nextLine();
                line = line.strip();

                if(!line.equals("") &&
                Character.toLowerCase(line.charAt(line.length()-1))==Character.toLowerCase(line.charAt(0)))
                {
                    res+=1;
                }
            }

            System.out.printf("The number of lines that start and end with the same char = %d ", res);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void solve_task_c4(String filename){
        FileReader fl = null;
        try {
            fl = new FileReader(filename);
            Scanner fsc = new Scanner(fl);

            int res = 0;

            while(fsc.hasNext()){
                String line = fsc.nextLine();
                line = line.strip();

                if(!line.equals("") && line.replace(" ", "").chars().distinct().count() == 1) {
                    System.out.println(line);
                    res+=1;
                }
            }

            System.out.printf("The number of lines that consist of the same chars = %d ", res);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args){
        String filename = "text.txt";

        solve_task_a(filename);
        solve_task_b(filename);
        solve_task_c1(filename, 't');
        solve_task_c2(filename, '.');
        solve_task_c3(filename);
        solve_task_c4(filename);
    }
}
