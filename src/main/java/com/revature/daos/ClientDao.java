package com.revature.daos;

import java.util.List;

import com.revature.beans.Client;

public interface ClientDao {

	public Client get(Client client);
	public Object login(Client client);
	public List<Client> getAll();
	public void remove(Client client);
	public int create(Client client);
	public Client update(Client client);
	
}
