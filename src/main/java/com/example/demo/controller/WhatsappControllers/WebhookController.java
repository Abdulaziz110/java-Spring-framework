package com.example.demo.controller.WhatsappControllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    private final String myToken = "1q2w3e";

    @PostMapping("/webhook")
    public ResponseEntity<String> handleWebhookVerification(
            @RequestParam("hub.mode") String mode,
            @RequestParam("hub.challenge") String challenge,
            @RequestParam("hub.verify_token") String verifyToken) {

        if (mode != null && verifyToken != null) {
            if ("subscribe".equals(mode) && myToken.equals(verifyToken)) {
                return new ResponseEntity<>(challenge, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
        }
    }
}

