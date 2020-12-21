/**
 * Word
 */
public class Word {

    String word;
    int noOfOccurance;

    public Word() {
        this.word = word;
        this.noOfOccurance = noOfOccurance;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getNoOfOccurance() {
        return noOfOccurance;
    }

    public void setNoOfOccurance(int noOfOccurance) {
        this.noOfOccurance = noOfOccurance;
    }

    @Override
    public String toString() {
        return word + "     " + noOfOccurance;
    }

}