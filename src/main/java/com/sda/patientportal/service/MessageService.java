package com.sda.patientportal.service;

import com.sda.patientportal.model.Message;
import com.sda.patientportal.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public MessageService() {
    }

    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    public Message create(Message message) {
        return messageRepository.save(message);
    }

    public Message getById(Long id) {
        Optional<Message> message = messageRepository.findById(id);
        return message.orElse(null);
    }

    public Message update(Message message) {
        return messageRepository.save(message);
    }

    public void delete(Long id) {
        messageRepository.deleteById(id);
    }

}
