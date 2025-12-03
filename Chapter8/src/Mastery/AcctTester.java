package Mastery;

public class AcctTester {

    public static void main(String[] args) {

        // Personal Account — start above minimum
        PersonalAcct p = new PersonalAcct(150, "John", "Doe");
        System.out.println("PERSONAL ACCOUNT:");
        System.out.println(p);

        System.out.println("\nWithdrawing $60...");
        p.withdrawal(60);  // Should drop below $100 → fee applied
        System.out.println(p);

        System.out.println("\nDepositing $50...");
        p.deposit(50);
        System.out.println(p);


        // Business Account — start above minimum
        BusinessAcct b = new BusinessAcct(650, "Mary", "Smith");
        System.out.println("\n\nBUSINESS ACCOUNT:");
        System.out.println(b);

        System.out.println("\nWithdrawing $100...");
        b.withdrawal(100); // Still above minimum → no fee
        System.out.println(b);

        System.out.println("\nWithdrawing $200...");
        b.withdrawal(200); // Should drop below 500 → $10 fee
        System.out.println(b);
    }
}
/* Screen Dump
PERSONAL ACCOUNT:
JDoe  John Doe Current balance is $150.00

Withdrawing $60...
Balance below minimum. Charging $2.00 fee.
JDoe  John Doe Current balance is $88.00

Depositing $50...
JDoe  John Doe Current balance is $138.00


BUSINESS ACCOUNT:
MSmith  Mary Smith Current balance is $650.00

Withdrawing $100...
MSmith  Mary Smith Current balance is $550.00

Withdrawing $200...
Balance below minimum. Charging $10.00 fee.
MSmith  Mary Smith Current balance is $340.00
*/