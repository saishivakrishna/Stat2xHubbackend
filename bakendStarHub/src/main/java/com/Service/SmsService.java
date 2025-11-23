package com.Service;

import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SmsService {

    private final String ACCOUNT_SID = "ACb154e313ca430673dfe1fe9a66fe6987";
    private final String AUTH_TOKEN = "0df134ca59489c710ce33c792482542d";
    private final String TWILIO_NUMBER = "+13312002813";   // Twilio number

    public SmsService() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    public String sendOtp(String to, String otp) {
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+91" + to),
                new com.twilio.type.PhoneNumber(TWILIO_NUMBER),
                "Your OTP is: " + otp)
                .create();

        return message.getSid();
    }
}
