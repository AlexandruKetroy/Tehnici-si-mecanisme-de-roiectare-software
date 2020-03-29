package utm.tmps;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;
public class UserProfileTest {

    UserProfile userProfile1;
    UserProfile userProfile2;
    UserProfile userProfile3;
    BundledUserProfileCache cache;
    Identity identity;
    BankDetails bankDetails;


    @BeforeEach
    void setUp() {
        identity = new Identity("Oleg", "Olegov", 33, 456);
        bankDetails = new BankDetails("Maxim", "Maximov", 23, 32);
        cache = new BundledUserProfileCache(identity, bankDetails);
        userProfile1 = cache.get("Identity");
        userProfile2 = cache.get("Identity");
        userProfile3 = cache.get("Bank Details");

    }

    @Test
    public void TwoIdentityObjectsShoouldBeEqual() {
        assertThat(userProfile1).isEqualTo(userProfile2);

    }

    @Test
    public void BankDetailsAndIdentityAreDifferent() {
        assertThat(userProfile1).isNotEqualTo(userProfile3);
    }

    @AfterEach
    void tearDown() {
        identity = null;
        bankDetails = null;
        cache = null;
        userProfile1 = null;
        userProfile2 = null;
        userProfile3 = null;
    }
}
