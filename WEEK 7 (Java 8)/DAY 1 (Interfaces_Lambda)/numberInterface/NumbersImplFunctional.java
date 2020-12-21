public class NumbersImplFunctional {

    public static void main(String[] args) {
        Num n = new Num() {

            public int getANumber() {
                return 10;
            }
        };
        int ll = n.getANumber();
        Num num = () -> 1000; // * Expression lambda
        int l = num.getANumber();
        System.out.println(l + " " + ll);
    }
}
