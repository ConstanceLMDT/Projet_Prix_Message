package com.example.prix.controller;

import com.example.prix.data.PrixDAO;
import com.example.prix.model.Prix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin("*")
@RestController
public class PrixRestController {


    @Autowired
    PrixDAO prixDAO;

    @GetMapping("/api/prix")
    public List<Prix> prixList(){
        return prixDAO.findAll();
    }

    @PostMapping("/api/prix")
    public ResponseEntity<Void> savePrix(@RequestBody Prix prix){
        prix.setCreatedAt(LocalDateTime.now());
        prixDAO.save(prix);
        return new ResponseEntity("Prix created.", HttpStatus.CREATED);
    }

    @DeleteMapping("/api/prix/{id}")
    public ResponseEntity<Long> deleteId(@PathVariable(value="id") Long id){
        prixDAO.deleteById(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/api/prix/{id}")
        public ResponseEntity<Double> updatePrix(@PathVariable(value="id") Long id, @RequestBody Prix prix){
        var prixEntity= prixDAO.getReferenceById(id);
        prixEntity.setPrix(prix.getPrix());
        prixDAO.save(prix);
        return new ResponseEntity("Prix update.", HttpStatus.ACCEPTED);
    }
}