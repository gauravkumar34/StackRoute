

public class Money {
    int amount;
    String currencyCode;

    public Money(int amount, String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

        @Override
    public boolean equals(Object obj) {
        Money mobj = (Money) obj;
        if(amount != mobj.amount)
            return false;
        else if(!(currencyCode.equals(mobj.currencyCode)))
            return false;
        else return true;
    }

    
    
}
