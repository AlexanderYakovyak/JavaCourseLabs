package TextComp;

import java.util.ArrayList;
import java.util.List;

public class Sentence{

    List<Word> words;

    public Sentence(){
        this.words = new ArrayList<>();
    }

    public Sentence(Word word){
        this.words = new ArrayList<Word>();
        this.words.add(word);
    }

    public Sentence(List<Word> arr) {
        this.words = arr;
    }

    public void setArr(List<Word> arr) {
        this.words = arr;
    }

    public List<Word> getArr() {
        return words;
    }

    @Override
    public String toString() {
        String sentence = "";
        for(Word word: words){
            sentence+= word.getWord();
        }

        return sentence + '\n';
    }

}
