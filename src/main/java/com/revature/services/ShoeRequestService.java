package com.revature.services;

import java.util.List;

import com.revature.beans.Client;
import com.revature.beans.Shoe;
import com.revature.beans.ShoeRequest;

public interface ShoeRequestService {

	public List<ShoeRequest> fetchAll();
	public List<ShoeRequest> fetchFromClient(Client client);
	public List<ShoeRequest> fetchByShoeReqeusted(Shoe shoe);
	public List<ShoeRequest> fetchToClient(Client client);
	public void create(ShoeRequest swap);
	public boolean resolve(ShoeRequest swap);
	public boolean deny(ShoeRequest swap);
}
