package com.example.demo.controller.WhatsappControllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    private final String myToken = "1q2w3e";

    @GetMapping("/webhook")
    public ResponseEntity<WebhookResponse> handleWebhookVerification(
            @RequestParam("hub.mode") String mode,
            @RequestParam("hub.challenge") String challenge,
            @RequestParam("hub.verify_token") String verifyToken) {

        WebhookResponse response = new WebhookResponse();

        if (mode != null && verifyToken != null) {
            if ("subscribe".equals(mode) && myToken.equals(verifyToken)) {
                response.setResponse(challenge);

                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setResponse("Invalid request");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } else {
            response.setResponse("Invalid request");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        
    }

     class WebhookResponse {
        private String response;

        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }
    }
}

