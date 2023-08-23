package com.example.demo.controller.WhatsappControllers;

import okhttp3.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {
    @RestController
    public class WhatsappController {
        private final String VERIFICATION_TOKEN = "12345";

        @GetMapping("/webhook")
        public ResponseEntity<String> verifyWebhook(@RequestParam("hub.mode") String mode,
                                                    @RequestParam("hub.challenge") String challenge,
                                                    @RequestParam("hub.verify_token") String token) {
            if (mode.equals("subscribe") && token.equals(VERIFICATION_TOKEN)) {
                return new ResponseEntity<>(challenge, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Verification token or mode mismatch", HttpStatus.FORBIDDEN);
            }
        }  }
    }
