package com.example.demo.controller.WhatsappControllers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WebhookController {

    private final String myToken = "1q2w3e";





    @PostMapping("/webhooks")
    public ResponseEntity<String> handleWebhooks(@RequestBody String requestBody) {
        try {
            WebhookRequestBody body = parseRequestBody(requestBody);
            if (!"messages".equals(body.getField())) {
                // Not from the messages webhook, so don't process
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

            List<PutItemOutcome> putItemOutcomes = new ArrayList<>();
            for (Message message : body.getValue().getMessages()) {
                Item reviewItem = new Item()
                        .withString("phonenumber", message.getFrom())
                        .withString("review", message.getText().getBody());


            }

            // Return 200 code once all reviews have been written to DynamoDB
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private WebhookRequestBody parseRequestBody(String requestBody) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(requestBody, WebhookRequestBody.class);
    }


    @GetMapping("/webhooks")
    public ResponseEntity<WebhookResponse> handleWebhookVerification(
            @RequestParam("hub.mode") String mode,
            @RequestParam("hub.challenge") String challenge,
            @RequestParam("hub.verify_token") String verifyToken) {

        WebhookResponse response = new WebhookResponse();

        if (mode != null && verifyToken != null) {
            if ("subscribe".equals(mode) && myToken.equals(verifyToken)) {
                response.setMessage(challenge);

                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.setMessage("Invalid request");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } else {
            response.setMessage("Invalid request");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        
    }



     class WebhookRequestBody {
        private String field;
        private Value value;

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public Value getValue() {
            return value;
        }

        public void setValue(Value value) {
            this.value = value;
        }
    }

    class Value {
        private List<Message> messages;

        public List<Message> getMessages() {
            return messages;
        }

        public void setMessages(List<Message> messages) {
            this.messages = messages;
        }
    }

    class Message {
        private String from;
        private Text text;

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public Text getText() {
            return text;
        }

        public void setText(Text text) {
            this.text = text;
        }
    }

    class Text {
        private String body;

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }

     class WebhookResponse {
        private int statusCode;
        private String message;

        public WebhookResponse() {
            this.statusCode = statusCode;
            this.message = message;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }


}

