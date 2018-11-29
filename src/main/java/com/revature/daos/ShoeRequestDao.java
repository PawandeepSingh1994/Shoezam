package com.revature.daos;

import java.util.List;

import com.revature.beans.Client;
import com.revature.beans.Shoe;
import com.revature.beans.ShoeRequest;

public interface ShoeRequestDao {

	public boolean add(ShoeRequest shoereq);
	public boolean resolve(ShoeRequest shoereq);
	public boolean deny(ShoeRequest shoereq);
	public List<ShoeRequest> getAll();
	public List<ShoeRequest> getAllByShoe(Shoe shoe);
	public List<ShoeRequest> getAllBelongingToClient(Client client);
	public List<ShoeRequest> getAllMadeByClient(Client client);
}
