package com.sivasankar.examples.sbr.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sivasankar.examples.sbr.model.Contact;

@Service
public class ContactService {
	private List<Contact> contacts = new ArrayList<>(
			Arrays.asList(new Contact("Siva", "+91-9876-543-210", "siva@siva.com"),
					new Contact("Sankar", "+91-1234-567-890", "sankar@sankar.com"),
					new Contact("Raj", "+91-9876-501-234", "raj@raj.com")));
	
	public List<Contact> getAllContacts() {
		return contacts;
	}
	
	public Contact getContact(String name) {
		return contacts.stream().filter(c -> c.getName().equals(name)).findFirst().get();
	}
	
	public void addContact(Contact contact) {
		contacts.add(contact);
	}
	
	public void updateContact(Contact contact) {
		for(int i=0; i<contacts.size(); i++) {
			Contact c = contacts.get(i);
			if(c.getName().equals(contact.getName())) {
				contacts.set(i, contact);
				return;
			}
		}
	}
	
	public void deleteContact(String name) {
		contacts.removeIf(c -> c.getName().equals(name));
	}
}
