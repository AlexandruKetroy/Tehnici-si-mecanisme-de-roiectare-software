package utm.tmps;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Identity extends UserProfile {
    private long Id;

    public Identity(Identity target) {
        super(target);
        if (target != null)
            this.Id = target.Id;
    }

    public Identity(String firstname, String lastName, int age, long id) {
        super(firstname,lastName,age);
        Id = id;
    }

    @Override
    public UserProfile clone() {
        return new Identity(this);
    }

    @Override
    public String toString() {
        return "Identity{" +
                " Firstname=" + super.getFirstName() +
                " Lastname=" + super.getLastName() +
                " Age=" + super.getAge() +
                " Id=" + Id +
                '}';
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Identity) || !super.equals(object2)) return false;
        Identity identity2 = (Identity) object2;
        return identity2.Id == Id;
    }
}
