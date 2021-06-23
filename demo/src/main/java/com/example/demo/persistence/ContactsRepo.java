package com.example.demo.persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Contact;

@Repository
public class ContactsRepo {

	List<Contact> contacts = new ArrayList<>(Arrays.asList(new Contact(1, "John", "john@example.com", "1234567895"),
			new Contact(2, "Joe", "joe@example.com", "1234567835"),
			new Contact(3, "Mary", "mary@example.com", "1234563895"),
			new Contact(4, "Bob", "bob@example.com", "1234567349")));

	public List<Contact> getContacts() {
		return contacts;
	}

	public Contact getContact(int id) {
		return contacts.stream().filter(c -> c.getId() == id).findFirst().get();
	}

	public void addContact(Contact contact) {
		contacts.add(contact);
	}

	public void updateContact(int id, Contact contact) {
		contacts.stream().filter(c -> c.getId() == id).forEach(c -> {
			c.setName(contact.getName());
			c.setMobile(contact.getMobile());
			c.setEmail(contact.getEmail());
		});
	}
	
	public void deleteContact(int id) {
		contacts.removeIf(c -> c.getId() == id);
	}
	
	
}
