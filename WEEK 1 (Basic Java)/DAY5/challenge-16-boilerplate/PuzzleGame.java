import java.util.Scanner;

public class PuzzleGame {

    /**
     * this function find the shortest word from array String
     * 
     * @param words
     */
    private static void shortestWord(String words[]) {
        String smallest = words[0];

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < smallest.length()) {
                smallest = words[i];
            }
        }
        System.out.println("The shortest word is : " + smallest);

    }

    /**
     * this function sort the Array String word
     * 
     * @param words
     * @return
     */

    private static String[] sortWords(String words[]) {
        String temp = "";
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i].compareTo(words[j]) < 0) { // -1 0 1
                    temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }

            }
        }
        return words;

    }

    /**
     * this function printing the sorted array
     * 
     * @param words
     */

    private static void printSortWord(String[] words) {
        sortWords(words);
        System.out.println("The sorted array is: ");
        for (int i = 0; i < words.length; i++) {
            System.out.println((i + 1) + ".\t" + words[i]);
        }

    }

    /**
     * search @param findWord the word in the list @param words
     *
     * @param findWord
     */
    private static void searchWord(String[] words, String findWord) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].toUpperCase().equals(findWord.toUpperCase())) {
                System.out.println("The word " + words[i] + "  is present in the list.");
            } else {
                System.out.println("The word " + words[i] + "  is NOT present in the list.");
            }
        }
    }

    /**
     * this function taking word from list and then check each word. That word is
     * Palindrom or not.
     * 
     * @param str
     * @return if(isPalindrome) then return true else false
     */
    private static boolean isPalindrome(String str) {
        int len = str.length();

        // compare each character from starting
        // with its corresponding character from last
        for (int i = 0; i < len / 2; i++)
            if (str.toUpperCase().charAt(i) != str.toUpperCase().charAt(len - i - 1))
                return false;

        return true;
    }

    /**
     * After checking word is palindrome then count the no of that word and print
     * that word
     * 
     * @param words
     */
    private static void findPalindrome(String[] words) {
        int count = 0;
        // String[] palindromeWord;
        System.out.println("The word which is palindrome is : ");
        for (int i = 0; i < words.length; i++) {

            String check_word = words[i];
            if (isPalindrome(check_word)) {
                System.out.println(check_word);
                count++;
            }

        }
        System.out.println("The number of palindromes in the list : " + count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of words: ");
        int n = sc.nextInt();
        System.out.println("Enter the words: ");
        String words[] = new String[n];
        for (int i = 0; i < n; i++) {
            String word;
            word = sc.next();
            words[i] = word;
        }
        System.out.println("Enter a word to search: ");
        String findWord = sc.next();
        shortestWord(words); // a
        searchWord(words, findWord); // b
        printSortWord(words); // c
        findPalindrome(words); // d

    }
}