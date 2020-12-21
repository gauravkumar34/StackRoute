/**
 * making EQUALS object to cheack the amount and iNR is equals.. actually
 * .equals() are used to comare single data type but with the this method it can
 * help to compare more than one data type at one time.
 */

public class Money {

    int amount;
    String currencyCode;

    public Money(int amount, String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    public boolean equals(Object obj) {
        Money mobj = (Money) obj;
        if (amount != mobj.amount) {
            return false;
        } else if (!(currencyCode.equals(mobj.currencyCode)))
            return false;
        else
            return true;
    }

}
