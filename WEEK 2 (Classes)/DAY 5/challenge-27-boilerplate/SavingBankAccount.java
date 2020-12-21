import java.sql.Date;

public class SavingBankAccount {
    private long accountNumber;
    private double totalBalance;
    private double avaliableBalance;
    private Date accOpeningDate;
    // ! AccountType status

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public double getAvaliableBalance() {
        return avaliableBalance;
    }

    public void setAvaliableBalance(double avaliableBalance) {
        this.avaliableBalance = avaliableBalance;
    }

    public Date getAccOpeningDate() {
        return accOpeningDate;
    }

    public void setAccOpeningDate(Date accOpeningDate) {
        this.accOpeningDate = accOpeningDate;
    }

}
