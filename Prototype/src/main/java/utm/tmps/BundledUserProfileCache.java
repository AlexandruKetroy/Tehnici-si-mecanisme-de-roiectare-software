package utm.tmps;

import java.util.HashMap;
import java.util.Map;


public class BundledUserProfileCache {
    private Map<String, UserProfile> cache = new HashMap<>();

    public BundledUserProfileCache(Identity identity, BankDetails bankDetails) {
        cache.put("Identity", identity);
        cache.put("Bank Details", bankDetails);
    }

    public UserProfile put(String key, UserProfile userProfile) {
        cache.put(key, userProfile);
        return userProfile;
    }

    public UserProfile get(String key) {
        return cache.get(key).clone();
    }
}