package com.Service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GenerateService {

    private static final String ALPHA_NUM = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

  

    public String generateReferral() {
		 return "REF" + randomString(3); 
	}

    private String randomString(int len) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append(ALPHA_NUM.charAt(random.nextInt(ALPHA_NUM.length())));
        }
        return sb.toString();
    }

	
}