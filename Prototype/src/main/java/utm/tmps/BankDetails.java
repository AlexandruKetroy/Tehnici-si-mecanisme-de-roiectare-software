package utm.tmps;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BankDetails extends UserProfile {
    private long bankAccountId;

    public BankDetails(BankDetails target) {
        super(target);
        if (target != null) {
            this.bankAccountId = target.bankAccountId;
        }
    }

    public BankDetails(String firstname, String lastName, int age, long bankAccountId) {
        super(firstname,lastName,age);
        this.bankAccountId = bankAccountId;
    }

    public UserProfile clone() {
        return new BankDetails(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof BankDetails) || !super.equals(object2)) return false;
        BankDetails bankDetails2 = (BankDetails) object2;
        return bankDetails2.bankAccountId == bankAccountId;
    }

    @Override
    public String toString() {
        return "BankDetails{" +
                "Firstname=" + super.getFirstName() +
                " Lastname=" + super.getLastName() +
                " Age=" + super.getAge() +
                " bankAccountId=" + bankAccountId +
                '}';
    }
}
