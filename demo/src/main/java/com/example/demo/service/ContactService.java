package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Contact;
import com.example.demo.persistence.ContactsRepo;
import com.example.demo.persistence.ContactsRepository;

@Service
public class ContactService {

	// @Autowired ContactsRepo contacts;
	@Autowired
	ContactsRepository contacts;

	public List<Contact> getContacts() {
		// return contacts.getContacts();
		List<Contact> cont = new ArrayList<Contact>();
		contacts.findAll().forEach(cont::add);
		return cont;
	}

	public Optional<Contact> getContact(int id) {
		// return contacts.getContact(id);
		return contacts.findById(id);
	}

	public String addContact(Contact contact) {
		// contacts.addContact(contact);
		contacts.save(contact);
		if(contacts.findById(contact.getId()).isPresent())
			return "Added the given contact with id "+contact.getId()+" to Contacts.";
		else
			return "Given contact is not saved!";
	}

	public String updateContact(int id, Contact contact) {
		// contacts.updateContact(id,contact);
		
		if(contacts.findById(id).isPresent()) {
			contacts.save(contact);
			return "Updated the details of given id "+id+" in Contacts.";
		}
		else
			return "Given id is not found!";
	}

	public String deleteContact(int id) {
		// contacts.deleteContact(id);
		if(contacts.findById(id).isPresent()) {
			contacts.deleteById(id);
			return "Deleted the given id "+id+" from Contacts.";
		}
		else
			return "Given id is not found!";
		
	}
}
