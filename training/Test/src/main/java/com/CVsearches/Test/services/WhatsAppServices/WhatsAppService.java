package com.CVsearches.Test.services.WhatsAppServices;

import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Service
public class WhatsAppService {


    private String API_URL = "https://graph.facebook.com/v17.0/103815216154428/messages";


    private String whatsappApiToken ="EAAOIOZAQ95j0BOzOhTsczgAPVXZBm3X8ZCPkEkdrZAmnz6aZADjVZCHcS3VzRgT81Cc2dZBvjLfaGByc5wsRpqH3ePksBPamJ7b0Vr2bxRf0uryKFLwQTDzo8mfUapld0hMajEPAJEBIpZAFdThMwZBSYjy3HHrq8KAjZA10JuoZAIc1DFd1xyco2PHG7c6jf4kCcF4z4hizReJ8A7IXYZBUMmKEkgfIQJuXeUbQ2EMnhdFdzh4ZD";

    public String sendWhatsAppMessage()  {
        JSONObject messageJson = new JSONObject();
        JSONObject textJson = new JSONObject();

        textJson.put("preview_url", false);
        textJson.put("body", "test message form the devdeveloper Abdulaziz Using Java Springramwork");

        messageJson.put("messaging_product", "whatsapp");
        messageJson.put("recipient_type", "individual");
        messageJson.put("to", "966508154855");
        messageJson.put("type", "text");
        messageJson.put("text", textJson);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + whatsappApiToken);

        HttpEntity<String> requestEntity = new HttpEntity<>(messageJson.toString(), headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(API_URL, requestEntity, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return "WhatsApp message sent!";
        } else {
            return "Failed to send WhatsApp message.";
        }
    }
}
