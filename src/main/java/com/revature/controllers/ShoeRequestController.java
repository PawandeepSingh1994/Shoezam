package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Client;
import com.revature.beans.Shoe;
import com.revature.beans.ShoeRequest;
import com.revature.services.ShoeRequestService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
@RequestMapping("/swaps")
public class ShoeRequestController {
	
	@Autowired 
	ShoeRequestService shoeRequestService;
	
	@GetMapping("/all")
	public List<ShoeRequest> getAllSwaps() {
		List<ShoeRequest> swaps = shoeRequestService.fetchAll();
		return swaps;
	}
	
	@GetMapping("/to/client/{id}")
	public List<ShoeRequest> getAllSwapsMadeToClient(@PathVariable("id") Integer id) {
		Client c = new Client(id);
		List<ShoeRequest> swaps = shoeRequestService.fetchToClient(c);
		return swaps;
	}
	
	@GetMapping("/from/client/{id}")
	public List<ShoeRequest> getAllSwapsMadeByClient(@PathVariable("id") Integer id) {
		Client c = new Client(id);
		List<ShoeRequest> swaps = shoeRequestService.fetchFromClient(c);
		return swaps;
	}
	
	@GetMapping("/requested/shoe/{id}")
	public List<ShoeRequest> getAllForShoe(@PathVariable("id") Integer id) {
		Shoe s = new Shoe(id);
		List<ShoeRequest> swaps = shoeRequestService.fetchByShoeReqeusted(s);
		return swaps;
	}
	
	@PostMapping("/resolve") 
	public String agreeToSwap(@RequestBody ShoeRequest swap) {
		Boolean success = shoeRequestService.resolve(swap);
		if (success) {
			return "Shoe successfully swapped, make a new get request for each shoe to see update.";
		}
		return "Something went wrong.  Resolve unsuccessfull.";
	}
	
	@PostMapping("/deny")
	public String denyToSwap(@RequestBody ShoeRequest swap) {
		Boolean success = shoeRequestService.deny(swap);
		if (success) {
			return "Shoe swap successfully denied.";
		}
		return "Something went wrong. Denial unsuccessfull.";
	}

	@PostMapping
	public ShoeRequest create(@RequestBody ShoeRequest swap) {
		shoeRequestService.create(swap);
		return swap;
	}
}
