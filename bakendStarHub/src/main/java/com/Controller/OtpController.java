package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Service.OtpService;
import java.util.Map;

@RestController
@RequestMapping("/api/otp")
@CrossOrigin("*")
public class OtpController {

    @Autowired
    private OtpService otpService;

    // ----------------------------
    // SEND OTP (expects JSON)
    // ----------------------------
    @PostMapping("/send")
    public Map<String, Object> sendOtp(@RequestBody Map<String, String> request) {
        String phone = request.get("phone");  // extract phone from JSON
        String sessionId = otpService.sendOtp(phone);

        return Map.of(
                "status", "OTP_SENT",
                "sessionId", sessionId
        );
    }

    // ----------------------------
    // VERIFY OTP (URL PARAMS)
    // ----------------------------
    @PostMapping("/verify")
    public Map<String, Object> verifyOtp(
            @RequestParam String sessionId,
            @RequestParam String otp) {

        boolean isValid = otpService.verifyOtp(sessionId, otp);

        return Map.of(
                "status", isValid ? "VALID" : "INVALID"
        );
    }
}
