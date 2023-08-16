package com.CVsearches.Test.controller.WhatsappControllers;

import com.CVsearches.Test.services.WhatsAppServices.WhatsAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WhatsappConroller {

    @Autowired
    private  WhatsAppService whatsAppService;

    @GetMapping("send-whatsapp-message")
    public Object sendMessage(){
        return whatsAppService.sendWhatsAppMessage();

    }

}
