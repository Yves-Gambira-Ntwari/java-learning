package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TeleNetwork;
import com.example.demo.repository.TeleNetworkRepo;

//@RestController
@Controller
@RequestMapping("/")
public class TeleNetworkController {
	
	@Autowired
	TeleNetworkRepo repoTelenetwork;
	
	@PostMapping("/networks/add")
	public String insertTeleNetwork(@ModelAttribute TeleNetwork data) throws IOException {
		repoTelenetwork.save(data);
		return "redirect:/networks";	
	}
	@GetMapping("")
	public List<TeleNetwork> getAllNetworks(){
		return repoTelenetwork.findAll();
	}
}
