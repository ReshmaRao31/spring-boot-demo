package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Contact;

public interface ContactsRepository extends CrudRepository<Contact,Integer>{

}
