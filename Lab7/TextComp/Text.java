package TextComp;

import java.util.ArrayList;
import java.util.List;

public class Text {

    private List<Sentence> sentences;

    public Text(){
        this.sentences = new ArrayList<Sentence>();
    }

    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }
    List<Sentence> getSentences() {
        return this.sentences;
    }

    public void addSentence(Sentence sentence){this.sentences.add(sentence);}

    public Sentence getTitle(){
        return this.sentences.get(0);
    }

    @Override
    public String toString() {
        String output = "";
        for (Sentence sentence: sentences) {
            output += sentence;

        }
        return output;
    }


}
