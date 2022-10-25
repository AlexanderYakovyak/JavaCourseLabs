import TextComp.*;

import java.util.ArrayList;
import java.util.List;


public class Task5_1 {

    public static void main(String[] args){

        Word word1 = new Word("Word1");
        Word word2 = new Word("word2");
        Word word3 = new Word("word3");


        List<Word> words1 = new ArrayList<Word>(){
            {
                add(word1);
                add(word2);
                add(word3);
            }
        };

        Sentence sentence1 = new Sentence(words1);


        Word word4 = new Word("Word4");
        List<Word> words2 = new ArrayList<Word>(){
            {
                add(word1);
                add(word2);
                add(word3);
                add(word4);
            }
        };


        Sentence sentence2 = new Sentence(words2);

        Word word5 = new Word("Word5");
        List<Word> words3 = new ArrayList<Word>(){
            {
                add(word1);
                add(word2);
                add(word3);
                add(word4);
                add(word5);
            }
        };


        Sentence sentence3 = new Sentence(words3);

        List<Sentence> sentences = new ArrayList<Sentence>(){
            {
                add(sentence1);
                add(sentence2);
                add(sentence3);
            }
        };

        Text text = new Text(sentences);


        Sentence sentence4 = new Sentence(new Word("Word6"));

        text.addSentence(sentence4);

        System.out.println(text);

        System.out.println("The title of the text (1-st sentence of the text): ");
        System.out.println(text.getTitle());

    }

}
