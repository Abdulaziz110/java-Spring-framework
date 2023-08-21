package com.example.demo.controller.WhatsappControllers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    @PostMapping("/webhook")
    public void handleWebhook(@RequestBody String payload) {
        System.out.println(payload);
    }
}
