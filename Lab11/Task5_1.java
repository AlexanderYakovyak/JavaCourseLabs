import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Task5_1 {

    public static void solve_tasks_a_d(String filename, String outputFile){
        String longest_word = "";
        int words_count = 0;

        FileReader fr = null;
        try {
            fr = new FileReader(filename);
            Scanner fsc = new Scanner(fr);

            FileWriter fw = new FileWriter(outputFile);

            while(fsc.hasNext()){
                String current_str = fsc.nextLine();
                String[] words = current_str.split("\\s+");

                words_count+= words.length;
                String current_longest = words[0];


                StringBuilder new_string = new StringBuilder();

                for(String x: words){
                    if(x.length()>current_longest.length()){
                        current_longest = x;
                    }
                    if(x.length()>1){
                        new_string.append(x).append(" ");
                    }
                }


                if(current_longest.length()>longest_word.length()){
                    longest_word = current_longest;
                }

                String result = new_string.toString();
                result = result.strip();
                fw.write(result+"\n");
            }

            System.out.println("Longest word: "+ longest_word);
            System.out.println("Number of words "+words_count);

            fr.close();
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void solve_tasks_e(String filename, String outputFile){

        FileReader fr = null;
        try {
            fr = new FileReader(filename);
            Scanner fsc = new Scanner(fr);
            FileWriter fw = new FileWriter(outputFile);

            int symbols=0;
            int words_num=0;
            int m;

            ArrayList<String> current_words = new ArrayList<String>();

            while(fsc.hasNext()){
                String current_str = fsc.nextLine();
                String[] words = current_str.split("\\s+");

                symbols=0;
                words_num=0;
                current_words.clear();

                for(String x: words){
                    symbols+=x.length()+1;
                    words_num+=1;
                    current_words.add(x);

                }

                if(1<words_num && symbols<80){
                    m = (80-symbols)/(words_num-1);
                    for(String word: current_words){
                        fw.write(word);
                        for(int i=0;i<m;++i){
                            fw.write(" ");
                        }
                    }
                    fw.write('\n');
                }

            }

            fr.close();
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws IOException {

        String filename = "text.txt";
        String outputFile1 = "output.txt";
        String outputFile2 = "output2.txt";

        solve_tasks_a_d(filename,outputFile1);
        solve_tasks_e(filename,outputFile2);

    }
}
