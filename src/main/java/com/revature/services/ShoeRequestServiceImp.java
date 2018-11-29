package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Client;
import com.revature.beans.Shoe;
import com.revature.beans.ShoeRequest;
import com.revature.daos.ShoeRequestDaoImp;

@Service
public class ShoeRequestServiceImp implements ShoeRequestService {
	
	@Autowired
	ShoeRequestDaoImp shoeRequestDaoImp;

	@Override
	public List<ShoeRequest> fetchAll() {
		List<ShoeRequest> shoes = shoeRequestDaoImp.getAll();
		System.out.println("All shoe requests:  " + shoes);
		return shoes;
	}

	@Override
	public List<ShoeRequest> fetchFromClient(Client client) {
		List<ShoeRequest> shoes = shoeRequestDaoImp.getAllMadeByClient(client);
		System.out.println("All shoe requests made by client" + "" + client.getEmail() + ": " + shoes);
		return shoes;
	}

	@Override
	public List<ShoeRequest> fetchByShoeReqeusted(Shoe shoe) {
		List<ShoeRequest> shoes = shoeRequestDaoImp.getAllByShoe(shoe);
		System.out.println("All shoes requests for a shoe: " + shoes);
		return shoes;
	}

	@Override
	public List<ShoeRequest> fetchToClient(Client client) {
		List<ShoeRequest> shoes = shoeRequestDaoImp.getAllBelongingToClient(client);
		System.out.println("All shoe requests made to " + client.getEmail() + ": " + shoes);
		return shoes;
	}

	@Override
	public void create(ShoeRequest swap) {
		shoeRequestDaoImp.add(swap);
		
	}

	@Override
	public boolean resolve(ShoeRequest swap) {
		Boolean resolveSuccess = shoeRequestDaoImp.resolve(swap);
		System.out.println("Was the swap resolved?   " + resolveSuccess);
		return resolveSuccess;
	}

	@Override
	public boolean deny(ShoeRequest swap) {
		Boolean denySuccess = shoeRequestDaoImp.deny(swap);
		System.out.println("was the swap denied?  " + denySuccess);
		return denySuccess;
	}

}
