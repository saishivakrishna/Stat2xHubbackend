package com.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api/otp")
@CrossOrigin("*")
public class OtpController {

    private final String API_KEY = "bc5182bd-c6fe-11f0-a6b2-0200cd936042";

    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestBody Map<String, String> req) {

        String phone = req.get("phone");

       String url = "https://2factor.in/API/V1/" + API_KEY + "/SMS/" + phone + "/AUTOGEN/OTP1";


        RestTemplate rest = new RestTemplate();
        String response = rest.getForObject(url, String.class);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyOtp(@RequestParam String sessionId,
                                            @RequestParam String otp) {

        String url = "https://2factor.in/API/V1/" + API_KEY + "/SMS/VERIFY/" + sessionId + "/" + otp;

        RestTemplate rest = new RestTemplate();
        String response = rest.getForObject(url, String.class);

        return ResponseEntity.ok(response);
    }
}

