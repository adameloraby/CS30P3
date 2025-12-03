package Mastery;

public class BusinessAcct extends Account {

    private static final double MIN_BAL = 500.00;
    private static final double FEE = 10.00;

    public BusinessAcct(double bal, String first, String last) {
        super(bal, first, last);
    }

    public BusinessAcct(String id) {
        super(id);
    }

    @Override
    public void withdrawal(double amt) {
        double oldBalance = getBalance();
        super.withdrawal(amt);

        if (oldBalance >= amt && getBalance() < MIN_BAL) {
            System.out.println("Balance below minimum. Charging $10.00 fee.");
            super.withdrawal(FEE);
        }
    }
}


