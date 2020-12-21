
/**
 * word
 */
public class Word {

    private String word;
    private int noOfOccurance;

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

    public Word() {
        this.word = word;
        this.noOfOccurance = noOfOccurance;
    }

    @Override
    public String toString() {
        return "Word [noOfOccurance=" + noOfOccurance + ", word=" + word + "]";
    }

}