package com.example.demo.controller.WhatsappControllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    private final String myToken = "1q2w3e";

    @GetMapping("/webhook")
    public String handleWebhookVerification(
            @RequestParam("hub.mode") String mode,
            @RequestParam("hub.challenge") String challenge,
            @RequestParam("hub.verify_token") String verifyToken) {

        if (mode != null && verifyToken != null) {
            if ("subscribe".equals(mode) && myToken.equals(verifyToken)) {
                return challenge;
            } else {
                return "Invalid request";
            }
        } else {
            return "Invalid request";
        }
    }
}
