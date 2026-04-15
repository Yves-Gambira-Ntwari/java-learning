package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.DtoContacts;
import com.example.demo.model.Contacts;
import com.example.demo.model.TeleNetwork;
import com.example.demo.repository.ContactsRepo;
import com.example.demo.repository.TeleNetworkRepo;

@Controller
@RequestMapping("/")
public class ContactController {
	@Autowired
	ContactsRepo repoContact;
	
	@Autowired
	TeleNetworkRepo repoTeleNetwork;
	
	@PostMapping("/contacts/add")
	public String insertContact(Contacts data) {
		

		repoContact.save(data);
		
		
		return "redirect:/home";
	}
}
