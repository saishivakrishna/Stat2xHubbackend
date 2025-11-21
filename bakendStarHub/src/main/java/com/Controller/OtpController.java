package com.Controller;

import com.Entity.OtpRequest;
import com.Service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/otp")
@CrossOrigin("*")
public class OtpController {

    @Autowired
    private OtpService otpService;

    // 🔹 Send OTP
    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestBody OtpRequest req) {
        String response = otpService.sendOtp(req.getPhone());
        return ResponseEntity.ok("OTP sent successfully! " + response);
    }

    // 🔹 Verify OTP
    @PostMapping("/verify")
    public ResponseEntity<String> verifyOtp(
            @RequestParam String phone,
            @RequestParam String otp) {

        boolean valid = otpService.verifyOtp(phone, otp);

        if (valid) {
            return ResponseEntity.ok("OTP Verified Successfully!");
        } else {
            return ResponseEntity.badRequest().body("Invalid or Expired OTP");
        }
    }
}
