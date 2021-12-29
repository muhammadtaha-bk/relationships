package com.spring.relationships.global;

import com.blueconic.browscap.UserAgentParser;
import com.blueconic.browscap.UserAgentService;

import java.util.UUID;

public class CommonUtils {
    public static String myUserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36";

    public static UserAgentParser getClient() {
        try {
            return new UserAgentService().loadParser();
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public static UUID generateRandomId() {
        return UUID.randomUUID();
    }

    public static String convertUuidToString(UUID uuid) {
        return (digits(uuid.getMostSignificantBits() >> 32, 8) +
                digits(uuid.getMostSignificantBits() >> 16, 4) +
                digits(uuid.getMostSignificantBits(), 4) +
                digits(uuid.getLeastSignificantBits() >> 48, 4) +
                digits(uuid.getLeastSignificantBits(), 12));
    }

    private static String digits(long val, int digits) {
        long hi = 1L << (digits * 4);
        return Long.toHexString(hi | (val & (hi - 1))).substring(1);
    }
}
