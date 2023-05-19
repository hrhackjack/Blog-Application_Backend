package com.HR.Blog.Controllers;

import com.HR.Blog.Entities.Chat;
import com.HR.Blog.Services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private ChatService chatService;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Chat receiveMessage(@Payload Chat message){
//        this.chatService.saveChat(message);
        return message;
    }

    @MessageMapping("/private-message")
    public Chat recMessage(@Payload Chat message){
        simpMessagingTemplate.convertAndSendToUser(message.getReceiver(),"/private",message);
//        this.chatService.saveChat(message);
        System.out.println(message.toString());
        return message;
    }
}
