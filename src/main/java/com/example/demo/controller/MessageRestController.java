package com.example.demo.controller;

import com.example.demo.data.MessageDAO;
import com.example.demo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin("*")
@RestController
public class MessageRestController {


    @Autowired
    MessageDAO messageDAO;


    @GetMapping("/api/msg")
    public List<Message> messageList(){
        return messageDAO.findAll();
    }

    @PostMapping("/api/msg")
    public ResponseEntity<Void> saveMessage(@RequestBody Message message){
        message.setCreatedAt(LocalDateTime.now());
        messageDAO.save(message);
        return new ResponseEntity("Message created.", HttpStatus.CREATED);
    }

    @DeleteMapping("/api/msg/{id}")
    public ResponseEntity<Long> deleteOrder(@PathVariable (value = "id") Long id){
        messageDAO.deleteById(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/api/msg/{id}")
    public ResponseEntity<String> updateMessage(@PathVariable (value = "id") Long id, @RequestBody Message message){
        var messageEntity= messageDAO.getReferenceById(id);
        messageEntity.setMessages(message.getMessages());
        messageDAO.save(message);
        return new ResponseEntity<>("Message updated.", HttpStatus.ACCEPTED);
    }


}
