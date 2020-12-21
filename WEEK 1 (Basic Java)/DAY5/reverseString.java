public class reverseString {
    public static void main(String[] args) {
        System.out.println(reveString1("hello"));
    }

    /**
     * this function reverse the string
     * 
     * @param s
     * @return
     */
    private static String reveString1(String s) {
        if (s.length() == 0) {
            return s;
        } else {
            int len = s.length();
            return s.charAt(len - 1) + reveString1(s.substring(0, len - 1));
        }
    }
}
