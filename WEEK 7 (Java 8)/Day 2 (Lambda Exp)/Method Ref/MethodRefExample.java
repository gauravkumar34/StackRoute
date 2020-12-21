class StringOperations {
    // static
    String strReverse(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }
        return rev;
    }

}

public class MethodRefExample {
    static String stringOpr(StringFunc fn, String str) {
        return fn.func(str);
    }

    public static void main(String[] args) {
        String s = "Lambdas and Functional Programming";
        String sout;
        StringOperations opr = new StringOperations();

        // sout = stringOpr(x -> StringOperations.strReverse(s), s); // static
        // sout = stringOpr(StringOperations::strReverse, s); // static method referance
        sout = stringOpr(x -> opr.strReverse(s), s); // insatance
        sout = stringOpr(opr::strReverse, s); // insatance method referance

        System.out.println("the revrse string is : " + sout);

    }
}