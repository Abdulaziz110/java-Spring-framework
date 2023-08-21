package com.example.demo.controller.WhatsappControllers;
import com.example.demo.services.WhatsAppServices.WhatsAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WhatsappConroller {

    @Autowired
    private WhatsAppService whatsAppService;

    @GetMapping("send-whatsapp-message")
    public Object sendMessage(){
        return whatsAppService.sendWhatsAppMessage();

    }

}
