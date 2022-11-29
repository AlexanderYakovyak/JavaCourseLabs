import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task17 {
    public static void main(String[] args){
        String filename = "text.txt";

        HashMap<String, Integer> wordsFrequency = new HashMap<String, Integer>();

        FileReader fr = null;
        try {
            fr = new FileReader(filename);
            Scanner scr = new Scanner(fr);

            while(scr.hasNext()){
                String line = scr.nextLine();
                String[] words = line.split("\\s+");

                for(String word: words){
                    String currentWord = word.strip();
                    if (wordsFrequency.containsKey(currentWord)){
                        int currentFrequency = wordsFrequency.get(currentWord);
                        wordsFrequency.put(currentWord, currentFrequency+1);
                    }else{
                        wordsFrequency.put(currentWord, 1);
                    }
                }
            }

            fr.close();

            for (Map.Entry<String, Integer> entry : wordsFrequency.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.printf("Word: {%s}, frequency: {%d} \n", key, value);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
