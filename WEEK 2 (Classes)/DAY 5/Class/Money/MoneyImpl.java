public class MoneyImpl {
    public static void main(String[] args) {
        Money income = new Money(3000, "INR");
        Money expanse = new Money(3000, "INR");

        System.out.println("Income is equal to expense : " + (income.equals(expanse)));
    }
}
