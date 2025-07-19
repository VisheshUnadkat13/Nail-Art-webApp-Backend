package com.nailartistry.NailartistryBackendApplication.service;

import com.nailartistry.NailartistryBackendApplication.model.ContactMessage;
import com.nailartistry.NailartistryBackendApplication.repo.ContactMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactMessageService {

    @Autowired
    private ContactMessageRepo repo;

    public List<ContactMessage> getAllContactMessage() {
        return repo.findAll();
    }

    public ContactMessage saveContactMessage(ContactMessage contactMessage) {
        return repo.save(contactMessage);
    }

    public void deleteContactMessgeById(long id) {
        repo.deleteById(id);
    }
}
