package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.revature.beans.Client;
import com.revature.beans.Shoe;
import com.revature.services.ShoeService;

//@RestController
@Controller
@CrossOrigin
@RequestMapping("shoes")
public class ShoeControler {
	
	@Autowired
	ShoeService shoeService;

//	
//	@RequestMapping(value="/shoes", method=RequestMethod.GET)
//	@RequestMapping
	@GetMapping
	@ResponseBody
	public List<Shoe> getAllShoes() {
		System.out.println("Hit get all shoes...");
		List<Shoe> allShoes = shoeService.fetchAllShoes();
		return allShoes;
	}
	
	@GetMapping("/color/{whichColor}")
	@ResponseBody
	public List<Shoe> getShoesByColor(@PathVariable("whichColor") String color) {
		List<Shoe> coloredShoes = shoeService.fetchShoesByColor(color);
		return coloredShoes;
	}
	
	@GetMapping("/brand/{whichBrand}")
	@ResponseBody
	public List<Shoe> getShoesByBrand(@PathVariable("whichBrand") String brand) {
		List<Shoe> brandShoes = shoeService.fetchShoesByBrand(brand);
		return brandShoes;
	}
	
//	@GetMapping("/size/{whichSize}")
//	@ResponseBody
//	public List<Shoe> getShoesBySize(@PathVariable("whichSize") Double size) {
//		List<Shoe> shoesOfSize = shoeService.fetchShoesBySize(size);
//		return shoesOfSize;
//	}
	
	@GetMapping("/size/{min}/{max}")
	@ResponseBody
	public List<Shoe> getShoesInSizeRange(@PathVariable("min") Double min, @PathVariable("max") Double max) {
		List<Shoe> shoesInRange = shoeService.fetchShoesBySizeRange(min, max);
		return shoesInRange;
	}
	
	@GetMapping("/price/{min}/{max}")
	@ResponseBody
	public List<Shoe> getShoesInPriceRange(@PathVariable("min") Double min, @PathVariable("max") Double max) {
		List<Shoe> shoesInRange = shoeService.fetchShoesByPriceRange(min, max);
		return shoesInRange;
	}
	
//	@GetMapping("/{shoeId}")
//	@ResponseBody
//	public Shoe getOneShoeById(@PathVariable("shoeId") Integer id) {
//		Shoe found = shoeService.fetchOneShoe(id);
//		return found;
//	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String addNewShoe(@RequestBody Shoe shoe) {
		System.out.println("Shoe in post request: " + shoe);
//		Client client, String title, String brand, Double size, Double price, String color, Integer shoeStatus
		Shoe toPost = new Shoe(
				shoe.getClient(), 
				shoe.getTitle(), 
				shoe.getBrand(), 
				shoe.getShoeSize(), 
				shoe.getPrice(), 
				shoe.getColor(), 
				shoe.getShoeStatus());
		shoeService.addShoe(toPost);
		String response = "Shoe added.";
		return response;
	}
	
	@GetMapping("/client/{id}")
	@ResponseBody
	public List<Shoe> getShoesForClient(@PathVariable("id") Integer id) {
		Client c = new Client(id);
		List<Shoe> shoesOfClient = shoeService.fetchShoesBelongingToClient(c);
		return shoesOfClient;
	}
	
	@GetMapping("sale/client/{id}")
	@ResponseBody
	public List<Shoe> getShoesForSaleForClient(@PathVariable("id") Integer id) {
		Client c = new Client(id);
		List<Shoe> shoesOfClient = shoeService.fetchShoesForSale(c);
		return shoesOfClient;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteShoe(@PathVariable("id") Integer id) {
		shoeService.removeShoe(new Shoe(id));
	}
	
	
}
