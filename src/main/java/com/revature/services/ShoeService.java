package com.revature.services;

import java.util.List;

import com.revature.beans.Client;
import com.revature.beans.Shoe;

public interface ShoeService {
	
	public List<Shoe> fetchAllShoes();
	public List<Shoe> fetchShoesByColor(String color);
	public List<Shoe> fetchShoesByBrand(String brand);
	public List<Shoe> fetchShoesBySize(Double size);
	public List<Shoe> fetchShoesBySizeRange(Double min, Double max);
	public List<Shoe> fetchShoesByPriceRange(Double min, Double max);
	public Shoe fetchOneShoe(Integer id);
	public List<Shoe> fetchShoesBelongingToClient(Client client);
	public List<Shoe> fetchShoesForSale(Client client);
	public Shoe updateShoe(Shoe shoe);
	public Shoe removeShoe(Shoe shoe);
	public Shoe addShoe(Shoe shoe);

}
