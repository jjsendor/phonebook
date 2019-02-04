package com.example.phonebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.phonebook.dao.ContactDAO;
import com.example.phonebook.model.Contact;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDAO contactDAO;

    @Override
    @Transactional
    public void createContact(Contact contact) {
        contactDAO.createContact(contact);
    }

    @Override
    @Transactional
    public List<Contact> getAllContacts() {
        return contactDAO.getAllContacts();
    }

    @Override
    @Transactional
    public Contact getContact(int contactId) {
        return contactDAO.getContact(contactId);
    }

    @Override
    @Transactional
    public Contact updateContact(Contact contact) {
        return contactDAO.updateContact(contact);
    }

    @Override
    @Transactional
    public void deleteContact(Integer contactId) {
        contactDAO.deleteContact(contactId);
    }

}
