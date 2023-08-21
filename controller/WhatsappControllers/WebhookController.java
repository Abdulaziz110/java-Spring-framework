package com.example.demo.controller.WhatsappControllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    // This endpoint handles the verification request
    @GetMapping("/webhooks")
    public String handleVerification(
            @RequestParam("hub.mode") String mode,
            @RequestParam("hub.challenge") String challenge,
            @RequestParam("hub.verify_token") String verifyToken) {

        if ("subscribe".equals(mode) && "meatyhamhock".equals(verifyToken)) {
            // Respond with the challenge value to verify the webhook
            return challenge;
        } else {
            // Invalid verification request
            return "Invalid request";
        }
    }
}
