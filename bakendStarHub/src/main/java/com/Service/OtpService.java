package com.Service;

import com.Entity.OtpStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class OtpService {

    @Value("${fast2sms.api.key}")
    private String apiKey;

    // TEMP STORE (Use DB for production)
    private Map<String, OtpStore> otpMap = new HashMap<>();

    // 🔹 SEND OTP
    public String sendOtp(String phone) {

        String otp = String.valueOf((int)(Math.random() * 9000) + 1000);
        long expiryTime = System.currentTimeMillis() + (5 * 60 * 1000); // 5 minutes

        otpMap.put(phone, new OtpStore(otp, expiryTime));

        String url = "https://www.fast2sms.com/dev/bulkV2?"
                + "authorization=" + apiKey
                + "&route=otp"
                + "&numbers=" + phone
                + "&variables_values=" + otp;

        RestTemplate rt = new RestTemplate();
        return rt.getForObject(url, String.class);
    }

    // 🔹 VERIFY OTP
    public boolean verifyOtp(String phone, String otp) {
        if (!otpMap.containsKey(phone)) {
            return false; // no OTP sent
        }

        OtpStore store = otpMap.get(phone);

        if (System.currentTimeMillis() > store.getExpiresAt()) {
            otpMap.remove(phone);
            return false; // expired
        }

        boolean isValid = store.getOtp().equals(otp);

        if (isValid) {
            otpMap.remove(phone); // OTP used, remove it
        }

        return isValid;
    }
}
