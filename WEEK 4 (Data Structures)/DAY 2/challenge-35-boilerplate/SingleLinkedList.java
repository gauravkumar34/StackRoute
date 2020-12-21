
public class SingleLinkedList {

    Node startPtr;

    /**
     * *this method are used to adding the word in the list ...
     */

    public void addWord(String item) {
        if (!updateOccurance(item)) {
            Word word = new Word();
            word.setWord(item);
            word.setNoOfOccurance(1);

            Node newNode = new Node(word);

            if (startPtr == null) {
                startPtr = newNode;
                startPtr.next = null;
            } else {
                newNode.next = startPtr;
                startPtr = newNode;
            }
        }
    }

    /**
     * *this method are used to update and checking the occurance of the word
     */

    public boolean updateOccurance(String item) {
        if (startPtr == null) {
            return false;
        }
        Node current = startPtr;
        while (current != null) {
            if (current.word.getWord().equals(item)) {
                current.word.setNoOfOccurance(current.word.getNoOfOccurance() + 1);
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    /**
     * *this method are used to display the word ...
     */
    public void showWord() {
        int count = 0;
        Node curr = startPtr;
        while (curr != null) {
            System.out.println(curr.word + " ");
            // ! curr.next = startPtr; {myError}
            curr = curr.next;
            count++;
        }
        // System.out.println(count);

    }

    /**
     * *this method are used to sort the word Alphabatically such as a, all,be,cloud
     * ...
     */
    public void sortAlpha() {
        Node curr = startPtr;
        Word temp;
        Node nextNode = null;
        if (curr == null) {
            System.out.println("Empty list");
        } else {
            while (curr != null) {
                nextNode = curr.next;
                while (nextNode != null) {
                    if (curr.word.getWord().compareTo(nextNode.word.getWord()) > 0) {
                        temp = curr.word;
                        curr.word = nextNode.word;
                        nextNode.word = temp;
                    }
                    nextNode = nextNode.next;
                }
                curr = curr.next;
            }
        }
    }

    /**
     * * this method is used to reverse sort in alphabatically
     */

    public void revSortAlpha() {
        Node curr = startPtr;
        Node nextNode;
        Node prevNode = null;
        if (curr == null) {
            System.out.println("Empty list");
        } else {
            while (curr != null) {
                nextNode = curr.next;
                curr.next = prevNode;
                prevNode = curr;
                curr = nextNode;
            }
            startPtr = prevNode;
        }
    }

    public void showFrequentWords() {
        Node curr = startPtr;
        Word temp;
        Node nextNode = null;
        if (curr == null) {
            System.out.println("Empty list");
        } else {
            while (curr != null) {
                nextNode = curr.next;
                while (nextNode != null) {
                    if (curr.word.getWord().compareTo(nextNode.word.getWord()) > 0) {
                        temp = curr.word;
                        curr.word = nextNode.word;
                        nextNode.word = temp;
                    }
                    nextNode = nextNode.next;
                }
                curr = curr.next;
            }
        }
    }

}
