package Mastery;

public class PersonalAcct extends Account {

    private static final double MIN_BAL = 100.00;
    private static final double FEE = 2.00;

    public PersonalAcct(double bal, String first, String last) {
        super(bal, first, last);
    }

    public PersonalAcct(String id) {
        super(id);
    }

    @Override
    public void withdrawal(double amt) {
        // Call normal withdrawal first
        double oldBalance = getBalance();
        super.withdrawal(amt);

        // If withdrawal succeeded and drops below minimum → charge fee
        if (oldBalance >= amt && getBalance() < MIN_BAL) {
            System.out.println("Balance below minimum. Charging $2.00 fee.");
            super.withdrawal(FEE);
        }
    }
}
