package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Client;
import com.revature.services.ClientService;

@Controller
@CrossOrigin(origins="*", allowedHeaders="*")
public class ClientController {
	
	@Autowired
	ClientService clientService;

	@GetMapping("/clients")
//	@RequestMapping(value="/clients", method=RequestMethod.GET)
	@ResponseBody
	public List<Client> getClientById() {
		System.out.println("Hit Client Controller...");
		List<Client> allTheClients = clientService.getAll();
		return allTheClients;
	}
	
	@GetMapping("/s3_credentials")
//	@RequestMapping(value="/clients", method=RequestMethod.GET)
	@ResponseBody
	public Client getcredentials() {
		System.out.println("Hit Client Controller...");
		Client result = new Client();
		result.setId(0);
		result.setFirstName("AKIAIP3L7I4QLMVMGEEA");
		result.setLastName("nLcz1INQ/aYmGLE/ixDWijtGFXFY5VuAabGFUbgB");
		result.setEmail("http://shoezam.s3.amazonaws.com");
		result.setPass("shoezam");
		result.setAddress(null);
		result.setCountry(null);
		result.setPostalCode(null);
		result.setPhoneNumber(null);
		result.setIsAdmin(false);
		result.setIsBlocked(false);
		return result;
	}
	
	@RequestMapping(value="/clients/login", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Object getClientViaLogin(@RequestBody Client client) {
		System.out.println("Hit login controller");
		System.out.println("Login request body: " + client);
		Object loggedinClient = clientService.login(client);
		return loggedinClient;
//		if (loggedinClient == null) {
//			return null;
//		} else {
//			return loggedinClient;
//		}
//		return ClientService.getInstance().login(client);
	}
	
//	@RequestMapping(value="/clients/{id}", method=RequestMethod.GET)
//	@ResponseBody
//	public Client getOneClient(@RequestParam("id") Integer id) {
//		Client client = new Client();
//		client.setUserid(id);
//		return ClientService.getInstance().getOne(client);
//	}
	
	@RequestMapping(value="/clients/:id", method=RequestMethod.DELETE)
	public boolean removeClient(@RequestBody Client client) {
		return clientService.deleteClient(client);
	}
	
	@RequestMapping(value="/clients", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public boolean add(@RequestBody Client client) {
		return clientService.createClient(client);
	}
	
	@RequestMapping(value="/clients", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Client edit(@RequestBody Client client) {
		return clientService.editClient(client);
	}
	
	@RequestMapping(value="/clients/block", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String block(@RequestBody Client client) {
		return clientService.block(client);
	}
}
