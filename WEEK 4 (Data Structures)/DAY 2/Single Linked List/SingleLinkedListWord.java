public class SingleLinkedListWord {

    WordNode startPtr;

    public void addWordNode(String item) {
        // 1 need to check if word id already in the list

        if (!updateOccurance(item)) {
            Word word = new Word();
            word.setWord(item);
            word.setOccurance(1);

            WordNode newWordNode = new WordNode(word);

            if (startPtr == null) {
                startPtr = newWordNode;
                startPtr.next = null;
            } else {
                // WordNode current = startPtr;

                newWordNode.next = startPtr;
                startPtr = newWordNode;
            }
        }

    }

    public boolean updateOccurance(String item) {
        if (startPtr == null) {
            return false;
        }
        WordNode current = startPtr;
        while (current != null) {

            if (current.word.getWord().equals(item)) {
                current.word.setOccurance(current.word.getOccurance() + 1);
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    void traversal() {
        WordNode current = startPtr;
        while (current != null) {
            // data holds Word object - string , int ->
            System.out.println(current.word + " ");
            current = current.next;
        }
    }
}
