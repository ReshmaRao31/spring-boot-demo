package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ContactDto;
import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;
import com.example.demo.utils.ContactMapper;

@Controller
@RestController
public class ContactController {

	@Autowired
	ContactService contactService;

	@Autowired
	private ContactMapper contactMapper;

	@RequestMapping(path = "/contacts", method = RequestMethod.GET)
	public List<ContactDto> getContacts() {

		List<Contact> allContacts = contactService.getContacts();
		List<ContactDto> allContactsDto = new ArrayList<ContactDto>();
		for (Contact n : allContacts) {
			allContactsDto.add(contactMapper.modelmapper().map(n, ContactDto.class));
		}
		return allContactsDto;
	}

	@RequestMapping(path = "/contacts/{id}",method =RequestMethod.GET)
	public ContactDto getContact(@PathVariable int id) {
		
		Optional<Contact> contact = contactService.getContact(id);
		if (contact.isPresent())
			return contactMapper.modelmapper().map(contact.get(), ContactDto.class);
		return null;
	}

	@RequestMapping(path = "/contacts", method = RequestMethod.POST)
	public String addContact(@RequestBody Contact contact) {
		return contactService.addContact(contact);
	}

	@RequestMapping(path = "/contacts/{id}", method = RequestMethod.PUT)
	public String updateContact(@RequestBody Contact contact, @PathVariable int id) {
		return contactService.updateContact(id, contact);
	}

	@RequestMapping(path ="/contacts/{id}", method = RequestMethod.DELETE)
	
	public String deleteContact(@PathVariable int id) {
		return contactService.deleteContact(id);
	}
}
