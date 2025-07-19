package com.nailartistry.NailartistryBackendApplication.controller;

import com.nailartistry.NailartistryBackendApplication.model.ContactMessage;
import com.nailartistry.NailartistryBackendApplication.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    ContactMessageService contactMessageService;

    @GetMapping
    public ResponseEntity<List<ContactMessage>> getAllContactMessage()
    {
        List<ContactMessage> messages=contactMessageService.getAllContactMessage();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContactMessage> submitContactMessage(@RequestBody ContactMessage contactMessage)
    {
        ContactMessage savedMessage=contactMessageService.saveContactMessage(contactMessage);
        return new ResponseEntity<>(savedMessage,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteContactMessage(@PathVariable long id)
    {
        try{
            contactMessageService.deleteContactMessgeById(id);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
