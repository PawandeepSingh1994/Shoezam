package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Client;
import com.revature.daos.ClientDaoImp;

@Service
public class ClientService {

	@Autowired
	ClientDaoImp clientDao;
		
	public Object login(Client client) {
//		return ClientDaoImp.getInstance().get(client);
		Object c = clientDao.login(client);
		return c;
	}
	
	public List<Client> getAll() {
		return clientDao.getAll();
	}
	
	public Client getOne(Client client) {
		return clientDao.get(client);
	}
	
	public boolean deleteClient(Client client) {
		clientDao.remove(client);
		Client notFound = clientDao.get(client);
		if (notFound == null) {
			return true;
		}
		return false;
	}
	
	public boolean createClient(Client client) {
		System.out.println("Client object we want to send to the db, from Client Service-----> " + client);
		int result = clientDao.create(client);
		if (result > 0) {
			return false;
		}
		return true;
	}
	
	public Client editClient(Client client) {
		System.out.println("What is the client object? -------------> " + client);
		return clientDao.update(client);
	}
	
	public String block(Client client) {
		System.out.println("Blocking client...");
		client.setIsBlocked(true);
		clientDao.update(client);
		return "Client " + client.getEmail() + " now blocked.";
	}
}
