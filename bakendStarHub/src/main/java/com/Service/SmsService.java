package com.Service;

import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SmsService {

private final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    private final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
    private final String TWILIO_NUMBER = System.getenv("TWILIO_PHONE_NUMBER");

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
