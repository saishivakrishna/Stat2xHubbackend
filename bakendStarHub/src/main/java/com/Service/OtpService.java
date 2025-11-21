package com.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OtpService {

    @Value("${fast2sms.api.key}")
    private String apiKey;

    public String sendOtp(String number, String otp) {

        try {
            String url = "https://www.fast2sms.com/dev/bulkV2?"
                    + "authorization=" + apiKey
                    + "&route=otp"
                    + "&numbers=" + number
                    + "&variables_values=" + otp;

            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class);

            return response;
        } catch (Exception e) {
            return "Error sending OTP: " + e.getMessage();
        }
    }
}
