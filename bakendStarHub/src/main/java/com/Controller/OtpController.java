package com.Controller;



import com.Service.SmsService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/otp")
@CrossOrigin("*")
public class OtpController {

    private final SmsService smsService;
    private final Map<String, String> otpStore = new HashMap<>();

    public OtpController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/send")
    public String sendOtp(@RequestBody Map<String, String> req) {
        String phone = req.get("phone");
        String otp = String.valueOf(new Random().nextInt(900000) + 100000);

        smsService.sendOtp(phone,  "🟦 Star2XHub\n" +
            "Welcome to Star2XHub!\n" +
            "Your OTP is: " + otp + "\n" +
            "Thank you for registering.");
        otpStore.put(phone, otp);

        return "OTP sent to " + phone;
    }

    @PostMapping("/verify")
    public String verifyOtp(@RequestParam String phone, @RequestParam String otp) {
        if (otp.equals(otpStore.get(phone))) {
            return "OTP Verified Successfully!";
        }
        return "Invalid OTP";
    }
}

