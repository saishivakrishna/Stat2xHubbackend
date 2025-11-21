package com.Entity;

public class OtpStore {
    private String otp;
    private long expiresAt;

    public OtpStore(String otp, long expiresAt) {
        this.otp = otp;
        this.expiresAt = expiresAt;
    }

    public String getOtp() {
        return otp;
    }

    public long getExpiresAt() {
        return expiresAt;
    }
}
