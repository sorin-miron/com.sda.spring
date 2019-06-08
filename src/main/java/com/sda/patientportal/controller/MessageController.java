package com.sda.patientportal.controller;

import com.sda.patientportal.model.Doctor;
import com.sda.patientportal.model.Message;
import com.sda.patientportal.service.DoctorService;
import com.sda.patientportal.service.MessageService;
import com.sda.patientportal.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Message> getAllMessages(){
        return messageService.getAll();
    }

    @PostMapping
    public Message createMessage(@RequestBody Message message){
        return messageService.create(message);
    }

    @GetMapping(value = "/{id}")
    public Message getMessageById(@PathVariable Long id){
        return messageService.getById(id);
    }

    @PutMapping(value = "/{id}")
    public Message updateMessage(@RequestBody Message message, @PathVariable Long id){
        if(!id.equals(message.getId())){
            return null;
        } else
            return messageService.update(message);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteDoctor(@PathVariable Long id){
        messageService.delete(id);
        System.out.println("Doctor deleted");
    }
}
