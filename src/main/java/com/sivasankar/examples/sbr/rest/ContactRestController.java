package com.sivasankar.examples.sbr.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sivasankar.examples.sbr.model.Contact;
import com.sivasankar.examples.sbr.service.ContactService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ContactRestController {
	
	@Autowired
	private ContactService contactService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "Application running...";
	}
	
	@RequestMapping("/contacts")
	public List<Contact> fetchContacts() {
		return contactService.getAllContacts();
	}
	
	@RequestMapping("/contacts/{name}")
	public Contact fetchContact(@PathVariable String name) {
		return contactService.getContact(name);
	}
	
	@RequestMapping(value="/contacts", method=RequestMethod.POST)
	public void addContact(@RequestBody Contact contact) {
		contactService.addContact(contact);
	}
	
	@RequestMapping(value="/contacts", method = RequestMethod.PUT)
	public void updateContact(@RequestBody Contact contact) {
		contactService.updateContact(contact);
	}
	
	@RequestMapping(value="/contacts", method = RequestMethod.DELETE)
	public void deleteContact(@RequestParam(name="name", required=true) String name) {
		contactService.deleteContact(name);
	}
}
