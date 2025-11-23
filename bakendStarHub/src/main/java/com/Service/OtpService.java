package com.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@Service
public class OtpService {

    @Value("${twofactor.api.key}")
    private String apiKey;

    @Value("${twofactor.base.url}")
    private String baseUrl;

    private final RestTemplate rest = new RestTemplate();

    // Send OTP by SMS only
    public String sendOtp(String phone) {

        String url = baseUrl + apiKey + "/SMS/+91" + phone + "/AUTOGEN/OTP";

        String response = rest.getForObject(url, String.class);
        JSONObject json = new JSONObject(response);

        if (!json.getString("Status").equals("Success")) {
            throw new RuntimeException("Failed to send OTP: " + response);
        }

        return json.getString("Details"); // sessionId
    }

    // Verify OTP
    public boolean verifyOtp(String sessionId, String otp) {

        String url = baseUrl + apiKey + "/SMS/VERIFY/" + sessionId + "/" + otp;

        String response = rest.getForObject(url, String.class);
        JSONObject json = new JSONObject(response);

        return json.getString("Status").equals("Success");
    }
}
