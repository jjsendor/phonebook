package com.example.phonebook.dao;

import java.util.List;

import com.example.phonebook.model.Contact;

public interface ContactDAO {

    public void createContact(Contact contact);

    public List<Contact> getAllContacts();

    public Contact getContact(int contactId);

    public Contact updateContact(Contact contact);

    public void deleteContact(Integer contactId);

}
