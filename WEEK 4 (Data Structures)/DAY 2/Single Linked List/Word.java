public class Word {
    private String word;
    private int occurance;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getOccurance() {
        return occurance;
    }

    public void setOccurance(int occurance) {
        this.occurance = occurance;
    }

    public Word() {
        this.word = word;
    }

    public Word(int occurance) {
        this.occurance = occurance;
    }

    @Override
    public String toString() {
        return "\nWord [occurance=" + occurance + ", word=" + word + "]";
    }

}
