package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.DtoContacts;
import com.example.demo.model.Contacts;
import com.example.demo.model.TeleNetwork;
import com.example.demo.repository.ContactsRepo;
import com.example.demo.repository.TeleNetworkRepo;


@Controller
@RequestMapping("/")
public class FrontEndController {
	
	@Autowired
	TeleNetworkRepo repoNetwork;
	@Autowired
	ContactsRepo repoContacts;
	
	@GetMapping("home")
	public String welcom(Model model) {
		List<Contacts> contact = repoContacts.findAll();
		model.addAttribute("allContacts", contact);
		
		return "welcome";
	}
	@GetMapping("/contacts")
	public String contacts(Model model) {
		model.addAttribute("contact", new Contacts());
		model.addAttribute("networks", repoNetwork.findAll());
		return "contacts/addNew";
	}
	
	@GetMapping("networks")
	public String addNetwork(Model model) {
		model.addAttribute("network", new TeleNetwork());		
		return "/teleNetwork/add";
	}
	@GetMapping("delete")
	public String deleteContact(@RequestParam("id") Long id) {
		repoContacts.deleteById(id);
		return "redirect:/home";
	}
	
	@GetMapping("update")
	public String showUpdateForm(@RequestParam("id") Long id, Model model) {
		Contacts contact = repoContacts.findById(id).orElse(null);
		model.addAttribute("contact",contact);
		model.addAttribute("networks", repoNetwork.findAll());
		return "contacts/addNew";
	}
}
