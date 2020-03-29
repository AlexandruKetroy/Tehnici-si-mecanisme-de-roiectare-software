package utm.tmps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class UserProfile {
    private String firstName;
    private String lastName;
    private int age;


    public UserProfile(UserProfile target) {
        if (target != null) {
            this.firstName = target.firstName;
            this.lastName = target.lastName;
            this.age = target.age;
        }
    }

    public abstract UserProfile clone();

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof UserProfile)) return false;
        UserProfile userProfile2 = (UserProfile) object2;
        return Objects.equals(userProfile2.firstName, firstName) &&
                Objects.equals(userProfile2.lastName, lastName) &&
                userProfile2.age == age;
    }
}

