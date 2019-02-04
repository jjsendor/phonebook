package com.example.phonebook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.phonebook.model.Contact;
import com.example.phonebook.service.ContactService;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/")
    public ModelAndView listContacts(ModelAndView model) throws IOException{
        List<Contact> contactsList = contactService.getAllContacts();
        model.addObject("contactsList", contactsList);
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/createContact", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Contact contact = new Contact();
        model.addObject("contact", contact);
        model.setViewName("ContactForm");
        return model;
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Contact contact) {
        if (contact.getId() == 0) {
            contactService.createContact(contact);
        }
        else {
            contactService.updateContact(contact);
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/editContact", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("id"));
        Contact contact = contactService.getContact(contactId);
        ModelAndView model = new ModelAndView("ContactForm");
        model.addObject("contact", contact);
        return model;
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("id"));
        contactService.deleteContact(contactId);
        return new ModelAndView("redirect:/");
    }

}
