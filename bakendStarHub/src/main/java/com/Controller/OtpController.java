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

    @GetMapping("/send")
    public Map<String, Object> sendOtp(@RequestParam String phone) {
        String sessionId = otpService.sendOtp(phone);
        return Map.of("status", "OTP_SENT", "sessionId", sessionId);
    }

    @GetMapping("/verify")
    public Map<String, Object> verifyOtp(@RequestParam String sessionId, @RequestParam String otp) {
        boolean isValid = otpService.verifyOtp(sessionId, otp);

        return Map.of("status", isValid ? "VALID" : "INVALID");
    }
}
