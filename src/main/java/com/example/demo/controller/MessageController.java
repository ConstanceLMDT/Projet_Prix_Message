package com.example.demo.controller;

import com.example.demo.data.MessageDAO;
import com.example.demo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class MessageController {

    @Autowired
    private MessageDAO messageDAO;

    @GetMapping("/msg")
    public String showMessage(Model model){
        model.addAttribute("msglist", messageDAO.findAll());
        model.addAttribute("messages", new Message());
        return "MessagePage" ;
    }

   @PostMapping("/msg")
    public String postMessage(@ModelAttribute Message newMessage){
        Message msg = new Message(newMessage.getAuthor(), newMessage.getMessages());
        messageDAO.save(msg);
       return "redirect:msg";
    }

}
